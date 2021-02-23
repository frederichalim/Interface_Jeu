package View;//Dossier
//Imports
import Tools.Music;
import Controller.ControllerOptions;
import Model.Option;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import static Tools.Music.startMainMenuMusic;
/********  Objet ViewOption *******/
public class ViewOptions {
    // Déclaration variable et Initalisation
    private Group root;
    private Option option;
    private ControllerOptions controllerOptions;
    private ImageView imgBg;
    private Slider slider;
    private Text titre;
    private Text volume;
    private Text resolution;
    private Text optionFullScreen;
    private Text optionDisabledScreen;
    private Button btnSuivant;
    private Button btnRetour;
    private Button btnPrecedent;
    private Stage stage;

    /******** Construstor ******/
    public ViewOptions(Group root, ViewHandler vh, Stage stage) {
        this.root = root; //Récupère ce root
        this.option = new Option(); // nouveau Modèle
        this.controllerOptions = new ControllerOptions(this, vh, option);
        this.stage = stage; // Récupère stage

        //Appel des Méthodes
        startMainMenuMusic();
        initBackground();
        initTitres();
        initSlider();
        initButtons();
    }

    private void initBackground() { //Méthode Background

        imgBg = new ImageView(Path.fondMenu); // Récupère l'image en passant pas le Path
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran

        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());

    }
    private void initTitres(){ // Méthode Text
        //////////////// Fonts ///////////////////////
        Font fontTitre = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 100);
        Font fontOption = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 30);
        Font fontOptionFUllScreen = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 25);
        //////////////// Gros Titre //////////////////
        titre = new Text(100, 150, "Option");
        titre.setFill(Color.BLUE);
        titre.setFont(fontTitre);
        titre.setTextAlignment(TextAlignment.JUSTIFY);
        //////////////// titre Volume ////////////////
        volume = new Text(100, 200, "Volume Musique :");
        volume.setFill(Color.BLUE);
        volume.setFont(fontOption);
        volume.setTextAlignment(TextAlignment.JUSTIFY);
        //////////////// titre Résolution écran ////////////////
        resolution = new Text(100, 300, "Full Screen :");
        resolution.setFill(Color.BLUE);
        resolution.setFont(fontOption);
        resolution.setTextAlignment(TextAlignment.JUSTIFY);
        //////////////// Option full Screen /////////////////////
        optionFullScreen = new Text(100, 400, "Activer");
        optionFullScreen.setFill(Color.BLUE);
        optionFullScreen.setFont(fontOptionFUllScreen);
        optionFullScreen.setTextAlignment(TextAlignment.JUSTIFY);
        //////////////// Option medium Screen /////////////////////
        optionDisabledScreen = new Text(205, 400, "Desactiver");
        optionDisabledScreen.setFill(Color.BLUE);
        optionDisabledScreen.setFont(fontOptionFUllScreen);
        optionDisabledScreen.setTextAlignment(TextAlignment.JUSTIFY);
    }
    private void initSlider(){ //Méthode médiaPlayer volume Musique
        //Attribution des valeurs dans un nouveau Objet slider
        slider = new Slider(0, 1, 0.5);
        slider.setShowTickMarks(false);
        slider.setShowTickLabels(false);
        slider.setMajorTickUnit(0.25f);
        slider.setBlockIncrement(0.1f);
        slider.setTranslateX(300);
        slider.setTranslateY(180);
        slider.setStyle("-fx-font-size:20px;-fx-control-inner-background: black;");
        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> Music.setVolume(newValue.doubleValue()));

    }
    private void initButtons(){ //Méthode bouttons
        ////// Fonts
        Font fontBtn = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 30);
        Font fontBtn1 = Font.loadFont(getClass().getResourceAsStream(Path.fontsVladimir), 35);
        /////// Effets
        DropShadow shadow = new DropShadow();
        shadow.setRadius(20);
        shadow.setColor(Color.web("blue"));
        /////// Attributions des valeurs au boutton retour
        btnRetour = new Button("Retour au Menu");
        btnRetour.setTranslateX(1000);
        btnRetour.setTranslateY(500);
        btnRetour.setStyle("-fx-background:none;-fx-border:none;-fx-text-fill:blue;");
        btnRetour.setOpacity(0.80);
        btnRetour.setFont(fontBtn);
        btnRetour.setPickOnBounds(false);
        btnRetour.setBackground(null);
        btnRetour.setMaxSize (500, 60);
        btnRetour.setOnMouseEntered(new EventHandler<MouseEvent>() { //Ecoute du lors d'un survole de la souris sur l'élement boutton retour

            @Override
            public void handle(MouseEvent t) { //Méthode pour changer les paramètres
                /****** Attributions des valeurs *****/
                btnRetour.setFont(fontBtn1);
                btnRetour.setStyle("-fx-text-fill:blue;");
                btnRetour.setEffect(shadow);
                btnRetour.setOpacity(1);
                btnRetour.setOnMouseClicked(controllerOptions);

            }
        });

        btnRetour.setOnMouseExited(new EventHandler<MouseEvent>() { //Ecoute du lors du survole de la souris quitte l'élement boutton retour

            @Override
            public void handle(MouseEvent t) {
                //Modif élement
                btnRetour.setFont(fontBtn);
                btnRetour.setStyle("-fx-text-fill:blue;");
                btnRetour.setEffect(null);
                btnRetour.setOpacity(0.80);

            }
        });
        ////////////////// Btn suivant ////////////
        btnSuivant = new Button(">");
        btnSuivant.setStyle("-fx-background:none;-fx-border:none;-fx-text-fill:blue;");
        btnSuivant.setFont(fontBtn);
        btnSuivant.setOpacity(0.50);
        btnSuivant.setTranslateX(1000);
        btnSuivant.setTranslateY(350);
        btnSuivant.setPickOnBounds(false);
        btnSuivant.setBackground(null);
        btnSuivant.setMaxSize (200, 60);
        btnSuivant.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors d'un survole de la souris sur l'élement boutton suivant

            @Override
            public void handle(MouseEvent t) {
                //Modif élement
                btnSuivant.setFont(fontBtn1);
                btnSuivant.setStyle("-fx-text-fill:blue;");
                btnSuivant.setTranslateY(345);
                btnSuivant.setEffect(shadow);
                btnSuivant.setOpacity(1);
                btnSuivant.setOnMouseClicked(controllerOptions);

            }
        });
        btnSuivant.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton suivant

            @Override
            public void handle(MouseEvent t) {
                //Modif élement
                btnSuivant.setFont(fontBtn);
                btnSuivant.setStyle("-fx-text-fill:blue;");
                btnSuivant.setEffect(null);
                btnSuivant.setOpacity(0.50);
                btnSuivant.setTranslateY(350);

            }
        });
        ////////////////// Btn precedent ////////////
        btnPrecedent = new Button("<");
        btnPrecedent.setStyle("-fx-background:none;-fx-border:none;-fx-text-fill:blue;");
        btnPrecedent.setFont(fontBtn);
        btnPrecedent.setOpacity(0.50);
        btnPrecedent.setTranslateX(1000);
        btnPrecedent.setTranslateY(350);
        btnPrecedent.setPickOnBounds(false);
        btnPrecedent.setBackground(null);
        btnPrecedent.setMaxSize (200, 60);
        btnPrecedent.setOnMouseEntered(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton Précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                btnPrecedent.setFont(fontBtn1);
                btnPrecedent.setStyle("-fx-text-fill:blue;");
                btnPrecedent.setTranslateY(345);
                btnPrecedent.setEffect(shadow);
                btnPrecedent.setOpacity(1);
                btnPrecedent.setOnMouseClicked(controllerOptions);

            }
        });
        btnPrecedent.setOnMouseExited(new EventHandler<MouseEvent>() {//Ecoute du lors du survole de la souris quitte l'élement boutton précedent

            @Override
            public void handle(MouseEvent t) {
                //Modif élements précedent
                btnPrecedent.setFont(fontBtn);
                btnPrecedent.setStyle("-fx-text-fill:blue;");
                btnPrecedent.setEffect(null);
                btnPrecedent.setOpacity(0.50);
                btnPrecedent.setTranslateY(350);

            }
        });

    }
    public void fullScreen(){

        // recuperer optionFullScreen avec le root et l'effacer du parent
        root.getChildren().remove(optionFullScreen);
        // ajouter optionMediumScreen au parent root
       root.getChildren().add(optionDisabledScreen);
        // ajouter le btn precedent au parent root
        root.getChildren().add(btnPrecedent);
        // enleve le bouton suivant au parent root
        root.getChildren().remove(btnSuivant);
        // recuperer la taille de la fenetre et modif en le plein écran en false
        stage.setFullScreen(false);
    }
    public void disabledScreen(){

        // enleve le boutton precedent du parent root et text
        root.getChildren().remove(btnPrecedent);
        root.getChildren().remove(optionDisabledScreen);
        // ajoute le boutton suivant au parent root et text
        root.getChildren().add(optionFullScreen);
        root.getChildren().add(btnSuivant);
        // recupere la fenetre et modification plein ecran
        stage.setFullScreen(true);
    }

    public void setVueCompleteOptions() { //Méthode Setter
        //Attache au root parent les élements enfans
        root.getChildren().clear();//efface le contenu de la vue
        root.getChildren().add(imgBg);
        root.getChildren().add(titre);
        root.getChildren().add(volume);
        root.getChildren().add(slider);
        root.getChildren().add(resolution);
        //condition si il est plein écran
        if(stage.isFullScreen()){

            //alors option en fullScreen
            root.getChildren().add(optionFullScreen);
            root.getChildren().add(btnSuivant);

        }else{

            //sinon option en medium
            root.getChildren().add(optionDisabledScreen);
            root.getChildren().add(btnPrecedent);
        }


        root.getChildren().add(btnRetour);

    }
    ///////// Getter
    public Button getBtnSuivant() { //Getter btnSuivant

        return btnSuivant;
    }
    public Button getBtnRetour() { //Getter btnSuivant
        return btnRetour;
    }
    public Button getBtnPrecedent() { //Getter btnSuivant
        return btnPrecedent;
    }

}
