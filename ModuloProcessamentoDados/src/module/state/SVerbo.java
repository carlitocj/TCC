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
class SVerbo implements State, AppDefines {

    public SVerbo(String palavra) {
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
            case Adverbio:
                return new SAdverbio(termo.getPalavra());
            case Substantivo:
                return new SSubstantivo(termo.getPalavra());
            default:
                System.out.println("Estrutura incorreta.");
                return null;
        }
    }
}
