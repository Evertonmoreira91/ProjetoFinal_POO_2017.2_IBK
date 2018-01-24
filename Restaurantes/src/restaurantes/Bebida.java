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
public abstract class Bebida {
    String nomeBebida ;
    int quantidade;
    int id;
    float preço;

    public abstract String getNomeBebida();
    public abstract int getQuantidade();
    public abstract float getPreço();
    public abstract int getId();
    public abstract void setId(int id);
    public abstract void setNomeBebida(String nomeBebida);
    public abstract void setQuantidade(int quantidade);
    public abstract void setPreço(float preço);

    @Override
    public abstract String toString();
     
    
    
    
    
    
}
