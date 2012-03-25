/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state;

import module.define.AppDefines;
import module.model.Token;
import module.state.context.StateContext;

/**
 *
 * @author carlito
 */
class SSubstantivo implements State, AppDefines {

    public SSubstantivo(String palavra, StateContext parent) {
        processa(palavra, parent);
    }

    @Override
    public void processa(String palavra, StateContext parent) {
        System.out.println("Processando substantivo...");
    }

    @Override
    public State novoEstado(Token token, StateContext parent) {
        switch (token.getTipo()) {
            case Verbo:
                return new SVerbo(token.getPalavra(), parent);
            case Adverbio:
                return new SAdverbio(token.getPalavra(), parent);
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }
}
