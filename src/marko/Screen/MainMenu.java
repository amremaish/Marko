/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.Screen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import marko.GameLoop;
import marko.utility.Style;

/**
 *
 * @author Amr
 */
public class MainMenu extends BorderPane {

    private Button Start, Settings, Quit;
    private GameLoop game;

    public MainMenu(GameLoop game) {
        this.game = game;
    }

    public void render() {
        VBox box = new VBox();
        box.setSpacing(30);
        box.setAlignment(Pos.CENTER);
        Start = new Button("Start");
        Start.setStyle(Style.MENU_BUTTON_STYLE);
        Settings = new Button("Settings");
        Settings.setStyle(Style.MENU_BUTTON_STYLE);
        Quit = new Button("Quit");
        Quit.setStyle(Style.MENU_BUTTON_STYLE);
        box.getChildren().addAll(Start, Settings, Quit);
        this.setCenter(box);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(75, 89, 102, 0.9), CornerRadii.EMPTY, Insets.EMPTY)));
        StackPane txtPane = new StackPane();
        BorderPane.setMargin(txtPane, new Insets(50, 0, 0, 0));
        txtPane.setAlignment(Pos.CENTER);
        Text text_header = new Text("POULA IS HERE");
        text_header.setFill(Color.ORANGE);
        text_header.setFont(Font.font("Helvetica", FontWeight.BOLD, 80));
        txtPane.getChildren().add(text_header);
        this.setTop(txtPane);

        Actions();

    }

    private void Actions() {
        MouseEnter(Start);
        MouseEnter(Settings);
        MouseEnter(Quit);

        MouseExit(Start);
        MouseExit(Settings);
        MouseExit(Quit);

        Start.setOnAction(e -> {
            game.getMainScene().setRoot(game);
            game.start();
        });
        
        Settings.setOnAction(e -> {

        });

        Quit.setOnAction(e -> {

        });
    }

    private void MouseEnter(Button b) {
        b.setOnMouseEntered(e -> {
            Button temp = (Button) e.getSource();
            temp.setStyle(Style.MENU_BUTTON_STYLE_HOVER);
        });
    }

    private void MouseExit(Button b) {
        b.setOnMouseExited(e -> {
            Button temp = (Button) e.getSource();
            temp.setStyle(Style.MENU_BUTTON_STYLE);
        });
    }

}
