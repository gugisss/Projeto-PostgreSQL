package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class GerenteDAO {
    private Connection conexao;

    public GerenteDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionarGerente(String usuario, String senha) {
        String sql = "INSERT INTO gerentes (usuario, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirGerente(int id) {
        String sql = "DELETE FROM gerentes WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String usuario, String senha) {
        String sql = "SELECT * FROM gerentes WHERE usuario = ? AND senha = ?";
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
    
    public void atualizarGerente(int id, String usuario, String senha) {
        String sql = "UPDATE gerentes SET usuario = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Gerente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
