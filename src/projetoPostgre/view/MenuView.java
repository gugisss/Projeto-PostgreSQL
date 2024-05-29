package projetoPostgre.view;

public class MenuView {

    public void showMainMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Acessar como Sócio");
        System.out.println("2. Acessar como Gerente");
        System.out.println("3. Acessar como Garçom");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuSocio() {
        System.out.println("=== MENU SÓCIO ===");
        System.out.println("1. Gerenciar Gerentes");
        System.out.println("2. Gerenciar Garçons");
        System.out.println("3. Gerenciar Pratos");
        System.out.println("4. Gerenciar Pedidos");
        System.out.println("5. Gerenciar Clientes");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuGerente() {
        System.out.println("=== MENU GERENTE ===");
        System.out.println("1. Gerenciar Garçons");
        System.out.println("2. Gerenciar Pratos");
        System.out.println("3. Gerenciar Pedidos");
        System.out.println("4. Gerenciar Clientes");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showMenuGarcom() {
        System.out.println("=== MENU GARÇOM ===");
        System.out.println("1. Gerenciar Pratos");
        System.out.println("2. Gerenciar Pedidos");
        System.out.println("3. Gerenciar Clientes");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showGarcomManagementMenu() {
        System.out.println("=== GERENCIAR GARÇOM ===");
        System.out.println("1. Adicionar Garçom");
        System.out.println("2. Excluir Garçom");
        System.out.println("3. Atualizar Gerente");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showPratoManagementMenu() {
        System.out.println("=== GERENCIAR PRATO ===");
        System.out.println("1. Adicionar Prato");
        System.out.println("2. Excluir Prato");
        System.out.println("3. Atualizar Prato");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showPedidoManagementMenu() {
        System.out.println("=== GERENCIAR PEDIDO ===");
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Excluir Pedido");
        System.out.println("3. Atualizar Pedido");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showClienteManagementMenu() {
        System.out.println("=== GERENCIAR CLIENTE ===");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Excluir Cliente");
        System.out.println("3. Atualizar Cliente");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public void showGerenteManagementMenu() {
        System.out.println("=== GERENCIAR GERENTE ===");
        System.out.println("1. Adicionar Gerente");
        System.out.println("2. Excluir Gerente");
        System.out.println("3. Atualizar Gerente");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }
}
