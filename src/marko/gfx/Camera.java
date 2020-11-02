/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.gfx;

import javafx.scene.shape.Rectangle;
import marko.GameLoop;
import marko.Marko;
import marko.control.KeyInput;

/**
 *
 * @author Amr
 */
public class Camera {

    private GameLoop loop;
    private Rectangle rec;
    private int OffsetX;

    public Camera(GameLoop loop) {
        this.loop = loop;
        initialize();
    }

    public void update() {

        if (KeyInput.LEFT) {
            OffsetX -= 1;
        } else if (KeyInput.RIGHT) {
            OffsetX += 1;
        }
        if (OffsetX <= 0) {
            OffsetX = 0;
        }
        rec.setTranslateX(OffsetX);
        loop.setTranslateX(OffsetX * -1);

    }

    private void initialize() {
        rec = new Rectangle();
        rec.setTranslateX(OffsetX);
        rec.setWidth(Marko.WIDTH);
        rec.setHeight(Marko.HEIGHT);
        loop.setClip(rec);
    }

}
