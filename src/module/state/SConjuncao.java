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
class SConjuncao implements State, AppDefines {

    public SConjuncao(String palavra, StateContext parent) {
        processa(palavra, parent);
    }

    @Override
    public void processa(String palavra, StateContext parent) {
        System.out.println("Processando conjunção...");
    }

    @Override
    public State novoEstado(Token token, StateContext parent) {
        switch (token.getTipo()) {
            case Adjetivo:
                return new SAdjetivo(token.getPalavra(), parent);
            case Substantivo:
                return new SSubstantivo(token.getPalavra(), parent);
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }
}
