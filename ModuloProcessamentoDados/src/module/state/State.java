/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state;

import module.model.Token;

/**
 *
 * @author carlito
 */
public interface State {

    public void processa(String palavra);

    public State novoEstado(Token termo);
}