/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state;

import module.define.AppDefines;
import module.model.Token;

/**
 *
 * @author carlito
 */
class SAdverbio implements State, AppDefines {

    public SAdverbio(String palavra) {
        processa(palavra);
    }

    @Override
    public void processa(String palavra) {
        System.out.println("Processando advérbio...");
    }

    @Override
    public State novoEstado(Token termo) {
        switch (termo.getTipo()) {
            case Verbo:
                return new SVerbo(termo.getPalavra());
            case Adjetivo:
                return new SAdjetivo(termo.getPalavra());
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }
}
