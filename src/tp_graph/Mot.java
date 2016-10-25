package tp_graph;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Mot {

    private String valeur;
    private ArrayList<Mot> listeVoisins;
    public Boolean visite_connexe = false;
    public Boolean visite_connexe_2 = false;
    public Boolean visite_diametre = false;

    public Mot(String valeur) {
        this.valeur = valeur;
        this.listeVoisins = new ArrayList();
    }

    public String getValeur() {
        return valeur;
    }

    public void addVoisin(Mot m) {
        this.listeVoisins.add(m);
    }

    public int getNumberOfVoisins() {
        return listeVoisins.size();
    }

    public ArrayList<Mot> getListeVoisins() {
        return listeVoisins;
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

    public ArrayList<Mot> parcoursComposanteConnexe() {
        ArrayList a = new ArrayList();
        this.visite_connexe = true;
        for (int i = 0; i < listeVoisins.size(); i++) {
            if (!listeVoisins.get(i).visite_connexe) {
                a.addAll(listeVoisins.get(i).parcoursComposanteConnexe());
            }
        }
        a.add(this);
        return a;
    }
   


    public int parcoursDiametre(int indice) {
        int memoire = indice;
        int tempo;
        this.visite_diametre = true;
        for (int i = 0; i < listeVoisins.size(); i++) {
            if (!listeVoisins.get(i).visite_diametre) {
                tempo = listeVoisins.get(i).parcoursDiametre(indice + 1);
                if (tempo > memoire) {
                    memoire = tempo;
                }
            }
        }
        return memoire;
    }

}
