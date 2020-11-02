/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.control;

import javafx.scene.input.KeyCode;
import marko.GameLoop;

/**
 *
 * @author Amr
 */
public class KeyInput {

    private GameLoop loop;
    public static boolean LEFT, RIGHT, UP, DOWN, SPACE;

    public KeyInput(GameLoop loop) {
        this.loop = loop;
    }

    public void Enabled() {
        loop.getMainScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                UP = true;
            } else if (e.getCode() == KeyCode.DOWN) {
                DOWN = true;
            } else if (e.getCode() == KeyCode.LEFT) {
                LEFT = true;
            } else if (e.getCode() == KeyCode.RIGHT) {
                RIGHT = true;
            } else if (e.getCode() == KeyCode.SPACE) {
                SPACE = true;
            }
        });

        loop.getMainScene().setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.UP) {
                UP = false;
            } else if (e.getCode() == KeyCode.DOWN) {
                DOWN = false;
            } else if (e.getCode() == KeyCode.LEFT) {
                LEFT = false;
            } else if (e.getCode() == KeyCode.RIGHT) {
                RIGHT = false;
            } else if (e.getCode() == KeyCode.SPACE) {
                SPACE = false;
            }
        });
    }

}
