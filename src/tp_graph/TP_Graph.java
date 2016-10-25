/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Epulapp
 */
public class TP_Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("***Projet Doublets - Bouland Joris & Cabrelli Tommy ***");
        System.out.println("");
        int nbLiens = 0;
        int nbMotsSansVoisins = 0;
        int nbComposantes1voisin = 0;
        ArrayList<Mot> listMot1Voisin = new ArrayList();
        TreeMap<Integer, Integer> listeNbSommetParNbVoisins = new TreeMap();
        Engine e = new Engine();
        Mot m;
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\mots04lettres.txt");
        ArrayList listResult = e.importFile(filePath);
        //Nombre de sommets : 
        System.out.println("Nombre de sommets : " + listResult.size());

        for (int i = 0; i < listResult.size(); i++) {
            m = (Mot) listResult.get(i);
            for (int j = i + 1; j < listResult.size(); j++) {
                if (m.testLien((Mot) listResult.get(j))) {
                    //Pour voir les liens se faire, décommentez la ligne ci-dessous : 
                    // System.out.println(m.getValeur() + " proche de " + ((Mot)listResult.get(j)).getValeur());
                    nbLiens++;
                }
            }
            //On regarde le nombre de voisin du mot
            int numVoisins = m.getNumberOfVoisins();
            if (numVoisins == 0) {
                nbMotsSansVoisins++;
            } else if (numVoisins == 1) {
                listMot1Voisin.add(m);
            }
            if(listeNbSommetParNbVoisins.containsKey(numVoisins)){
                int old = listeNbSommetParNbVoisins.get(numVoisins);
                listeNbSommetParNbVoisins.put(numVoisins, ++old);
            } else {
                listeNbSommetParNbVoisins.put(numVoisins, 1);
            }
        }
        System.out.println("Nombre d'arêtes : " + nbLiens);
        System.out.println("Nombre de mots sans voisin : " + nbMotsSansVoisins);
        //Question 5 - On vérifie si les voisins des mots avec un seul voisin ont aussi un seul voisin
        for (int i = 0; i < listMot1Voisin.size(); i++) {
            if (listMot1Voisin.get(i).getListeVoisins().get(0).getNumberOfVoisins() == 1) {
                nbComposantes1voisin++;
            }
        }
        System.out.println("Nombre de composantes composées uniquement de deux mots : " + nbComposantes1voisin);
        int nbcomposanteconnexe = 0;
        for (int i = 0; i < listResult.size(); i++) {
            m = (Mot) listResult.get(i);
            if (!m.visite) {
                m.parcoursComposanteConnexe();
                nbcomposanteconnexe++;
            }
        }
        System.out.println("Nombre de composantes connexe : " + nbcomposanteconnexe);
        System.out.println("Au maximum : " + listeNbSommetParNbVoisins.lastEntry().getValue() + " sommet(s) avec " + listeNbSommetParNbVoisins.lastKey() + " voisin(s)." );
        Set set = listeNbSommetParNbVoisins.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("Il y a "+ mentry.getValue() + " sommet(s) avec ");
            System.out.println(mentry.getKey() + " voisin(s)");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_graph;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class TP_Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nbLiens = 0;
        int nbMotsSansVoisins = 0;
        ArrayList<Mot> listMot1Voisin = new ArrayList();
        Engine e = new Engine();
        Mot m;
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\mots04lettres.txt");
        System.out.println(filePath);
        ArrayList listResult = e.importFile(filePath);
        //Nombre de sommets : 
        System.out.println("Nombre de sommets : " + listResult.size());

        for (int i = 0; i < listResult.size(); i++) {
            m = (Mot) listResult.get(i);
            for (int j = i + 1; j < listResult.size(); j++) {
                if (m.testLien((Mot) listResult.get(j))) {
                    //Pour voir les liens se faire, décommentez la ligne ci-dessous : 
                    // System.out.println(m.getValeur() + " proche de " + ((Mot)listResult.get(j)).getValeur());
                    nbLiens++;
                }
            }
            if (m.getNumberOfVoisins() == 0) {
                nbMotsSansVoisins++;
            } else if (m.getNumberOfVoisins() == 1) {
                listMot1Voisin.add(m);
            }
        }
        System.out.println("Nombre d'arêtes : " + nbLiens);
        System.out.println("Nombre de mots sans voisin : " + nbMotsSansVoisins);
        //Question 5 - On vérifie si les voisins des mots avec un seul voisin ont aussi un seul voisin
        for (int i = 0; i < listMot1Voisin.size(); i++) {
            if (listMot1Voisin.get(i).getListeVoisins().get(0).getNumberOfVoisins() == 1) {

            }
        }
        System.out.println("Debut Algo");
        int nbcomposanteconnexe = 0;
        ArrayList<ArrayList<Mot>> composanteconnexes = new ArrayList<ArrayList<Mot>>();
        for (int i = 0; i < listResult.size(); i++) {
            m = (Mot) listResult.get(i);
            if (!m.visite_connexe) {
                composanteconnexes.add(m.parcoursComposanteConnexe());
                nbcomposanteconnexe++;
                System.out.println("composante connexe : " + nbcomposanteconnexe);
            }
        }
        System.out.println("Nombre de composantes connexe : " + nbcomposanteconnexe);
        
        for(int i=0; i<composanteconnexes.size();i++){
            composanteconnexes.get(i);
            
        }
        
    }
}
