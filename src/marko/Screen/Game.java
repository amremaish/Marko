/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.Screen;

import javafx.scene.paint.Color;
import marko.GameLoop;
import marko.Marko;
import marko.control.KeyInput;
import marko.gfx.Entity;
import marko.gfx.Player;
import marko.gfx.Wall;
import marko.gfx.world;
import static marko.gfx.world.player;
import marko.physics.Collision;
import marko.physics.Jump;

/**
 *
 * @author Amr
 */
public class Game {

    private GameLoop gameLoop;
    private Jump jump;

    public Game(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void render() {
        for (int i = 0; i < world.WORLD.length; i++) {
            for (int j = 0; j < world.WORLD[i].length(); j++) {
                Entity e = world.DrawEntity(world.WORLD[i].charAt(j), i, j);
                if (e instanceof Player) {
                    Entity sky = world.DrawEntity(world.sky, i, j);
                    gameLoop.getChildren().add(sky);
                }
                gameLoop.getChildren().add(e);
            }
        }
        player.toFront();
        jump = new Jump(player);

    }

    public void updatePlayer() {
        if (player.IS_JUMPING) {
            jump.jumpPlayer();
        } else {
            jump.fall();
        }

        if (KeyInput.RIGHT) {
            player.walkRight();
        } else if (KeyInput.LEFT) {
            player.walkLeft();
        } else if (KeyInput.SPACE && !player.IS_JUMPING) {
            jump.jumpPlayer();
        } else {
            world.player.animateIdle();
        }

    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

}
