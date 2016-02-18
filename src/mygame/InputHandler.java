/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.input.KeyInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

/**
 *
 * @author Morten
 */
public class InputHandler implements RawInputListener {

    CharacterSprite player;
    Vector3f position;
    boolean left,right;

    public InputHandler(CharacterSprite player) {
        this.player = player;
        position = player.getLocalTranslation();
    }

    public void beginInput() {
    }

    public void endInput() {
    }

    public void onJoyAxisEvent(JoyAxisEvent evt) {
    }

    public void onJoyButtonEvent(JoyButtonEvent evt) {
    }

    public void onMouseMotionEvent(MouseMotionEvent evt) {
    }

    public void onMouseButtonEvent(MouseButtonEvent evt) {
    }

    public void onKeyEvent(KeyInputEvent evt) {
        if (evt.getKeyCode() == KeyInput.KEY_D && evt.isPressed()) {
            
            right = true;
        }
        else if (evt.getKeyCode() == KeyInput.KEY_A && evt.isPressed()) {
            
            left = true;
        } 
        else if ((evt.getKeyCode() == KeyInput.KEY_W || evt.getKeyCode() == KeyInput.KEY_SPACE ) && evt.isPressed() && player.isGrounded()) {
            player.moveVector.y = player.jumpspeed;
            player.spacepressed = true;
         //   player.grounded = false;
            player.gravityfreedom = player.gravitymax;
        } 
        else if ((evt.getKeyCode() == KeyInput.KEY_W || evt.getKeyCode() == KeyInput.KEY_SPACE )
                && evt.isReleased()) {
            player.spacepressed = false;
            
        }
        else if (evt.isReleased() && evt.getKeyCode() == KeyInput.KEY_D ){
            right = false;
        }
        else if(evt.isReleased() && evt.getKeyCode() == KeyInput.KEY_A ){
            left = false;
                
            
        }
        
        if(!right && !left || right && left){
            player.moveVector.x = 0;
        } else if (left){
            player.moveVector.x = player.speed*-1;
        } else if (right){
            player.moveVector.x = player.speed;
        }

    }

    public void onTouchEvent(TouchEvent evt) {
    }
}
