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
    
    public void convertToByte(){
        Integer.toBinaryString(_message);
    }
    
    @Override
    public String toString(){
        /*String res = "";
        for(byte b : convertToByte()){
            res += b;
        }*/
        return Integer.toBinaryString(_message);
    }
}
