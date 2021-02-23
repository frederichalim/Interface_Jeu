package Model;

public class Partie {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private int numPartie;
    private int nbrJoueur;
    private int qteLettres;
    public static int LARGEUR =15;
    public static int LONGUEUR = 15;
    private int[][] plateauDeJeu;

    public Partie(int numPartie, int nbrJoueur, int qteLettres) {
       this.numPartie= numPartie;
       this.nbrJoueur=nbrJoueur;
       this.qteLettres =qteLettres;
    }

    public int getCaseDuPlateauDeJeu(int i, int j) {
        return plateauDeJeu[i][j];
    }


}


