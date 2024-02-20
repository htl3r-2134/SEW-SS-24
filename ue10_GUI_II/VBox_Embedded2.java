package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VBox_Embedded2 extends Application {
    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("VBox in Borderpane v.2");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 200);
        primarystage.setScene(scene);

        CheckBox bild = new CheckBox("Bild");
        CheckBox text = new CheckBox("Text");
        Button darstellen = new Button("Darstellen");
        darstellen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        darstellen.setMinWidth(Control.USE_PREF_SIZE);

        StackPane stackPane_darstellen = new StackPane();
        darstellen.setAlignment(Pos.BOTTOM_CENTER);
        VBox.setVgrow(stackPane_darstellen, Priority.ALWAYS);
        stackPane_darstellen.getChildren().add(darstellen);

        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(15));
        vBox.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.getChildren().addAll(bild, text, darstellen, stackPane_darstellen);

        BorderPane.setMargin(vBox, new Insets(10));
        borderPane.setRight(vBox);

        primarystage.show();
    }
}
