package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.RawInputListener;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.system.AppSettings;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

        SolidSprite dirtblock;
    CharacterSprite player;
    Vector3f startPos;
    long timeLastUpdate;
    ArrayList<Sprite> sprites;
    ArrayList<SolidSprite> solids;
    Level level01;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public Main() {

        sprites = new ArrayList<Sprite>();
        solids = new ArrayList<SolidSprite>();
        level01 = new Level(sprites, solids);
        setShowSettings(false);
        AppSettings appSettings = new AppSettings(true);
        appSettings.put("Width", Toolkit.getDefaultToolkit().getScreenSize().width);
        appSettings.put("Height", Toolkit.getDefaultToolkit().getScreenSize().height);

        appSettings.put("Fullscreen", false);
        appSettings.put("Title", "Shanara Chronicles");
        appSettings.put("VSync", true);

        setSettings(appSettings);

        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
    }

    @Override
    public void simpleInitApp() {



        Spritefactory spritefactory = new Spritefactory(assetManager);

        Sprite cloud = spritefactory.makeSprite(200, 700, "cloud");
        dirtblock = (SolidSprite) spritefactory.makeSolidSprite(0, 0, "dirtblock");
        SolidSprite dirtblock2 = (SolidSprite) spritefactory.makeSolidSprite(dirtblock.width, 0, "dirtblock");
        SolidSprite redwall = (SolidSprite) spritefactory.makeSolidSprite(200, dirtblock.height + 1, "redwall");
        SolidSprite redwall2 = (SolidSprite) spritefactory.makeSolidSprite(200, dirtblock.height + 1 + redwall.height+1, "redwall");
        player = (CharacterSprite) spritefactory.makeCharacterSprite(50, dirtblock.height + 40, "link", level01);
        startPos = player.position.clone();
        sprites.add(player);
        sprites.add(cloud);

        solids.add(redwall);
        solids.add(redwall2);
        solids.add(dirtblock);
        solids.add(dirtblock2);

        RawInputListener ril = new InputHandler(player);
        inputManager.addRawInputListener(ril);
        for (int i = 0; i < sprites.size(); i++) {
            guiNode.attachChild(sprites.get(i));
        }
        for (int i = 0; i < solids.size(); i++) {
            guiNode.attachChild(solids.get(i));
        }

//
//        rootNode.attachChild(g2);
//        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        
        if(player.position.y + player.height < 0){
            player.position = startPos.clone();
        }
        
        for (int i = 0; i < solids.size(); i++) {
            player.blockedHorizontal(solids.get(i));
            player.blockedVertically(solids.get(i));

        }
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update();
        }
        if (System.currentTimeMillis() > timeLastUpdate + 200) {
            timeLastUpdate = System.currentTimeMillis();

        }


    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
