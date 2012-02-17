package module.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carlito
 */
public class Termo {

    private String palavra;
    private String tipo;
    private double positivo;
    private double negativo;

    public Termo() {
        setPalavra("");
        setTipo("");
        setPositivo(0);
        setNegativo(0);
    }

    public double getNegativo() {
        return negativo;
    }

    public void setNegativo(double nagativo) {
        this.negativo = nagativo;
    }

    public double getPositivo() {
        return positivo;
    }

    public void setPositivo(double positivo) {
        this.positivo = positivo;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
