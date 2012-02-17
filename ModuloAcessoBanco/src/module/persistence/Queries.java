/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import module.model.Termo;

/**
 *
 * @author carlito
 */
public class Queries {

    /** Método que busca todas as palavras no banco.

     * @return HashMap -
     * Onde a chave (String) consiste em 'palavra-tipo'.
     * Exemplo: 'viajarei-verbo'.
     */
    public HashMap<String, Termo> selectAll() {
        HashMap<String, Termo> termos = new HashMap<String, Termo>();
        Termo termo;
        try {
            PreparedStatement stmt = FabricaConexao.getConexao().
                    prepareStatement("select "
                    + "	palavra.palavra, "
                    + "	palavra.positivo, "
                    + "	palavra.negativo, "
                    + "	tipo.tipo "
                    + "from tcc.palavra "
                    + "	join tcc.tipo on "
                    + "	palavra.fk_tipo = tipo.cod_tipo;");
            stmt.execute();

            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                termo = new Termo();
                termo.setPalavra(result.getString("palavra"));
                termo.setPositivo(result.getDouble("positivo"));
                termo.setNegativo(result.getDouble("negativo"));
                termo.setTipo(result.getString("tipo"));
                termos.put(termo.getPalavra() + "-" + termo.getTipo(), termo);
                termo = null;
            }

            stmt.close();
            result.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return termos;
        }
        return termos;
    }
}
