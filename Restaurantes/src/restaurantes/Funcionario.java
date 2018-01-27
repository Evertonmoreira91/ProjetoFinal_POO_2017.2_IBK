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
public abstract class Funcionario implements Serializable{
    private static final long serialVersionUID =403212556265069759L;

    protected String nome;
    protected float salario;
    protected String CPF;
    protected Conta conta;
    protected String senha;
    protected String cargo;

    public abstract String getNome();

    public abstract String getCPF();

    public abstract float getSalario();

    public abstract Conta getConta();

    public abstract String getSenha();

    public abstract String getCargo();

    public abstract void setCPF(String CPF);

    public abstract void setConta(Conta conta);

    public abstract void setNome(String nome);

    public abstract void setSalario(float salario);

    public abstract void setSenha(String senha);

    public abstract void setCargo(String cargo);

    @Override
    public abstract String toString();

}
