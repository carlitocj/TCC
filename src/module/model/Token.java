/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.model;

/**
 *
 * @author carlito
 */
public class Token {

    private String palavra;
    private short tipo;

    public Token() {
        setPalavra("");
        setTipo((short) -1);
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }
}
