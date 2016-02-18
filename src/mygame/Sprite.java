/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.texture.Texture2D;

/**
 *
 * @author Morten
 */
public class Sprite extends Geometry {
    public boolean spacepressed = false;
    int gravityfreedom;
    public final int gravitymax = 20;
    public final float speed = 17;
    public final float gravity = 2;
    public final float jumpspeed = 20;
    
    public Vector3f moveVector;
    public Vector3f position;
    public Vector3f nextPosition;
 
    public float width;
    public float height;
    
    public Sprite(float x, float y) {
        moveVector = Vector3f.ZERO;
        position = getLocalTranslation();
        position.x = x;
        position.y = y;
                
    }
    

    
    public void update(){
        
    }
    
    public boolean isGrounded(){
        return true;
    }    
    
}
