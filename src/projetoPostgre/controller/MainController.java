package projetoPostgre.controller;

import projetoPostgre.model.*;
import projetoPostgre.view.MenuView;

import java.util.Scanner;

public class MainController {
    private final GarcomDAO garcomDAO;
    private final SocioDAO socioDAO;
    private final PratoDAO pratoDAO;
    private final PedidoDAO pedidoDAO;
    private final ClienteDAO clienteDAO;
    private final GerenteDAO gerenteDAO;
    private final MenuView menuView;
    private final Scanner scanner;

    public MainController() {
        this.garcomDAO = new GarcomDAO();
        this.socioDAO = new SocioDAO();
        this.pratoDAO = new PratoDAO();
        this.pedidoDAO = new PedidoDAO();
        this.clienteDAO = new ClienteDAO();
        this.gerenteDAO = new GerenteDAO();
        this.menuView = new MenuView();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            menuView.showMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (authenticateUser("socios")) {
                        processSocioInput();
                    }
                    break;
                case 2:
                    if (authenticateUser("gerentes")) {
                        processGerenteInput();
                    }
                    break;
                case 3:
                    if (authenticateUser("garcons")) {
                        processGarcomInput();
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
    }

    private boolean authenticateUser(String role) {
        System.out.println("Digite seu usuário:");
        String usuario = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        boolean isAuthenticated;
        switch (role) {
            case "socios":
                isAuthenticated = socioDAO.authenticate(usuario, senha);
                break;
            case "gerentes":
                isAuthenticated = gerenteDAO.authenticate(usuario, senha);
                break;
            case "garcons":
                isAuthenticated = garcomDAO.authenticate(usuario, senha);
                break;
            default:
                isAuthenticated = false;
        }

        if (isAuthenticated) {
            System.out.println("Seja bem-vindo!");
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
        return isAuthenticated;
    }

    private void processSocioInput() {
        int option;
        do {
            menuView.showMenuSocio();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    manageGerente();
                    break;
                case 2:
                    manageGarcom();
                    break;
                case 3:
                    managePrato();
                    break;
                case 4:
                    managePedido();
                    break;
                case 5:
                    manageCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private void processGerenteInput() {
        int option;
        do {
            menuView.showMenuGerente();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    manageGarcom();
                    break;
                case 2:
                    managePrato();
                    break;
                case 3:
                    managePedido();
                    break;
                case 4:
                    manageCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private void processGarcomInput() {
        int option;
        do {
            menuView.showMenuGarcom();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    managePrato();
                    break;
                case 2:
                    managePedido();
                    break;
                case 3:
                    manageCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 0);
    }

    private void manageGarcom() {
        menuView.showGarcomManagementMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarGarcom();
                break;
            case 2:
                excluirGarcom();
                break;
            case 3:
                atualizarGarcom();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private void managePrato() {
        menuView.showPratoManagementMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarPrato();
                break;
            case 2:
                excluirPrato();
                break;
            case 3:
            	atualizarPrecoPrato();
            	break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private void managePedido() {
        menuView.showPedidoManagementMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarPedido();
                break;
            case 2:
                excluirPedido();
                break;
            case 3:
            	atualizarPedido();
            	break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private void manageCliente() {
        menuView.showClienteManagementMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                excluirCliente();
                break;
            case 3:
            	atualizarCliente();
            	break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private void manageGerente() {
        menuView.showGerenteManagementMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                adicionarGerente();
                break;
            case 2:
                excluirGerente();
                break;
            case 3:
            	atualizarGerente();
            	break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    // Chamando métodos dos DAOs

    private void adicionarCliente() {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = scanner.nextLine();
        clienteDAO.adicionarCliente(nome, email);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private void excluirCliente() {
        System.out.println("Digite o ID do cliente a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine();
        clienteDAO.excluirCliente(id);
        System.out.println("Cliente excluído com sucesso!");
    }
    
    private void atualizarCliente() {
        System.out.println("Digite o ID do cliente a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo nome do cliente:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite o novo nome do cliente:");
        String novoEmail = scanner.nextLine();
        clienteDAO.atualizarCliente(id, novoNome, novoEmail);
        System.out.println("Cliente atualizado com sucesso!");
    }

    private void adicionarGarcom() {
        System.out.println("Digite o nome do garçom:");
        String nome = scanner.nextLine();
        System.out.println("Digite a senha do garçom:");
        String senha = scanner.nextLine();
        garcomDAO.adicionarGarcom(nome, senha);
        System.out.println("Garçom adicionado com sucesso!");
    }

    private void excluirGarcom() {
        System.out.println("Digite o ID do garçom a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine();
        garcomDAO.excluirGarcom(id);
        System.out.println("Garçom excluído com sucesso!");
    }

    private void atualizarGarcom() {
        System.out.println("Digite o ID do garçom a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo nome do garçom:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova senha do garçom:");
        String novaSenha = scanner.nextLine();
        garcomDAO.atualizarGarcom(id, novoNome, novaSenha);
        System.out.println("Garçom atualizado com sucesso!");
    }

    private void adicionarPrato() {
        System.out.println("Digite o nome do prato:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do prato:");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        pratoDAO.adicionarPrato(nome, preco);
        System.out.println("Prato adicionado com sucesso!");
    }

    private void excluirPrato() {
        System.out.println("Digite o ID do prato a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine();
        pratoDAO.excluirPrato(id);
        System.out.println("Prato excluído com sucesso!");
    }
    
    private void atualizarPrecoPrato() {
        System.out.println("Digite o ID do prato a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.println("Digite o novo preço do prato:");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha restante

        pratoDAO.atualizarPrecoPrato(id, novoPreco);
        System.out.println("Preço atualizado com sucesso!");
    }

    private void adicionarPedido() {
        System.out.println("Digite o ID do cliente:");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o ID do prato:");
        int pratoId = scanner.nextInt();
        scanner.nextLine();
        pedidoDAO.adicionarPedido(clienteId, pratoId);
        System.out.println("Pedido adicionado com sucesso!");
    }

    private void excluirPedido() {
        System.out.println("Digite o ID do pedido a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine();
        pedidoDAO.excluirPedido(id);
        System.out.println("Pedido excluído com sucesso!");
    }
    
    private void atualizarPedido() {
        System.out.println("Digite o ID do prato a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha restante

        System.out.println("Digite o novo preço do prato:");
        String novaDescricao = scanner.nextLine();
        pedidoDAO.atualizarDescricaoPedido(id, novaDescricao);
        System.out.println("Preço atualizado com sucesso!");
    }


    private void adicionarGerente() {
        System.out.println("Digite o nome do gerente:");
        String nome = scanner.nextLine();
        System.out.println("Digite a senha do gerente:");
        String senha = scanner.nextLine();
        gerenteDAO.adicionarGerente(nome, senha);
        System.out.println("Gerente adicionado com sucesso!");
    }

    private void excluirGerente() {
        System.out.println("Digite o ID do gerente a ser excluído:");
        int id = scanner.nextInt();
        scanner.nextLine();
        gerenteDAO.excluirGerente(id);
        System.out.println("Gerente excluído com sucesso!");
    }
    
    private void atualizarGerente() {
        System.out.println("Digite o ID do gerente a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo nome do gerente:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova senha do gerente:");
        String novaSenha = scanner.nextLine();
        gerenteDAO.atualizarGerente(id, novoNome, novaSenha);
        System.out.println("Gerente atualizado com sucesso!");
    }
    

}
