package avaliacao;

import java.util.Scanner;

/**
 * Gerenciar a "TECNIKA DO ALLAN"
 *
 * @author Marcelo F Athayde
 */
public class Avaliacao {

    Scanner entrada = new Scanner(System.in);
    String[] produtos = new String[10];
    double[] precoConserto = new double[10];
    int[] estoque = new int[10];
    int quantidadeProdutos = 0;
    int[] faturamento = new int[10];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Avaliacao minhaClasse = new Avaliacao();

        int opcao = 0;
        do {
            opcao = minhaClasse.monstrarMenu();
            switch (opcao) {
                case 1:
                    minhaClasse.cadastrarProduto();
                    break;
                case 2:
                    minhaClasse.fazerConserto();
                    break;
                case 3:
                    minhaClasse.entreguarProduto();
                    break;
                case 4:
                    minhaClasse.exibirRelatorioProdutos();
                    break;
                case 5:
                    minhaClasse.exibirRelatorioNaoconsertados();
                    break;
                case 6:
                    minhaClasse.exibirProdutosConsertadosNaoentregues();
                    break;
                case 7:
                    minhaClasse.exibirFaturamentoLoja();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    break;

            }
            if (opcao != 7) {
                // colocar um sout para nao aparcer sempre o menu
                System.out.println("Presssione qualquer tecla");
                minhaClasse.entrada.next();
            }
        } while (opcao != 8);

    }

    public int monstrarMenu() {
        System.out.println(" === Menu de Opções ===\n"
                + "1. Receber produto do cliente-cadastrar\n"
                + "2. Fazer conserto\n"
                + "3. Entregar produto ao cliente\n"
                + "4. Exibir relatorio completo de produtos\n"
                + "5. Exibir relatorio de produtos que ainda nao consertados\n"
                + "6. Exibir relatorio de produtos consertados- não retirados\n"
                + "7. Exibir o faturamento total da loja\n"
                + "8. Sair do Programa\n"
                + "Escolha uma opção (1-7):");
        int opcaoEscolhida = entrada.nextInt();
        return opcaoEscolhida;
    }

    public void cadastrarProduto() {
        System.out.println("Informe o nome do produto: ");
        produtos[quantidadeProdutos] = entrada.next();
        System.out.println("Informe o preço do conserto:");
        precoConserto[quantidadeProdutos] = entrada.nextDouble();
        System.out.println("Informe quantos produtos para consertar:");
        estoque[quantidadeProdutos] = entrada.nextInt();
        quantidadeProdutos++;
    }

    public void fazerConserto() {
        boolean[] consertado = new boolean[10];
        boolean[] entregue = new boolean[10];
        // Solicitar informações sobre consertado ou não
        System.out.println("====Consertar ====");
        System.out.println("Informe o produto:");
        String produto = entrada.next();
        System.out.println("Informe a Quantidade:");
        int quantidade = entrada.nextInt();

        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produto.equalsIgnoreCase(produtos[i])) {
                if (quantidade <= estoque[i]) {
                    //atualizar estoque
                    estoque[i] = estoque[i] - quantidade;
                    //atualizar o faturamento
                    faturamento[i] += precoConserto[i] * quantidade;
                    System.out.println("Produto consertado com sucesso!");
                    return;
                } else {
                    System.out.println("Quantidade insuficiente para fazer o conserto");
                    return;
                }

            }
            System.out.println("Produto nao foi encontrado!");
        }

    }

    public void entreguarProduto() {

    }

    public void exibirFaturamentoLoja() {
        System.out.println("=== FATURAMENTO ===");

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println(produtos[i] + ": " + faturamento[i]);

        }
    }

    // public void exibirRelatorioProdutos() {
    //   }
    public void exibirRelatorioProdutos() {

    }

    public void exibirRelatorioNaoconsertados() {

    }

    public void exibirProdutosConsertadosNaoentregues() {

    }

    private boolean formatarSaida(String preço, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
