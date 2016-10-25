package tp_graph;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Mot {

    private String valeur;
    private ArrayList<Mot> listeVoisins;
    public Boolean visite = false;

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
    
    public int getNumberOfVoisins(){
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
    
    public void parcoursComposanteConnexe(){
        
        this.visite=true;        
        for(int i=0;i<listeVoisins.size();i++){
            if(!listeVoisins.get(i).visite)
            listeVoisins.get(i).parcoursComposanteConnexe();
        }
    }

}
