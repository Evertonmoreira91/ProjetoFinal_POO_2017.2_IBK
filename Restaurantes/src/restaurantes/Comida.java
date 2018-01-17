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
public class Comida extends Prato{

    public Comida(String name , int numero, float preço ) {
        this.nomePrato = name;
        this.preço = preço;
        Comida.id =  Comida.id +1;
    }
    
}
