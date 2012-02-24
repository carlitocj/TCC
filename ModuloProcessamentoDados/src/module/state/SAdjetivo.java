/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package module.state;

import module.define.AppDefines;
import module.model.Termo;

/**
 *
 * @author carlito
 */
class SAdjetivo implements State, AppDefines{

    public SAdjetivo(String palavra){
        processa(palavra);
    }

    @Override
    public void processa(String palavra) {
    }

    @Override
    public State novoEstado(Termo termo) {
        switch (termo.getTipo()) {
            case Adjetivo:
                return new SAdjetivo(termo.getPalavra());
            default:
                System.out.println("Estrutura incorreta.");
                return null;
        }
    }

}
