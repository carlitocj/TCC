/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.context;

import java.util.List;
import module.model.Termo;
import module.state.SInicial;
import module.state.State;

/**
 *
 * @author carlito
 */
public class StateContext {

    private State estadoAtual;
    private State estadoAnterior;
    private List<Termo> tokens;

    public StateContext(List<Termo> tokens) {
        this.tokens = tokens;
        estadoAtual = new SInicial();
        iterator();
    }

    private void iterator() {
        for (Termo termo : tokens) {
            setState(termo);
        }
    }

    public void setState(Termo termo) {
        estadoAnterior = estadoAtual;
        estadoAtual = estadoAtual.novoEstado(termo);
    }
}
