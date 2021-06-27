package de.pmdungeon.tools;

/**
 * Contains the global Parameters of the program, to be altered with launch
 * parameters.
 * 
 * @author Alesia
 *
 */
public class GlobalParameters {
    /**
     * Default name of the window
     */
    private static String windowname = "PMDungeon";

    /**
     * Window default height
     */
    private static int height = 480;

    /**
     * Window default width
     */
    private static int width = 640;

    /**
     * Default asset path
     */
    private static String levelFolder = "assets/level/";

    /**
     * Default start level of the dungeon
     */
    private static String firstLevelFile = GlobalParameters.levelFolder + "small_dungeon.json";

    /**
     * Default framerate
     */
    private static int framesPerSecond = 30;

    /**
     * Default virtual height
     */
    private static float virtualHeight = 5;

    /**
     * Sets if window is resizable, default false
     */
    private static boolean resizable = false;

    /**
     * Sets whether window should be fullscreen, default false
     */
    private static boolean fullscreen = false;

    /**
     * @param resizable sets if window is resizable
     */
    public static void setResizable(boolean resizable) {
        GlobalParameters.resizable = resizable;
    }

    /**
     * @return resizable checks whether the window is resizable
     */
    public static boolean isResizable() {
        return resizable;
    }

    /**
     * 
     * @return windowname returns name of window
     */
    public static String getWindowname() {
        return windowname;
    }

    /**
     * 
     * @param windowname sets name of window
     */
    public static void setWindowname(String windowname) {
        GlobalParameters.windowname = windowname;
    }

    /**
     * 
     * @return height of window
     */
    public static int getHeight() {
        return height;
    }

    /**
     * 
     * @param height set height of window
     */
    public static void setHeight(int height) {
        GlobalParameters.height = height;
    }

    /**
     * 
     * @return width of window
     */
    public static int getWidth() {
        return width;
    }

    /**
     * 
     * @param width set width of window
     */
    public static void setWidth(int width) {
        GlobalParameters.width = width;
    }

    /**
     * 
     * @return startLevelFile returns path and name of starting level
     */
    public static String getStartLevelFile() {
        return firstLevelFile;
    }

    /**
     * 
     * @param startLevelFile sets start level filename and adds the path
     */
    public static void setStartLevelFile(String startLevelFile) {
        GlobalParameters.firstLevelFile = GlobalParameters.levelFolder + startLevelFile;
    }

    /**
     * 
     * @return levelFolder returns path to the folder containing level assets
     */
    public static String getLevelFolder() {
        return levelFolder;
    }

    /**
     * 
     * @param pathToLevel sets path to level assets
     */
    public static void setLevelFolder(String pathToLevel) {
        GlobalParameters.levelFolder = pathToLevel;
    }

    /**
     * 
     * @return framesPerSecond returns the framerate in frames per second
     */
    public static int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * 
     * @param framesPerSecond sets the framerate in frames per second
     */
    public static void setFramesPerSecond(int framesPerSecond) {
        GlobalParameters.framesPerSecond = framesPerSecond;
    }

    /**
     * 
     * @return virtualHeight returns virtual height
     */
    public static float getVirtualHeight() {
        return virtualHeight;
    }

    /**
     * 
     * @param virtualHeight sets virtual height
     */
    public static void setVirtualHeight(float virtualHeight) {
        GlobalParameters.virtualHeight = virtualHeight;
    }

    /**
     * 
     * @return fullscreen returns whether window is set to be fullscreen
     */
    public static boolean isFullscreen() {
        return fullscreen;
    }

    /**
     * 
     * @param fullscreen sets whether window should be fullscreen
     */
    public static void setFullscreen(boolean fullscreen) {
        GlobalParameters.fullscreen = fullscreen;
    }

}
