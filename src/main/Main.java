package main;

//David, arranja um nome melhor para o jogo melhor do que
// Triple-S Football

import gestão.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
     //   Jogador j = new Jogador("olá",12, new ArrayList<>());
        TripleSFootball tsf = new TripleSFootball();
        Scanner in = new Scanner(System.in);
        int op = 0;
/*
lista de opcoes:
criar equpipa fantasma(primeira equipa dos jogadores criados)
criar jogador
criar equipa
associar jogador a uma equipa
transferir jogador
remover jogador de uma equipa
remover equipa
alterar nome da equipa
apagar jogador(apenas os criados)

 */

        do {
            System.out.println("1 - Criar equipa\n2 - Criar Jogador\n3 - Saír");
            op = in.nextInt();

            switch(op){
                case 1 :
                    System.out.println("Insira o nome da Equipajogador a ser criado");
                    String nomeE= in.nextLine();
                    System.out.println("Insira a idade do jogador a ser criado");

                case 2 :
                    System.out.println("Insira o nome do jogador a ser criado");
                    String nomeJ= in.nextLine();
                    System.out.println("Insira a idade do jogador a ser criado");
                    int idadeJ=in.nextInt();
                    System.out.println("Insira resto das informacoes do jogador a ser criado");
                    tsf.criaJogador();//com os argumentos certos
            }

        }while(op != 3);
    }
}