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
public abstract class Funcionario implements AutenticavelInterno{
    protected String nome ;
    protected float salario;
    protected String CPF;
    protected Conta conta;
    protected String senha;

    public abstract String getNome();
    public abstract String getCPF();
    public abstract float getSalario();
    public abstract Conta getConta();
    public abstract String getSenha(); 
    public abstract void setCPF(String CPF) ;
    public abstract void setConta(Conta conta) ;
    public abstract void setNome(String nome);
    public abstract void setSalario(float salario);
    public abstract void setSenha(String senha);
    @Override
    public abstract String toString();
    

}
