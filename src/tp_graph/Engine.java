/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Epulapp
 */
public class Engine {
    
     public ArrayList<Mot> importFile(String Path) {
        
        ArrayList<Mot> list = new ArrayList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Path));
            String line = br.readLine();

            while (line != null) {
                list.add(new Mot(line));
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TP_Graph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TP_Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
