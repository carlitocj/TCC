package module.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AcessoArquivoFonte {

    private final String CAMINHO = System.getProperty("user.home")+"/POSTagger/";

    public String lerArquivoSaida() {
        File f = new File(CAMINHO + "output.txt");

        StringBuilder sb = new StringBuilder();

        FileReader fr = null;
        try {
            fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);
            String readLine = br.readLine();
            while (readLine != null && !readLine.isEmpty()) {
                sb.append(readLine);
                readLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void escreverArquivoEntrada(String conteudo) {
        File fArquivo = new File(CAMINHO + "input.txt");

        try {
            FileWriter fwArquivo = null;
            fwArquivo = new FileWriter(fArquivo, false);
            BufferedWriter bw = new BufferedWriter(fwArquivo);
            bw.write(conteudo + "\n");
            bw.close();
            fwArquivo.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
