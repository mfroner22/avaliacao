/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo F Athayde
 */
public class AtividadeComplementar {

    Scanner entrada = new Scanner(System.in);
    String[] atletasNomes = new String[10];
    boolean[] provaCompletada = new boolean[10];
    int quantidadeAtletas = 0;
    Double[] tempoProva = new Double[10];
    int[] voltasProva = new int[10];

    public static void main(String[] args) {
        AtividadeComplementar minhaClasse = new AtividadeComplementar();
        int opcao = 0;
        do {
            opcao = minhaClasse.monstrarMenu();
            switch (opcao) {
                case 1:
                    minhaClasse.cadastrarAtleta();
                    break;
                case 2:
                    minhaClasse.resultadoAtleta();
                    break;
                case 3:
                    minhaClasse.relatorioAtletas();
                    break;
                case 4:
                    minhaClasse.exibirRelatorioAtletasProvaCompleta();
                    break;
                case 5:
                    minhaClasse.exibirRelatorioProvaNaocompleta();
                    break;
                case 6:
                    minhaClasse.exibirAtletaMenorTempo();
                    break;
                case 7:
                    minhaClasse.exibirTempoTotalProva();
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
                + "1. Cadastrar Atleta \n"
                + "2. Registrar Resultado do Atleta- completar prova, tempo, voltas\n"
                + "3. Exibir relatorio completo Atletas\n"
                + "4. Exibir relatorio Atletas q completaram a prova\n"
                + "5. Exibir relatorio Atletas q NÃO completaram a prova\n"
                + "6. Exibir Atleta com menor tempo de prova\n"
                + "7. Exibir Numero total de Voltas(todos Atletas)\n"
                + "8. Sair do Programa\n"
                + "Escolha uma opção (1-7):");
        int opcaoEscolhida = entrada.nextInt();
        return opcaoEscolhida;
    }

    public void cadastrarAtleta() {
        System.out.println("Informe o nome do atleta: ");
        atletasNomes[quantidadeAtletas] = entrada.next();
        provaCompletada[quantidadeAtletas] = false;
        voltasProva[quantidadeAtletas] = 0;
        quantidadeAtletas++;

    }

    public void resultadoAtleta() {
        System.out.println("Informe o nome do atleta: ");
        String nome = entrada.next();
        for (int i = 0; i < quantidadeAtletas; i++) {

            if (atletasNomes[i].equalsIgnoreCase(nome)) {
                provaCompletada[i] = true;
                System.out.println("Informe o tempo de prova: ");
                tempoProva[i] = entrada.nextDouble();
                System.out.println("Informe quatidade de voltas: ");
                voltasProva[i] = entrada.nextInt();
                return;

            }
            System.out.println("Atleta nao cadastrado!");
        }
    }

    public void exibirRelatorioAtletasProvaCompleta() {
        for (int i = 0; i < quantidadeAtletas; i++) {
            if (provaCompletada[i]) {
                System.out.println(atletasNomes[i]);
            }
        }

    }

    public void exibirRelatorioProvaNaocompleta() {
        for (int i = 0; i < quantidadeAtletas; i++) {
            if (!provaCompletada[i]) {
                System.out.println(atletasNomes[i]);
            }
        }

    }

    public void exibirAtletaMenorTempo() {

    }

    public void exibirTempoTotalProva() {

    }

    public void relatorioAtletas() {
        for (int i = 0; i < quantidadeAtletas; i++) {
            System.out.println(atletasNomes[i]);
        }

    }
}
