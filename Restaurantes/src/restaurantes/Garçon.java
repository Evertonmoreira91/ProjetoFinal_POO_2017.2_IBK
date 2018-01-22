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
public class Garçon extends Funcionario implements FuncionamentoExterno, Comparable<Garçon>{
        private  static int idDaClass;
        private int id ;
    
        public Garçon( String name,float salario, String CPF, Conta caixa, int senha) {
        this.nome= name;
        this.salario= salario;
        this.CPF= CPF;
        this.conta = caixa;
        this.senha = senha;
        this.id = idDaClass++;
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
        return this.nome.compareTo(o.getNome());
    }
    
    
}
