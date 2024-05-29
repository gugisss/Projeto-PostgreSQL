package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionarCliente(String nome, String email) {
        String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listarClientes() {
        String sql = "SELECT * FROM clientes";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void atualizarCliente(int id, String nome, String email) {
        String sql = "UPDATE clientes SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
