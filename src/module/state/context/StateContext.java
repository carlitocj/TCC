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
        score = 0;
        qtdScore = 0;
        this.tokens = tokens;
        estadoAtual = new SInicial();
        iterator();
    }

    private void iterator() {
        for (Token termo : tokens) {
            setState(termo);
        }
        System.out.println("Processo concluído.");
        System.out.println("Pontuação da frase: " + calculaScoreFrase());
    }

    public void setState(Token token) {
        estadoAnterior = estadoAtual;
        estadoAtual = estadoAtual.novoEstado(token, this);
        if (estadoAtual == null) {
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }

    public Termo getScoreWord(String key) {
        return ControlePrincipal.getMapPalavras().get(key);
    }

    public void setScore(double score) {
        System.out.println(score);
        this.score =+ score;
        qtdScore++;
    }

    private double calculaScoreFrase() {
        return score / qtdScore;
    }
}
