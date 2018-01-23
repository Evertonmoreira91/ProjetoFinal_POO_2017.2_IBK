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
public final class Cozinheiro extends Funcionario implements Comparable<Cozinheiro>{
        private  static int idDaClass;
        private int id ;
    
    
       public Cozinheiro( String name,float salario, String CPF,Conta caixa, String senha) throws ValorInvalidoException {
       try{
        setNome(name);
        setSalario(salario);
        setCPF(CPF);
        setConta(caixa);
        setSenha(senha);
        this.id = idDaClass++;
         } catch (ValorInvalidoException | InputMismatchException e){
            System.err.println(e.getMessage());
         }
    }

    @Override
    public boolean autentica(String password) {
        
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
//        return this.nome.compareTo(o.getNome());
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
        
        if (obj == null || !(obj instanceof Cozinheiro))
            return false;
        else
            return (this.id == ((Cozinheiro)obj).getId());
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

    public void setCPF(String CPF) throws ValorInvalidoException  {
        if ( CPF.length()== 11){
            this.CPF = CPF;
        } else {
            throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
        }
    }

    public void setConta(Conta conta) {
        this.conta=conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) throws InputMismatchException{
        
        if ( "float".equals(nameOf(salario))){
            this.salario =salario;
        }else{
            throw new InputMismatchException ("Valor invalido: Digite Valores reais "+salario);
        }
    }
 // Gerar o tipo do objeto
        private static String nameOf(Object o) {
                return o.getClass().getSimpleName();
    }

    public void setSenha(String senha) throws ValorInvalidoException {
         if ( senha.length()== 11){
            this.senha = senha;
        } else {
            throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
        }
        
    }
    
    
}
