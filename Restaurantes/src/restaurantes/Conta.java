/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.io.Serializable;

/**
 *
 * @author WizIBK inck
 */
public class Conta implements Serializable{

  
    protected float saldo;
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    

    
    
}
