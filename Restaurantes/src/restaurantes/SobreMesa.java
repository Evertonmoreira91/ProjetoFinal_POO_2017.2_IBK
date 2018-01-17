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
public class SobreMesa extends Prato {
    
    public SobreMesa(String name , int numero, float preço ) {
        this.nomePrato = name;
        this.preço = preço;
        SobreMesa.id =  SobreMesa.id +1;
    }
    
}
