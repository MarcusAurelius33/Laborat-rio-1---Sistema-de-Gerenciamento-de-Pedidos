package lp2lab1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Controla a execução do sistema do restaurante
public class Sistema {

    private List<Pedido> pedidos;
    private Scanner scanner;
    private int proximoNumeroPedido;

    public Sistema() {
        this.pedidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.proximoNumeroPedido = 1; 
    }
// executa o menu e o loop do programa
    public void executar() {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    removerPedido();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n===== Sistema de Pedidos do Restaurante =====");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void registrarPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        
        Pedido novoPedido = new Pedido(proximoNumeroPedido, nomeCliente);
        
        //adicionar itens ao pedido
        while (true) {
            System.out.print("Digite o nome do item (ou 'fim' para concluir): ");
            String nomeItem = scanner.nextLine();
            
            if (nomeItem.equalsIgnoreCase("fim")) {
                break; 
            }
            
            System.out.print("Digite o preço do item: ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine(); 
            
            Item item = new Item(nomeItem, precoItem);
            novoPedido.adicionarItem(item);
        }
        
        pedidos.add(novoPedido);
        
        proximoNumeroPedido++;
        
        System.out.println("\n--- Pedido Registrado com Sucesso! ---");
        exibirResumoPedido(novoPedido);
    }
    
    private void removerPedido() {
        System.out.print("Digite o número do pedido que deseja remover: ");
        int numeroParaRemover = scanner.nextInt();
        scanner.nextLine(); 
        
        Pedido pedidoParaRemover = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numeroParaRemover) {
                pedidoParaRemover = pedido;
                break;
            }
        }
        
        if (pedidoParaRemover != null) {
            pedidos.remove(pedidoParaRemover);
            System.out.println("Pedido " + numeroParaRemover + " removido com sucesso.");
        } else {
            System.out.println("Erro: Pedido com número " + numeroParaRemover + " não encontrado.");
        }
    }

    private void listarPedidos() {
        System.out.println("\n===== Lista de Todos os Pedidos Registrados =====");
        
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado ainda.");
        } else {
            for (Pedido pedido : pedidos) {
                exibirResumoPedido(pedido);
                System.out.println("---------------------------------------------");
            }
        }
    }

    //exibir o resumo formatado de um pedido.
    private void exibirResumoPedido(Pedido pedido) {
        System.out.println("=============================================");
        System.out.println("Pedido N°: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("------------------ Itens ------------------");
        for (Item item : pedido.getItens()) {
            System.out.printf("- %s: R$ %.2f\n", item.getNome(), item.getPreco());
        }
        System.out.println("---------------------------------------------");
        System.out.printf("Total: R$ %.2f\n", pedido.calcularValorTotal());
        System.out.println("=============================================");
    }
    
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.executar();
    }
}
