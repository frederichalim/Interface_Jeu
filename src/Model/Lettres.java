package Model;

import java.util.ArrayList;

public class Lettres {
    protected String lettres;
    boolean lettresJouees;
    protected int valeurLettres;
    protected int pointlettres;


    ArrayList<Lettres> listeLettres = new ArrayList<>();

    //CONSTRUCTEURS
    public Lettres(String lettres, int nbrLettres, int pointlettres) {
        this.valeurLettres = valeurLettres;
        this.lettres = lettres;
        this.pointlettres = pointlettres;
    }



    //METHODES
    public void initsac() {
        Lettres lettresA = new Lettres("A", 9,1);
        Lettres lettresB = new Lettres("B", 2,3);
        Lettres lettresC = new Lettres("C", 2,3);
        Lettres lettresD = new Lettres("D", 3,2);
        Lettres lettresE = new Lettres("E", 15,1);
        Lettres lettresF = new Lettres("F", 2,4);
        Lettres lettresG = new Lettres("G", 2,3);
        Lettres lettresH = new Lettres("H", 2,4);
        Lettres lettresI = new Lettres("I", 8,1);
        Lettres lettresJ = new Lettres("J", 1,1);
        Lettres lettresK = new Lettres("K", 1,10);
        Lettres lettresL = new Lettres("L", 5,1);
        Lettres lettresM = new Lettres("M", 3,2);
        Lettres lettresN = new Lettres("N", 6,1);
        Lettres lettresO = new Lettres("O", 6,1);
        Lettres lettresP = new Lettres("P", 2,3);
        Lettres lettresQ = new Lettres("Q", 1,8);
        Lettres lettresR = new Lettres("R", 6,1);
        Lettres lettresS = new Lettres("S", 6,1);
        Lettres lettresT = new Lettres("T", 6,1);
        Lettres lettresU = new Lettres("U", 2,1);
        Lettres lettresV = new Lettres("V", 2,4);
        Lettres lettresW = new Lettres("W", 1,10);
        Lettres lettresX = new Lettres("X", 1,10);
        Lettres lettresY = new Lettres("Y", 1,10);
        Lettres lettresZ = new Lettres("Z", 1,10);
        Lettres lettresJoker = new Lettres("", 2,0);



        //ajouter les lettres dans le sac
        listeLettres.add(lettresA);
        listeLettres.add(lettresB);
        listeLettres.add(lettresC);
        listeLettres.add(lettresD);
        listeLettres.add(lettresE);
        listeLettres.add(lettresF);
        listeLettres.add(lettresG);
        listeLettres.add(lettresH);
        listeLettres.add(lettresI);
        listeLettres.add(lettresJ);
        listeLettres.add(lettresK);
        listeLettres.add(lettresL);
        listeLettres.add(lettresM);
        listeLettres.add(lettresN);
        listeLettres.add(lettresO);
        listeLettres.add(lettresP);
        listeLettres.add(lettresQ);
        listeLettres.add(lettresR);
        listeLettres.add(lettresS);
        listeLettres.add(lettresT);
        listeLettres.add(lettresU);
        listeLettres.add(lettresV);
        listeLettres.add(lettresW);
        listeLettres.add(lettresX);
        listeLettres.add(lettresY);
        listeLettres.add(lettresZ);
        listeLettres.add(lettresJoker);

    }

    public void retirerLettresSac(Lettres lettres) {


       //listeLettres.remove(lettres);

    }

//    public void getRandomChevalet()
//    {
//        //choisissez un caractére au hasard à partir de cette chaîne
//        String sac = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//
//        StringBuilder s = new StringBuilder(88);
//
//        for (int i = 0; i < 88; i++) {
//            int index = (int)(listeLettres.size() * Math.random());
//            //s.append(listeLettres.charAt(index));
//        }
//
//        // Génère le chevalet
//        for (int i = 0; i < 7; i++) {
//            System.out.println(lettresJouees);
//        }
//
//    }


    //ACCESSEURS


    public String getLettres() {
        return lettres;
    }

    public void setLettres(String lettres) {
        this.lettres = lettres;
    }

    public boolean isLettresJouees() {
        return lettresJouees;
    }

    public void setLettresJouees(boolean lettresJouees) {
        this.lettresJouees = lettresJouees;
    }

    public int getValeurLettres() {
        return valeurLettres;
    }

    public void setValeurLettres(int valeurLettres) {
        this.valeurLettres = valeurLettres;
    }
}
