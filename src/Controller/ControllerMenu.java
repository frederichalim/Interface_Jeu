package Controller;//Dossier
//Imports
import Model.Menu;
import View.ViewHandler;
import View.ViewMenuPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**************** Objet class ControllerMenu *************/
public class ControllerMenu implements EventHandler<MouseEvent> {
    private ViewMenuPrincipal vue;
    private ViewHandler vh;
    private Menu menu;
/***************** Constructor ***************************/
    public ControllerMenu(ViewMenuPrincipal vue, ViewHandler vh, Menu menu) {
        this.vue = vue;
        this.vh = vh;
        this.menu = menu;
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vue.getBtnNewGame())) {
            //menu.initGame();
            vh.afficherJeu();
        } else if (event.getSource().equals(vue.getBtnOptions())) {//Si Boutton Options
            vh.afficherOptions();//appel à envoier la vue Options
        } else if (event.getSource().equals(vue.getBtnExit())) {//Si Boutton Exit
            System.exit(0); //appel à quitter le programme
        }
    }
}

