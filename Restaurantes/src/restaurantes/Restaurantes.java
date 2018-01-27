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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.lang.*;

public class Restaurantes implements Serializable {

    Scanner in = new Scanner(System.in);
    Funcionario dono, gerente;
    Funcionario[] cozinheiro;
    Funcionario[] garçon;
    static List<Funcionario> listaFuncionarios = new ArrayList<>();
    static List<Proprietario> listaDono = new ArrayList<>();
    static TreeSet<Gerente> listaGerente = new TreeSet<>();
    static TreeSet<Garçon> listaGarçon = new TreeSet<>();
    static TreeSet<Cozinheiro> listaCozinheiro = new TreeSet<>();
    static TreeSet<Comida> listaComida = new TreeSet<>();
    static TreeSet<SobreMesa> listaSobreMesas = new TreeSet<>();
    static TreeSet<CervejaAlcool> listaCervejaAlcools = new TreeSet<>();
    static TreeSet<Refrigerante> listaRefrigerantes = new TreeSet<>();
    static TreeSet<Sucos> listaSucos = new TreeSet<>();

    public void cadastrarFuncionario() throws Exception, ValorInvalidoException {
        String nome;
        float salario = 0;
        String CPF = null;
        String senha = null;
        int primeiraVeze = 0, i, n;
        boolean continuar = true;

        if (primeiraVeze == 0) {
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
                    if (CPF.length() == 11) {
                        continuar = false;
                    }
                } catch (Exception e) {
                    throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                }
            }
            continuar = true;
            while (continuar) {
                System.out.println("Digite A SENHA do Proprietario.");
                try {
                    senha = in.next();
                    if (senha.length() == 6) {
                        continuar = false;
                    }
                } catch (Exception e) {
                    throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                }
            }
            continuar = true;
            Conta caixa = new Conta();
            dono = new Proprietario(nome, CPF, caixa, senha, "Proprietario");
            listaDono.add((Proprietario) dono);
            listaFuncionarios.add((Funcionario) dono);
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");

//        CADASTRANDO O GERENTE
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR UM GERENTE?");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" Digite S-(Sim) ou N-(Não)");
            char c = in.next().charAt(0);
            if (c == 'S') {
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
                        if (CPF.length() == 11) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                    }
                }
                continuar = true;
                while (continuar) {
                    System.out.println("Digite A SENHA do Gerente.");
                    try {
                        senha = in.next();
                        if (senha.length() == 6) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                    }
                }
                continuar = true;
                Conta gerenteConta = new Conta();
                gerente = new Gerente(nome, salario, CPF, gerenteConta, senha, "Gerente");
                listaGerente.add((Gerente) gerente);
                listaFuncionarios.add((Funcionario) gerente);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }

// CADASTRANDO O(S) COZINHEIROS
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO O(S) COZINHEIROS.");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS COZINHEIROS?");
            n = in.nextInt();
            Funcionario[] cozinheiro = new Cozinheiro[n];
            Conta[] cozinheiroConta = new Conta[n];
            for (i = 0; i < n; i++) {
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
                        if (CPF.length() == 11) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                    }
                }
                continuar = true;
                while (continuar) {
                    System.out.println("Digite A SENHA do Cozinheiro.");
                    try {
                        senha = in.next();
                        if (senha.length() == 6) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                    }
                }
                continuar = true;
                cozinheiroConta[i] = new Conta();
                cozinheiro[i] = new Cozinheiro(nome, salario, CPF, cozinheiroConta[i], senha, "Cozinheiro");
                listaCozinheiro.add((Cozinheiro) cozinheiro[i]);
                listaFuncionarios.add(cozinheiro[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
// CADASTRANDO O(S) GARÇON(S)
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO O(S)GARÇON(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS GARÇON(S)?");
            n = in.nextInt();
            Funcionario[] garçon = new Garçon[n];
            Conta[] garçonConta = new Conta[n];
            for (i = 0; i < n; i++) {
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
                        if (CPF.length() == 11) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                    }
                }
                continuar = true;
                while (continuar) {
                    System.out.println("Digite A SENHA DO GARÇON..");
                    try {
                        senha = in.next();
                        if (senha.length() == 6) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                    }
                }
                continuar = true;
                garçonConta[i] = new Conta();
                garçon[i] = new Garçon(nome, salario, CPF, garçonConta[i], senha, "Garçon");
                listaGarçon.add((Garçon) garçon[i]);
                listaFuncionarios.add(garçon[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
            System.out.println(" O SENHOR DESEJA SALVAR AS INFORMAÇÕES ? Digite (S) PARA CONFIRMAR");
            char escolha = in.next().charAt(0);
            if (escolha == 'S') {
                geraArquivoFuncionario();
            }
            primeiraVeze++;
        } else {
            System.out.println("O(A) SENHOR(A) DESEJA CADASTRAR (1)-Gerente , (2)-Cozinheiro ou (3)-Garçon .");
            n = in.nextInt();
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
                            if (CPF.length() == 11) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                        }
                    }
                    continuar = true;
                    while (continuar) {
                        System.out.println("Digite A SENHA do Gerente.");
                        try {
                            senha = in.next();
                            if (senha.length() == 6) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                        }
                    }
                    continuar = true;
                    Conta gerenteConta = new Conta();
                    Funcionario gerente = new Gerente(nome, salario, CPF, gerenteConta, senha, "Gerente");
                    listaGerente.add((Gerente) gerente);
                    listaFuncionarios.add(gerente);
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
                            if (CPF.length() == 11) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                        }
                    }
                    continuar = true;
                    while (continuar) {
                        System.out.println("Digite A SENHA do Cozinheiro.");
                        try {
                            senha = in.next();
                            if (senha.length() == 6) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                        }
                    }
                    continuar = true;
                    Conta cozinheiroConta = new Conta();
                    Funcionario cozinheiro = new Cozinheiro(nome, salario, CPF, cozinheiroConta, senha, "Cozinheiro");
                    listaCozinheiro.add((Cozinheiro) cozinheiro);
                    listaFuncionarios.add(cozinheiro);
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
                            if (CPF.length() == 11) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("O CPF deve conter 11 digitos " + CPF);
                        }
                    }
                    continuar = true;
                    while (continuar) {
                        System.out.println("Digite A SENHA DO GARÇON..");
                        try {
                            senha = in.next();
                            if (senha.length() == 6) {
                                continuar = false;
                            }
                        } catch (Exception e) {
                            throw new ValorInvalidoException("Senha INVALIDA: 6 digitos  " + senha);
                        }
                    }
                    continuar = true;
                    Conta garçonConta = new Conta();
                    Funcionario garçon = new Garçon(nome, salario, CPF, garçonConta, senha, "Garçon");
                    listaGarçon.add((Garçon) garçon);
                    listaFuncionarios.add(garçon);
                    System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n/n");
                    break;
                default:
                    break;
            }
            System.out.println(" O SENHOR DESEJA SALVAR AS INFORMAÇÕES ? Digite (S) PARA CONFIRMAR");
            char escolha = in.next().charAt(0);
            if (escolha == 'S') {
                geraArquivoFuncionario();
            }
        }
    }

    public void imprimirListaDosFuncionarios() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS GERENTES \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Iterator<Gerente> iterator0 = listaGerente.iterator();
        while (iterator0.hasNext()) {
            System.out.println(iterator0.next() + " ");
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS COZINHEIROS \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Iterator<Cozinheiro> iterator1 = listaCozinheiro.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next() + " ");
        }

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n IMPRIMINDO A lISTA DOS GARÇONS \n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        Iterator<Garçon> iterator2 = listaGarçon.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next() + " ");
        }

    }

    public void removerFuncionario() {
        int n, id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO FUNCIONARIO.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS FUNCIONARIOS O SENHOR DESEJA REMOVER ? DIGITE (1)--GERENTE  (2)--GARÇON(S)  (3)--COZINHEIRO(S)?");
        n = in.nextInt();
        if (n == 1) {
            System.out.println("DIGITE O ID DO GERENTE A REMOVER");
            id = in.nextInt();
            for (Gerente lista : listaGerente) {
                if (lista.getId() == id) {
                    listaGerente.remove(lista);
                    System.out.println("GERENTE " + id + " REMOVIDO.");
                    break;
                }
            }
        } else if (n == 2) {
            System.out.println("DIGITE O ID DO GARÇON A REMOVER.");
            id = in.nextInt();
            for (Garçon lista : listaGarçon) {
                if (lista.getId() == id) {
                    listaGarçon.remove(lista);
                    System.out.println("GARÇON " + id + " REMOVIDO.");
                    break;
                }
            }
        } else if (n == 3) {
            System.out.println("DIGITE O ID DO COZINHEIRO A REMOVER.");
            id = in.nextInt();
            for (Cozinheiro lista : listaCozinheiro) {
                if (lista.getId() == id) {
                    listaCozinheiro.remove(lista);
                    System.out.println("COZINHEIRO " + id + " REMOVIDO.");
                    break;
                }
            }
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    }

    public void cadastrarPrato() {
        String nome;
        int quantidade = 0;
        float preço = 0;
        boolean continuar = true;
        int n;

        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO PRATOS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS PRATOS O SENHOR DESEJA CADASTRAR ? DIGITE (C)--COMIDA(  S)--SOBREMESA ?");
        char c = in.next().charAt(0);
        if (c == 'C') {

            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO COMIDA(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS COMIDAS ?");
            n = in.nextInt();
            Prato[] comida = new Comida[n];
            for (int i = 0; i < n; i++) {
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
                        if (quantidade >= 0) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                }
                continuar = true;
                comida[i] = new Comida(nome, quantidade, preço);
                listaComida.add((Comida) comida[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }

        } else if (c == 'S') {

            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO SOBREMESA(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS SOBREMESA(S) ?");
            n = in.nextInt();
            Prato[] sobreMesa = new SobreMesa[n];
            for (int i = 0; i < n; i++) {
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
                        if (quantidade >= 0) {
                            continuar = false;
                        }
                    } catch (Exception e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                }
                continuar = true;
                sobreMesa[i] = new SobreMesa(nome, quantidade, preço);
                listaSobreMesas.add((SobreMesa) sobreMesa[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
        }
    }

    public void removerPrato() {
        int n, id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO O(S) PRATO(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS PRATOS O SENHOR DESEJA REMOVER ? DIGITE (1)--COMIDA(S)  (2)--SOBREMESA(S)?");
        n = in.nextInt();
        if (n == 1) {
            System.out.println("DIGITE O ID DA COMIDA A REMOVER");
            id = in.nextInt();
            for (Comida lista : listaComida) {
                if (lista.getId() == id) {
                    listaComida.remove(lista);
                    System.out.println("COMIDA " + id + " REMOVIDO.");
                    break;
                }
            }
        } else if (n == 2) {
            System.out.println("DIGITE O ID DA SOBREMESA A REMOVER.");
            id = in.nextInt();
            for (SobreMesa lista : listaSobreMesas) {
                if (lista.getId() == id) {
                    listaSobreMesas.remove(lista);
                    System.out.println("SOBREMESA " + id + " REMOVIDO.");
                    break;
                }
            }
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

    }

    public void cadastrarBebidas() {
        String nome;
        int quantidade = 0;
        float preço = 0;
        boolean continuar = true;
        int n;

        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("CADASTRANDO BEBIDAS.");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS BEBIDAS O SENHOR DESEJA CADASTRAR ? DIGITE (C)--CERVEJA/ALCOOL   (R)--REFRIGERENTES  (S)--SUCOS ?");
        char c = in.next().charAt(0);
        if (c == 'C') {

            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO CERVEJA/ALCOOL.");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTAS CERVEJA(S)/ALCOOL ?");
            n = in.nextInt();
            Bebida[] cervejaAlcool = new CervejaAlcool[n];
            for (int i = 0; i < n; i++) {
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
                        if (quantidade >= 0) {
                            continuar = false;
                        }
                    } catch (NumberFormatException e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                }
                continuar = true;
                cervejaAlcool[i] = new CervejaAlcool(nome, quantidade, preço);
                listaCervejaAlcools.add((CervejaAlcool) cervejaAlcool[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }

        } else if (c == 'R') {

            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO REFRIGERANTE(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS REFRIGERANTE(S) ?");
            n = in.nextInt();
            Bebida[] refrigerante = new Refrigerante[n];
            for (int i = 0; i < n; i++) {
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
                        if (quantidade >= 0) {
                            continuar = false;
                        }
                    } catch (NumberFormatException e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                }
                continuar = true;
                refrigerante[i] = new Refrigerante(nome, quantidade, preço);
                listaRefrigerantes.add((Refrigerante) refrigerante[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
        }
        if (c == 'S') {

            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("CADASTRANDO SUCO(S).");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println(" O SENHOR DESEJA CADASTRAR QUANTOS SUCO(S) ?");
            n = in.nextInt();
            Bebida[] sucos = new Sucos[n];
            for (int i = 0; i < n; i++) {
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
                        if (quantidade >= 0) {
                            continuar = false;
                        }
                    } catch (NumberFormatException e) {
                        in.reset();
                        System.out.println("Valor invádlido!" + e.getMessage());
                    }
                }
                continuar = true;
                sucos[i] = new Sucos(nome, quantidade, preço);
                listaSucos.add((Sucos) sucos[i]);
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n\n");
            }
        }

    }

    public void removerBebidas() {
        int n, id;
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("REMOVENDO A(S) BEBIDAS(S).");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println(" QUAIS BEBIDAS O SENHOR DESEJA REMOVER ? DIGITE (1)--CERVEJA/ALCOOL   (2)--REFRIGERENTES  (3)--SUCOS ?");
        n = in.nextInt();
        switch (n) {
            case 1:
                System.out.println("DIGITE O ID DA CERVEJA/ALCOOL  A REMOVER");
                id = in.nextInt();
                for (CervejaAlcool lista : listaCervejaAlcools) {
                    if (lista.getId() == id) {
                        listaCervejaAlcools.remove(lista);
                        System.out.println("CERVEJA/ALCOOL  " + id + " REMOVIDO.");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("DIGITE O ID DO REFRIGERENTE A REMOVER.");
                id = in.nextInt();
                for (Refrigerante lista : listaRefrigerantes) {
                    if (lista.getId() == id) {
                        listaRefrigerantes.remove(lista);
                        System.out.println("REFRIGERENTE " + id + " REMOVIDO.");
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("DIGITE O ID DO SUCO A REMOVER.");
                id = in.nextInt();
                for (Sucos lista : listaSucos) {
                    if (lista.getId() == id) {
                        listaSucos.remove(lista);
                        System.out.println("SUCO " + id + " REMOVIDO.");
                        break;
                    }
                }
                break;
            default:
                break;
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    }

    public void imprimirCadarpio() throws IOException {// listar os pratos e as bebidas
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n A lISTA DOS PRATOS \n ");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n AS COMIDAS \n");
        Iterator<Comida> iterator0 = listaComida.iterator();
        while (iterator0.hasNext()) {
            System.out.println(iterator0.next() + " ");
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n AS SOBREMESAS \n");
        Iterator<SobreMesa> iterator1 = listaSobreMesas.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next() + " ");
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n A lISTA DOS BEBIDAS \n ");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n OS REFRIGERENTES \n");
        Iterator<Refrigerante> iterator2 = listaRefrigerantes.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next() + " ");
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n AS CERVEJAS/ALCOOL \n");
        Iterator<CervejaAlcool> iterator3 = listaCervejaAlcools.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next() + " ");
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.println("\n OS SUCOS \n");
        Iterator<Sucos> iterator4 = listaSucos.iterator();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next() + " ");
        }
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

    }

    public void leituraArquivoFuncionario() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream("Funcionario.bin");
        ObjectInputStream leitura = new ObjectInputStream(os);
        listaFuncionarios = (List<Funcionario>) leitura.readObject();
        os.close();
    }

    public void geraArquivoFuncionario() throws IOException {
        FileOutputStream os = new FileOutputStream("Funcionario.bin");

        ObjectOutputStream gravar = new ObjectOutputStream(os);

        gravar.writeObject(listaFuncionarios);
        gravar.flush();

        gravar.close();
        os.flush();
        os.close();

        System.out.println("Gravação realizada Sucesso");
    }

    public void leituraArquivoCardapio() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream("Cardapio.bin");
        ObjectInputStream leitura = new ObjectInputStream(os);
        listaComida = (TreeSet<Comida>) leitura.readObject();
        listaCervejaAlcools = (TreeSet<CervejaAlcool>) leitura.readObject();
        listaSobreMesas = (TreeSet<SobreMesa>) leitura.readObject();
        listaRefrigerantes = (TreeSet<Refrigerante>) leitura.readObject();
        listaSucos = (TreeSet<Sucos>) leitura.readObject();

        os.close();
    }

    public void geraArquivoCardapio() throws IOException {
        FileOutputStream os = new FileOutputStream("Cardapio.bin");

        ObjectOutputStream gravar = new ObjectOutputStream(os);

        gravar.writeObject(listaComida);
        gravar.writeObject(listaCervejaAlcools);
        gravar.writeObject(listaSobreMesas);
        gravar.writeObject(listaRefrigerantes);
        gravar.writeObject(listaSucos);
        gravar.flush();

        gravar.close();
        os.flush();
        os.close();

        System.out.println("Gravação realizada Sucesso");
    }

    /**
     *
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Restaurantes OMEGA = new Restaurantes();
        boolean saida = false, permissão = false, pararOprograma = false;
        String CPF, senha, cargo = null;
        int n, opção, primeiraveze = 0;
        Proprietario usuario1 = new Proprietario();
        Gerente usuario2= new Gerente();
        Cozinheiro usuario3 = new Cozinheiro();
        Garçon usuario4 = new Garçon();
  
        

        System.out.println("inicializando os sistemas");

        do {
            if (primeiraveze == 0) {
                try {
                    OMEGA.leituraArquivoFuncionario();
                    System.out.println(" CARREGAMENTO DO ARQUIVO FUNCIONARIO !");
                    primeiraveze++;
                } catch (Exception e) {
                    System.out.println("ERRO AO CARREGAMENTO DO ARQUIVO FUNCIONARIO ! " + e.getMessage());
                    if (e.getMessage() == null) {
                        OMEGA.cadastrarFuncionario();
                        primeiraveze++;
                    }
                }
            } else {
                try {
                    OMEGA.leituraArquivoCardapio();
                    System.out.println(" CARREGAMENTO DO ARQUIVO Cardapio ! ");
                } catch (Exception e) {
                    if (e.getMessage() == null) {
                        System.out.println("NENHUM CARDAPIO FOI AINDA CADASTRADO ! ");
                    } else {
                        System.out.println("ERRO AO CARREGAMENTO DO ARQUIVO CARDAPIO ! " + e.getMessage());
                    }
                }
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                System.out.println(" \n Digite (1)---CADASTRANDO FUNCIONARIO NO SISTEMA  (2)--- MONITORANDO O SISTEMA \n");
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                n = in.nextInt();
                if (n == 1) {
                    System.out.println("inicializando O CADASTRO No sistema");
                    System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    System.out.println("IDENTIFIQUE-SE");
                    while (permissão == false) {
//                        in.next();
                        System.out.println("DIGITE SEU CPF");
                        CPF = in.next();
                        System.out.println("DIGITE A SUA SENHA");
                        senha = in.next();
                        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                        // verificar
//                         Iterator<Proprietario> iterator2 = listaDono.iterator();
//                            while (iterator2.hasNext()) {
//                                System.out.println(iterator2.next() + " ");
//                            }
//                        //
                        for (Proprietario dono : listaDono) {
                            if (dono.getCPF().equals(CPF) && (dono.getSenha().equals(senha))) {
                                permissão = true;
                                break;
                            }
                        }
                        if (permissão == true) {
                            System.out.println("Acesso AUTORIZADA");
                            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

                            while (!saida) {
                                System.out.println(" SE DESEJAR SAIR DO SISTEMA DIGITA <<(0)>>");
                                System.out.println(" O QUE O SENHOR DESEJAR FAZER DO SISTEMA ? ");
                                System.out.println(" (1)-- Cadastrar Funcionario");
                                System.out.println(" (2)-- Remover Funcionario");
                                System.out.println(" (3)-- Imprimir a lista dos Funcionarios");
                                opção = in.nextInt();
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                if (opção == 1) {
                                    OMEGA.cadastrarFuncionario();
                                } else if (opção == 2) {
                                    OMEGA.removerFuncionario();
                                } else if (opção == 3) {
                                    OMEGA.imprimirListaDosFuncionarios();
                                } else if (opção == 0) {
                                    saida = true;
                                }
                            }

                        } else {
                            System.err.println("Acesso NAO-AUTORIZADA");
                            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                        }
                    }

                } else if (n == 2) {
                    System.out.println("inicializando A MONITORAÇÃO do sistema");
                    System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    System.out.println("IDENTIFIQUE-SE");
                    System.out.println("DIGITE SEU CPF");
                    CPF = in.next();
                    System.out.println("DIGITE A SUA SENHA");
                    senha = in.next();
                    System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                     Iterator<Funcionario> iterator2 = listaFuncionarios.iterator();
//                            while (iterator2.hasNext()) {
//                                System.out.println(iterator2.next() + " ");
//                            }
//                    
                    for (Funcionario Funcionarios : listaFuncionarios) {
                        if (Funcionarios.getCPF().equals(CPF) && (Funcionarios.getSenha().equals(senha))) {
                            cargo = Funcionarios.getCargo();
                            if ("Proprietario".equals(cargo)){
                                 usuario1 = (Proprietario)Funcionarios;
                            }else if ("Gerente".equals(cargo)){
                                 usuario2 = (Gerente)Funcionarios;
                            }else if ("Cozinheiro".equals(cargo)){
                                 usuario3 = (Cozinheiro)Funcionarios;
                            }else if ("Garçon".equals(cargo)){
                                 usuario4 = (Garçon)Funcionarios;
                            }
                            permissão = true;
                            break;
                        }
                    }
                    if (permissão == true) {
                        System.out.println("Acesso AUTORIZADA");
                        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                        if ("Proprietario".equals(cargo)) {
                            while (!saida) {
                               
                                System.out.println(" SE DESEJAR SAIR DO SISTEMA DIGITA <<(0)>>");
                                System.out.println("  O QUE O SENHOR DESEJAR Fazer DO SISTEMA ? ");
                                System.out.println(" (1)-- Cadastrar Prato");
                                System.out.println(" (2)-- Remover Prato");
                                System.out.println(" (3)-- Cadastrar Bebida");
                                System.out.println(" (4)-- Remover Bebida");
                                System.out.println(" (5)-- Efectuar Pagamento");
                                System.out.println(" (6)-- Devolver Troco");
                                System.out.println(" (7)-- Pagar Salario Mensuais");
                                System.out.println(" (8)-- Pagar As Compras");
                                System.out.println(" (9)-- Pagar As Manutensões");
                                System.out.println(" (10)--Imprimir Cardapio");
                                opção = in.nextInt();
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                                for (Proprietario dono : listaDono) { }
                                    System.out.println("juste un teste/n");
                                    if (opção == 1) {
                                        OMEGA.cadastrarPrato();
                                    } else if (opção == 2) {
                                        OMEGA.removerPrato();
                                    } else if (opção == 3) {
                                        OMEGA.cadastrarBebidas();
                                    } else if (opção == 4) {
                                        OMEGA.removerBebidas();
                                    } else if (opção == 5) {
                                        System.out.println("DIGITE O VALOR");
                                       usuario1.efectuarPagamento(in.nextFloat());
                                    } else if (opção == 6) {
                                        System.out.println("DIGITE O VALOR");
                                       usuario1.devolverTroco(in.nextFloat());
                                    } else if (opção == 7) {
                                        usuario1.pagarSalarioMensuais((TreeSet<Funcionario>) listaFuncionarios);
                                    } else if (opção == 8) {
                                        System.out.println("DIGITE O VALOR");
                                        usuario1.pagarAsCompras(in.nextFloat());
                                    } else if (opção == 9) {
                                        System.out.println("DIGITE O VALOR");
                                        usuario1.pagarAsManutenções(in.nextFloat());
                                    } else if (opção == 10) {
                                        OMEGA.imprimirCadarpio();
                                    } else if (opção == 0) {
                                        saida = true;
                                        try {
                                            OMEGA.geraArquivoCardapio();
                                        } catch (Exception e) {
                                            System.out.println("ERRO AO SALVAR ARQUIVO !");
                                        }
                                    }
                               
                            }

                        } else if ("Gerente".equals(cargo)) {
                            while (!saida) {
                                System.out.println(" SE DESEJAR SAIR DO SISTEMA DIGITA-(0)");
                                System.out.println("  O QUE O SENHOR DESEJAR Fazer DO SISTEMA ? ");
                                System.out.println(" (1)-- Cadastrar Prato");
                                System.out.println(" (2)-- Remover Prato");
                                System.out.println(" (3)-- Cadastrar Bebida");
                                System.out.println(" (4)-- Romover Bebida");
                                System.out.println(" (5)-- Efectuar Pagamento");
                                System.out.println(" (6)-- Devolver Troco");
                                System.out.println(" (7)--Imprimir Cardapio");
                                opção = in.nextInt();
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                                for (Gerente gerente : listaGerente) {}
//                                    if (gerente.getCPF().equals(CPF) && (gerente.getSenha().equals(senha))) {}
                                        if (opção == 1) {
                                            OMEGA.cadastrarPrato();
                                        } else if (opção == 2) {
                                            OMEGA.removerPrato();
                                        } else if (opção == 3) {
                                            OMEGA.cadastrarBebidas();
                                        } else if (opção == 4) {
                                            OMEGA.removerBebidas();
                                        } else if (opção == 5) {
                                            System.out.println("DIGITE O VALOR");
                                            usuario2.efectuarPagamento(listaDono, in.nextFloat());
                                        } else if (opção == 6) {
                                            System.out.println("DIGITE O VALOR");
                                            usuario2.devolverTroco(listaDono, in.nextFloat());
                                        } else if (opção == 7) {
                                            OMEGA.imprimirCadarpio();
                                        } else if (opção == 0) {
                                            saida = true;
                                            try {
                                                OMEGA.geraArquivoCardapio();
                                            } catch (Exception e) {
                                                 System.out.println("ERRO AO SALVAR ARQUIVO !");
                                            }
                                        }
//                                        break;
                                    
                                
                            }

                        } else if ("Cozinheiro".equals(cargo)) {
                            while (!saida) {
                                System.out.println(" SE DESEJAR SAIR DO SISTEMA DIGITA-(0)");
                                System.out.println("  O QUE O SENHOR DESEJAR Fazer DO SISTEMA ? ");
                                System.out.println(" (1)-- Cadastrar Prato");
                                System.out.println(" (2)-- Remover Prato");
                                System.out.println(" (3)-- Cadastrar Bebida");
                                System.out.println(" (4)-- Romover Bebida");
                                System.out.println(" (5)-- Imprimir Cardapio");
                                opção = in.nextInt();
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                                for (Cozinheiro cozinheiros : listaCozinheiro) { }
//                                    if (cozinheiros.getCPF().equals(CPF) && (cozinheiros.getSenha().equals(senha))) {  }
                                        if (opção == 1) {
                                            OMEGA.cadastrarPrato();
                                        } else if (opção == 2) {
                                            OMEGA.removerPrato();
                                        } else if (opção == 3) {
                                            OMEGA.cadastrarBebidas();
                                        } else if (opção == 4) {
                                            OMEGA.removerBebidas();
                                        } else if (opção == 5) {
                                            OMEGA.imprimirCadarpio();
                                        } else if (opção == 0) {
                                            saida = true;
                                            try {
                                                OMEGA.geraArquivoCardapio();
                                            } catch (Exception e) {
                                                System.out.println("ERRO AO SALVAR ARQUIVO !");
                                            }
                                        }
//                                        break;
                                  
                               

                            }
                        } else if ("Garçon".equals(cargo)) {
                            while (!saida) {
                                System.out.println(" SE DESEJAR SAIR DO SISTEMA DIGITA-(0)");
                                System.out.println("  O QUE O SENHOR DESEJAR Fazer DO SISTEMA ? ");
                                System.out.println(" (1)-- Cadastrar Prato");
                                System.out.println(" (2)-- Remover Prato");
                                System.out.println(" (3)-- Cadastrar Bebida");
                                System.out.println(" (4)-- Romover Bebida");
                                System.out.println(" (5)-- Efectuar Pagamento");
                                System.out.println(" (6)-- Devolver Troco");
                                System.out.println(" (7)--Imprimir Cardapio");
                                opção = in.nextInt();
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                                System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
//                                for (Garçon garçon : listaGarçon) {
//                                    if (garçon.getCPF().equals(CPF) && (garçon.getSenha().equals(senha))) {
                                        if (opção == 1) {
                                            OMEGA.cadastrarPrato();
                                        } else if (opção == 2) {
                                            OMEGA.removerPrato();
                                        } else if (opção == 3) {
                                            OMEGA.cadastrarBebidas();
                                        } else if (opção == 4) {
                                            OMEGA.removerBebidas();
                                        } else if (opção == 5) {
                                            System.out.println("DIGITE O VALOR");
                                            usuario4.efectuarPagamento(listaDono, in.nextFloat());
                                        } else if (opção == 6) {
                                            System.out.println("DIGITE O VALOR");
                                            usuario4.devolverTroco(listaDono, in.nextFloat());
                                        } else if (opção == 7) {
                                            OMEGA.imprimirCadarpio();
                                        } else if (opção == 0) {
                                            saida = true;
                                            try {
                                                OMEGA.geraArquivoCardapio();
                                            } catch (Exception e) {
                                               System.out.println("ERRO AO SALVAR ARQUIVO !");
                                            }
                                        }
//                                        break;
//                                    }
//                                }
                            }

                        }
                        permissão = false;
                    } else {
                        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                        System.err.println("Acesso NAO-AUTORIZADA");
                        System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

                    }

                }
            }
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.println("SE DESEJAR PARAR O PROGRAMA DIGITA << 0 >> CASO CONTRARIO DIGITE << 9 >>");
            if (in.nextInt() == 0) {
                pararOprograma = true;
            }
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            System.out.printf("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        } while (!pararOprograma);

    }

}
