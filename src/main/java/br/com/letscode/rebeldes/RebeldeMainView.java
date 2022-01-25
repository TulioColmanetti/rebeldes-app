package br.com.letscode.rebeldes;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class RebeldeMainView {
    private Scanner scanner;
    private InteligenciaCentral inteligenciaCentral = new InteligenciaCentral();
    private Rebelde rebelde;
    private String nome;
    private int idade;
    private Raça raça;

    public RebeldeMainView(){
        this.scanner = new Scanner(System.in);
    }

    private void askNome() {
        System.out.println("Qual o nome do Rebelde?");
        String nome = scanner.next();
        if (nome.isBlank()) {
            System.out.println("Nome inválido!");
            askNome();
        } else
            this.nome = nome;
    }

    private void askIdade() {
        System.out.println("Qual a idade do Rebelde?");
        int idade = scanner.nextInt();
        if (idade <= 0) {
            System.out.println("Idade inválida!");
            askIdade();
        } else
            this.idade = idade;
    }

    private void askRaça() {
        System.out.println("Qual a raça do Rebelde?");
        for (Raça raça : Raça.values()) {
            System.out.printf("%d - %s\n", raça.ordinal(), raça.name());
        }
        int raçaIndex = scanner.nextInt();
        if (raçaIndex < 0 || raçaIndex >= Raça.values().length) {
            System.out.println("Raça inválida!");
            askRaça();
        } else
            this.raça = Raça.values()[raçaIndex];
    }

    private void obtemDadosRebelde() {
        askNome();
        askIdade();
        askRaça();

        this.rebelde = Rebelde.builder()
                .Nome(this.nome)
                .Idade(this.idade)
                .Raça(this.raça)
                .build();
    }

    private void solicitaIngressoIC() {
        boolean ingressou = this.inteligenciaCentral.solicitarIngressoDeRebelde(this.rebelde);

        if(ingressou)
            System.out.println("Rebelde '" + rebelde.getNome() + "' ingressou na Aliança!");
        else
            System.out.println("Rebelde '" + rebelde.getNome() + "' recusado!");
    }

    private void exibirRebeldesIC() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de rebeldes:\n");
        for (Rebelde rebelde : this.inteligenciaCentral.getRebeldes())
        {
            sb.append(rebelde.toString());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void gerarRelatorioRebeldesIC() {
        try {
            this.inteligenciaCentral.gerarRelatorioDeRebeldes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void renderMenu() {
        System.out.println("<<<<< Menu da Aliança Rebelde >>>>>");
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("'S' - Solicitar Ingresso na Aliança");
        System.out.println("'E' - Exibir Lista de Rebeldes");
        System.out.println("'R' - Gerar Relatório de Rebeldes");
        System.out.println("'X' - Sair");
    }

    public void showMenu() {
        renderMenu();

        String option;
        boolean status = true;
        do {
            option = scanner.next();
            switch (option.toUpperCase()) {
                case "S":
                    obtemDadosRebelde();
                    solicitaIngressoIC();
                    renderMenu();
                    break;
                case "E":
                    exibirRebeldesIC();
                    renderMenu();
                    break;
                case "R":
                    gerarRelatorioRebeldesIC();
                    renderMenu();
                    break;
                case "X":
                    status = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (status);
    }
}
