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
public interface FuncionamentoExterno {

    public void efectuarPagamento(float valor);

    public void devolverTroco(float valor);
}
