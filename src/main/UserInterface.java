package main;

import gestão.Equipa;
import gestão.Jogador;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    Parser p;
    TripleSFootball tsf;
    Scanner scin;

    public UserInterface(){
        this.p = new Parser();
        this.tsf = new TripleSFootball();
        this.scin = new Scanner(System.in);
    }

    public void run(){
        Menu primeiro = new Menu(new String[] {"Começar novo jogo","Carregar jogo","Recuar"});

        primeiro.setPreCondition(3,() -> false);

        primeiro.setHandler(1,()->{
                try {
                    p.parse("estados/output.txt");
                } catch (LinhaIncorretaException linhaIncorretaException) {
                    linhaIncorretaException.printStackTrace();
                }
                this.tsf = new TripleSFootball(p.getEquipas(),p.getJogadores(),p.getJogos());
                comecarJogo();
        });

        primeiro.setHandler(2,()->{
            File[] f = new File("estados/").listFiles();
            String[] files = new String[f.length+1];
            try{
                for(int i=0; i<f.length; i++){
                        files[i] = f[i].getName().split("\\.")[0];
                }
                files[f.length] = "Recuar";
                Menu load = new Menu(files);

                for (int i = 1; i<=files.length; i++) {
                    int finalI = i;
                    load.setHandler(i,()->{
                        try {
                            p.parse("estados/"+files[finalI-1]+".txt");
                        } catch (LinhaIncorretaException linhaIncorretaException) {
                            linhaIncorretaException.printStackTrace();
                        }
                        this.tsf = new TripleSFootball(p.getEquipas(),p.getJogadores(),p.getJogos());
                        comecarJogo();
                    });
                }
                load.run();


            }catch (Exception e){
                e.printStackTrace();
            }
        });

        primeiro.run();
    }

    private void comecarJogo() {
        Menu jogo = new Menu(new String[] {"Equipas","Jogadores","Constituição da Equipa","Transferir Jogador","Salvar Jogo","Recuar"});

        jogo.setHandler(1, this::listarEquipas);

        jogo.setHandler(2, this::listarJogadores);

        jogo.setHandler(3, this::listarJogadoresEquipa);

        jogo.setHandler(4, this::transferirJogador);

        jogo.setHandler(5, this::salvarJogo);

        jogo.run();
    }

    public void listarEquipas(){
        Map<String, Equipa> equipas = this.tsf.getEquipas();
        for(Map.Entry<String,Equipa> entry : equipas.entrySet()){
            System.out.println(entry.getKey());
        }
        scin.nextLine();
    }

    public void listarJogadores(){
        Map<String, Jogador> jogadores = this.tsf.getJogadores();
        for(Map.Entry<String,Jogador> entry : jogadores.entrySet()){
            System.out.println(entry.getKey());
        }
        scin.nextLine();
    }

    public void listarJogadoresEquipa(){
        System.out.println("Equipa a listar: ");
        String equipa = scin.nextLine();

        if(this.tsf.getEquipas().containsKey(equipa)){
            Equipa team = this.tsf.getEquipa(equipa);

                    for(Jogador j : team.getJogadores()){
                        System.out.println(j.getNome());
                    }
        }
        else System.out.println("Equipa não se encontra na base de dados!");
        scin.nextLine();
    }

    public void transferirJogador(){
        System.out.println("Jogador a transferir: ");
        String jogador = scin.nextLine();
        System.out.println("Equipa destino: ");
        String equipaDestino = scin.nextLine();

        this.tsf.transfereJogador(jogador,equipaDestino);

        scin.nextLine();
    }

    public void salvarJogo(){
        System.out.println("Guardar com nome (Sem espaços): ");
        String progresso = scin.nextLine();

        try {
            p.escreverFicheiro("estados/"+progresso+".txt",tsf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scin.nextLine();
    }
}
