/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package module.state;

import module.model.Termo;

/**
 *
 * @author carlito
 */
class SConjuncao implements State{

    public SConjuncao(String palavra){
        processa(palavra);
    }

    @Override
    public void processa(String palavra) {
    }

    @Override
    public State novoEstado(Termo termo) {
        switch (termo.getTipo()) {
            default:
                System.out.println("Estrutura incorreta.");
                return null;
        }
    }

}
