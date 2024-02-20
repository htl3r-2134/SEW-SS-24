package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HBox_Embedded2 extends Application {
     @Override
    public void start(Stage primarystage) {
         primarystage.setTitle("HBox in Borderpane v.2");
         BorderPane borderPane = new BorderPane();
         Scene scene = new Scene(borderPane, 600, 200);
         primarystage.setScene(scene);

         Label dateiname = new Label("Dateiname");
         TextField textField = new TextField();
         textField.setPrefWidth(200);
         Button bearbeiten = new Button("Bearbeiten");
         bearbeiten.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
         bearbeiten.setMinWidth(Control.USE_PREF_SIZE);

         StackPane button_bearbeiten = new StackPane();
         button_bearbeiten.setAlignment(Pos.CENTER_RIGHT);
         HBox.setHgrow(button_bearbeiten, Priority.ALWAYS);
         button_bearbeiten.getChildren().addAll(bearbeiten);

         HBox hBox = new HBox();
         hBox.setSpacing(15);
         hBox.setPadding(new Insets(10));
         hBox.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
         hBox.getChildren().addAll(dateiname, textField, button_bearbeiten, bearbeiten);

        BorderPane.setMargin(hBox, new Insets(5));
        borderPane.setTop(hBox);

         primarystage.show();

     }
}
