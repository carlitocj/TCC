import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConsultaBaseDeDados {
	
	public static void main(String[] args) {
		getAvaliacao("abafais");
	}
	
	public static void getAvaliacao(String palavra){
		Connection conexao = getConexao();
		
		 try {
			Statement stm = conexao.createStatement();
			String SQL = "select * from tcc.palavra where palavra like '"+palavra+"'";
			ResultSet rs = stm.executeQuery(SQL);  
			while(rs.next())  
			   {  
			      String codigo = rs.getString("cod_palavra");  
//			      String aut = rs.getString("fk_tipo");  
			      float notaPos = rs.getFloat("positivo");
			      float notaNeg = rs.getFloat("negativo");
			  
			      System.out.println("Codigo: "+codigo+" Pos: "+notaPos+" Neg: "+notaNeg);  
			   }  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	     
	}
	
	
	
	
	
	private static Connection getConexao()  { // metodo de conexÃ£o do banco de dados e de exceÃ§Ã£o  
		try {  
			Class.forName("org.postgresql.Driver");  
			System.out.println("Conectando ao Banco Postgres"); // mostra quando estiver conectando  
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");// Retor na o endereÃ§o do servidor de banco de dados  
		} catch (ClassNotFoundException | SQLException e) {  
			e.printStackTrace();
		}  
		return null;
	}

}
