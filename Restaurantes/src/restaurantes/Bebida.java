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
    String nomeBebida;
    int quantidade;
    static int id;
    float preço;
    int quantidadeDisponivel;

    public String getNomeBebida() {
        return nomeBebida;
    }

    public float getPreço() {
        return preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }
    
    
    
    
    
    
}
