package Model;

import java.util.ArrayList;
public class Joueur {

    private ArrayList<Lettres> listeLettres;
    private boolean estVide;

    public Joueur(boolean estVide) {
        this.listeLettres = new ArrayList<>();
        this.estVide = estVide;
        Position position;
        if (estVide)
            position = new Position(0, 4);
        else
            position = new Position(7, 4);
       // Roi roi = new Roi(position);
    }
}

/*
7 T C F Q K F C T
6 P P P P P P P P
5
4
3
2
1 P P P P P P P P
0 T C F Q K F C T
  0 1 2 3 4 5 6 7
*/
