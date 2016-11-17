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
    
    public message(int message){
        _message = message;
    }
    
    public String ConvertToBinary(){
        String res = Integer.toBinaryString(_message);
        if(res.length() % 2 != 0){
            res = "0"+res;
        }
        return res;
    }
    
    public int[] ConvertToTab(){
        /*System.out.println(ConvertToBinary().getBytes());
        return ConvertToBinary().getBytes();*/
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
}
