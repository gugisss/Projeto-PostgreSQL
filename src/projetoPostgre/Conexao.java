package projetoPostgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/Sakura Sushi Bar";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1902";
    private static Connection conexao = null;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                // Carrega o driver JDBC do PostgreSQL
                Class.forName("org.postgresql.Driver");
                // Estabelece a conexão
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
//                System.out.println("Conexão estabelecida com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Falha ao estabelecer a conexão.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Driver JDBC não encontrado.");
            	}
        	}
        	return conexao;
    	}
        
        
        public int executaSQL(String sql) {
        	try {
        		Statement stm = conexao.createStatement();
        		int res = stm.executeUpdate(sql);
        		conexao.close();
        		return res;
        	} catch (SQLException e) {        	
        		return 0;
        	}
        }
        
        public ResultSet executaBusca(String sql) {
        	try {
        		Statement stm = conexao.createStatement();
        		ResultSet rs = stm.executeQuery(sql);
        		conexao.close();
        		return rs;
        	}catch(Exception e) {
        		e.printStackTrace();
        		return null;
        	}
        }
        
    }

