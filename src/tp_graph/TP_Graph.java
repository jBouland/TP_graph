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
        Engine e = new Engine();
        Mot m;
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\mots04lettres.txt"); 
        System.out.println(filePath);
        ArrayList listResult = e.importFile(filePath);
        
        for(int i=0; i<listResult.size(); i++){
            m = (Mot)listResult.get(i);
            for(int j=i+1; j<listResult.size(); j++){
                if(m.testLien((Mot)listResult.get(j))){
                    //Pour voir les liens se faire, décommentez la ligne ci-dessous : 
                   // System.out.println(m.getValeur() + " proche de " + ((Mot)listResult.get(j)).getValeur());
                }
            }
        }
        System.out.println("Debut Algo");
        int nbcomposanteconnexe=0;
        for(int i=0; i<listResult.size();i++){
            System.out.println("Boucle : "+i);
            m = (Mot)listResult.get(i);
            if(!m.visite){
                m.parcoursComposanteConnexe();
                nbcomposanteconnexe++;
            System.out.println("composante connexe : "+nbcomposanteconnexe);
            }
        }
        System.out.println("Nombre de composantes connexe : "+nbcomposanteconnexe);
    }
}
