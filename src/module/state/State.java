/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state;

import module.model.Token;
import module.state.context.StateContext;

/**
 *
 * @author carlito
 */
public interface State {

    public void processa(String palavra, StateContext parent);

    public State novoEstado(Token token, StateContext parent);
}
