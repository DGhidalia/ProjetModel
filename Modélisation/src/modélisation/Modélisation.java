/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modélisation;

import message.message;
import découpage.méthode;

/**
 *
 * @author dg738399
 */
public class Modélisation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        message m = new message(64);
        méthode mt = new méthode(m);
        mt.SplitMessage();
    }
    
}
