package View;//Dossier
//Imports
import Controller.ControllerMenu;
import Model.Menu;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.scene.paint.Color;
/********** Objet Class ViewMenuPrincipal ******/
public class ViewMenuPrincipal {

    private ControllerMenu controllerMenu;
    private Menu menu;
    private Group root;
    private ImageView imgBg;
    private Button btnExit;
    private Button btnNewGame;
    private Button btnOptions;
    private Text titre;
    /*************** Construtor ****************/
    public ViewMenuPrincipal(Group root, ViewHandler vh) {
        //Récupère les paramètres de ViewHandler
        this.root = root;
        this.menu = new Menu();
        this.controllerMenu = new ControllerMenu(this,vh,menu);
        //Appel des Méthodes
        initButtons();
        initBackground();
        initTitre();
    }
    private void initBackground() { //Méthode Background
        imgBg = new ImageView(Path.fondMenu);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }
    public void initTitre() { //Méthode Text

        titre = new Text(100, 150, "");
        Font fontTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 100);
        titre.setFill(Color.WHITE);
        titre.setFont(fontTitre);
        titre.setTextAlignment(TextAlignment.JUSTIFY);

    }
    private void initButtons() {//Méthode Buttons
        ///////fonts
        Font fontBtn = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 40);
        Font fontBtn1 = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 50);
        ///////effets
//        DropShadow shadow = new DropShadow();
//        shadow.setRadius(20);
//        shadow.setColor(Color.web("white"));
//        GaussianBlur blur = new GaussianBlur();
//        blur.setRadius(3);
        //////////////Button Nouvelle Partie //////////////
        btnNewGame = new Button("Nouveau jeu");
        btnNewGame.setTranslateX(1000);
        btnNewGame.setTranslateY(300);
        btnNewGame.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");

        btnNewGame.setOpacity(0.80);
        btnNewGame.setFont(fontBtn);
        btnNewGame.setPickOnBounds(false);
        btnNewGame.setBackground(null);
        btnNewGame.setMaxSize (500, 60);
        btnNewGame.setOnMouseClicked(controllerMenu);
        btnNewGame.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
           public void handle(MouseEvent t) {
//
//                btnNewGame.setFont(fontBtn1);
//                btnNewGame.setStyle("-fx-text-fill:blue;");
//                //btnNewGame.setEffect(shadow);
//                btnNewGame.setOpacity(1);
//                //btnOptions.setEffect(blur);
//                //btnExit.setEffect(blur);
             btnOptions.setOnMouseClicked(controllerMenu);
            }
        });
//        btnNewGame.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//
//                btnNewGame.setFont(fontBtn);
//                btnNewGame.setStyle("-fx-text-fill:blue;");
//                btnNewGame.setEffect(null);
//                btnNewGame.setOpacity(0.80);
//                btnOptions.setEffect(null);
//                btnExit.setEffect(null);
//
//            }
//        });
        ////////////// Button Option /////////////////
        btnOptions = new Button("Options");
        btnOptions.setTranslateX(1000);
        btnOptions.setTranslateY(500);
        btnOptions.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
        btnOptions.setOpacity(0.80);
        btnOptions.setFont(fontBtn);
        btnOptions.setPickOnBounds(false);
        btnOptions.setBackground(null);
        btnOptions.setMaxSize (500, 60);
        btnOptions.setOnMouseEntered(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent t) {
//
//                btnOptions.setFont(fontBtn1);
//                btnOptions.setStyle("-fx-text-fill:blue;");
//                //btnOptions.setEffect(shadow);
//                btnOptions.setOpacity(1);
//               // btnNewGame.setEffect(blur);
//                //btnExit.setEffect(blur);
                btnOptions.setOnMouseClicked(controllerMenu);
            }
//        });
//        btnOptions.setOnMouseExited(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//
//                btnOptions.setFont(fontBtn);
//                btnOptions.setStyle("-fx-text-fill:blue;");
//                btnOptions.setEffect(null);
//                btnOptions.setOpacity(0.80);
//                btnNewGame.setEffect(null);
//                btnExit.setEffect(null);
//            }
        });
        ////////////// Button Exit//////////////////
        btnExit = new Button("Quitter");
        btnExit.setTranslateX(1000);
        btnExit.setTranslateY(700);
        btnExit.setStyle("-fx-background-color: #bac503;-fx-border-width: 2px;-fx-border-radius: 50px;-fx-border-color: black; -fx-background-radius: 50px;-fx-font-family: \"Vladimir Script\"; -fx-font-size: 30pt;");
        btnExit.setOpacity(0.80);
        btnExit.setFont(fontBtn);
        btnExit.setPickOnBounds(false);
        btnExit.setBackground(null);
        btnExit.setMaxSize (500, 60);
        btnExit.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                //Modif de l'élement button Exit
                btnExit.setFont(fontBtn1);
               // btnExit.setStyle("-fx-text-fill:white;");
                //btnExit.setEffect(shadow);
                btnExit.setOpacity(1);
               // btnNewGame.setEffect(blur);
               // btnOptions.setEffect(blur);
                btnExit.setOnMouseClicked(controllerMenu);
            }

        });
        btnExit.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                //Modif de l'élement button Exit
                btnExit.setFont(fontBtn);
                //btnExit.setStyle("-fx-text-fill:white;");
                btnExit.setEffect(null);
                btnExit.setOpacity(0.80);
                btnNewGame.setEffect(null);
                btnOptions.setEffect(null);

            }
        });
    }
    //SETTER
    public void setVueCompleteMenu() {
        root.getChildren().clear();//efface le contenu de la vue
        root.getChildren().add(imgBg);
        root.getChildren().add(titre);
        root.getChildren().add(btnNewGame);
        root.getChildren().add(btnOptions);
        root.getChildren().add(btnExit);
    }
    //GETTER
    public Button getBtnNewGame() {

        return btnNewGame;
    }
    public Button getBtnOptions() {
        return btnOptions;
    }
    public Button getBtnExit() {
        return btnExit;
    }

    public Menu getMenu() {
        return menu;
    }
}
