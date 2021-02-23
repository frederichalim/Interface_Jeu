package Model;

public class Plateau {

    private Case[][] plateau;

    public Plateau() {
        plateau = new Case[12][12];
        for (int i = 0; i < plateau.length; i++) {
           for (int j = 0; j < plateau[i].length; j++) {
               boolean estVide;
               if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1)
                   estVide = true;
               else
                    estVide = false;
                plateau[i][j] = new Case(null, estVide);
            }
        }
    }
}

/*

 */
