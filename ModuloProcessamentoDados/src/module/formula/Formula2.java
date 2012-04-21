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
public class Formula2 {

    public Formula2(List<Termo> termos) {
        calculaTermos(termos);
    }

    private void calculaTermos(List<Termo> termos) {
        double score = 0;
        double sum = 0;
        for (int i = 0; i < termos.size(); i++) {
            score += (1 * (termos.get(i).getPositivo() - termos.get(i).getNegativo())) / (i + 1);
            sum += 1 / (i + 1);
        }
        calculaMediaFinal(score, sum);
    }

    private void calculaMediaFinal(double score, double sum) {
        double mediaFinal = score / sum;
        System.out.println("Score Formula 2: " + mediaFinal);
    }
}
