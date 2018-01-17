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
public class ClienteVIP extends Cliente {
    String nome;
    int redução;
    int senhaVip;
    static int numeroDeClienteVip;
    
   
    ClienteVIP(String name, int redução , int senha){
        this.nome = name;
        this.redução = redução;
        this.senhaVip = senha;
        ClienteVIP.numeroDeClienteVip = ClienteVIP.numeroDeClienteVip + 1;
    }
    
}
