package fdg.game;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.app.state.AppState;
import com.jme3.system.AppSettings;

public class Nodes extends SimpleApplication {

    public static void main(String[] args) {

        Nodes fdg = new Nodes();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("F3DG");
        fdg.setSettings(settings);

        fdg.start();
    }

    public Nodes() {
    }

    public Nodes(AppState... initialStates) {
        super(initialStates);
    }

    @Override
    public void simpleInitApp() {

        Box box1 = new Box(1, 1, 1);
        Geometry blueCube = new Geometry("Box", box1);
        blueCube.setLocalTranslation(new Vector3f(1, -1, 1));
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);
        blueCube.setMaterial(material);

        Box box2 = new Box(0.8f, 0.8f, 0.8f);
        Geometry redCube = new Geometry("Box1", box2);
        redCube.setLocalTranslation(new Vector3f(1, 1, 1));
        Material material1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material1.setColor("Color", ColorRGBA.Red);
        redCube.setMaterial(material1);

        Box box3 = new Box(0.3f,0.3f,0.1f);
        Geometry greenCube = new Geometry("Box2", box3);
        Material material2 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        material2.setColor("Color",ColorRGBA.Green);
        greenCube.setMaterial(material2);

        Node pivot = new Node("pivot"); //by default the Node is positioned at (0,0,0).
        rootNode.attachChild(pivot); //Necesario attach el Node al rootNode
        pivot.attachChild(redCube);
        pivot.attachChild(blueCube);
        pivot.attachChild(greenCube);
        //rootNode.detachAllChildren(); attach para incluir y detach para eliminar (gráficamente)
        pivot.rotate(.4f, .4f, 0f);


    }

}
