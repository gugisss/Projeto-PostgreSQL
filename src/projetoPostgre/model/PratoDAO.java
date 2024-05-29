package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class PratoDAO {
    private Connection conexao;

    public PratoDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionarPrato(String nome, double preco) {
        String sql = "INSERT INTO pratos (nome, preco) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPrato(int id) {
        String sql = "DELETE FROM pratos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listarPratos() {
        String sql = "SELECT * FROM pratos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void atualizarPrecoPrato(int id, double novoPreco) {
        String sql = "UPDATE pratos SET preco = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Preço do prato atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
