package fdg.desktopmodule;

import fdg.game.Nodes;
import com.jme3.system.AppSettings;

/**
 * Used to launch a jme application in desktop environment
 *
 */
public class DesktopLauncher {
    public static void main(String[] args) {
        final Nodes game = new Nodes();

        final AppSettings appSettings = new AppSettings(true);

        game.setSettings(appSettings);
        game.setShowSettings(false); //Settings dialog not supported on mac
        game.start();
    }
}
