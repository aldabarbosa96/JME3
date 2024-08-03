package fdg.android;

import com.jme3.app.AndroidHarness;
import fdg.game.FDG;


public class AndroidLauncher extends AndroidHarness {

    public AndroidLauncher() {
        appClass = FDG.class.getCanonicalName();
    }
}
