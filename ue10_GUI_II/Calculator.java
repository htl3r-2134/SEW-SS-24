package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Calculator");
        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);
        Scene scene = new Scene(flowPane, 350, 200);
        primarystage.setScene(scene);

        flowPane.setPadding(new Insets(10, 0, 0, 10));
        flowPane.setVgap(20);
        flowPane.setHgap(30);

        TextField z1 = new TextField();
        z1.setPrefColumnCount(10);
        TextField z2 = new TextField();
        z2.setPrefColumnCount(10);

        Button buttonplus = new Button("buttonplus");
        Button buttonminus = new Button("buttonminus");
        Button buttonmal = new Button("buttonmal");
        Button buttondividiert = new Button("buttondividiert");
        Label erg = new Label("erg");

        flowPane.getChildren().addAll(buttonplus, buttonminus, buttonmal, buttondividiert, erg, z1, z2);

        primarystage.show();


        buttonplus.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 + zahlz2;
            erg.setText("" + sum);
        } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });

        buttonminus.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 - zahlz2;
            erg.setText("" + sum);
            } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });

        buttonmal.setOnAction(actionEvent -> {
            try {
            double zahlz1 = Double.parseDouble(z1.getText());
            double zahlz2 = Double.parseDouble(z2.getText());
            double sum = zahlz1 * zahlz2;
            erg.setText("" + sum);
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
                erg.setText("" + sum);
            } else {
                erg.setText("Eine Zahl ist 0");
            }

            } catch (Exception e) {
                erg.setText("Falsche eingabe!");
            }
        });
    }
}
