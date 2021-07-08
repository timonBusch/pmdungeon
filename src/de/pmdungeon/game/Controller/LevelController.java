package de.pmdungeon.game.Controller;

import de.pmdungeon.dungeonCreator.DungeonWorld;
import de.pmdungeon.dungeonCreator.dungeonconverter.DungeonConverter;
import de.pmdungeon.game.GameSetup;
import de.pmdungeon.tools.Constants;
import de.pmdungeon.tools.Point;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** Use this to control the level itself. */
public class LevelController {
    /** Method to call after a new level is loaded */
    private final Method onLevelLoad;
    /** Instance of the class that contains onLevelLoad (should be MainGameController) */
    private final Object klass;
    /** Arguments for onLevelLoad */
    private final Object[] args;
    /** the converter that generates the dungeon out of a json */
    private final DungeonConverter dungeonConverter = new DungeonConverter();
    /** if this is true, the next level will get load */
    private boolean nextLevelTriggered = false;
    /** the current level */
    private DungeonWorld dungeonWorld;
    /** the next level */
    private Stage nextStage = Stage.A;

    /**
     * @param onLevelLoad Method that will be called if a new level get load
     * @param klass Instance of the MainControllerClass
     * @param args Arguments for onLevelLoaded
     */
    public LevelController(Method onLevelLoad, Object klass, Object[] args) {
        this.onLevelLoad = onLevelLoad;
        this.klass = klass;
        this.args = args;
    }

    /**
     * Load a new dungeon. Calls onLevelLoad
     *
     * @param dungeon DungeonWorld to load
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void loadDungeon(DungeonWorld dungeon)
            throws InvocationTargetException, IllegalAccessException {
        this.dungeonWorld = dungeon;
        this.nextLevelTriggered = false;
        this.dungeonWorld.makeConnections();
        onLevelLoad.invoke(klass, args);
    }

    /** If next level is triggered, this will load it. Also draws the level. */
    public void update() {
        // load next stage if triggered
        if (nextLevelTriggered) {
            try {
                nextStage();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        draw();
    }

    /**
     * Check if given Point is (rounded) a TriggerTile
     *
     * @param p point check
     * @return result of check
     */
    public boolean checkForTrigger(Point p) {
        return (int) p.x == dungeonWorld.getNextLevelTrigger().getX()
                && (int) p.y == dungeonWorld.getNextLevelTrigger().getY();
    }

    /** Used to set the trigger if the next level should be loaded */
    public void triggerNextStage() {
        this.nextLevelTriggered = true;
    }

    /**
     * Return the current level.
     *
     * @return
     */
    public DungeonWorld getDungeon() {
        return dungeonWorld;
    }

    /** Draws the dungeon itself. */
    public void draw() {
        if (dungeonWorld == null) return;
        dungeonWorld.renderFloor(GameSetup.batch);
        dungeonWorld.renderWalls(dungeonWorld.getHeight() - 1, 0, GameSetup.batch);
    }

    /** If next stage is triggered, change the dungeon. */
    protected void nextStage() throws InvocationTargetException, IllegalAccessException {
        loadDungeon(dungeonConverter.dungeonFromJson(Constants.PATHTOLEVEL + nextStage.getValue()));
        nextStage = Stage.values()[(nextStage.ordinal() + 1) % Stage.values().length];
    }

    enum Stage {
        A("small_dungeon.json"),
        B("simple_dungeon_2.json"),
        C("simple_dungeon.json"),
        D("boss_dungeon.json");

        private final String value;

        Stage(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
