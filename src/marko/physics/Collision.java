/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.physics;

import marko.control.KeyInput;
import marko.gfx.Entity;
import marko.gfx.world;

/**
 *
 * @author Amr
 */
public class Collision {

    public static boolean PlayerCollision(Entity entity, double addedXValue, double addedYValue, String WORLD[]) {
        int rightLeft = (KeyInput.RIGHT == true ? 1 : KeyInput.LEFT == true ? -1 : 1);
        System.out.println("Y = " + entity.getY_pos(addedYValue) + " " + entity.getX_pos(addedXValue, rightLeft) + " - " + WORLD[entity.getY_pos(addedYValue)].charAt(entity.getX_pos(addedXValue, rightLeft)));
        if (WORLD[entity.getY_pos(addedYValue)].charAt(entity.getX_pos(addedXValue, rightLeft)) == world.wall) {
            return true;
        }
        return false;
    }

}
