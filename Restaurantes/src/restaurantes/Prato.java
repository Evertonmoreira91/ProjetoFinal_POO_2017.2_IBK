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
public abstract class Prato {
    String nomePrato ;
    int quantidade;
    static int id;
    float preço;
    int quantidadeDisponivel;

    public String getNomePrato() {
        return nomePrato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreço() {
        return preço;
    }
    
}
