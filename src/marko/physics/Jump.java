/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.physics;

import marko.gfx.Entity;
import static marko.gfx.Player.IS_STUCK;
import marko.gfx.world;
import static marko.gfx.world.player;

/**
 *
 * @author Amr
 */
public class Jump {

    private Entity entity;
    private float velocity = 20.0f;
    private float falling = -10f;
    private final float gravity = -1f;

    public Jump(Entity entity) {
        this.entity = entity;
        reset();
    }

    public void reset() {
        player.IS_JUMPING = false;
        player.IS_FALLING = false;
        velocity = 20.0f;
        falling = -10f;
    }

    public void jumpPlayer() {
        if (Collision.PlayerCollision(player, 0, velocity * -1, world.WORLD)) {
            reset();
            return;
        }
        player.IS_JUMPING = true;
        entity.setTranslateY(entity.getTranslateY() - velocity);
        velocity += gravity;
    }

    public void fall() {
        if (Collision.PlayerCollision(player, 0, falling * -1, world.WORLD)) {
            reset();
            return;
        }
        player.IS_FALLING = true;
        entity.setTranslateY(entity.getTranslateY() - falling);
        falling += gravity;
    }

}
