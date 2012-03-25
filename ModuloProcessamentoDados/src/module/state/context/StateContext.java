/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.state.context;

import java.util.List;
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
    private double score;
    private int qtdScore;
    private List<Token> tokens;

    public StateContext(List<Token> tokens) {
        System.out.println("Iniciando máquina de estados...");
        score = 0;
        qtdScore = 0;
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
        System.out.println("Processo concluído.");
        System.out.println("Pontuação da frase: " + calculaScoreFrase());
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

    public void setScore(double score) {
        System.out.println("Score: " + score);
        this.score = +score;
        qtdScore++;
    }

    private double calculaScoreFrase() {
        return score / qtdScore;
    }
}
