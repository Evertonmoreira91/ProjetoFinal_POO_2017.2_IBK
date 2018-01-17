/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

/**
 *
 * @author WizIBK inck
 */
public class Refrigerante extends Bebida{
    
     public Refrigerante(String name , int numero, float preço ) {
        this.nomeBebida = name;
        this.preço = preço;
        Refrigerante.id = Refrigerante.id +1 ;
    }
    
    
    
}
