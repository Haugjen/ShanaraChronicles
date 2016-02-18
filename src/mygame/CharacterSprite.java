/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.ArrayList;

/**
 *
 * @author Morten
 */
public class CharacterSprite extends SolidSprite {

    public Level level;

    public CharacterSprite(float x, float y, Level level) {
        super(x, y);
        this.level = level;
    }

    @Override
    public void update() {
        super.update();
        gravityfreedom -= 1;
        if(this.getMaterial().getName().equals("goomba")){
        System.out.println(this.getMaterial().getName());
            System.out.println(isGrounded());
            System.out.println(spacepressed);
            System.out.println(gravityfreedom);
        }
//            System.out.println(isGrounded());
//            System.out.println(spacepressed);
//            System.out.println(gravityfreedom);
        for (int i = 0; i < level.solids.size(); i++) {
            blockedHorizontal(level.solids.get(i));
            blockedVertically(level.solids.get(i));

        }
        position = position.add(moveVector);
        if (!isGrounded() && (gravityfreedom <= 0 || !spacepressed)) {
            moveVector.y -= gravity;
//            System.out.println("free fall");
        }
        setLocalTranslation(position);
    }

    public boolean intersects(float x, float y, Sprite other) {
    //    System.out.println("intersect " + other);
        return x <= other.position.x + other.width
                && x + width >= other.position.x
                && y <= other.position.y + other.height
                && y + height >= other.position.y;
    }
    
  

    public void blockedHorizontal(Sprite other) {
       // boolean blocked = false;
        if(intersects(position.x + moveVector.x, position.y, other) ){
                float dx = Math.signum(moveVector.x);
                while(!intersects(position.x + dx, position.y, other)){
                    position.x += dx;
                }
                moveVector.x = 0;
                

        }

     //   return blocked;
    }

    public void blockedVertically(Sprite other) {
        if(intersects(position.x, position.y + moveVector.y, other)){
            float dy = Math.signum(moveVector.y);
            while(!intersects(position.x, position.y + dy, other)){
                position.y += dy;
            }

            moveVector.y = 0;

        }
    }

    @Override
    public boolean isGrounded() {
        boolean result = false;
        for (SolidSprite solid : level.solids) {
            if(intersects(position.x, position.y-1, solid)){
                result = true;
            }
        }
        return result;
    }
}
