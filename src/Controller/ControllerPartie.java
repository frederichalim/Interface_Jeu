package Controller;

import Model.Chevalet;
import Model.Lettres;
import View.ViewGame;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import java.awt.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.peer.LightweightPeer;

import javafx.scene.layout.HBox;

import javax.swing.*;


public class ControllerPartie implements EventHandler<MouseEvent> {
    private ViewGame viewGame;
    public ImageView lettre1;
    private ImageView lettre2;
    private ImageView lettre3;
    private ImageView lettre4;
    private ImageView lettre5;
    private ImageView lettre6;
    private ImageView lettre7;
    private ViewGame targetBox;


    private ViewHandler vh;
    private Lettres lettres;
    private Chevalet chevalet;
    private String valeurLettre;

    private Group root;

    int posx = 60;
    int posy = 60;
    double width = 900;
    double height = 500;
    ImageView iv;
    int nombreLeft = 10;
    int nombreRight = 0;
    int curseur = 0;
    Point imageCorner;
    Point prevPt;
    double preX;
    double preY;


    public ControllerPartie(ViewGame viewGame, ViewHandler vh) {
        this.viewGame = viewGame;
        this.vh = vh;
        this.lettres = lettres;
    }


    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(viewGame.getBtnJouer())) { //Ecoute si le bouton jouer

            viewGame.initChevalet();
//            viewGame.fullScreen();
            viewGame.setVueCompleteGame();
        } else if (event.getSource().equals(viewGame.getBtnShake())) { //Ecoute si le boutton mélanger
            viewGame.disabledScreen();
            viewGame.setVueCompleteGame();
        } else if (event.getSource().equals(viewGame.getBtnPrecedent())) {//Ecoute si boutton retour
            vh.afficherMenuPrincipal(); //appel la méthode de ViewHandler pour afficher la vue de la page principal
        } else if (event.getSource().equals(viewGame.getLettre1())) {


            setupGestureSource(viewGame.getLettre1());
            setupGestureSource(viewGame.getLettre2());
            setupGestureSource(viewGame.getLettre3());
            setupGestureSource(viewGame.getLettre4());
            setupGestureSource(viewGame.getLettre5());
            setupGestureSource(viewGame.getLettre6());
            setupGestureSource(viewGame.getLettre7());

            HBox hBox1 = new HBox();
            hBox1.setPrefWidth(60);
            hBox1.setPrefHeight(60);
            hBox1.setStyle("-fx-border-color: red;"
                    + "-fx-border-width: 2;"
                    + "-fx-border-style: solid;");

            HBox hBox2 = new HBox();
            hBox2.setPrefWidth(60);
            hBox2.setPrefHeight(60);
            hBox2.setStyle("-fx-border-color: red;"
                    + "-fx-border-width: 2;"
                    + "-fx-border-style: solid;");

            root.getChildren().add(hBox1);
            root.getChildren().add(hBox2);
////
////
//////            Dragboard db = lettre1.startDragAndDrop(TransferMode.COPY);
//////            ClipboardContent content = new ClipboardContent();
//////            // root.getChildren().remove(lettre1);
//////            content.putImage(lettre1.getImage());
//////
//////            db.setContent(content);
//////
//////            imagememoire = source;
//////
//////
//////            event.consume();
////
//////    }
////
//

        }
    }

    //
    //insère l'image dans un box
    void insertImage(Image i, HBox hb1) {

        //déclare un objet imageView
        iv = new ImageView();

        iv.setImage(i);
        setupGestureSource(iv);
        hb1.getChildren().add(iv);


    }
//
//

    //gère le transfert image
    void setupGestureSource(final ImageView source) {

        source.setOnDragDetected(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("test1");
                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);

                /* put a image on dragboard */
                ClipboardContent content = new ClipboardContent();

                Image sourceImage = source.getImage();
                content.putImage(sourceImage);
                db.setContent(content);


                iv = source;


                event.consume();
            }
        });

        source.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("test2");
                source.setCursor(Cursor.HAND);
                curseur = (int) e.getSceneX();
            }
        });


    }



    //gère la cible ou l'image sera mise
    void setupGestureTarget(HBox targetBox) {


        targetBox.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("test3");

                Dragboard db = event.getDragboard();

                if (db.hasImage()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });

        targetBox.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();
                System.out.println("test4");
                if (db.hasImage()) {

                    iv.setImage(db.getImage());

                    //zone de scrute
                    //Point2D localPoint = targetBox.sceneToLocal(1000,1000);
                    Point2D localPoint = targetBox.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY()));

                    targetBox.getChildren().remove(iv);
                    iv.setX((int) (localPoint.getX() - iv.getBoundsInLocal().getWidth()));
                    iv.setY((int) (localPoint.getY() - iv.getBoundsInLocal().getHeight()));

                    targetBox.getChildren().add(iv);

                    event.setDropCompleted(true);
                } else {
                    event.setDropCompleted(false);
                }

                event.consume();
            }
        });

    }



}




