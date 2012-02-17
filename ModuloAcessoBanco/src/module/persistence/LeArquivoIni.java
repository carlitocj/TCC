package module.persistence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author carlito
 */
class LeArquivoIni {

    private String driver;
    private String url;
    private String usuario;
    private String senha;

    public LeArquivoIni() {
        leArquivoBD();
    }

    private void leArquivoBD() {
        String[] parametros = null;
        String linha = null;
        try {
            FileReader bdFile = new FileReader("config/bd.ini");
            BufferedReader bdFileReader = new BufferedReader(bdFile);

            while ((linha = bdFileReader.readLine()) != null) {
                parametros = null;
                parametros = linha.split("=");

                if (parametros[0].equals("driver")) {
                    setDriver(parametros[1]);
                } else {
                    if (parametros[0].equals("url")) {
                        setUrl(parametros[1]);
                    } else {
                        if (parametros[0].equals("usuario")) {
                            setUsuario(parametros[1]);
                        } else {
                            if (parametros[0].equals("senha")) {
                                setSenha(parametros[1]);
                            }
                        }
                    }
                }
            }
            bdFile.close();
            bdFileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String Driver) {
        this.driver = Driver;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String Url) {
        this.url = Url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }
}
