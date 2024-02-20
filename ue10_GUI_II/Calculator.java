package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Calculator extends Application {
    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Calculator");
        BorderPane borderPane1 = new BorderPane();
        Scene scene1 = new Scene(borderPane1, 350, 200);
        primarystage.setScene(scene1);

        TextField z1 = new TextField();
        z1.setPromptText("Erste Zahl");
        z1.setPrefColumnCount(10);
        TextField z2 = new TextField();
        z2.setPromptText("Zweite Zahl");
        z2.setPrefColumnCount(10);

        Button buttonplus = new Button("buttonplus");
        buttonplus.setPrefWidth(100);
        buttonplus.setAlignment(Pos.CENTER);
        Button buttonminus = new Button("buttonminus");
        buttonminus.setPrefWidth(100);
        buttonminus.setAlignment(Pos.CENTER);
        Button buttonmal = new Button("buttonmal");
        buttonmal.setPrefWidth(100);
        buttonmal.setAlignment(Pos.CENTER);
        Button buttondividiert = new Button("buttondividiert");
        buttondividiert.setPrefWidth(100);
        buttondividiert.setAlignment(Pos.CENTER);
        Label erg = new Label("Ergebnis:");

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setPadding(new Insets(15));
        vBox1.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox1.getChildren().addAll(z1, z2, erg);
        vBox1.setPrefWidth(150);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setPadding(new Insets(15));
        vBox2.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox2.getChildren().addAll(buttonplus, buttonminus, buttonmal, buttondividiert);
        vBox2.setPrefWidth(150);

        VBox.setMargin(buttonplus, new Insets(0, 10, 0, 10));
        VBox.setMargin(buttonminus, new Insets(0, 10, 0, 10));
        VBox.setMargin(buttonmal, new Insets(0, 10, 0, 10));
        VBox.setMargin(buttondividiert, new Insets(0, 10, 0, 10));

        BorderPane.setMargin(vBox1, new Insets(10));
        BorderPane.setMargin(vBox2, new Insets(10));
        borderPane1.setLeft(vBox1);
        borderPane1.setRight(vBox2);

        primarystage.show();


        buttonplus.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 + zahlz2;
            erg.setText("Ergebnis: " + sum);
        } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });

        buttonminus.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 - zahlz2;
            erg.setText("Ergebnis: " + sum);
            } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });

        buttonmal.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 * zahlz2;
            erg.setText("Ergebnis: " + sum);
            } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });

        buttondividiert.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            if (zahlz1 > 0 && zahlz2 > 0) {
                double sum = zahlz1 / zahlz2;
                erg.setText("Ergebnis: " + sum);
            } else {
                erg.setText("Eine Zahl ist 0");
            }

            } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });
    }
}
