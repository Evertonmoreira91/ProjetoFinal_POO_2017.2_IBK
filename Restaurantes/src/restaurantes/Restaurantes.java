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
import java.util.*;
import java.lang.*;

public class Restaurantes {
      Scanner in = new Scanner(System.in);
      TreeSet<Gerente> listaGerente = new TreeSet<>();
      TreeSet<Garçon>  listaGarçon = new TreeSet<>();
      TreeSet<Cozinheiro> listaCozinheiro = new TreeSet<>();
   
    
    public void cadastrarFuncionario (){
         String nome ;
         float salario ;
         String CPF ;
         int senha ;
         int primeiraVeze=0 ,i , n ;
         
        if (primeiraVeze == 0){
//       CADASTRANDO O PROPRIETARIO
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println("CADASTRANDO O PROPRIETARIO DO RESTAURANTE.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println("Digite o NOME de Proprietario.");
        nome = in.nextLine();
        System.out.println("Digite o CPF do Proprietario.");
        CPF = in.nextLine();
        System.out.println("Digite A SENHA do Proprietario.");
        senha = in.nextInt();
        Conta caixa = new Conta();
        Funcionario dono = new Proprietario( nome, CPF , caixa, senha);
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
//        CADASTRANDO O GERENTE
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println(" O SENHOR DESEJA CADASTRAR UM GERENTE?");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println(" Digite S-(Sim) ou N-(Não)");
        char c= in.nextLine().charAt(0);
        if(c == 'S'){
        System.out.println("CADASTRANDO O GERENTE.");
        System.out.println("Digite o NOME de Gerente.");
        nome = in.nextLine();
        System.out.println("Digite o SALARIO do Gerente.");
        salario = in.nextFloat();
        System.out.println("Digite o CPF do Gerente.");
        CPF = in.nextLine();
        System.out.println("Digite A SENHA do Gerente.");
        senha = in.nextInt();
        Conta gerenteConta = new Conta();
        Funcionario gerente = new Gerente( nome , salario , CPF , gerenteConta, senha);
        listaGerente.add((Gerente) gerente);
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
        }
// CADASTRANDO O(S) COZINHEIROS
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println("CADASTRANDO O(S) COZINHEIROS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS COZINHEIROS?");
         n=in.nextInt();
         Funcionario [] cozinheiro = new Cozinheiro[n];
         Conta [] cozinheiroConta= new Conta[n];
       for (i=0;i<n;i++){
            System.out.println("Digite o NOME do Cozinheiro.");
            nome = in.nextLine();
            System.out.println("Digite o SALARIO do Cozinheiro.");
            salario = in.nextFloat();
            System.out.println("Digite o CPF do Cozinheiro.");
            CPF = in.nextLine();
            System.out.println("Digite A SENHA do Cozinheiro.");
            senha = in.nextInt();
            cozinheiroConta [i] = new Conta();
            cozinheiro [i] = new Cozinheiro(nome,salario,CPF, cozinheiroConta[i],senha);
            listaCozinheiro.add((Cozinheiro) cozinheiro[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
        }
// CADASTRANDO O(S) GARÇON(S)
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println("CADASTRANDO O(S)GARÇON(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS GARÇON(S)?");
        n =in.nextInt();
         Funcionario [] garçon = new Garçon[n];
         Conta [] garçonConta= new Conta[n];
       for (i=0;i<n;i++){
            System.out.println("Digite o NOME DO GARÇON.");
            nome = in.nextLine();
            System.out.println("Digite o SALARIO DO GARÇON..");
            salario = in.nextFloat();
            System.out.println("Digite o CPF DO GARÇON..");
            CPF = in.nextLine();
            System.out.println("Digite A SENHA DO GARÇON..");
            senha = in.nextInt();
            garçonConta [i] = new Conta();
            garçon [i] = new Garçon(nome,salario,CPF, garçonConta[i],senha);
            listaGarçon.add((Garçon) garçon[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
        }
       primeiraVeze++;
    }else {
            System.out.println("O(A) SENHOR(A) DESEJA CADASTRAR (1)-Gerente , (2)-Cozinheiro ou (3)-Garçon .");
            n =in.nextInt();
             switch (n) {
                 case 1:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println(" O SENHOR DESEJA CADASTRAR UM GERENTE?");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("CADASTRANDO O GERENTE.");
                     System.out.println("Digite o NOME de Gerente.");
                     nome = in.nextLine();
                     System.out.println("Digite o SALARIO do Gerente.");
                     salario = in.nextFloat();
                     System.out.println("Digite o CPF do Gerente.");
                     CPF = in.nextLine();
                     System.out.println("Digite A SENHA do Gerente.");
                     senha = in.nextInt();
                     Conta gerenteConta = new Conta();
                     Funcionario gerente = new Gerente( nome , salario , CPF , gerenteConta, senha);
                     listaGerente.add((Gerente) gerente);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
                     break;
                 case 2:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("CADASTRANDO O(S) COZINHEIROS.");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("Digite o NOME do Cozinheiro.");
                     nome = in.nextLine();
                     System.out.println("Digite o SALARIO do Cozinheiro.");
                     salario = in.nextFloat();
                     System.out.println("Digite o CPF do Cozinheiro.");
                     CPF = in.nextLine();
                     System.out.println("Digite A SENHA do Cozinheiro.");
                     senha = in.nextInt();
                     Conta cozinheiroConta = new Conta();
                     Funcionario cozinheiro = new Cozinheiro(nome,salario,CPF, cozinheiroConta,senha);
                     listaCozinheiro.add((Cozinheiro) cozinheiro);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
                     break;
                 case 3:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("CADASTRANDO O(S)GARÇON(S).");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("Digite o NOME DO GARÇON.");
                     nome = in.nextLine();
                     System.out.println("Digite o SALARIO DO GARÇON..");
                     salario = in.nextFloat();
                     System.out.println("Digite o CPF DO GARÇON..");
                     CPF = in.nextLine();
                     System.out.println("Digite A SENHA DO GARÇON..");
                     senha = in.nextInt();
                     Conta garçonConta = new Conta();
                     Funcionario garçon = new Garçon(nome,salario,CPF, garçonConta,senha);
                     listaGarçon.add((Garçon) garçon);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n/n");
                     break;
                 default:
                     break;
             }
        }
    }
    
    public void imprimirListaDosFuncionarios (){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n IMPRIMINDO LA lISTA DOS GERENTES /n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        for (Gerente gerentes : listaGerente){
            System.out.println(gerentes);
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n IMPRIMINDO LA lISTA DOS COZINHEIROS /n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
         for (Cozinheiro cozinheiros : listaCozinheiro){
            System.out.println(cozinheiros);
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n IMPRIMINDO LA lISTA DOS GARÇONS /n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
         for (Garçon garçons : listaGarçon){
            System.out.println(garçons);
        }
    }
    
    public void removerFuncionario(){
        
    } 
    
    public void cadastrarPrato(){
        
    }
    
    public void imprimirCadarpio(){// listar os pratos e as bebidas
    
    }
    
    public void cadastrarBebidas(){
        
    }

    
    public static void main(String[] args) {
        Restaurantes OMEGA= new Restaurantes();
        OMEGA.cadastrarFuncionario();
        OMEGA.imprimirListaDosFuncionarios();
       
        int n;
        
        System.out.println();





    }
    
}
