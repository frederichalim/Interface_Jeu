package View;

import Controller.ControllerPartie;
import Model.Chevalet;
import Model.Joueur;
import Model.Lettres;
import Model.Partie;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import java.awt.dnd.DragSource;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragGestureRecognizer;


public class ViewGame {

    private ControllerPartie controllerPartie;
    private Partie partie;
    private Group root;
    private ImageView imgBg;
    private Button pionLettre;
    private Button btnPrecedent;
    private Button btnJouer;
    private Button btnShake;
    private Text gameFullScreen;
    private Text gameDisabledScreen;
    private Text resolution;
    private Stage stage;
    private ImageView chevalet;
    private ImageView compteurPoints;
    private ImageView background;
    public String valeurLettre;
    public ImageView lettre1;
    private ImageView lettre2;
    private ImageView lettre3;
    private ImageView lettre4;
    private ImageView lettre5;
    private ImageView lettre6;
    private ImageView lettre7;
    private HBox hBox1;
    private HBox hBox2;
    private int axeX = 100;
    private int axeY = 955;
    ImageView iv;
    int curseur = 0;


    private int numeroLettre;


    /*************** Construtor ****************/
    public ViewGame(Group root, ViewHandler vh, Stage stage) {
        //Récupère les paramètres de ViewHandler
        this.root = root;

        this.partie = vh.getMp().getMenu().getPartie();
        this.controllerPartie = new ControllerPartie(this, vh);
        this.stage = stage; // Récupère stage
        //Appel des Méthodes
        initbutton();
        initBackground();
        //initHBox();

        //initLettres();
    }


    private void initBackground() { //Méthode Background
        imgBg = new ImageView(Path.fondMenu1);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight(950);
        imgBg.setFitWidth(950);
    }

//    private void initHBox() {
//        HBox hBox1 = new HBox();
//        hBox1.setPrefWidth(80);
//        hBox1.setPrefHeight(80);
//        hBox1.setStyle("-fx-border-color: red;"
//                + "-fx-border-width: 2;"
//                + "-fx-border-style: solid;");
//
//        //setupGestureTarget(hBox1);
//
//        HBox vBox = new HBox();
//        vBox.getChildren().addAll(hBox1);
//        root.getChildren().addAll(vBox);
//
//        root.getChildren().clear();
//
//    }
    private void initbutton() {

        ////////////////// Btn precedent ////////////
        btnPrecedent = new Button("Retour");
        btnPrecedent.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");

        // btnPrecedent.setFont(fontBtn);
        //btnPrecedent.setOpacity(0.50);
        btnPrecedent.setTranslateX(1050);
        btnPrecedent.setTranslateY(750);
        btnPrecedent.setPickOnBounds(false);
        btnPrecedent.setBackground(null);
        btnPrecedent.setMaxSize(200, 60);
        btnPrecedent.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton Précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                //btnPrecedent.setFont(fontBtn1);
                btnPrecedent.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
                //btnPrecedent.setTranslateY(345);
                //btnPrecedent.setEffect(shadow);
                //btnPrecedent.setOpacity(1);
                btnPrecedent.setOnMouseClicked(controllerPartie);

            }
        });
        btnPrecedent.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                // btnPrecedent.setFont(fontBtn);
                btnPrecedent.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
                // btnPrecedent.setEffect(null);
                //btnPrecedent.setOpacity(0.50);
                // btnPrecedent.setTranslateY(350);

            }
        });

        btnJouer = new Button("Jouer");
        btnJouer.setTranslateX(1050);
        btnJouer.setTranslateY(500);
        btnJouer.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");


        btnJouer.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton Précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                //btnPrecedent.setFont(fontBtn1);
                btnJouer.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
                //btnPrecedent.setTranslateY(345);
                //btnPrecedent.setEffect(shadow);
                //btnPrecedent.setOpacity(1);
                btnJouer.setOnMouseClicked(controllerPartie);

            }
        });
        btnJouer.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                // btnPrecedent.setFont(fontBtn);
                btnJouer.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
                // btnPrecedent.setEffect(null);
                //btnPrecedent.setOpacity(0.50);
                // btnPrecedent.setTranslateY(350);

            }
        });

        btnShake = new Button("Valider");
        btnShake.setTranslateX(1050);
        btnShake.setTranslateY(250);
        btnShake.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");

//
//        btnShake.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton Précedent
//
//            @Override
//            public void handle(MouseEvent t) {
//                //Modif élements précedent
//                //btnPrecedent.setFont(fontBtn1);
//                btnShake.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
//                //btnPrecedent.setTranslateY(345);
//                //btnPrecedent.setEffect(shadow);
//                //btnPrecedent.setOpacity(1);
//                btnShake.setOnMouseClicked(controllerPartie);
//
//            }
//        });
//        btnShake.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton précedent
//
//            @Override
//            public void handle(MouseEvent t) {
//                //Modif élements précedent
//                // btnPrecedent.setFont(fontBtn);
//                btnShake.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
//                // btnPrecedent.setEffect(null);
//                //btnPrecedent.setOpacity(0.50);
//                // btnPrecedent.setTranslateY(350);
//
//            }
//        });

    }


    public void fullScreen() {

        // recuperer optionFullScreen avec le root et l'effacer du parent
        root.getChildren().remove(gameFullScreen);
        // ajouter optionMediumScreen au parent root
        root.getChildren().add(gameDisabledScreen);
        // ajouter le btn precedent au parent root
        root.getChildren().add(btnPrecedent);
        root.getChildren().add(btnJouer);
        root.getChildren().add(btnShake);

        // enleve le bouton suivant au parent root
        //root.getChildren().remove(btnSuivant);
        // recuperer la taille de la fenetre et modif en le plein écran en false
        stage.setFullScreen(false);
    }

    public void disabledScreen() {

        // enleve le boutton precedent du parent root et text
        root.getChildren().remove(btnPrecedent);
        root.getChildren().remove(gameDisabledScreen);
        // ajoute le boutton suivant au parent root et text
        root.getChildren().add(gameFullScreen);
        root.getChildren().add(btnShake);
        root.getChildren().add(btnJouer);
        root.getChildren().add(btnPrecedent);
        //root.getChildren().add(btnSuivant);
        // recupere la fenetre et modification plein ecran
        stage.setFullScreen(true);
    }

    public void setVueCompleteGame() { //Méthode Setter
        //Attache au root parent les élements enfans
        root.getChildren().clear();//efface le contenu de la vue
        root.getChildren().add(imgBg);
        //root.getChildren().add(resolution);
        root.getChildren().add(btnPrecedent);
        root.getChildren().add(btnShake);
        root.getChildren().add(btnJouer);
        root.getChildren().add(chevalet);
        root.getChildren().add(compteurPoints);
        root.getChildren().add(lettre1);
        root.getChildren().add(lettre2);
        root.getChildren().add(lettre3);
        root.getChildren().add(lettre4);
        root.getChildren().add(lettre5);
        root.getChildren().add(lettre6);
        root.getChildren().add(lettre7);

       // root.getChildren().addAll(hBox1);
//        root.getChildren().addAll(hBox2);


//        root.getChildren().add(lettresB);
//        root.getChildren().add(lettresC);
//        root.getChildren().add(lettresD);
//        root.getChildren().add(lettresE);
//        root.getChildren().add(lettresF);
        //condition si il est plein écran
        if (stage.isFullScreen()) {

            //alors option en fullScreen
            root.getChildren().add(gameFullScreen);
            root.getChildren().add(btnJouer);

        } else {

            //sinon option en medium
            root.getChildren().add(gameDisabledScreen);
            root.getChildren().add(btnPrecedent);
        }


        root.getChildren().add(btnPrecedent);

    }




    public void initChevalet() {

        compteurPoints = new ImageView("Asset/Images/CompteurPoints.png");
        compteurPoints.setX(1000);
        compteurPoints.setY(850);
        HBox hBox1 = new HBox();
        chevalet = new ImageView("Asset/Images/Chevalet.png");

        chevalet.setX(80);
        chevalet.setY(955);//955
        for (int i = 1; i < 8; i++) {


            if (i == 1) {

                lettre1 = new ImageView(getAdresseImage(valeurLettre));

                lettre1.setX(axeX);
                lettre1.setY(axeY);//955

                lettre1.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton Précedent

                    @Override
                    public void handle(MouseEvent t) {

                        //lettre1.setStyle("CompteurPoints.png");
                        lettre1.setOnMouseClicked(controllerPartie);

                    }
                });

                lettre1.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton précedent

                    @Override
                    public void handle(MouseEvent t) {

                        lettre1.setStyle("CompteurPoints.png");

                    }
                });

            } else if (i == 2) {
                lettre2 = new ImageView(getAdresseImage(valeurLettre));
                lettre2.setX(160);
                lettre2.setY(955);


            } else if (i == 3) {
                lettre3 = new ImageView(getAdresseImage(valeurLettre));
                lettre3.setX(220);
                lettre3.setY(955);

            } else if (i == 4) {
                lettre4 = new ImageView(getAdresseImage(valeurLettre));
                lettre4.setX(280);
                lettre4.setY(955);

            } else if (i == 5) {
                lettre5 = new ImageView(getAdresseImage(valeurLettre));
                lettre5.setX(340);
                lettre5.setY(955);

            } else if (i == 6) {
                lettre6 = new ImageView(getAdresseImage(valeurLettre));
                lettre6.setX(400);
                lettre6.setY(955);

            } else if (i == 7) {
                lettre7 = new ImageView(getAdresseImage(valeurLettre));
                lettre7.setX(460);
                lettre7.setY(955);

            }
        }


    }



    private String getAdresseImage(String valeurLettre) {
        valeurLettre = Chevalet.getRandomStr(1);
        if (valeurLettre.equals("A")) {
          return "Asset/Images/LettreA.png";

        } else if (valeurLettre.equals("B")) {
            return "Asset/Images/LettreB.png";

        } else if (valeurLettre.equals("C")) {
            return "Asset/Images/LettreC.png";
        } else if (valeurLettre.equals("D")) {
            return "Asset/Images/LettreD.png";
        } else if (valeurLettre.equals("E")) {
            return "Asset/Images/LettreE.png";
        } else if (valeurLettre.equals("F")) {
            return "Asset/Images/LettreF.png";
        } else if (valeurLettre.equals("G")) {
            return "Asset/Images/LettreG.png";
        } else if (valeurLettre.equals("H")) {
            return "Asset/Images/LettreH.png";
        } else if (valeurLettre.equals("I")) {
            return "Asset/Images/LettreI.png";
        } else if (valeurLettre.equals("J")) {
            return "Asset/Images/LettreJ.png";
        } else if (valeurLettre.equals("K")) {
            return "Asset/Images/LettreK.png";
        } else if (valeurLettre.equals("L")) {
            return "Asset/Images/LettreL.png";
        } else if (valeurLettre.equals("M")) {
            return "Asset/Images/LettreM.png";
        } else if (valeurLettre.equals("N")) {
            return "Asset/Images/LettreN.png";
        } else if (valeurLettre.equals("O")) {
            return "Asset/Images/LettreO.png";
        } else if (valeurLettre.equals("P")) {
            return "Asset/Images/LettreP.png";
        } else if (valeurLettre.equals("Q")) {
            return "Asset/Images/LettreQ.png";
        } else if (valeurLettre.equals("R")) {
            return "Asset/Images/LettreR.png";
        } else if (valeurLettre.equals("S")) {
            return "Asset/Images/LettreS.png";
        } else if (valeurLettre.equals("T")) {
            return "Asset/Images/LettreT.png";
        } else if (valeurLettre.equals("U")) {
            return "Asset/Images/LettreU.png";
        } else if (valeurLettre.equals("V")) {
            return "Asset/Images/LettreV.png";
        } else if (valeurLettre.equals("V")) {
            return "Asset/Images/LettreV.png";

        } else if (valeurLettre.equals("W")) {
            return "Asset/Images/LettreW.png";
        } else if (valeurLettre.equals("X")) {
            return "Asset/Images/LettreX.png";
        } else if (valeurLettre.equals("Y")) {
            return "Asset/Images/LettreY.png";
        } else if (valeurLettre.equals("Z")) {
            return "Asset/Images/LettreZ.png";
        }

        return "Asset/Images/LettreJoker.png";

    }


    ///////// Getter
    public Button getBtnShake() { //Getter btnSuivant

        return btnShake;
    }

    public Button getBtnPrecedent() { //Getter btnSuivant
        return btnPrecedent;
    }

    public Button getBtnJouer() { //Getter btnSuivant
        return btnJouer;
    }

    public ImageView getLettre1() {
        return lettre1;
    }

    public ImageView getLettre2() {
        return lettre2;
    }

    public ImageView getLettre3() {
        return lettre3;
    }

    public ImageView getLettre4() {
        return lettre4;
    }

    public ImageView getLettre5() {
        return lettre5;
    }

    public ImageView getLettre6() {
        return lettre6;
    }

    public ImageView getLettre7() {
        return lettre7;
    }

    public void setLettre1(ImageView lettre1) {
        this.lettre1 = lettre1;
    }

    public void setLettre2(ImageView lettre2) {
        this.lettre2 = lettre2;
    }

    public void setLettre3(ImageView lettre3) {
        this.lettre3 = lettre3;
    }

    public void setLettre4(ImageView lettre4) {
        this.lettre4 = lettre4;
    }

    public void setLettre5(ImageView lettre5) {
        this.lettre5 = lettre5;
    }

    public void setLettre6(ImageView lettre6) {
        this.lettre6 = lettre6;
    }

    public void setLettre7(ImageView lettre7) {
        this.lettre7 = lettre7;
    }


    public int getAxeX() {
        return axeX;
    }

    public int getAxeY() {
        return axeY;
    }



}


