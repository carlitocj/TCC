import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CargaArquivo {

	private static String CAMINHO = "/home/romulo/git/TCC/TesteSH/Postagger/";
	private StringBuffer sb;

	public CargaArquivo() {

		File f = new File(CAMINHO + "output.txt");
		
		setSb(new StringBuffer());

		FileReader fr = null;
		try {
			fr = new FileReader(f);

			BufferedReader br = new BufferedReader(fr);
			String readLine = br.readLine();
			while (readLine != null && !readLine.isEmpty()) {
				getSb().append(readLine);
				readLine = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}

}
