package fdg.android;

import com.jme3.app.AndroidHarness;
import fdg.game.Nodes;


public class AndroidLauncher extends AndroidHarness {

    public AndroidLauncher() {
        appClass = Nodes.class.getCanonicalName();
    }
}
