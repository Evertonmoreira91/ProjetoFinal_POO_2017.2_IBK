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
        Funcionario dono = new Proprietario( nome, CPF , caixa, senha);
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
        Funcionario gerente = new Gerente( nome , salario , CPF , gerenteConta, senha);
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
        
    } 
    
    public void cadastrarPrato(){
        
    }
    
    public void imprimirCadarpio(){// listar os pratos e as bebidas
    
    }
    
    public void cadastrarBebidas(){
        
    }

    
    public static void main(String[] args) throws Exception {
        Restaurantes OMEGA= new Restaurantes();
        OMEGA.cadastrarFuncionario();
        OMEGA.imprimirListaDosFuncionarios();
     





    }
    
}
