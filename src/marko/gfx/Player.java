/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.gfx;

import static marko.gfx.world.player;
import marko.physics.Collision;

/**
 *
 * @author Amr
 */
public class Player extends Entity {

    private int x, y;
    private int w, h;
    private final int speed = 9;
    private spriteSheet RunRight, idle, RunLeft;
    public static boolean IS_STUCK;
     public static boolean IS_JUMPING;
     public static boolean IS_FALLING;

    public Player(int x, int y, int w, int h, String iconName) {
        super(x, y, w, h, "Idle__000");
        RunRight = new spriteSheet();
        RunLeft = new spriteSheet();
        idle = new spriteSheet();
        loadSheets();
    }

    private void loadSheets() {

        // run right
        for (int i = 0; i < 10; i++) {
            RunRight.addSheet(x, y, w, h, "Run__00" + i);

        }

        // run left
        for (int i = 0; i < 10; i++) {
            RunLeft.addSheet(x, y, w, h, "left_Run__00" + i);

        }
        // idle
        for (int i = 0; i < 10; i++) {
            idle.addSheet(x, y, w, h, "Idle__00" + i);
        }

    }

    public void animateIdle() {
        super.setImage(idle.nextSprite().getImage());
    }

    public boolean walkRight() {
        super.setImage(RunRight.nextSprite().getImage());
        if (Collision.PlayerCollision(player, speed, 0, world.WORLD)) {
            IS_STUCK = false;
            return false;
        }
        super.setTranslateX(super.getTranslateX() + speed);
        IS_STUCK = true;
        return true;
    }

    public boolean walkLeft() {
        super.setImage(RunLeft.nextSprite().getImage());
        if (Collision.PlayerCollision(player, speed * -1, 0, world.WORLD)) {
            IS_STUCK = false;
            return false;
        }
        super.setTranslateX(super.getTranslateX() - speed);
        IS_STUCK = true;
        return true;
    }
    
    public int getSpeed(){
        return speed;
    }
    
}
