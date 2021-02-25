/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amine gasa
 */
public class answer {

    static int MAX;
    static ArrayList<Integer> Input, Output;
    static int Num;
    static int score = 0;

    static ArrayList<Integer> Solve(ArrayList<Integer> input) {
        ArrayList<Integer> bs = new ArrayList<Integer>();
        int j,t;
       for(j=0;j<input.size();++j)
       {
    	   t=Input.get(j);
    	   bs.add(2*t);
       }
        return bs;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String[] fileNames = {"a_example", "b_small", "c_medium", "d_quite_big", "e_also_big"};
        for (int i = 0; i < fileNames.length; i++) {
            getInputFromFile(fileNames[i]);
            Output = Solve(Input);
            writeIntoFile(fileNames[i]);
        }
    }

    static void getInputFromFile(String fileName) throws FileNotFoundException {
        try {
            Input = new ArrayList<Integer>();
            BufferedReader fr = new BufferedReader(new FileReader("input\\" + fileName + ".in"));
            String line, firstLine;
            firstLine = fr.readLine();
            while ((line = fr.readLine()) != null) {
                String letters[] = line.split(" ");
                for (int i = 0; i < letters.length; i++) {
                    Input.add(Integer.valueOf(letters[i]));
                }
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(answer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void writeIntoFile(String fileName) {
        try {
            PrintWriter outputFile = new PrintWriter("output\\" + fileName + ".out", "UTF-8");
            outputFile.println(Output.size());
            for (int i = 0; i < Output.size(); i++) {
                outputFile.print(Output.get(i) + " ");
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }

}
