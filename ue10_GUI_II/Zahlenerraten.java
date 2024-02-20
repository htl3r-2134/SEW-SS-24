package Heyderer.ue10_GUI_II;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Zahlenerraten extends Application {
    private static int kleinsteZahl;
    private static int groessteZahl;
    private String textAreaText = "";
    private int Versuche = 1;
    private int letzteZahl;

    public static int randomZahl() {
        int randomZahl = 0;
        int groesste_oder_kleinste = (int) (Math.random() * 3);
        if (groesste_oder_kleinste == 1 || groesste_oder_kleinste == 0) {
            randomZahl = RandomGroessteZahl();
        } else if (groesste_oder_kleinste == 2) {
            randomZahl = RandomKleinsteZahl();
        }
        return randomZahl;
    }

    public static int RandomGroessteZahl() {
        return (int) (Math.random() * groessteZahl);
    }

    public static int RandomKleinsteZahl() {
        return (int) (Math.random() * kleinsteZahl);
    }

    public static int randomKleinsteZahlIntervall() {
        int kleinsteIntervallZahl = 0;
        int minus_plus = (int) (Math.random() * 3);
        if (groessteZahl < 0) {
            kleinsteIntervallZahl = (int) (Math.random() * -1000);
        } else {
            if (minus_plus == 1 || minus_plus == 0) {
                kleinsteIntervallZahl = (int) (Math.random() * 1000);
            } else {
                kleinsteIntervallZahl = (int) (Math.random() * -1000);
            }
        }
        if (kleinsteIntervallZahl >= groessteZahl) {
            randomKleinsteZahlIntervall();
        }
        return kleinsteIntervallZahl;
    }

    public static int randomGroessteZahlIntervall() {
        int groessteIntervallZahl = 0;
        int minus_plus = (int) (Math.random() * 3);
        if (minus_plus == 1 || minus_plus == 0) {
            groessteIntervallZahl = (int) (Math.random() * 1000);
        } else {
            groessteIntervallZahl = (int) (Math.random() * -1000);
        }
        return groessteIntervallZahl;
    }

    @Override
    public void start(Stage primarystage) {
        primarystage.setTitle("Zahlenraten");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 200);
        primarystage.setScene(scene);


            int GroessteZahl = randomGroessteZahlIntervall();
            int KleinsteZahl = randomKleinsteZahlIntervall();

        TextArea textArea = new TextArea();
        textArea.setText("Denke die eine Zahl aus dem Intervall [" + KleinsteZahl + ", " + GroessteZahl +  "]" +
                " aus,\nich versuche sie zu erraten.\nWenn ich sie erraten habe, gib den Buchstaben r " +
                "(= richtig) ein.\nBeginne das Raten mit dem Start Button.");
        textArea.setPrefWidth(400);
        textArea.setEditable(false);

        kleinsteZahl = KleinsteZahl;
        groessteZahl = GroessteZahl;


        Button start = new Button("Start");
        start.setMinWidth(Control.USE_PREF_SIZE);
        start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Label tipp = new Label("Tipp:");
        tipp.setPadding(new Insets(5, 0, 0, 0));
        TextField k_g_r = new TextField();
        k_g_r.setPrefWidth(90);
        k_g_r.setPromptText("Eingabe: k|g|r");

        StackPane stackPane_tipp_kgr = new StackPane();
        stackPane_tipp_kgr.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(stackPane_tipp_kgr, Priority.ALWAYS);
        stackPane_tipp_kgr.getChildren().addAll(tipp, k_g_r);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(15);
        hBox1.setPadding(new Insets(10));
        hBox1.getChildren().addAll(start, stackPane_tipp_kgr, tipp, k_g_r);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(15);
        hBox2.setPadding(new Insets(10));
        hBox2.getChildren().addAll(textArea);

        BorderPane.setMargin(hBox1, new Insets(0, 10, 10, 10));
        BorderPane.setMargin(hBox2, new Insets(10, 10, 0, 10));
        borderPane.setCenter(hBox2);
        borderPane.setBottom(hBox1);

        primarystage.show();

        start.setOnAction(ActionEvent -> {
            textArea.clear();
            int ersteZahl = randomZahl();
            textAreaText += "1.Versuch - die Zahl ist: " + ersteZahl + "\nIst mein Tipp zu klein (k) oder zu groß (g)? ";
            textArea.setText(textAreaText);

            EventHandler<ActionEvent> textReader = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    textArea.setText(textAreaText += k_g_r.getText());
                    textArea.setText(textAreaText += "\n");

                    if (k_g_r.getText().equals("k")) {
                        if (Versuche == 1) {
                            kleinsteZahl = ersteZahl;
                        } else {
                            kleinsteZahl = letzteZahl;
                        }
                        int randomZahl1 = randomZahl();
                        if (randomZahl1 < kleinsteZahl || randomZahl1 > groessteZahl) {
                            randomZahl1 = randomZahl();
                        }
                        Versuche += 1;
                        textAreaText += Versuche + ".Versuch - die Zahl ist: " + randomZahl1 + "\nIst mein Tipp zu klein" +
                                " (k) oder zu groß (g)? ";
                        textArea.setText(textAreaText);
                        letzteZahl = randomZahl1;
                    }
                    if (k_g_r.getText().equals("g")) {
                        if (Versuche == 1) {
                            groessteZahl = ersteZahl;
                        } else {
                            groessteZahl = letzteZahl;
                        }
                        int randomZahl2 = randomZahl();
                        if (randomZahl2 < kleinsteZahl || randomZahl2 > groessteZahl) {
                            randomZahl2 = randomZahl();
                        }
                        Versuche += 1;
                        textAreaText += Versuche + ".Versuch - die Zahl ist: " + randomZahl2 + "\nIst mein Tipp zu klein" +
                                " (k) oder zu groß (g)? ";
                        textArea.setText(textAreaText);
                        letzteZahl = randomZahl2;
                    }
                    if (k_g_r.getText().equals("r")) {
                        textAreaText += "--> Endlich habe ich die Zahl erraten!";
                        textArea.setText(textAreaText);
                    }

                    k_g_r.clear();
                    k_g_r.requestFocus();
                }
            };
            k_g_r.setOnAction(textReader);



            /*
            for (int i = 2; i < (groessteZahl * 2); i++) {

                textAreaText += (i + ".Versuch - die Zahl ist: " + randomZahl + "\nIst mein Tipp zu klein (k) oder zu groß (g)?\n");
                textArea.setText(textAreaText);

                if (k_g_r.getText().equals("k")) {
                    groessteZahl = randomZahl;
                }
                if (k_g_r.getText().equals("g")) {
                    kleinsteZahl = randomZahl;
                }
                if (k_g_r.getText().equals("r")) {
                    textAreaText += "--> Endlich habe ich die Zahl erraten!";
                }
            }

             */
        });
    }
}
