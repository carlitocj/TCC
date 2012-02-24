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
public class SInicial implements State, AppDefines{

    public SInicial(){
        processa("");
    }

    public void processa(String palavra) {
    }

    public State novoEstado(Termo termo) {
        switch (termo.getTipo()) {
            case Substantivo:
                return new SSubstantivo(termo.getPalavra());
            case Adverbio:
                return new SAdverbio(termo.getPalavra());
            case Verbo:
                return new SVerbo(termo.getPalavra());
            default:
                System.out.println("Estrutura incorreta.");
                return null;
        }
    }

}
