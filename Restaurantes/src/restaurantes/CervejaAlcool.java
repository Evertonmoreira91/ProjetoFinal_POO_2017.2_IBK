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
public final class CervejaAlcool extends Bebida implements Comparable<CervejaAlcool>{
    private static int idDaClasse;
       
    public CervejaAlcool(String name , int numero, float preço ) {
        setNomeBebida(name);
        setPreço(preço);
        setQuantidade(numero);
        setId(idDaClasse++);
    }

   @Override
    public String getNomeBebida() {
        return this.nomeBebida;
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
    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida= nomeBebida;
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
      return " Id "+ getId()+" -- "+getNomeBebida();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CervejaAlcool))
            return false;
        else
            return (this.id == ((CervejaAlcool)obj).getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime * result + ((nomeBebida == null)? 0 : nomeBebida.hashCode());
        return result; 
    }

    @Override
    public int compareTo(CervejaAlcool o) {
       if (this.getId() > o.getId()){
            return 1;
        }else if (this.getId() < o.getId()){
            return -1;
        }else {
            return 0;
        }
    }
    
    
}
