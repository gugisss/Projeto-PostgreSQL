package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class GarcomDAO {
    private Connection conexao;

    public GarcomDAO() {
        this.conexao = Conexao.getConexao();
    }
    public boolean authenticate(String usuario, String senha) {
        String sql = "SELECT * FROM garcons WHERE usuario = ? AND senha = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void adicionarGarcom(String usuario, String senha) {
        String sql = "INSERT INTO garcons (usuario, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirGarcom(int id) {
        String sql = "DELETE FROM garcons WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarGarcom(int id, String usuario, String senha) {
        String sql = "UPDATE garcons SET usuario = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Garçom atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
