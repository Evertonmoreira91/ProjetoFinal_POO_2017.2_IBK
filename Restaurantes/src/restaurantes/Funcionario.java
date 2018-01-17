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
    protected int senha;
}
