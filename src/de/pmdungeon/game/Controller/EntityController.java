package de.pmdungeon.game.Controller;

import de.pmdungeon.interfaces.IEntity;

import java.util.ArrayList;

/** Handles every entity in the dungeon. */
public class EntityController {

    /** Contains all the entities this controller handles. */
    private final ArrayList<IEntity> dungeonEntities;

    public EntityController() {
        this.dungeonEntities = new ArrayList<>();
    }

    /**
     * calls the update method for every entity in the list. removes entity if deletable is set true
     */
    public void update() {
        dungeonEntities.removeIf(obj -> obj.deleteable());
        dungeonEntities.forEach(obj -> obj.update());
    }

    /**
     * add an entity to the list
     *
     * @param entity
     * @throws IllegalArgumentException
     */
    public void addEntity(IEntity entity) throws IllegalArgumentException {
        if (entity == null) throw new IllegalArgumentException("null can not be added.");
        if (!dungeonEntities.contains(entity)) this.dungeonEntities.add(entity);
    }

    /**
     * removes entity from the list
     *
     * @param entity
     * @throws IllegalArgumentException
     */
    public void removeEntity(IEntity entity) throws IllegalArgumentException {
        if (entity == null) throw new IllegalArgumentException("null can not be deleted.");
        if (dungeonEntities.contains(entity)) this.dungeonEntities.remove(entity);
    }

    /** removes all entities from the list */
    public void removeAll() {
        this.dungeonEntities.clear();
    }

    /**
     * removes all instances of the class c from the list
     *
     * @param c referenz Class (use Class.forName("PACKAGE.CLASSNAME") )
     * @throws IllegalArgumentException
     */
    public void removeAllFrom(Class<?> c) throws IllegalArgumentException {
        if (c == null) throw new IllegalArgumentException("null is not a class");
        dungeonEntities.removeIf(obj -> c.isInstance(obj));
    }

    /** returns entity list */
    public ArrayList<IEntity> getList() {
        return this.dungeonEntities;
    }
}
