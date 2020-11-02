/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import marko.Screen.Game;
import marko.Screen.MainMenu;
import marko.control.KeyInput;
import marko.gfx.Camera;
import marko.gfx.Player;

/**
 *
 * @author Amr
 */
public class GameLoop extends Pane {

    private Timeline time;
    private KeyFrame GameFrame, GameFrame1;
    private Scene scene;
    private KeyInput key;
    private Game game;
    private Camera camera;
    private int counter = 0 ;

    public GameLoop(Scene scene) {
        this.scene = scene;
        time = new Timeline();
        time.setCycleCount(Animation.INDEFINITE);
        InitializeMainMenu();

    }

    private void InitializeMainMenu() {
        MainMenu menu = new MainMenu(this);
        menu.render();
        scene.setRoot(menu);

    }

    private void initializeGame() {

        game = new Game(this);
        game.render();

        key = new KeyInput(this);
        key.Enabled();

        camera = new Camera(this);

    }

    public void start() {
        if (GameFrame != null) {
            return;
        }
        initializeGame();
        GameFrame = new KeyFrame(Duration.seconds(.005), (ActionEvent event) -> {
            render();
            if (counter % 9 == 0){
                animation();
              
            }
            counter ++;
        });

        time.getKeyFrames().add(GameFrame);

        time.play();
    }

    public void Pasue() {
        if (GameFrame == null) {
            return;
        }
        time.pause();
    }

    public Scene getMainScene() {
        return scene;
    }

    private void render() {
        if(Player.IS_STUCK){
            camera.update();
        }

    }

    private void animation() {
        game.updatePlayer();

    }

}
