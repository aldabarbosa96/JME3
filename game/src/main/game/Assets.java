package fdg.game;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.font.BitmapText;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class Assets extends SimpleApplication {
    private Geometry ninja;

    public static void main(String[] args) {
        Assets app = new Assets();
        app.start();

    }
    @Override
    public void simpleInitApp() {

        /* load a teapot model (OBJ file from jme3-testdata)  TEAPOT*/
        Spatial teapot = assetManager.loadModel("Models/Teapot/teapot.obj");
        Material mat_default = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
        teapot.setMaterial(mat_default);
        teapot.setLocalTranslation(0f,-4.4f,7f);
        rootNode.attachChild(teapot);

        /* create a wall (Box with material and texture from jme3-testdata) STONE_FLOOR*/
        Box box = new Box(2.5f,2.5f,1.0f);
        Spatial wall = new Geometry("Box", box );
        Material mat_brick = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_brick.setTexture("ColorMap", assetManager.loadTexture("Textures/BrickWall.jpg"));
        wall.setMaterial(mat_brick);
        wall.setLocalTranslation(7.0f,-2.5f,-10f);
        rootNode.attachChild(wall);

        /* display a line of text (default font from jme3-testdata)  TEXT*/
        setDisplayStatView(true);
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText statsText = new BitmapText(guiFont);
        statsText.setSize(guiFont.getCharSet().getRenderedSize());
        statsText.setText("Source Alpha Footage V.01");
        statsText.setLocalTranslation(300, statsText.getLineHeight(), 0);
        guiNode.attachChild(statsText);

        /* load a Ninja model (OgreXML + material + texture from test_data) NINJA*/
        Spatial ninja = assetManager.loadModel("Models/Ninja/ninja.mesh.xml");
        // Aplicar el material y la textura adecuados al Ninja
        ninja.scale(0.05f, 0.05f, 0.05f);
        ninja.rotate(0.0f, -3.0f, 0.0f);
        ninja.setLocalTranslation(0.0f, -4.7f, -2.0f);
        rootNode.attachChild(ninja);

        /* add a light to make the model visible.*/
        DirectionalLight light0 = new DirectionalLight();
        light0.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal());
        rootNode.addLight(light0);

        DirectionalLight light1 = new DirectionalLight();
        light1.setDirection(new Vector3f(0f, 0f, 1f).normalizeLocal());
        rootNode.addLight(light1);

        DirectionalLight light2 = new DirectionalLight();
        light2.setDirection(new Vector3f(1f, 0f, 0f).normalizeLocal());
        rootNode.addLight(light2);

        /*DirectionalLight light0 = new DirectionalLight();
        light0.setDirection(new Vector3f(0f, 1f, 0f).normalizeLocal());
        rootNode.addLight(light0);*/
        /*DirectionalLight light2 = new DirectionalLight();
        light2.setDirection(new Vector3f(0f, -1f, 0f).normalizeLocal());
        rootNode.addLight(light2);*/

        Box woodWall = new Box(5f,5f,5f); //WOOD_BOX
        Spatial wood = new Geometry("Wood Wall",woodWall);
        Material mat_wood = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_wood.setTexture("ColorMap", assetManager.loadTexture("Textures/WoodWall.jpg"));
        wood.setMaterial(mat_wood);
        wood.scale(0.2f,0.2f,0.2f);
        wood.setLocalTranslation(0f,-5.5f,7f);
        rootNode.attachChild(wood);

        /* import .jar docs by filtering .zip
        assetManager.registerLocator("game/town.zip", ZipLocator.class);
        Spatial gamelvl = assetManager.loadModel("main.scene");
        gamelvl.setLocalTranslation(0f,-5f,0f);
        gamelvl.setLocalScale(2);
        rootNode.attachChild(gamelvl);*/

        Spatial gameLevel = assetManager.loadModel("Scenes/town/main.scene");
        gameLevel.setLocalTranslation(0, -5.2f, 0);
        gameLevel.setLocalScale(2);
        rootNode.attachChild(gameLevel);
    }

}
