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
public abstract class Prato implements Serializable{
    String nomePrato ;
    int quantidade;
    int id;
    float preço;

    public abstract String getNomePrato();
    public abstract int getQuantidade();
    public abstract float getPreço();
    public abstract int getId();
    public abstract void setId(int id);
    public abstract void setNomePrato(String nomePrato);
    public abstract void setQuantidade(int quantidade);
    public abstract void setPreço(float preço);

    @Override
    public abstract String toString();
     
    
    
    
}
