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
public class Cozinheiro extends Funcionario implements Comparable<Cozinheiro>{
        private  static int idDaClass;
        private int id ;
    
    
       public Cozinheiro( String name,float salario, String CPF,Conta caixa, int senha) {
        this.nome= name;
        this.salario = salario;
        this.CPF= CPF;
        this.conta = caixa;
        this.senha = senha;
        this.id = idDaClass++;
    }

    @Override
    public boolean autentica(int password) {
        
        return false;
    }

    @Override
    public void cadastrarPrato() {
       
    }

    @Override
    public void cadastrarBebida() {
        
    }

    public int getId() {
        return id;
    }
    
      @Override
    public int compareTo(Cozinheiro o) {
        return this.nome.compareTo(o.getNome());
    }
    
    
}
