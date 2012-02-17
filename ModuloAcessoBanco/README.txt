Adicionar o .jar do ModuloAcessoBanco ao classpath do projeto.

O diretório config com o arquivo bd.ini, onde se encontram as
configurações do banco de dados, deve ficar na raiz do
projeto principal.

Exemplo de utilização:

HashMap<String, Termo> mapTermos = null;
Queries query = new Queries();
mapTermos = query.selectAll();
