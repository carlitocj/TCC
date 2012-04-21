/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state.context;

import java.util.ArrayList;
import java.util.List;
import module.formula.Formula1;
import module.formula.Formula2;
import module.model.Termo;
import module.model.Token;
import module.parser.ControlePrincipal;
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
    private List<Termo> termos;

    public StateContext(List<Token> tokens) {
        termos = new ArrayList<Termo>();
        System.out.println("Iniciando máquina de estados...");
        this.tokens = tokens;
        estadoAtual = new SInicial();
        iterator();
    }

    private void iterator() {
        for (Token termo : tokens) {
            if (!setState(termo)) {
                return;
            }
        }
        System.out.println("Calculando pontuação...");
        calculaScoreFrase();
    }

    public boolean setState(Token token) {
        estadoAnterior = estadoAtual;
        estadoAtual = estadoAtual.novoEstado(token, this);
        if (estadoAtual == null) {
            return false;
        }
        return true;
    }

    public Termo getScoreWord(String key) {
        return ControlePrincipal.getMapPalavras().get(key);
    }

    public void setScore(Termo termo) {
        termos.add(termo);
    }

    private void calculaScoreFrase() {
        new Formula1(termos);
        new Formula2(termos);
    }
}
