/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author WizIBK inck
 */
public  class Garçon extends Funcionario implements FuncionamentoExterno, Comparable<Garçon> ,Serializable{

    private static int idDaClass;
    private int id;

    public Garçon(String name, float salario, String CPF, Conta caixa, String senha, String cargo) {
        setNome(name);
        setSalario(salario);
        setCPF(CPF);
        setConta(caixa);
        setSenha(senha);
        setCargo(cargo);
        this.id = idDaClass++;
    }

    public Garçon() {
    }
    

    public void efectuarPagamento(List<Proprietario> lista, float valor) {
        for (Proprietario dono : lista) {
            dono.getConta().saldo = dono.getConta().saldo + valor;
        }
    }

    public void devolverTroco(List<Proprietario> lista, float valor) {
        for (Proprietario dono : lista) {
            dono.getConta().saldo = dono.getConta().saldo + valor;
        }
    }

    public int getId() {
        return id;
    }

   
    public int compareTo(Garçon o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Garçon)) {
            return false;
        } else {
            return (this.id == ((Garçon) obj).getId());
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
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
    
 @Override
    public String toString() {
        return " Id " + getId() +  " - " + getCargo() +" - " + getNome() + " CPF: " + getCPF();
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setSenha(String senha) {
        this.senha = senha;

    }

    @Override
    public String getCargo() {
        return this.cargo;
    }

    @Override
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void efectuarPagamento(float valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void devolverTroco(float valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
