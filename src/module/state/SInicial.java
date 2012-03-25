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
public class SInicial implements State, AppDefines{

    public SInicial(){
        processa("", null);
    }

    @Override
    public void processa(String palavra, StateContext parent) {
        System.out.println("Estado inicial...");
    }

    @Override
    public State novoEstado(Token token, StateContext parent) {
        switch (token.getTipo()) {
            case Substantivo:
                return new SSubstantivo(token.getPalavra(), parent);
            case Adverbio:
                return new SAdverbio(token.getPalavra(), parent);
            case Verbo:
                return new SVerbo(token.getPalavra(), parent);
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }

}
