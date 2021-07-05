package de.pmdungeon.desktop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import de.pmdungeon.game.GameSetup;
import de.pmdungeon.game.Controller.MainController;
import de.pmdungeon.tools.GlobalParameters;

/**
 * Contains the logic to run the dungeon, and to parse the launch parameters.
 *
 */
public class DesktopLauncher {
    private static final Logger LOGGER = Logger.getLogger(DesktopLauncher.class.getName());

    /**
     * Runs the dungeon.
     * 
     * @param mc   MainController of the Dungeon
     * @param args Launch parameters to override the default values -h Height of the
     *             window in px -w Width of the window in px -lf Path to folder
     *             containing level assets -fl file name of starting level -fps
     *             frame rate the program runs at in frames per second -vh Virtual
     *             height -re Sets whether the window is resizable -fs Sets the
     *             program to be fullscreen
     */
    public static void run(MainController mc, String[] args) {
        Options options = new Options();

        Option height = new Option("h", "height", true, "Window height in px");
        Option width = new Option("w", "width", true, "Window width in px");
        Option ptl = new Option("lf", "levelFolder", true, "Defines location of level assets");
        Option sl = new Option("fl", "firstLevelFile", true, "Defines the starting level asset");
        Option fps = new Option("fps", "framesPerSecond", true, "Defines the frames per second the software runs at");
        Option virtualHeight = new Option("vh", "virtualHeight", true, "Defines the Virtual height");
        Option resizable = new Option("re", "resizable", true, "Resizable true, defaults to false, true when set");
        Option fullscreen = new Option("fs", "fullscreen", true, "Fullscreen true, defaults to false, true when set");
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
                LOGGER.log(Level.FINE,
                        "Invalid Parameter for option Height. " + e.getMessage() + "Using default value instead.");
            }
        }
        if (cmd.hasOption("w")) {
            try {
                GlobalParameters.setWidth((int) cmd.getParsedOptionValue("width"));
            } catch (ParseException e) {
                LOGGER.log(Level.FINE,
                        "Invalid Parameter for option Width. " + e.getMessage() + "Using default value instead.");
            }
        }
        if (cmd.hasOption("lf")) {
            try {
                GlobalParameters.setLevelFolder((String) cmd.getParsedOptionValue("lf"));
            } catch (ParseException e) {
                LOGGER.log(Level.FINE,
                        "Invalid Path to level folder. " + e.getMessage() + "Using default value instead.");
            }
        }
        if (cmd.hasOption("fl")) {
            try {
                GlobalParameters.setStartLevelFile((String) cmd.getParsedOptionValue("fl"));
            } catch (ParseException e) {
                LOGGER.log(Level.FINE, "Invalid file name/path for starting level. " + e.getMessage()
                        + "Using default value instead.");
            }
        }
        if (cmd.hasOption("fps")) {
            try {
                GlobalParameters.setFramesPerSecond((int) cmd.getParsedOptionValue("fps"));
            } catch (ParseException e) {
                LOGGER.log(Level.FINE, "Invalid Parameter for option Frames per Second. " + e.getMessage()
                        + "Using default value instead.");
            }
        }
        if (cmd.hasOption("vh")) {
            try {
                GlobalParameters.setVirtualHeight((int) cmd.getParsedOptionValue("vh"));
            } catch (ParseException e) {
                LOGGER.log(Level.FINE, "Invalid Parameter for option Virtual Height. " + e.getMessage()
                        + "Using default value instead.");
            }
        }
        if (cmd.hasOption("re")) {
            GlobalParameters.setResizable(true);

        }
        if (cmd.hasOption("fs")) {
            GlobalParameters.setFullscreen(true);
        }

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle(GlobalParameters.getWindowname());
        config.setForegroundFPS(GlobalParameters.getFramesPerSecond());
        // appropriately sets borderless window mode if toggled
        if (GlobalParameters.isFullscreen()) {
            config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
            GlobalParameters.setHeight(Lwjgl3ApplicationConfiguration.getDisplayMode().height);
            GlobalParameters.setWidth(Lwjgl3ApplicationConfiguration.getDisplayMode().width);
        } else {
            config.setWindowedMode(GlobalParameters.getWidth(), GlobalParameters.getHeight());
            config.setResizable(GlobalParameters.isResizable());
        }
        new Lwjgl3Application(new GameSetup(mc), config);
    }

}
