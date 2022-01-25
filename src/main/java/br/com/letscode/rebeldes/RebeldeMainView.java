package br.com.letscode.rebeldes;

import java.util.Scanner;

public class RebeldeMainView {
    private Scanner scanner;
    private InteligenciaCentral inteligenciaCentral = InteligenciaCentral.builder().build();
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

    private void obtemDadosRebelde() {
        askNome();
        askIdade();
        askRaça();
    }

    private void solicitaIngressoIC() {
        this.rebelde = Rebelde.builder()
                .Nome(this.nome)
                .Idade(this.idade)
                .Raça(this.raça)
                .build();

        boolean ingressou = this.inteligenciaCentral.solicitarIngressoDeRebelde(this.rebelde);
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

    public void showMenu() {
        System.out.println("Digite 'S' para Solicitar Ingresso na Aliança ou 'X' para Sair");

        String option;
        boolean status = true;
        do {
            option = scanner.next();
            switch (option.toUpperCase()) {
                case "S":
                    obtemDadosRebelde();
                    solicitaIngressoIC();
                    this.showMenu();
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
