/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import module.state.context.StateContext;
import module.define.AppDefines;
import module.exec.ExecutarSH;
import module.file.AcessoArquivoFonte;
import module.model.Termo;
import module.model.Token;
import module.persistence.Queries;

/**
 *
 * @author carlito
 */
public class ControlePrincipal implements AppDefines {

    private static HashMap<String, Termo> mapPalavras;

    public ControlePrincipal(String[] frases) {
        controlaProcesso(frases);
    }

    private void controlaProcesso(String[] frases) {
        String textoSaida;

        carregaPalavrasBanco();
        for (String frase : frases) {
            System.out.println();
            System.out.println("###############################################");
            System.out.println("Frase: "+frase);
            escreveArquivo(frase);
            rodaSh();
            textoSaida = leArquivo();
            parser(textoSaida);
            System.out.println("###############################################");
            System.out.println();
        }
    }

    private void carregaPalavrasBanco() {
        Queries moduloAcessoBanco = new Queries();
        if ((mapPalavras = moduloAcessoBanco.selectAll()) == null) {
            System.out.println("Erro ao buscar palavras do banco.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }

    private void escreveArquivo(String frase) {
        AcessoArquivoFonte moduloArquivoFonte = new AcessoArquivoFonte();
        if (frase == null || frase.trim().isEmpty()) {
            System.out.println("Erro: texto nulo ou vazio a ser analisado.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
        moduloArquivoFonte.escreverArquivoEntrada(frase);
    }

    private void rodaSh() {
        ExecutarSH moduloRodaSh = new ExecutarSH();
        if (!moduloRodaSh.rodarSH()) {
            System.out.println("Erro ao rodar script POSTagger.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
    }

    private String leArquivo() {
        AcessoArquivoFonte moduloArquivoFonte = new AcessoArquivoFonte();
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
        ArrayList<Token> listaTokens = new ArrayList<Token>();

        StringTokenizer st = new StringTokenizer(sbi.toString(), " ");
        Token token;
        while (st.hasMoreTokens()) {
            if ((token = encapsulaToken(st.nextToken())) != null) {
                listaTokens.add(token);
            }
        }

        //instancia a máquina de estados para polarização da frase
        new StateContext(listaTokens);
    }

    private Token encapsulaToken(String token) {
        Token objToken = new Token();

        if (token.contains("/ADJ")) {
            objToken.setTipo(Adjetivo);
            objToken.setPalavra(token.replace("/ADJ", ""));
            return objToken;
        }
        if (token.contains("/ADV")) {
            objToken.setTipo(Adverbio);
            objToken.setPalavra(token.replace("/ADV", ""));
            return objToken;
        }
        if (token.contains("/CJ")) {
            objToken.setTipo(Conjuncao);
            objToken.setPalavra(token.replace("/CJ", ""));
            return objToken;
        }
        if (token.contains("/CN")) {
            objToken.setTipo(Substantivo);
            objToken.setPalavra(token.replace("/CN", ""));
            return objToken;
        }
        if (token.contains("/V")) {
            objToken.setTipo(Verbo);
            objToken.setPalavra(token.replace("/V", ""));
            return objToken;
        }

        return null;
    }

    public static HashMap<String, Termo> getMapPalavras() {
        return mapPalavras;
    }
}
