package View;//Dossier
//Imports
import Controller.ControllerMenu;
import Controller.ControllerOptions;
import Model.Menu;
import Model.Option;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/************ Objet Class ViewHandler ********/
public class ViewHandler extends Application {
    private ViewMenuPrincipal mp;
    private ViewOptions vo;
    private ViewGame vg;

    /**
     * Permet le lancement de l'application : méthode obligatoire pour JavaFX
     *
     * @param primaryStage (paramètre obligatoire)
     */
    @Override
    public void start(Stage primaryStage) {
        // L'objet de type primary stage correspond à l'élement graphique de base à afficher.
        // C'est par cet objet que l'on va définir le comportement global de la fenêtre
        // (s'il y a un contour autour de la fenêtre, son titre, si on peut redéfinir la fenêtre etc).

        // root représente le panel qui va être affiché dans le primary stage.
        // tout ce qui doit être affiché doit lui être ajouté, tout ce qui ne doit pas être affiché doit être supprimé
        // du root
        Group root = new Group();

        // l'objet root est donc ajouté dans la scene, on peut changer de scène pour changer complêtement d'interface
        // on ne le fera pas dans nos exercices, nous metterons juste à jour le root.
        Scene scene = new Scene(root);

        // le root a été ajouté dans la scène, on lie donc la scène à la "primaryStage"
        primaryStage.setScene(scene);

        mp = new ViewMenuPrincipal(root,this);
        vo = new ViewOptions(root, this, primaryStage);//Passe les paramètres à de ViewHandler à ViewOption
        vg = new ViewGame(root, this, primaryStage);

        // Affichage du menu
        afficherMenuPrincipal();

        // Exercice 1) prenez le code en main : testez de changer les paramétres des méthodes suivantes
        primaryStage.setTitle("Scrabble");
        primaryStage.setFullScreenExitHint("");
        primaryStage.setResizable(true);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void afficherMenuPrincipal() {//Méthode qui appel une autre méthode de ViewMenuPrincipal

        mp.setVueCompleteMenu();

    }
    public void afficherOptions() { //Méthode qui appel une autre méthode de ViewOptions

        vo.setVueCompleteOptions();

    }
    public void afficherJeu() { //Méthode qui appel une autre méthode de ViewOptions

        vg.setVueCompleteGame();

    }

    public ViewMenuPrincipal getMp() {
        return mp;
    }
}