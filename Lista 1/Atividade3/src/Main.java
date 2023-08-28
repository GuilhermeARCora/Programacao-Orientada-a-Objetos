import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemEstoque {
    private String nome;
    private int quantidade;

    public ItemEstoque(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

class SistemaGerenciamentoEstoque {
    private List<ItemEstoque> estoque;

    public SistemaGerenciamentoEstoque() {
        this.estoque = new ArrayList<>();
    }

    public void adicionarItem(String nome, int quantidade) {
        ItemEstoque novoItem = new ItemEstoque(nome, quantidade);
        estoque.add(novoItem);
        System.out.println(quantidade + " unidades de " + nome + " adicionadas ao estoque.");
    }

    public void removerItem(String nome) {
        ItemEstoque itemRemovido = null;
        for (ItemEstoque item : estoque) {
            if (item.getNome().equals(nome)) {
                itemRemovido = item;
                estoque.remove(item);
                System.out.println(item.getQuantidade() + " unidades de " + nome + " removidas do estoque.");
                break;
            }
        }
        if (itemRemovido == null) {
            System.out.println(nome + " não encontrado no estoque.");
        }
    }

    public void listarItens() {
        System.out.println("Itens em estoque:");
        for (ItemEstoque item : estoque) {
            System.out.println(item.getNome() + ": " + item.getQuantidade() + " unidades");
        }
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        for (ItemEstoque item : estoque) {
            if (item.getNome().equals(nome)) {
                item.setQuantidade(novaQuantidade);
                System.out.println("Quantidade de " + nome + " atualizada para " + novaQuantidade + " unidades.");
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaGerenciamentoEstoque sistema = new SistemaGerenciamentoEstoque();

        while (true) {
            System.out.println("\nEscolha uma opção:\n");
            System.out.println("1. Escreva o nome dos itens que deseja adicionar ao estoque");
            System.out.println("2. Escreva o nome dos itens que deseja Remover do estoque");
            System.out.println("3. Solicitar a lista de itens presentes no estoque");
            System.out.println("4. Atualizar quantidade de unidades de um dos itens");
            System.out.println("5. Sair do sistema\n");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nomeAdicao = scanner.nextLine();
                    System.out.print("Digite a quantidade a ser adicionada: ");
                    int quantidadeAdicao = scanner.nextInt();
                    sistema.adicionarItem(nomeAdicao, quantidadeAdicao);
                    break;
                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    String nomeRemocao = scanner.nextLine();
                    sistema.removerItem(nomeRemocao);
                    break;
                case 3:
                    sistema.listarItens();
                    break;
                case 4:
                    System.out.print("Digite o nome do item a ser atualizado: ");
                    String nomeAtualizacao = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    sistema.atualizarQuantidade(nomeAtualizacao, novaQuantidade);
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
