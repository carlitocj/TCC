import java.util.ArrayList;
import java.util.StringTokenizer;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CargaArquivo ca = new CargaArquivo();
		
		
		StringBuffer sbi = ca.getSb();
		ArrayList<String> listaTokens = new ArrayList<String>();
		
		StringTokenizer st = new StringTokenizer(sbi.toString()," ");
		String nextToken =  st.nextToken();
		while(nextToken!=null){
			listaTokens.add(nextToken);
			if(st.hasMoreTokens()){
				nextToken = st.nextToken();
			}else{
				break;
			}
		}
		
		for (String string : listaTokens) {
			System.out.println(string);
			if(string.contains("/CN")){
				
			}
		}

	}

}
