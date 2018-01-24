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
      Funcionario dono , gerente; Funcionario [] cozinheiro;Funcionario [] garçon;
      TreeSet<Gerente> listaGerente = new TreeSet<>();
      TreeSet<Garçon>  listaGarçon = new TreeSet<>();
      TreeSet<Cozinheiro> listaCozinheiro = new TreeSet<>();
      TreeSet<Comida> listaComida = new TreeSet<>();
      TreeSet<SobreMesa> listaSobreMesas = new TreeSet<>();
      TreeSet<CervejaAlcool> listaCervejaAlcools = new TreeSet<>();
      TreeSet<Refrigerante> listaRefrigerantes = new TreeSet<>();
      TreeSet<Sucos> listaSucos = new TreeSet<>();
   
    
    public void cadastrarFuncionario () throws Exception,ValorInvalidoException{
         String nome ;
         float salario = 0 ;
         String CPF = null ;
         String senha = null ;
         int primeiraVeze=0 ,i , n ;
         boolean continuar = true;
         
        if (primeiraVeze == 0){
//       CADASTRANDO O PROPRIETARIO
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO O PROPRIETARIO DO RESTAURANTE.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("Digite o NOME de Proprietario.");
        nome = in.nextLine();
        while (continuar) {
                   System.out.println("Digite o CPF do Proprietario.");
                  try {                
                     CPF = in.nextLine();
                  if (CPF.length()== 11) {   
                    continuar = false;
                  }
                } catch (Exception e) {
                   throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
    //                  System.out.println("Valor invádlido!" + e.getMessage());
                }
              } 
        continuar = true;  
        while (continuar) {
                System.out.println("Digite A SENHA do Proprietario.");
                 try {                
                 senha = in.next();
                if (senha.length()== 6) {   
                    continuar = false;
                }
              } catch( Exception e) {
               throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
             }
            } 
        continuar = true;
        Conta caixa = new Conta();
        dono = new Proprietario( nome, CPF , caixa, senha);
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        
//        CADASTRANDO O GERENTE
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" O SENHOR DESEJA CADASTRAR UM GERENTE?");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" Digite S-(Sim) ou N-(Não)");
        char c= in.next().charAt(0);
        if(c == 'S'){
        System.out.println("CADASTRANDO O GERENTE.");
        System.out.println("Digite o NOME de Gerente.");
        in.next();
        nome = in.nextLine();
        while (continuar) {
            System.out.println("Digite o SALARIO do Gerente.");
            try {                
                salario = Float.parseFloat(in.next());
                if (salario >= 0.0) {   
                    continuar = false;
                }
            } catch (Exception e) {
                in.reset();
                System.out.println("Valor invádlido!" + e.getMessage());
            }
        }
        continuar = true;       
      
         while (continuar) {
                  System.out.println("Digite o CPF do Gerente.");
                  try { 
                     CPF = in.next();
                  if (CPF.length()== 11) {   
                    continuar = false;
                  }
                } catch (Exception e) {
                     throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                }
              } 
        continuar = true;  
        while (continuar) {
                System.out.println("Digite A SENHA do Gerente.");
                try {                
                 senha = in.next();
                if (senha.length()== 6) {   
                    continuar = false;
                }
              } catch( Exception e) {
               throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
             }
            } 
        continuar = true;
        Conta gerenteConta = new Conta();
        gerente = new Gerente( nome , salario , CPF , gerenteConta, senha);
        listaGerente.add((Gerente) gerente);
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        }
        
// CADASTRANDO O(S) COZINHEIROS
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO O(S) COZINHEIROS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS COZINHEIROS?");
         n=in.nextInt();
         Funcionario [] cozinheiro = new Cozinheiro[n];
         Conta [] cozinheiroConta= new Conta[n];
       for (i=0;i<n;i++){
            System.out.println("Digite o NOME do Cozinheiro.");
            in.next();
            nome = in.nextLine();
            while (continuar) {
            System.out.println("Digite o SALARIO do Cozinheiro.");
            try {                
                salario = Float.parseFloat(in.next());
                if (salario >= 0.0) {   
                    continuar = false;
                }
            } catch (Exception e) {
                in.reset();
                System.out.println("Valor invádlido!" + e.getMessage());
            }
             }
            continuar = true;
            
           while (continuar) {
                 System.out.println("Digite o CPF do Cozinheiro.");
                  try {                
                     CPF = in.next();
                  if (CPF.length()== 11) {   
                    continuar = false;
                  }
                } catch (Exception e) {
                     throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                }
              } 
             continuar = true;           
             while (continuar) {
                System.out.println("Digite A SENHA do Cozinheiro.");
                try {                
                 senha = in.next();
                if (senha.length()== 6) {   
                    continuar = false;
                }
              } catch( Exception e) {
               throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
             }
            } 
            continuar = true;
            cozinheiroConta [i] = new Conta();
            cozinheiro [i] = new Cozinheiro(nome,salario,CPF, cozinheiroConta[i],senha);
            listaCozinheiro.add((Cozinheiro) cozinheiro[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        }
// CADASTRANDO O(S) GARÇON(S)
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO O(S)GARÇON(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS GARÇON(S)?");
        n =in.nextInt();
         Funcionario [] garçon = new Garçon[n];
         Conta [] garçonConta= new Conta[n];
       for (i=0;i<n;i++){
            System.out.println("Digite o NOME DO GARÇON.");
            in.next();
            nome = in.nextLine();
            while (continuar) {
           System.out.println("Digite o SALARIO DO GARÇON..");
            try {                
                salario = Float.parseFloat(in.next());
                if (salario >= 0.0) {   
                    continuar = false;
                }
            } catch (Exception e) {
                in.reset();
                System.out.println("Valor invádlido!" + e.getMessage());
            }
             }
            continuar = true;            
            
             while (continuar) {
                     System.out.println("Digite o CPF DO GARÇON..");
                      try {                
                          CPF = in.next();
                          if (CPF.length()== 11) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                         throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                      }
                     } 
             continuar = true;
             while (continuar) {
                    System.out.println("Digite A SENHA DO GARÇON..");
                      try {                
                         senha = in.next();
                          if (senha.length()== 6) {   
                              continuar = false;
                          }
                         } catch( Exception e) {
                         throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
                      }
                     } 
            continuar = true;
            garçonConta [i] = new Conta();
            garçon [i] = new Garçon(nome,salario,CPF, garçonConta[i],senha);
            listaGarçon.add((Garçon) garçon[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        }
       primeiraVeze++;
    }else {
            System.out.println("O(A) SENHOR(A) DESEJA CADASTRAR (1)-Gerente , (2)-Cozinheiro ou (3)-Garçon .");
            n =in.nextInt();
             switch (n) {
                 case 1:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                     System.out.println(" O SENHOR DESEJA CADASTRAR UM GERENTE?");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/n");
                     System.out.println("CADASTRANDO O GERENTE.");
                     System.out.println("Digite o NOME de Gerente.");
                     in.next();
                     nome = in.nextLine();                     
                    while (continuar) {
                    System.out.println("Digite o SALARIO do Gerente.");
                      try {                
                          salario = Float.parseFloat(in.next());
                          if (salario >= 0.0) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                          in.reset();
                          System.out.println("Valor invádlido!" + e.getMessage());
                      }
                       }
                     continuar = true;
                     
                     while (continuar) {
                     System.out.println("Digite o CPF do Gerente.");
                      try {                
                          CPF = in.next();
                          if (CPF.length()== 11) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                         throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                      }
                     } 
                     continuar = true;
                     while (continuar) {
                     System.out.println("Digite A SENHA do Gerente.");
                      try {                
                         senha = in.next();
                          if (senha.length()== 6) {   
                              continuar = false;
                          }
                         } catch( Exception e) {
                         throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
                      }
                     } 
                     continuar = true;
                     Conta gerenteConta = new Conta();
                     Funcionario gerente = new Gerente( nome , salario , CPF , gerenteConta, senha);
                     listaGerente.add((Gerente) gerente);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n/n");
                     break;
                 case 2:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                     System.out.println("CADASTRANDO O(S) COZINHEIROS.");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                     System.out.println("Digite o NOME do Cozinheiro.");
                     in.next();
                     nome = in.nextLine();                     
                      while (continuar) {
                    System.out.println("Digite o SALARIO do Cozinheiro.");
                      try {                
                          salario = Float.parseFloat(in.next());
                          if (salario >= 0.0) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                          in.reset();
                          System.out.println("Valor invádlido!" + e.getMessage());
                      }
                       }
                     continuar = true;                   
                  
                   while (continuar) {
                     System.out.println("Digite o CPF do Cozinheiro.");
                      try {                
                          CPF = in.next();
                          if (CPF.length()== 11) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                         throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                      }
                     } 
                     continuar = true;
                      while (continuar) {
                     System.out.println("Digite A SENHA do Cozinheiro.");
                      try {                
                         senha = in.next();
                          if (senha.length()== 6) {   
                              continuar = false;
                          }
                         } catch( Exception e) {
                         throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
                      }
                     } 
                     continuar = true;
                     Conta cozinheiroConta = new Conta();
                     Funcionario cozinheiro = new Cozinheiro(nome,salario,CPF, cozinheiroConta,senha);
                     listaCozinheiro.add((Cozinheiro) cozinheiro);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n/n");
                     break;
                 case 3:
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                     System.out.println("CADASTRANDO O(S)GARÇON(S).");
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                     System.out.println("Digite o NOME DO GARÇON.");
                     in.next();
                     nome = in.nextLine();                    
                    while (continuar) {
                    System.out.println("Digite o SALARIO DO GARÇON..");
                      try {                
                          salario = Float.parseFloat(in.next());
                          if (salario >= 0.0) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                          in.reset();
                          System.out.println("Valor invádlido!" + e.getMessage());
                      }
                       }
                    continuar = true;
                    
                    while (continuar) {
                    System.out.println("Digite o CPF DO GARÇON..");
                      try {                
                          CPF = in.next();
                          if (CPF.length()== 11) {   
                              continuar = false;
                          }
                      } catch (Exception e) {
                         throw new ValorInvalidoException("O CPF deve conter 11 digitos "+CPF);
                      }
                     } 
                     continuar = true;                     
                    while (continuar) {
                     System.out.println("Digite A SENHA DO GARÇON..");
                      try {                
                         senha = in.next();
                          if (senha.length()== 6) {   
                              continuar = false;
                          }
                         } catch( Exception e) {
                         throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  "+senha);
                      }
                     } 
                     continuar = true;
                     Conta garçonConta = new Conta();
                     Funcionario garçon = new Garçon(nome,salario,CPF, garçonConta,senha);
                     listaGarçon.add((Garçon) garçon);
                     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n/n");
                     break;
                 default:
                     break;
             }
        }
    }
    
    
    public void imprimirListaDosFuncionarios (){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS GERENTES \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

           Iterator<Gerente> iterator0 = listaGerente.iterator();
           while (iterator0.hasNext()){
               System.out.println( iterator0.next()+" ");
           }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS COZINHEIROS \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        
            Iterator<Cozinheiro> iterator1 = listaCozinheiro.iterator();
           while (iterator1.hasNext()){
               System.out.println( iterator1.next()+" ");
           }
        
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS GARÇONS \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
         
        Iterator<Garçon> iterator2 = listaGarçon.iterator();
           while (iterator2.hasNext()){
               System.out.println( iterator2.next()+" ");
           }
    
    }
    
    public void removerFuncionario(){
        int n,id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO FUNCIONARIO.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS FUNCIONARIOS O SENHOR DESEJA REMOVER ? DIGITE (1)--GERENTE  (2)--GARÇON(S)  (3)--COZINHEIRO(S)?");
        n =in.nextInt();
        if(n == 1){
            System.out.println("DIGITE O ID DO GERENTE A REMOVER");
            id = in.nextInt();
            for (Gerente lista: listaGerente){
                if (lista.getId() == id){
                   listaGerente.remove(lista);
                   System.out.println("GERENTE "+id+" REMOVIDO.");
                   break;
                }
            }
        }else if(n==2){
            System.out.println("DIGITE O ID DO GARÇON A REMOVER.");
            id = in.nextInt();
            for ( Garçon lista: listaGarçon){
                if (lista.getId() == id){
                   listaGarçon.remove(lista);
                   System.out.println("GARÇON "+id+" REMOVIDO.");
                   break;
                }
            }
        }else if (n==3){
            System.out.println("DIGITE O ID DO COZINHEIRO A REMOVER.");
            id = in.nextInt();
            for (Cozinheiro lista: listaCozinheiro){
                if (lista.getId() == id){
                   listaCozinheiro.remove(lista);
                   System.out.println("COZINHEIRO "+id+" REMOVIDO.");
                   break;
                }
            }
       }
       System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
       System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    } 
    
    public void cadastrarPrato(){
        String nome ; int quantidade = 0 ; 
        float preço = 0 ; 
        boolean continuar= true;
        int n;
        
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO PRATOS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS PRATOS O SENHOR DESEJA CADASTRAR ? DIGITE (C)--COMIDA(  S)--SOBREMESA ?");
        char c= in.next().charAt(0);
        if(c == 'C'){
            
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO COMIDA(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS COMIDAS ?");
        n =in.nextInt();
        Prato [] comida = new Comida[n];
       for (int i=0;i<n;i++){
            System.out.println("DIGITE O NOME DO PRATO.");
            in.next();
            nome = in.nextLine();
            while (continuar) {
           System.out.println("DIGITE O PREÇO DO PRATO.");
            try {                
                preço = Float.parseFloat(in.next());
                if (preço >= 0.0) {   
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                in.reset();
                System.out.println("Valor invádlido!" + e.getMessage());
            }
             }
            continuar = true;            
             while (continuar) {
                     System.out.println("DIGITE A QUANTIDADE DO PRATO.");
                      try {                
                          quantidade = Integer.parseUnsignedInt(in.next());
                         if ( quantidade >= 0) {   
                        continuar = false;
                    }
                } catch (Exception e) {
                    in.reset();
                    System.out.println("Valor invádlido!" + e.getMessage());
                }
                     } 
             continuar = true;
            comida [i] = new Comida(nome,quantidade,preço);
            listaComida.add((Comida) comida[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        }
        
        }else if (c== 'S'){
            
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO SOBREMESA(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS SOBREMESA(S) ?");
            n =in.nextInt();
            Prato [] sobreMesa = new SobreMesa[n];
           for (int i=0;i<n;i++){
                System.out.println("DIGITE O NOME DO PRATO.");
                in.next();
                nome = in.nextLine();
                while (continuar) {
               System.out.println("DIGITE O PREÇO DO PRATO.");
                try {                
                    preço = Float.parseFloat(in.next());
                    if (preço >= 0.0) {   
                        continuar = false;
                    }
                } catch (NumberFormatException e) {
                    in.reset();
                    System.out.println("Valor invádlido!" + e.getMessage());
                }
                 }
                continuar = true;            
                 while (continuar) {
                         System.out.println("DIGITE A QUANTIDADE DO PRATO.");
                          try {                
                              quantidade = Integer.parseUnsignedInt(in.next());
                             if ( quantidade >= 0) {   
                            continuar = false;
                        }
                    } catch (Exception e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                         } 
                 continuar = true;
                sobreMesa [i] = new SobreMesa(nome,quantidade,preço);
                listaSobreMesas.add((SobreMesa) sobreMesa[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
        }
    }
    
    public void removerPrato(){
        int n,id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO O(S) PRATO(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS PRATOS O SENHOR DESEJA REMOVER ? DIGITE (1)--COMIDA(S)  (2)--SOBREMESA(S)?");
        n =in.nextInt();
        if(n == 1){
            System.out.println("DIGITE O ID DA COMIDA A REMOVER");
            id = in.nextInt();
            for (Comida lista: listaComida){
                if (lista.getId() == id){
                   listaComida.remove(lista);
                   System.out.println("COMIDA "+id+" REMOVIDO.");
                   break;
                }
            }
        }else if(n==2){
            System.out.println("DIGITE O ID DA SOBREMESA A REMOVER.");
            id = in.nextInt();
            for ( SobreMesa lista: listaSobreMesas){
                if (lista.getId() == id){
                   listaSobreMesas.remove(lista);
                   System.out.println("SOBREMESA "+id+" REMOVIDO.");
                   break;
                }
            }
        }
           System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
           System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        
        
    }
    
    public void cadastrarBebidas(){
        String nome ; int quantidade = 0 ; 
        float preço = 0 ; 
        boolean continuar= true;
        int n;
        
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO BEBIDAS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS BEBIDAS O SENHOR DESEJA CADASTRAR ? DIGITE (C)--CERVEJA/ALCOOL   (R)--REFRIGERENTES  (S)--SUCOS ?");
        char c= in.next().charAt(0);
        if(c == 'C'){
            
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO CERVEJA/ALCOOL.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS CERVEJA(S)/ALCOOL ?");
        n =in.nextInt();
        Bebida [] cervejaAlcool = new CervejaAlcool[n];
       for (int i=0;i<n;i++){
            System.out.println("DIGITE O NOME DO CERVEJA(S)/ALCOOL .");
            in.next();
            nome = in.nextLine();
            while (continuar) {
           System.out.println("DIGITE O PREÇO DO CERVEJA(S)/ALCOOL .");
            try {                
                preço = Float.parseFloat(in.next());
                if (preço >= 0.0) {   
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                in.reset();
                System.out.println("Valor invádlido!" + e.getMessage());
            }
             }
            continuar = true;            
             while (continuar) {
                     System.out.println("DIGITE A QUANTIDADE DO CERVEJA(S)/ALCOOL .");
                      try {                
                          quantidade = Integer.parseUnsignedInt(in.next());
                         if ( quantidade >= 0) {   
                        continuar = false;
                    }
                } catch (NumberFormatException e) {
                    in.reset();
                    System.out.println("Valor invádlido!" + e.getMessage());
                }
                     } 
             continuar = true;
            cervejaAlcool [i] = new CervejaAlcool(nome,quantidade,preço);
            listaCervejaAlcools.add((CervejaAlcool) cervejaAlcool[i]);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
        }
        
        }else if (c== 'R'){
            
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO REFRIGERANTE(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS REFRIGERANTE(S) ?");
            n =in.nextInt();
            Bebida [] refrigerante = new Refrigerante[n];
           for (int i=0;i<n;i++){
                System.out.println("DIGITE O NOME DO REFRIGERANTE.");
                in.next();
                nome = in.nextLine();
                while (continuar) {
               System.out.println("DIGITE O PREÇO DO REFRIGERANTE.");
                try {                
                    preço = Float.parseFloat(in.next());
                    if (preço >= 0.0) {   
                        continuar = false;
                    }
                } catch (NumberFormatException e) {
                    in.reset();
                    System.out.println("Valor invádlido!" + e.getMessage());
                }
                 }
                continuar = true;            
                 while (continuar) {
                         System.out.println("DIGITE A QUANTIDADE DO REFRIGERANTE.");
                          try {                
                              quantidade = Integer.parseUnsignedInt(in.next());
                             if ( quantidade >= 0) {   
                            continuar = false;
                        }
                    } catch (NumberFormatException e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                         } 
                 continuar = true;
                refrigerante [i] = new Refrigerante(nome,quantidade,preço);
                listaRefrigerantes.add((Refrigerante) refrigerante[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
        }if (c== 'S'){
            
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO SUCO(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS SUCO(S) ?");
            n =in.nextInt();
            Bebida [] sucos = new Sucos[n];
           for (int i=0;i<n;i++){
                System.out.println("DIGITE O NOME DO SUCO.");
                in.next();
                nome = in.nextLine();
                while (continuar) {
               System.out.println("DIGITE O PREÇO DO SUCO.");
                try {                
                    preço = Float.parseFloat(in.next());
                    if (preço >= 0.0) {   
                        continuar = false;
                    }
                } catch (NumberFormatException e) {
                    in.reset();
                    System.out.println("Valor invádlido!" + e.getMessage());
                }
                 }
                continuar = true;            
                 while (continuar) {
                         System.out.println("DIGITE A QUANTIDADE DO SUCO.");
                          try {                
                              quantidade = Integer.parseUnsignedInt(in.next());
                             if ( quantidade >= 0) {   
                            continuar = false;
                        }
                    } catch (NumberFormatException e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                         } 
                 continuar = true;
                sucos [i] = new Sucos(nome,quantidade,preço);
                listaSucos.add((Sucos) sucos[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
    }
        
    }
    
    public void removerBebidas(){
     int n,id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO A(S) BEBIDAS(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS BEBIDAS O SENHOR DESEJA REMOVER ? DIGITE (1)--CERVEJA/ALCOOL   (2)--REFRIGERENTES  (3)--SUCOS ?");
        n =in.nextInt();
          switch (n) {
              case 1:
                  System.out.println("DIGITE O ID DA CERVEJA/ALCOOL  A REMOVER");
                  id = in.nextInt();
                  for (CervejaAlcool lista: listaCervejaAlcools){
                      if (lista.getId() == id){
                          listaCervejaAlcools.remove(lista);
                          System.out.println("CERVEJA/ALCOOL  "+id+" REMOVIDO.");
                          break;
                      }
                  }     break;
              case 2:
                  System.out.println("DIGITE O ID DO REFRIGERENTE A REMOVER.");
                  id = in.nextInt();
                  for ( Refrigerante lista: listaRefrigerantes){
                      if (lista.getId() == id){
                          listaRefrigerantes.remove(lista);
                          System.out.println("REFRIGERENTE "+id+" REMOVIDO.");
                          break;
                      }
                  }     break;
              case 3:
                  System.out.println("DIGITE O ID DO SUCO A REMOVER.");
                  id = in.nextInt();
                  for ( Sucos lista: listaSucos){
                      if (lista.getId() == id){
                          listaSucos.remove(lista);
                          System.out.println("SUCO "+id+" REMOVIDO.");
                          break;
                      }
                  }     break;
              default:
                  break;
          }
       System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
       System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    } 
     
    public void imprimirCadarpio(){// listar os pratos e as bebidas
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n A lISTA DOS PRATOS \n ");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n AS COMIDAS \n");
           Iterator<Comida> iterator0 = listaComida.iterator();
           while (iterator0.hasNext()){
               System.out.println( iterator0.next()+" ");
           }
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n AS SOBREMESAS \n");
           Iterator<SobreMesa> iterator1 = listaSobreMesas.iterator();
           while (iterator1.hasNext()){
               System.out.println( iterator1.next()+" ");
           }
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n A lISTA DOS BEBIDAS \n ");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n OS REFRIGERENTES \n");
           Iterator<Refrigerante> iterator2 = listaRefrigerantes.iterator();
           while (iterator2.hasNext()){
               System.out.println( iterator2.next()+" ");
           }
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n AS CERVEJAS/ALCOOL \n");
           Iterator<CervejaAlcool> iterator3 = listaCervejaAlcools.iterator();
           while (iterator3.hasNext()){
               System.out.println( iterator3.next()+" ");
           }
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.println("\n OS SUCOS \n");
           Iterator<Sucos> iterator4 = listaSucos.iterator();
           while (iterator4.hasNext()){
               System.out.println( iterator4.next()+" ");
           }
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
     
    }
    
    public void login(AutenticavelInterno a){
        
    }
       
       
    public static void main(String[] args) throws Exception {
        Restaurantes OMEGA= new Restaurantes();
        OMEGA.cadastrarFuncionario();
        OMEGA.imprimirListaDosFuncionarios();
        OMEGA.removerFuncionario();
        OMEGA.cadastrarPrato();
        OMEGA.removerPrato();
        OMEGA.login(dono);




    }
    
}
