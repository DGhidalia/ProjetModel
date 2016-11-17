/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package découpage;

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
    
    public void SplitMessage(){
        int j;
        int i = _secret.ConvertToTab().length /2;
        int prem[] = new int[i];
        int deuse[] = new int[i];
        for(j=0;j<i;j++){
            prem[j]= _secret.ConvertToTab()[j];
        }
        for(j=i;j<i*2;j++){
            deuse[j-i] = _secret.ConvertToTab()[j];
        }
    }
    
    //public 
}
