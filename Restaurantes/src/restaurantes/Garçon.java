/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.util.InputMismatchException;

/**
 *
 * @author WizIBK inck
 */
public final class Garçon extends Funcionario implements FuncionamentoExterno, Comparable<Garçon>{
        
        private  static int idDaClass;
        private int id ;
    
        public Garçon( String name,float salario, String CPF, Conta caixa, String senha) {
        setNome(name);
        setSalario(salario);
        setCPF(CPF);
        setConta(caixa);
        setSenha(senha);
        this.id = idDaClass++;
    }

        @Override
  public boolean autentica(String password) {
      if (this.senha != password){
            return false;
      } 
      return true;
    }

    @Override
    public void cadastrarPrato() {
        
    }

    @Override
    public void cadastrarBebida() {
        
    }

    @Override
    public void efectuarPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void devolverTroco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
    
    @Override
    public int compareTo(Garçon o) {
        if (this.getId() > o.getId()){
            return 1;
        }else if (this.getId() < o.getId()){
            return -1;
        }else {
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null || !(obj instanceof Garçon))
            return false;
        else
            return (this.id == ((Garçon)obj).getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime * result + ((nome == null)? 0 : nome.hashCode());
        return result; 
    }

    @Override
    public String toString() {
        return " Id "+ getId()+" - "+getNome()+" CPF: "+ getCPF();
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
       return this.CPF;
    }

    public float getSalario() {
        return this.salario;
    }

    public Conta getConta() {
        return this.conta;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setCPF(String CPF)  {
            this.CPF = CPF;
    }


    public void setConta(Conta conta) {
        this.conta=conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
     

    public void setSenha(String senha)  {
            this.senha = senha;
        
    }


    
    
}
