/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_graph;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Mot {

    private String valeur;
    private ArrayList<Mot> listeVoisins;

    public Mot(String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return valeur;
    }

    public void addVoisin(Mot m) {
        this.listeVoisins.add(m);
    }

    public boolean testLien(Mot m) {
        int numberDiff = 0;
        if (m.getValeur().length() == this.valeur.length()) {
            for (int i = 0; i < valeur.length(); i++) {
                if (valeur.charAt(i) != m.getValeur().charAt(i)) {
                    numberDiff++;
                    if (numberDiff > 1) {
                        return false; //Pas de lien
                    }
                }
            }
            //On créé un lien
            this.listeVoisins.add(m);
            m.addVoisin(this);
            return true;
        }
        return false;
    }

}
