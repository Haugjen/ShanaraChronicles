/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture2D;

/**
 *
 * @author Morten
 */
public class Spritefactory {
    AssetManager assetManager;

    public Spritefactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    public Sprite makeSprite(float x, float y, String texture){
        Sprite sprite = new Sprite(x,y);
        build(sprite,texture);
        return sprite;
    }
    public Sprite makeCharacterSprite(float x, float y, String texture, Level level){
        Sprite sprite = new CharacterSprite(x,y,level);
        build(sprite,texture);
        return sprite;
    }
    
//    public Sprite makeEnemySprite(float x, float y, String texture, Level level){
//        Sprite sprite = new EnemySprite();
//    }
    
    public Sprite makeSolidSprite(float x, float y, String texture){
        Sprite sprite = new SolidSprite(x,y);
        build(sprite,texture);
        return sprite;
    
    }
    
    
    public void build(Sprite sprite, String texture){
        Material material = new Material(assetManager, "MatDefs/SpriteSheet.j3md");
        material.setName(texture);
        Texture2D texture2d = (Texture2D) assetManager.loadTexture("Textures/"+texture+".png");
        material.setTexture("ColorMap", texture2d);
        material.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        material.setFloat("SizeX", 1);
        material.setFloat("SizeY", 1);
        sprite.width = texture2d.getImage().getWidth();
        sprite.height = texture2d.getImage().getHeight();
        sprite.setMesh(new Quad(sprite.width,sprite.height));
        sprite.setMaterial(material);
    }

}
