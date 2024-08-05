package fdg.game;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Loop extends SimpleApplication {
    private Geometry player;

    public static void main(String[] args) {
        Loop gameLoop = new Loop();
        gameLoop.start();
    }
    @Override
    public void simpleInitApp() {
        Box box = new Box(1,1,1);
        Material material = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Red);
        player = new Geometry("blue cube",box);
        player.setMaterial(material);
        rootNode.attachChild(player);
    }

    @Override
    public void simpleUpdate(float frames){
        player.rotate(0,2*frames,0);


    }
}
