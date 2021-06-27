package de.pmdungeon.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import de.pmdungeon.game.Controller.MainController;
import de.pmdungeon.game.GameSetup;
import de.pmdungeon.tools.GlobalParameters;

import org.apache.commons.cli.*;

/**
 * Contains the logic to run the dungeon, and to parse the launch parameters.
 * 
 * @author Alesia
 *
 */
public class DesktopLauncher {

    /**
     * Runs the dungeon.
     *  @param mc   MainController of the Dungeon
     * @param args Launch parameters to override the default values 
     * -h Height of the window in px 
     * -w Width of the window in px 
     * -lf Path to folder containing level assets
     * -fl file name of starting level 
     * -fps frame rate the program runs at in frames per second 
     * -vh Virtual height 
     * -re Sets whether the window is resizable 
     * -fs Sets the program to be fullscreen    
     */
    public static void run(MainController mc, String[] args) {

        Options options = new Options();

        Option height = new Option("h", "height", true, "Window height in px");
        Option width = new Option("w", "width", true, "Window width in px");
        Option ptl = new Option("lf", "levelFolder", true, "Defines location of level assets");
        Option sl = new Option("fl", "firstLevelFile", true, "Defines the starting level asset");
        Option fps = new Option("fps", "framesPerSecond", true, "Defines the frames per second the software runs at");
        Option virtualHeight = new Option("vh", "virtualHeight", true, "Defines the Virtual height");
        Option resizable = new Option("re", "resizable", true, "Resizable true/false, defaults to false");
        Option fullscreen = new Option("fs", "fullscreen", true, "Fullscreen true/false, defaults to false");
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        if (cmd.hasOption("h")) {
            try {
                GlobalParameters.setHeight((int) cmd.getParsedOptionValue("height"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("w")) {
            try {
                GlobalParameters.setWidth((int) cmd.getParsedOptionValue("width"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("ptl")) {
            try {
                GlobalParameters.setLevelFolder((String) cmd.getParsedOptionValue("ptl"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("sl")) {
            try {
                GlobalParameters.setStartLevelFile((String) cmd.getParsedOptionValue("sl"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("fr")) {
            try {
                GlobalParameters.setFramesPerSecond((int) cmd.getParsedOptionValue("fr"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("vh")) {
            try {
                GlobalParameters.setVirtualHeight((int) cmd.getParsedOptionValue("vh"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (cmd.hasOption("re")) {
            if (cmd.getOptionValue("re") == "true") {
                GlobalParameters.setResizable(true);
            } else {
                GlobalParameters.setResizable(false);
            }
        }
        if (cmd.hasOption("fs")) {
            if (cmd.getOptionValue("fs") == "true") {
                GlobalParameters.setFullscreen(true);
            } else {
                GlobalParameters.setFullscreen(false);
            }
        }

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle(GlobalParameters.getWindowname());
        config.setForegroundFPS(GlobalParameters.getFramesPerSecond());
        // appropriately sets borderless window mode if toggled
        if (GlobalParameters.isFullscreen()) {
            config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        } else {
            config.setWindowedMode(GlobalParameters.getWidth(), GlobalParameters.getHeight());
            config.setResizable(GlobalParameters.isResizable());
        }
        new Lwjgl3Application(new GameSetup(mc), config);
    }

}
