/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state.context;

import java.util.List;
import module.model.Token;
import module.state.SInicial;
import module.state.State;

/**
 *
 * @author carlito
 */
public class StateContext {

    private State estadoAtual;
    private State estadoAnterior;
    private List<Token> tokens;

    public StateContext(List<Token> tokens) {
        this.tokens = tokens;
        estadoAtual = new SInicial();
        iterator();
    }

    private void iterator() {
        for (Token termo : tokens) {
            setState(termo);
        }
        System.out.println("Processo concluído.");
    }

    public void setState(Token termo) {
        estadoAnterior = estadoAtual;
        estadoAtual = estadoAtual.novoEstado(termo);
        if(estadoAtual==null){
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }
}
