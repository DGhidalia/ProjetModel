/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package découpage;

import java.util.Scanner;
import message.message;

/**
 *
 * @author dg738399
 */
public class méthode {
    
    private message _secret;
    
    public méthode(message secret){
        this._secret = secret;
    }
    
    public int[][] SplitMessage(){
        int j;
        int i = _secret.ConvertToTab().length /this._secret.getNbPers();
        int prem[] = new int[i];
        int deuse[] = new int[i];
        for(j=0;j<i;j++){
            prem[j]= _secret.ConvertToTab()[j];
        }
        for(j=i;j<i*2;j++){
            deuse[j-i] = _secret.ConvertToTab()[j];
        }
        int[][] tab = new int[][] {prem,deuse};
        return tab;
    }
    
    public void GiveSecret(){
        int i = _secret.ConvertToTab().length /2;
        int[][] secret = this.SplitMessage();
        System.out.println("La première partie du secret est :");
        for(int j=0;j<i;j++){
            System.out.print(secret[0][j]);
        }
        System.out.println();
        System.out.println("La seconde partie du secret est :");
        for(int j=0;j<i;j++){
            System.out.print(secret[1][j]);
        }
        System.out.println();
        this.RebuiltSecret(secret[0], secret[1]);
    }
    
    public int[] RebuiltSecret(int[] prem,int[] deuse){
        int taille = prem.length + deuse.length;
        int[] tabFusion = new int[taille];
        
        for (int i = 0; i < prem.length; i++) {
            tabFusion[i] = prem[i];
        }
        
        for (int i = prem.length; i < prem.length+deuse.length; i++) {
            tabFusion[i] = deuse[i - prem.length];
        }
        return tabFusion;
    }
    
    public boolean EgalTab(int[] tabProp,int[] tabVrai){
        boolean res = true;
        boolean end = true;
        int i =0;
        if(tabProp.length == tabVrai.length){
            while(res && end){
                if(tabProp[i] != tabVrai[i]){
                    res = false;
                }
                i++;
                if(i == tabVrai.length){
                    end = false;
                }
            }
        }
        else{
            res = false;
        }
        return res;
    }
    
    public int[] AskSecret(){
        Scanner sc = new Scanner(System.in);
        int i = this._secret.ConvertToTab().length/2;
        int[] prem = new int[i];
        int[] deuse = new int[i];
        System.out.println("Donnez la premiere partie du nombre binaire : ");
        for(int j=0;j<i;j++){
            prem[j] = sc.nextInt();
        }
        System.out.println("Donnez la deuxième partie du nombre binaire : ");
        for(int j=0;j<i;j++){
            deuse[j] = sc.nextInt();
        }
        return RebuiltSecret(prem,deuse);
    }
    
    public int[] getSecret(){
        return this._secret.ConvertToTab();
    }
    
    
    //-- Prolongement 1 ----------------------------------------------
    
    public int[][] ProlongSplitMessage(){
        int i = this._secret.ConvertToTab().length/(this._secret.getNbPers()*2);
        int[][] tabSecret = new int[this._secret.getNbPers()*2][i];    
        boolean end = false;
        int nb = 0;
        int c;
        int k = this._secret.ConvertToTab().length/i;
        
        while(nb<k){
            int[] t = new int[i];
            c=0;
            for(int j = nb*2; j<i+(nb*2);j++){
                t[c] = this._secret.ConvertToTab()[j];
                c++;
            }
            tabSecret[nb] = t;
            nb++;
        }
        return tabSecret;
    }
    
    public void ProlongGiveSecret(){
        int i = this._secret.ConvertToTab().length/(this._secret.getNbPers()*2);
        int[][] secret = this.ProlongSplitMessage();
    }
}
