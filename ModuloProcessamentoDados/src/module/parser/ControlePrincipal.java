/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import module.exec.ExecutarSH;
import module.file.AcessoArquivoFonte;
import module.model.Termo;
import module.persistence.Queries;

/**
 *
 * @author carlito
 */
public class ControlePrincipal {

    private ExecutarSH moduloRodaSh;
    private AcessoArquivoFonte moduloArquivoFonte;
    private Queries moduloAcessoBanco;
    private HashMap<String, Termo> mapPalavras;

    public ControlePrincipal(String textoEntrada) {
        moduloRodaSh = new ExecutarSH();
        moduloArquivoFonte = new AcessoArquivoFonte();
        moduloAcessoBanco = new Queries();
        controlaProcesso(textoEntrada);
    }

    private void controlaProcesso(String textoEntrada) {
        String textoSaida;

        carregaPalavrasBanco();
        escreveArquivo(textoEntrada);
        rodaSh();
        textoSaida = leArquivo();
        parser(textoSaida);
    }

    private void carregaPalavrasBanco() {
        if ((mapPalavras = moduloAcessoBanco.selectAll()) == null) {
            System.out.println("Erro ao buscar palavras do banco.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }

    private void escreveArquivo(String frase) {
        if (frase == null || frase.trim().isEmpty()) {
            System.out.println("Erro: texto nulo ou vazio a ser analisado.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
        moduloArquivoFonte.escreverArquivoEntrada("O computador é muito rápido.");
    }

    private void rodaSh() {
        if (!moduloRodaSh.rodarSH()) {
            System.out.println("Erro ao rodar script POSTagger.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }

    private String leArquivo() {
        String saida;
        saida = moduloArquivoFonte.lerArquivoSaida();
        if (saida == null || saida.trim().isEmpty()) {
            System.out.println("Erro ao ler arquivo de saída do POSTagger.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
        return saida;
    }

    private void parser(String texto) {
        StringBuilder sbi = new StringBuilder(texto);
        ArrayList<String> listaTokens = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(sbi.toString(), " ");
        while (st.hasMoreTokens()) {
            listaTokens.add(st.nextToken());
        }

        for (String string : listaTokens) {
            System.out.println(string);
        }
    }
}
