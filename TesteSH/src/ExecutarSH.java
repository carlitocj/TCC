import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JOptionPane;

public class ExecutarSH {

	private static String CAMINHO = "/home/romulo/git/TCC/TesteSH/Postagger/";

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "cat " + CAMINHO
				+ "input.txt | " + CAMINHO + "run-Tagger.sh > " + CAMINHO
				+ "output.txt");
		try {
			Process processo = pb.start();
			int waitFor = processo.waitFor();
			System.out.println(waitFor);
			String is = converterStreamParaString(processo.getInputStream());
			System.out.println(is);
			mostrarResultado();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void mostrarResultado() {
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "cat " + CAMINHO
				+ "output.txt");
		try {
			Process processo = pb.start();
			int waitFor = processo.waitFor();
			System.out.println(waitFor);
			String is = converterStreamParaString(processo.getInputStream());
			System.out.println(is);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String converterStreamParaString(InputStream is)
			throws IOException {

		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
}
