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
public class Comida extends Prato implements Comparable<Comida>{
    
    private static int idDaClasse;
     
    public Comida(String name , int numero, float preço ) {
        setNomePrato(name);
        setPreço(preço);
        setQuantidade(numero);
        setId(idDaClasse++);
    }

    @Override
    public String getNomePrato() {
        return this.nomePrato;
    }

    @Override
    public int getQuantidade() {
       return this.quantidade;
    }

    @Override
    public float getPreço() {
       return this.preço;
    }

    @Override
    public int getId() {
       return this.id;
    }

    @Override
    public void setId(int id) {
        this.id= id;
    }

    @Override
    public void setNomePrato(String nomePrato) {
        this.nomePrato= nomePrato;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade=quantidade;
    }

    @Override
    public void setPreço(float preço) {
        this.preço= preço;
    }

    @Override
    public String toString() {
      return " Id "+ getId()+" -- "+getNomePrato();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Comida))
            return false;
        else
            return (this.id == ((Comida)obj).getId());
    }

    @Override
    public int compareTo(Comida o) {
       if (this.getId() > o.getId()){
            return 1;
        }else if (this.getId() < o.getId()){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime * result + ((nomePrato == null)? 0 : nomePrato.hashCode());
        return result; 
    }
    
}
