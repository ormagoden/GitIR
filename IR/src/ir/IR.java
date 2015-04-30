/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import snowballstemmer.EnglishStemmer;

/**
 *
 * @author Ormagoden
 */
public class IR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        String path = "C:\\java\\doc1.txt";
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            String term;

            while (sc.hasNext()) {
                term = sc.next();

                term = term.replaceAll("[ / . + * \\ : “ ” ( ) „ ‟ $ % # '  @ ! , & | < > { } ; ? _ ) 1 2 3 4 5 6 7 8 9 0 ]", "");
                term = term.replace("[", "");
                term = term.replace("]", "");
                term = term.replace("-", "");                
                term = term.replaceAll("( )+", " ");
                term = term.toLowerCase();

                if(!term.equals("")){
                EnglishStemmer stemmer = new EnglishStemmer();

                //set the word to be stemmed
                stemmer.setCurrent(term);
                //call stem() method. stem() method returns boolean value. 
                if (stemmer.stem()) {
                    //If stemming is successful obtain the stem of the given word
                    System.out.println(stemmer.getCurrent());
                }
                }
                //create a new instance of PorterStemmer
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
