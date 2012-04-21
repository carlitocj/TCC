/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state;

import module.define.AppDefines;
import module.model.Termo;
import module.model.Token;
import module.state.context.StateContext;

/**
 *
 * @author carlito
 */
class SVerbo implements State, AppDefines {

    public SVerbo(String palavra, StateContext parent) {
        processa(palavra, parent);
    }

    @Override
    public void processa(String palavra, StateContext parent) {
        System.out.println("Processando verbo...");
        Termo termo = null;
        termo=parent.getScoreWord(palavra+"-verbo");
        if(termo!=null){
            parent.setScore(termo);
        }
    }

    @Override
    public State novoEstado(Token token, StateContext parent) {
        switch (token.getTipo()) {
            case Adjetivo:
                return new SAdjetivo(token.getPalavra(), parent);
            case Adverbio:
                return new SAdverbio(token.getPalavra(), parent);
            case Substantivo:
                return new SSubstantivo(token.getPalavra(), parent);
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }
}
