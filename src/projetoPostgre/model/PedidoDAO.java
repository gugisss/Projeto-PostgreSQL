package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class PedidoDAO {
    private Connection conexao;

    public PedidoDAO() {
        this.conexao = Conexao.getConexao();
    }
    public void adicionarPedido(int clienteId, int pratoId) {
        String sql = "INSERT INTO pedidos (cliente_id, prato_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            stmt.setInt(2, pratoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPedido(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listarPedidos() {
        String sql = "SELECT * FROM pedidos";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void atualizarDescricaoPedido(int id, String novaDescricao) {
        String sql = "UPDATE pedidos SET descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novaDescricao);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Descrição do pedido atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
