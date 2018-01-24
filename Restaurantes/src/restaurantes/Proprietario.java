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
public final class Proprietario extends Funcionario implements FuncionamentoExterno, PagamentoInterno {
    
    
        public Proprietario( String name, String CPF, Conta caixa, String senha) {
       
        setNome(name);
        setCPF(CPF);
        setConta(caixa);
        setSenha(senha);
        
    }

    @Override
    public boolean autentica(String password) {
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
    
    
     @Override
    public String toString() {
        return "Proprietario "+" - "+getNome()+" CPF: "+ getCPF();
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
