/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantes;

import java.io.Serializable;
import java.util.TreeSet;

/**
 *
 * @author WizIBK inck
 */
public  class Proprietario extends Funcionario implements FuncionamentoExterno, PagamentoInterno, Comparable<Proprietario>,Serializable{
        static int id;
    public Proprietario(String name, String CPF, Conta caixa, String senha, String cargo) {

        setNome(name);
        setCPF(CPF);
        setConta(caixa);
        this.conta.saldo= 30000;
        setSenha(senha);
        setCargo(cargo);
        this.id = 1;

    }

    @Override
    public void efectuarPagamento(float valor) {
        this.conta.saldo = this.conta.saldo + valor;
    }

    @Override
    public void devolverTroco(float valor) {
        this.conta.saldo = this.conta.saldo - valor;

    }

    @Override
    public void pagarSalarioMensuais(TreeSet<Funcionario> lista) {

        for (Funcionario funcionarios : lista) {
            this.conta.saldo = this.conta.saldo - funcionarios.getSalario();
        }
        System.out.println(" Pagamentos MENSUAIS com Sucesso");
    }

    @Override
    public void pagarAsCompras(float valor) {
        this.conta.saldo = this.conta.saldo - valor;
    }

    @Override
    public void pagarAsManutenções(float valor) {
        this.conta.saldo = this.conta.saldo - valor;
    }

    @Override
    public String toString() {
        return "Proprietario " + " - " + getNome() + " CPF: " + getCPF();
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
    public int compareTo(Proprietario o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int getId() {
        return id;
    }
    
}
