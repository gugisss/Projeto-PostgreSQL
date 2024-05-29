package projetoPostgre.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projetoPostgre.Conexao;

public class SocioDAO {
    private Connection conexao;

    public SocioDAO() {
        this.conexao = Conexao.getConexao();
    }

    public boolean authenticate(String usuario, String senha) {
        String sql = "SELECT * FROM socios WHERE usuario = ? AND senha = ?";
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

    // Aqui você pode adicionar métodos para outras operações relacionadas aos sócios, como adicionar, excluir, atualizar, etc.
}
