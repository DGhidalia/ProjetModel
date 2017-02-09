/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.nio.ByteBuffer;

/**
 * classe message sui stocke le message et permet de le passer en binaire(premiere méthode)
 * @author dg738399
 */
public class message {
    private int _message;
    private int _nbPersonnes;
    
    public message(int message,int nb){
        _message = message;
        _nbPersonnes = nb;
    }
    
    public String ConvertToBinary(){
        String res = Integer.toBinaryString(_message);
        while(res.length() % (_nbPersonnes*2) != 0){
            res = "0"+res;
        }
        return res;
    }
    
    public int[] ConvertToTab(){
        String toConvert = ConvertToBinary();
        int res[] = new int[toConvert.length()];
        for(int i = 0;i<toConvert.length();i++){
            if(toConvert.charAt(i)== '0'){
                res[i]=0;
            }
            else if(toConvert.charAt(i)=='1'){
                res[i]=1;
            }
        }
        return res;
    }
    
    @Override
    public String toString(){
        return ConvertToBinary();
    }
    
    public int getNbPers(){
        return this._nbPersonnes;
    }
}
