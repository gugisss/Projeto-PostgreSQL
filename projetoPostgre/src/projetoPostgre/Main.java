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
        System.out.println("1. Sócios");
        System.out.println("2. Gerente");
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
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void showMenuGerente() {
        System.out.println("1. Garçom");
        System.out.println("2. Pratos");
        System.out.println("3. Pedidos");
        System.out.println("4. Clientes");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void showMenuGarcom() {
        System.out.println("1. Pratos");
        System.out.println("2. Pedidos");
        System.out.println("3. Clientes");
        System.out.println("0. Voltar");
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
                    if (authenticateUser(scanner, "garcons")) {
                        processGarcomInput(scanner);
                    }
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
        System.out.println("Digite seu usuário:");
        String usuario = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        String sql = "SELECT * FROM " + tableName + " WHERE usuario = ? AND senha = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Seja bem-vindo!");
                    return true;
                } else {
                    System.out.println("Usuário ou senha incorretos.");
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
                	manageGerente(scanner);
                case 2:
                    manageGarcom(scanner);
                    break;
                case 3:
                    managePrato(scanner);
                    break;
                case 4:
                    managePedido(scanner);
                    break;
                case 5:
                    manageCliente(scanner);
                    break;
                case 0:
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
                    manageGarcom(scanner);
                    break;
                case 2:
                    managePrato(scanner);
                    break;
                case 3:
                    managePedido(scanner);
                    break;
                case 4:
                    manageCliente(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private static void processGarcomInput(Scanner scanner) {
        int option;
        do {
            showMenuGarcom();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    managePrato(scanner);
                    break;
                case 2:
                    managePedido(scanner);
                    break;
                case 3:
                    manageCliente(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private static void manageGarcom(Scanner scanner) {
        System.out.println("1. Adicionar garçom");
        System.out.println("2. Excluir garçom");
        System.out.println("0. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();
        
        switch (option) {
            case 1:
                adicionarGarcom(scanner);
                break;
            case 2:
                excluirGarcom(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private static void managePrato(Scanner scanner) {
        System.out.println("1. Adicionar prato");
        System.out.println("2. Excluir prato");
        System.out.println("0. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarPrato(scanner);
                break;
            case 2:
                excluirPrato(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private static void managePedido(Scanner scanner) {
        System.out.println("1. Adicionar pedido");
        System.out.println("2. Excluir pedido");
        System.out.println("0. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarPedido(scanner);
                break;
            case 2:
                excluirPedido(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private static void manageCliente(Scanner scanner) {
        System.out.println("1. Adicionar cliente");
        System.out.println("2. Excluir cliente");
        System.out.println("0. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarCliente(scanner);
                break;
            case 2:
                excluirCliente(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private static void adicionarGarcom(Scanner scanner) {
        System.out.println("Digite o usuário do garçom:");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do garçom:");
        String senha = scanner.nextLine();

        String sql = "INSERT INTO garcons (usuario, senha) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Garçom adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirGarcom(Scanner scanner) {
        System.out.println("Digite o ID do garçom a ser excluído:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM garcons WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Garçom excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void manageGerente(Scanner scanner) {
        System.out.println("1. Adicionar gerente");
        System.out.println("2. Excluir gerente");
        System.out.println("0. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
            	adicionarGerente(scanner);
                break;
            case 2:
                excluirGerente(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private static void adicionarGerente(Scanner scanner) {
        System.out.println("Digite o usuário do gerente:");
        String usuario = scanner.nextLine();
        System.out.println("Digite a senha do gerente:");
        String senha = scanner.nextLine();

        String sql = "INSERT INTO gerentes (usuario, senha) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gerente adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void excluirGerente(Scanner scanner) {
        System.out.println("Digite o ID do gerente a ser excluído:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM gerentes WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gerente excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void adicionarPrato(Scanner scanner) {
        System.out.println("Digite o nome do prato:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do prato:");
        double preco = scanner.nextDouble();

        String sql = "INSERT INTO pratos (nome, preco) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Prato adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirPrato(Scanner scanner) {
        System.out.println("Digite o ID do prato a ser excluído:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM pratos WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Prato excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarPedido(Scanner scanner) {
        System.out.println("Digite a descrição do pedido:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o ID do cliente:");
        int clienteId = scanner.nextInt();

        String sql = "INSERT INTO pedidos (descricao, cliente_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, descricao);
            stmt.setInt(2, clienteId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pedido adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirPedido(Scanner scanner) {
        System.out.println("Digite o ID do pedido a ser excluído:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM pedidos WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pedido excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        String sql = "INSERT INTO clientes (nome) VALUES (?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente adicionado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirCliente(Scanner scanner) {
        System.out.println("Digite o ID do cliente a ser excluído:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
