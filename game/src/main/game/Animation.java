package fdg.game;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Animation extends SimpleApplication implements AnimEventListener {
    private AnimChannel channel;
    private AnimControl control;
    Node player;

    public static void main(String[] args) {
        Animation app = new Animation();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        viewPort.setBackgroundColor(ColorRGBA.LightGray);
        initKeys();
        DirectionalLight dl = new DirectionalLight();
        dl.setDirection(new Vector3f(-0.1f, -1f, -1).normalizeLocal());
        rootNode.addLight(dl);

        // Carga y adjuntado de modelo
        player = (Node) assetManager.loadModel("Models/Oto/OtoOldAnim.j3o");
        player.setLocalScale(0.5f);
        rootNode.attachChild(player);

        // Buscar AnimControl en el nodo player y sus subnodos
        control = findAnimControl(player);
        if (control != null) {
            control.addListener(this);
            channel = control.createChannel();
            channel.setAnim("stand");
            channel.setLoopMode(LoopMode.Loop);

            for (String anim : control.getAnimationNames()) { // animaciones disponibles
                System.out.println(anim);
            }

        } else {
            System.err.println("AnimControl not found in the model!");
        }
    }

    private AnimControl findAnimControl(Spatial spatial) {
        if (spatial instanceof Node) {
            Node node = (Node) spatial;
            AnimControl control = node.getControl(AnimControl.class);
            if (control != null) {
                return control;
            }
            for (Spatial child : node.getChildren()) {
                control = findAnimControl(child);
                if (control != null) {
                    return control;
                }
            }
        }
        return null;
    }

    @Override
    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        if (animName.equals("Walk")) {
            channel.setAnim("Walk", 0.50f);
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(1f);
        } else if (animName.equals("pull")) { // Cambio: Restablecer a "stand" después de "pull"
            channel.setAnim("stand", 0.50f);
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(1f);
        }
    }

    @Override
    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        // unused
    }

    /** Custom Keybinding: Map named actions to inputs. */
    private void initKeys() {
        inputManager.addMapping("Walk", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(actionListener, "Walk");

        inputManager.addMapping("pull", new KeyTrigger(KeyInput.KEY_H));
        inputManager.addListener(actionListener, "pull");
    }

    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("Walk") && !keyPressed) {
                if (channel != null) {
                    if (!"Walk".equals(channel.getAnimationName())) {
                        channel.setAnim("Walk", 0.50f);
                        channel.setLoopMode(LoopMode.Loop);
                    }
                } else {
                    System.err.println("AnimChannel is null!");
                }
            }
            if (name.equals("pull") && !keyPressed) {
                if (channel != null) {
                    if (!"pull".equals(channel.getAnimationName())) {
                        channel.setAnim("pull", 0.50f);
                        channel.setLoopMode(LoopMode.DontLoop);
                        channel.setSpeed(1f);
                    }
                } else {
                    System.err.println("AnimChannel is null!");
                }
            }
        }
    };
}
