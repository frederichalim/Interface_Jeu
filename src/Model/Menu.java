package Model;

public class Menu {
    public final static String textBoutonJouer = "Nouvelle partie";
    private Partie partie;

    public Menu() {
        this.partie = null;
    }

    public void initGame() {
        Partie partie1 = new Partie(1, 2, 88);



    }

    public Partie getPartie() {
        return partie;
    }
}
