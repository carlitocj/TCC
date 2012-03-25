/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.main;

import module.parser.ControlePrincipal;

/**
 *
 * @author carlito
 */
public class Main {

    public static void main(String[] args) {
        for (String frase : args) {
            new ControlePrincipal(frase);
        }
    }
}
