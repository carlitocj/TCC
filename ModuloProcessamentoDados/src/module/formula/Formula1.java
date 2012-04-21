/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.formula;

import java.util.List;
import module.model.Termo;

/**
 *
 * @author carlito
 */
public class Formula1 {

    private double score = 0;
    private int countTermos = 0;

    public Formula1(List<Termo> termos) {
        for (Termo termo : termos) {
            calculaTermo(termo);
        }
        calculaMediaFinal();
    }

    private void calculaTermo(Termo termo) {
        countTermos++;
        score += (termo.getPositivo() - termo.getNegativo());
    }

    private void calculaMediaFinal() {
        double mediaFinal = score / countTermos;
        System.out.println("Score Formula 1: " + mediaFinal);
    }
}
