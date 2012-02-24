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
class SAdjetivo implements State, AppDefines {

    public SAdjetivo(String palavra) {
        processa(palavra);
    }

    @Override
    public void processa(String palavra) {
        System.out.println("Processando adjetivo...");
    }

    @Override
    public State novoEstado(Token termo) {
        switch (termo.getTipo()) {
            case Adjetivo:
                return new SAdjetivo(termo.getPalavra());
            case Conjuncao:
                return new SConjuncao(termo.getPalavra());
            default:
                System.out.println("FRASE COM ESTRUTURA INCORRETA.");
                return null;
        }
    }
}
