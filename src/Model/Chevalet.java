package Model;


import javafx.scene.image.ImageView;

import javax.swing.text.View;

public class Chevalet {
    public int valeurLettre;
    private ImageView chevalet;
    private ImageView lettre;
    private int numeroLettre;

    private void initChevaletRandom() {


        // System.out.println(getRandomStr(1));
        String lettre = "A";
        // Affiche le chevalet
        for (int i = 0; i < 7; i++) {
            lettre = getRandomStr(1);
            //Affiche(lettre);


        }
    }

    public static String getRandomStr(int n) {
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "AAAAAAAAA" +
                "BB" +
                "CC"+
                "DDD" +
                "EEEEEEEEEEEEEEEEE" +
                "FF" +
                "GG" +
                "HH" +
                "IIIIIIII" +
                "J" +
                "K" +
                "LLLLL" +
                "MMM" +
                "NNNNNN" +
                "OOOOOO" +
                "PP" +
                "Q" +
                "RRRRRR" +
                "SSSSSS" +
                "TTTTTT" +
                "UUUUUU" +
                "VV" +
                "W" +
                "X" +
                "Y" +
                "Z";


        StringBuilder s = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (str.length() * Math.random());
            s.append(str.charAt(index));
        }
        return s.toString();
    }
}



