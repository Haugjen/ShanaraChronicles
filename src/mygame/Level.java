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
public class Level {
    ArrayList<Sprite> sprites;
    ArrayList<SolidSprite> solids;

    public Level(ArrayList<Sprite> sprites, ArrayList<SolidSprite> solids) {
        this.sprites = sprites;
        this.solids = solids;
    }
    
    
}
