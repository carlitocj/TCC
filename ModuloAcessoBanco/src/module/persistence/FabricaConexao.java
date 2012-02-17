package module.persistence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlito
 */
class FabricaConexao {

    private static Connection Conexao;
    private static LeArquivoIni ArquivoIni = new LeArquivoIni();

    public static Connection getConexao() {
        if (Conexao == null) {
            try {
                Class.forName(ArquivoIni.getDriver());
                Conexao = DriverManager.getConnection(ArquivoIni.getUrl(),
                        ArquivoIni.getUsuario(), ArquivoIni.getSenha());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Conexao;
    }
}
