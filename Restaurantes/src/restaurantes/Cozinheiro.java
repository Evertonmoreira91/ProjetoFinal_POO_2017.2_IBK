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
public class Cozinheiro extends Funcionario {

    @Override
    public boolean autentica(int password) {
        
        return false;
    }

    @Override
    public void cadastrarPrato() {
       
    }

    @Override
    public void cadastrarBebida() {
        
    }
    
    
}
