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
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\mots04lettres.txt");
        System.out.println(filePath);
        ArrayList listResult = e.importFile(filePath);
    }
}
