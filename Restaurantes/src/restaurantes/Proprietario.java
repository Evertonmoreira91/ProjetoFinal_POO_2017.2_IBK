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
public class Proprietario extends Funcionario implements FuncionamentoExterno, PagamentoInterno {
    
    
        public Proprietario( String name, String CPF, Conta caixa, int senha) {
        this.nome= name;
        this.CPF= CPF;
        this.conta = caixa;
        this.senha = senha;
    }

    @Override
    public boolean autentica(int password) {
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
       
    }

    @Override
    public void devolverTroco() {
        
    }

    @Override
    public void pagarSalarioMensuais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pagarAsCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pagarAsManutenções() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
