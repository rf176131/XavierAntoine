/// Affichage des scores précédants


package Menu;

import JeuDeBase.Mapping.*;
import Openning.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;


public class Scores extends Page{
    
    private String[][] scorelist = new String[10][2];
    private ArrayList<String> fichier = new ArrayList<>();
    private File file;
    private FileReader reader;
    private char[] chars;
    private String score ="";
    int i=0;
        
    public Scores() {
        loadscores();
        test();
        displayscore();
    }
    
    public void loadscores() {
        String fichier = "scoreboard.txt";
        String tableau[] = new String[2];
        int j=0;
        try {
          FileReader fr = new FileReader(fichier);
          BufferedReader br = new BufferedReader(fr);
          String str;
          int nbligne = 0;
          while((str=br.readLine()) != null)
          {
            String[] splits = str.split(";");
            int taille = splits.length;
            for(int i = 0; i < taille ;i++)
            {
              tableau[i] = splits[i];
            }
            scorelist[j][0] = tableau[0];
            scorelist[j][1] = tableau[1];
            j++;
          }br.close();
        }
        catch(IOException ioe){System.out.println("erreur:"+ioe);}
    }
    
    void displayscore() {
        JLabel[] l = new JLabel[10];
        JPanel panel = new JPanel(new FlowLayout());
       for(int i = 0; i < 10; i++)
       {
         l[i] = new JLabel(scorelist[i][0] + " - " + scorelist[i][1]);
         this.add(l[i]);
         panel.add(new JLabel(scorelist[i][0] + " - " + scorelist[i][1]));
       }
       
    }
    
    public void test() {
        for(int i=0; i<4; i++) {
            System.out.println(scorelist[i][0] + " - " + scorelist[i][1]);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
