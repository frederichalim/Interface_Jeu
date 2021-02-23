package Model;


import javafx.scene.image.ImageView;

public class Case {
    private boolean estVide;
    private Lettres lettres;
//    private String cheminCaseActuelle;

    public Case(Lettres lettres, boolean estVide) {
        this.estVide = estVide;
       this.lettres = lettres;
    }

    public boolean isEstVide() {
        return estVide;
    }

    public void setEstVide(boolean estVide) {
                this.estVide = estVide;
    }

    public Lettres getLettres() {
        return lettres;
    }

    public void setLettres(Lettres lettres) {
        this.lettres = lettres;
    }


}
