package main;
import gestão.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Jogador j = new Jogador("olá",12, new ArrayList<>());
        //TripleSFootball tsf = new TripleSFootball();

    Parser p = new Parser();

        try {
            p.parse();
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }

        TripleSFootball tsf = new TripleSFootball(p.getEquipas(),p.getJogadores());

        tsf.transfereJogador("Eduardo Costa de Magalhaes","Sporting Club Chopin","Sporting Club Chopin");




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
/*
sugestoes de interfaces:
1- de edicoes:
criar equipaas e/ou jogadores, transferir joagdores, apagar jogadores e/ou equipas criadas
2- de jogar:
    inicialisar:
        inserir nome do tecnico, inserir equipa a ser utilizada,
    funcionalidades:
        basicas:
            alterar escalacao antes do jogo, titulares e reservas
            fazer max de 3 substituicoes durante o intervalo
            jogar as partidas
        avancadas:
            contratar e/ou despedir jogador
 */
  /*      do {
            System.out.println("1- Criar equipa\n2- Criar Jogador\n3- Tranferir jogador de clube\n4- Apagar jogador criado\n" +
                    "5- Apagar equipa\n0- Saír");
            op = in.nextInt();
            switch(op){
                case 1 :
                    //criar equipa
                    System.out.println("Insira o nome da Equipajogador a ser criado");
                    String nomeE1= in.nextLine();
                    System.out.println("Insira a idade do jogador a ser criado");
                    tsf.criaEquipa();//com os argumentos certos
                    break;
                case 2 :
                    //criar jogador
                    System.out.println("Insira o nome do jogador a ser criado");
                    String nomeJ2= in.nextLine();
                    System.out.println("Insira a idade do jogador a ser criado");
                    int idadeJ2=in.nextInt();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double velJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double resJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double desJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double impJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double jdcJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double remJ2=in.nextDouble();
                    System.out.println("Insira a velocidade do jogador a ser criado");
                    double cdpJ2=in.nextDouble();
                    System.out.println("Insira resto das informacoes do jogador a ser criado");
                    System.out.println("Insira a posicao do jogador a ser criado");
                    String posicaoJ2= in.nextLine();
                    Jogador j2;
                    if(posicaoJ2.equals("GuardaRedes")){
                        System.out.println("Insira a a elasticidade do GuardaRedes a ser criado");
                        double elas= in.nextDouble();
                        j2=tsf.criaGuardaRedes(nomeJ2,idadeJ2, velJ2, resJ2, desJ2, impJ2, jdcJ2, remJ2, cdpJ2,elas);
                    }else {
                        //ver meio de validar posicao
                        j2=tsf.criaJogador(nomeJ2, idadeJ2, velJ2, resJ2, desJ2, impJ2, jdcJ2, remJ2, cdpJ2, posicaoJ2);//com os argumentos certos
                    }
                    break;
                case 3 :
                    //transferir jogador
                    System.out.println("Insira o nome do jogador a ser transferido");
                    String nomeJ3= in.nextLine();
                    //caso o jogador estiver na equipa fantasma, sai dela para a outra equipa, caso contrario
                    System.out.println("Insira o nome da velha equipa do jogador, " +
                            "caso o jogador nao va para nenhuma equipa ainda, digite 'fantasma'");
                    String nomeE3_velha= in.nextLine();
                    System.out.println("Insira o nome da nova equipa do jogador, " +
                        "caso o jogador nao va para nenhuma equipa ainda, digite 'fantasma'");
                    String nomeE3_nova= in.nextLine();
                    tsf.transfereJogador(nomeJ3,nomeE3_velha,nomeE3_nova);
                    break;
                case 4 :
                    //apagar jogador
                    System.out.println("Insira o nome do jogador a ser apagado");
                    String nomeJ4= in.nextLine();
                    //caso o jogador nao tiver a equipa fantasma como primeiro clube, nao pode ser apagado
                    break;
                case 5:
                    //apagar equipa
                    System.out.println("Insira o nome da equipa a ser apagado");
                    String nomeE5= in.nextLine();
                    //caso nao for uma equipa criada nao pode ser apagada
                default :
                    break;
            }
        }while(op != 0);
    */
    }
}
