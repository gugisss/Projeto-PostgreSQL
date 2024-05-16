package projetoPostgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static Connection conexao;

    public static void main(String[] args) {
        conexao = Conexao.getConexao();
        if (conexao != null) {
            processUserInput();
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("Bem-vindo à Sakura Sushi Bar");
        System.out.println("1. Socios");
        System.out.println("2. Gerente ");
        System.out.println("3. Garçom");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void showMenuSocio() {
        System.out.println("1. Gerente");
        System.out.println("2. Garçom");
        System.out.println("3. Pratos");
        System.out.println("4. Pedidos");
        System.out.println("5. Clientes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void showMenuGerente() {
        System.out.println("1. Garçom");
        System.out.println("2. Pratos");
        System.out.println("3. Pedidos");
        System.out.println("4. Clientes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (authenticateUser(scanner, "socios")) {
                        processSocioInput(scanner);
                    }
                    break;
                case 2:
                	if (authenticateUser(scanner, "gerentes")) {
                        processGerenteInput(scanner);
                    }
                    break;
                case 3:
                    // Implementar lógica para Garçom
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);

        scanner.close();
        closeConnection();
    }

    private static boolean authenticateUser(Scanner scanner, String tableName) {
        System.out.println("Digite seu usuario");
        String usuario = scanner.next();
        System.out.println("Digite sua senha");
        String senha = scanner.next();

        String sql = "SELECT * FROM " + tableName + " WHERE senha = ? AND usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, senha);
            stmt.setString(2, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Seja bem-vindo");
                    return true;
                } else {
                    System.out.println("Usuário ou senha incorretos");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void processSocioInput(Scanner scanner) {
        int option;
        do {
            showMenuSocio();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("1. Adicionar garçom");
                    System.out.println("2. Excluir garçom");
                    System.out.println("3. Atualizar garçom");
                    break;
                case 2:
                    System.out.println("1. Adicionar prato");
                    System.out.println("2. Excluir prato");
                    System.out.println("3. Atualizar prato");
                    break;
                case 3:
                    System.out.println("1. Adicionar pedido");
                    System.out.println("2. Excluir pedido");
                    System.out.println("3. Atualizar pedido");
                    break;
                case 4:
                    System.out.println("1. Adicionar cliente");
                    System.out.println("2. Excluir cliente");
                    System.out.println("3. Atualizar cliente");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }
    
    private static void processGerenteInput(Scanner scanner) {
        int option;
        do {
            showMenuGerente();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("1. Adicionar gerente");
                    System.out.println("2. Excluir gerente");
                    System.out.println("3. Atualizar gerente");
                    break;
                case 2:
                    System.out.println("1. Adicionar garçom");
                    System.out.println("2. Excluir garçom");
                    System.out.println("3. Atualizar garçom");
                    break;
                case 3:
                    System.out.println("1. Adicionar prato");
                    System.out.println("2. Excluir prato");
                    System.out.println("3. Atualizar prato");
                    break;
                case 4:
                    System.out.println("1. Adicionar pedido");
                    System.out.println("2. Excluir pedido");
                    System.out.println("3. Atualizar pedido");
                    break;
                case 5:
                    System.out.println("1. Adicionar cliente");
                    System.out.println("2. Excluir cliente");
                    System.out.println("3. Atualizar cliente");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private static void closeConnection() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão encerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
