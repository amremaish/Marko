/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.gfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Amr
 */
public class Entity extends ImageView {

    public static final int TILE_WIDTH = 50, TILE_HEIGHT = 50;

    private int X_pos, Y_pos;
    private int XBlocks, YBlocks;

    public Entity(int x, int y, String iconName) {
        X_pos = x;
        Y_pos = y;
        this.setFitWidth(TILE_WIDTH);
        this.setFitHeight(TILE_HEIGHT);
        this.setTranslateX(x * TILE_WIDTH);
        this.setTranslateY(y * TILE_HEIGHT);
        this.setImage(new Image("res/" + iconName + ".png"));
    }

    public Entity(int x, int y, int XBlocks, int YBlocks, String iconName) {
        X_pos = x;
        Y_pos = y;
        this.XBlocks = XBlocks;
        this.YBlocks = YBlocks;
        this.setFitWidth(TILE_WIDTH * XBlocks);
        this.setFitHeight(TILE_HEIGHT * YBlocks);
        this.setTranslateX(x * TILE_WIDTH - (TILE_WIDTH * (XBlocks - 1)));
        this.setTranslateY(y * TILE_HEIGHT - (TILE_HEIGHT * (YBlocks - 1)));
        this.setImage(new Image("res/" + iconName + ".png"));

    }

    public int getX_pos(double addedValue, int RightOrLeft) {

        return (int) (Math.ceil((this.getTranslateX() + addedValue) / TILE_WIDTH) + RightOrLeft * (XBlocks - 1));
    }

    public int getY_pos(double addedValue) {
        return (int) (Math.ceil((this.getTranslateY() + addedValue) / TILE_HEIGHT) +  (YBlocks - 1));
    }

    public int getX_pos() {
        return X_pos;
    }

    public void setX_pos(int X_pos) {
        this.X_pos = X_pos;
    }

    public int getY_pos() {
        return Y_pos;
    }

    public void setY_pos(int Y_pos) {
        this.Y_pos = Y_pos;
    }

}
