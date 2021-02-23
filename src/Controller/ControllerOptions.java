package Controller; // dossier

//Imports
import Model.Option;
import View.ViewHandler;
import View.ViewOptions;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//Class implement un écoute de la souris
public class ControllerOptions implements EventHandler<MouseEvent> {

    private ViewOptions vueOptions;
    private ViewHandler vh;
    private Option option;

    public ControllerOptions(ViewOptions vueOptions, ViewHandler vh, Option option) {
        this.vueOptions = vueOptions; // Objet ViewOptions
        this.vh = vh; // Objet ViewHandler
        this.option = option; //model
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(vueOptions.getBtnSuivant())) { //Ecoute si le boutton suivant
            vueOptions.fullScreen();
            vueOptions.setVueCompleteOptions();
        } else if (event.getSource().equals(vueOptions.getBtnPrecedent())) { //Ecoute si le boutton precedent
            vueOptions.disabledScreen();
            vueOptions.setVueCompleteOptions();
        } else if (event.getSource().equals(vueOptions.getBtnRetour())) {//Ecoute si boutton retour
            vh.afficherMenuPrincipal(); //appel la méthode de ViewHandler pour afficher la vue de la page principal
        }
    }
}
