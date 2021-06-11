package main;

import gestão.Equipa;
import gestão.GuardaRedes;
import gestão.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


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
        Menu jogo = new Menu(new String[] {"Jogar","Equipas","Jogadores","Constituição da Equipa","Transferir Jogador","Criar Jogador","Criar Equipa","Salvar Jogo","Recuar"});

        jogo.setHandler(1, this::iniciarJogo);

        jogo.setHandler(2, this::listarEquipas);

        jogo.setHandler(3, this::listarJogadores);

        jogo.setHandler(4, this::listarJogadoresEquipa);

        jogo.setHandler(5, this::transferirJogador);

        jogo.setHandler(6, this::criarJogador);

        jogo.setHandler(7, this::criarEquipa);

        jogo.setHandler(8, this::salvarJogo);

        jogo.run();
    }

    public void criarJogador(){
        System.out.println("Nome do jogador: ");
        String nome = scin.nextLine();

        if(tsf.getJogadores().containsKey(nome)){
            System.out.println("Jogador já existente!");
        }else {

            System.out.println("Posição:\nGuarda-Redes || Defesa || Lateral || Medio || Avancado");
            String posicao = scin.nextLine();

            switch (posicao) {
                case "Guarda-Redes":
                    criaGuardaRedes(nome);
                    break;
                case "Medio":
                    criaMedio(nome);
                    break;
                case "Lateral":
                    criaLateral(nome);
                    break;
                default:
                    if (posicao.equals("Defesa") || posicao.equals("Avancado")) {
                        criaJogadorElse(nome, posicao);
                    } else {
                        System.out.println("Posição não reconhecida!");
                    }
            }
            scin.nextLine();
        }
    }

    public void criaGuardaRedes(String nome){
        System.out.println("Número: ");
        int numero = scin.nextInt();
        System.out.println(("Velocidade: "));
        int velocidade = scin.nextInt();
        System.out.println("Resistência: ");
        int resistencia = scin.nextInt();
        System.out.println("Destreza: ");
        int destreza = scin.nextInt();
        System.out.println("Impulsão: ");
        int impulsao = scin.nextInt();
        System.out.println("Jogo de Cabeça: ");
        int jogoDeCabeca = scin.nextInt();
        System.out.println("Remate: ");
        int remate = scin.nextInt();
        System.out.println("Capacidade de Passe: ");
        int capacidadeDePasse = scin.nextInt();
        System.out.println("Elasticidade: ");
        int elasticidade = scin.nextInt();

        Jogador j = new GuardaRedes(nome,numero,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,capacidadeDePasse,elasticidade);
        tsf.addJogador(j);
    }

    public void criaMedio(String nome){
        System.out.println("Número: ");
        int numero = scin.nextInt();
        System.out.println(("Velocidade: "));
        int velocidade = scin.nextInt();
        System.out.println("Resistência: ");
        int resistencia = scin.nextInt();
        System.out.println("Destreza: ");
        int destreza = scin.nextInt();
        System.out.println("Impulsão: ");
        int impulsao = scin.nextInt();
        System.out.println("Jogo de Cabeça: ");
        int jogoDeCabeca = scin.nextInt();
        System.out.println("Remate: ");
        int remate = scin.nextInt();
        System.out.println("Capacidade de Passe: ");
        int capacidadeDePasse = scin.nextInt();
        System.out.println("Recuperação: ");
        int recuperacao = scin.nextInt();

        Jogador j = new Medio(nome,numero,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,capacidadeDePasse,recuperacao);
        tsf.addJogador(j);
    }

    public void criaLateral(String nome){
        System.out.println("Número: ");
        int numero = scin.nextInt();
        System.out.println(("Velocidade: "));
        int velocidade = scin.nextInt();
        System.out.println("Resistência: ");
        int resistencia = scin.nextInt();
        System.out.println("Destreza: ");
        int destreza = scin.nextInt();
        System.out.println("Impulsão: ");
        int impulsao = scin.nextInt();
        System.out.println("Jogo de Cabeça: ");
        int jogoDeCabeca = scin.nextInt();
        System.out.println("Remate: ");
        int remate = scin.nextInt();
        System.out.println("Capacidade de Passe: ");
        int capacidadeDePasse = scin.nextInt();
        System.out.println("Cruzamento: ");
        int cruzamento = scin.nextInt();

        Jogador j = new Lateral(nome,numero,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,capacidadeDePasse,cruzamento);
        tsf.addJogador(j);
    }

    public void criaJogadorElse(String nome,String posicao){
        System.out.println("Número: ");
        int numero = scin.nextInt();
        System.out.println(("Velocidade: "));
        int velocidade = scin.nextInt();
        System.out.println("Resistência: ");
        int resistencia = scin.nextInt();
        System.out.println("Destreza: ");
        int destreza = scin.nextInt();
        System.out.println("Impulsão: ");
        int impulsao = scin.nextInt();
        System.out.println("Jogo de Cabeça: ");
        int jogoDeCabeca = scin.nextInt();
        System.out.println("Remate: ");
        int remate = scin.nextInt();
        System.out.println("Capacidade de Passe: ");
        int capacidadeDePasse = scin.nextInt();

        if(posicao.equals("Avancado")) {
            Jogador j = new Avancado(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
            tsf.addJogador(j);
        }else{
            Jogador j = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, jogoDeCabeca, remate, capacidadeDePasse);
            tsf.addJogador(j);
        }


    }

    public void criarEquipa(){
        System.out.println("Nome da equipa: ");
        String nome = scin.nextLine();

        if(tsf.existeEquipa(nome)){
            System.out.println("Nome já existe na base de dados!");
        }else{
            Equipa e = new Equipa(nome);
            tsf.adicionaEquipa(e);
        }
    }

    public void iniciarJogo() {
        List<Jogador> jogadoresCasa = new ArrayList<>();
        List<Jogador> jogadoresFora = new ArrayList<>();
        List<Integer> jogadoresCasaInt = new ArrayList<>();
        List<Integer> jogadoresForaInt = new ArrayList<>();
        Map<Integer,Integer> subsCasa = new HashMap<>();
        Map<Integer,Integer> subsFora = new HashMap<>();
        int golosCasa = 0;
        int golosFora = 0;
        Equipa teamCasa = null;
        Equipa teamFora = null;
        Random rand = new Random();

        listarEquipas();
        System.out.println("Equipa casa");
        String casa = scin.nextLine();
        System.out.println("Equipa fora");
        String fora = scin.nextLine();
        if(this.tsf.existeEquipa(casa)&& this.tsf.existeEquipa(fora)){
            teamCasa = this.tsf.getEquipa(casa);
            System.out.println("Equipa casa: "+teamCasa.getNome());
            for(Jogador j : teamCasa.getJogadores()){
                System.out.println(j.getCamisola()+" - "+j.getNome()+" Habilidade: "+j.calculaHabilidade());
            }
            System.out.println("Selecione 1 a 1 os 11 titulares!");
            for(int i = 0; i < 11; i++){
                int numero = scin.nextInt();
                jogadoresCasa.add(teamCasa.getJogadorByNumber(numero));
                jogadoresCasaInt.add(numero);
            }
            //subs casa
            System.out.println("Deseja efetuar substituicoes?");
            System.out.println("0-Nao");
            System.out.println("1-Sim");
            int subsOpC=scin.nextInt();
            if(subsOpC==1) {
                scin.nextLine();
                for (int i = 0; i < 3; i++) {
                    System.out.println("Substituição Casa " + (i + 1) + ":");
                    String subs = scin.nextLine();
                    subsCasa.put(Integer.parseInt(subs.split("->")[0]), Integer.parseInt(subs.split("->")[1]));
                }
            }
            //fora
            teamFora = this.tsf.getEquipa(fora);
            System.out.println("Equipa fora: "+teamFora.getNome());
            for(Jogador j : teamFora.getJogadores()){
                System.out.println(j.getCamisola()+" - "+j.getNome()+" Habilidade: "+j.calculaHabilidade());
            }
            for(int i = 0; i < 11; i++){
                int numero = scin.nextInt();
                jogadoresFora.add(teamFora.getJogadorByNumber(numero));
                jogadoresForaInt.add(numero);
            }
            System.out.println("Deseja efetuar substituicoes?");
            System.out.println("0-Nao");
            System.out.println("1-Sim");
            int subsOpF=scin.nextInt();
            if(subsOpF==1) {
                //subs fora
                scin.nextLine();
                for (int i = 0; i < 3; i++) {
                    System.out.println("Substituição Fora " + (i + 1) + ":");
                    String subs = scin.nextLine();
                    subsFora.put(Integer.parseInt(subs.split("->")[0]), Integer.parseInt(subs.split("->")[1]));
                }
            }
        }
        /*
        if(this.tsf.getEquipas().containsKey(casa)){
            teamCasa = this.tsf.getEquipa(casa);
            System.out.println("Equipa casa: "+teamCasa.getNome());
            for(Jogador j : teamCasa.getJogadores()){
                System.out.println(j.getCamisola()+" - "+j.getNome());
            }
            System.out.println("Selecione 1 a 1 os 11 titulares!");
            for(int i = 0; i < 11; i++){
                int numero = scin.nextInt();
                jogadoresCasa.add(teamCasa.getJogadorByNumber(numero));
                jogadoresCasaInt.add(numero);
            }
        }*/
/*
        if(this.tsf.getEquipas().containsKey(fora)){
            teamFora = this.tsf.getEquipa(fora);
            System.out.println("Equipa fora: "+teamFora.getNome());
            for(Jogador j : teamFora.getJogadores()){
                System.out.println(j.getCamisola()+" - "+j.getNome());
            }
            for(int i = 0; i < 11; i++){
                int numero = scin.nextInt();
                jogadoresFora.add(teamFora.getJogadorByNumber(numero));
                jogadoresForaInt.add(numero);
            }
        }*/
        /*
        scin.nextLine();
        for(int i = 0;i<3;i++){
            System.out.println("Substituição Casa "+(i+1)+":");
            String subs = scin.nextLine();
            subsCasa.put(Integer.parseInt(subs.split("->")[0]),Integer.parseInt(subs.split("->")[1]));
        }

        for(int i = 0;i<3;i++){
            System.out.println("Substituição Fora "+(i+1)+":");
            String subs = scin.nextLine();
            subsFora.put(Integer.parseInt(subs.split("->")[0]),Integer.parseInt(subs.split("->")[1]));
        }
*/
        if(calculaProbMarcar(jogadoresCasa,jogadoresFora) == 0){
            golosCasa = rand.nextInt(5);
            golosFora = rand.nextInt(2);
        }else{
            golosCasa = rand.nextInt(2);
            golosFora = rand.nextInt(5);
        }

        for(Map.Entry<Integer,Integer> entry : subsCasa.entrySet()){
            for(int i = 0; i < jogadoresCasa.size();i++){
                if(jogadoresCasa.get(i).getCamisola() == entry.getKey()){
                    jogadoresCasa.remove(i);
                    jogadoresCasa.add(teamCasa.getJogadorByNumber(entry.getValue()));
                    jogadoresCasaInt.remove(Integer.valueOf(entry.getKey()));
                    jogadoresCasaInt.add(Integer.valueOf(entry.getValue()));
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry : subsFora.entrySet()){
            for(int i = 0; i < jogadoresFora.size();i++){
                if(jogadoresFora.get(i).getCamisola() == entry.getKey()){
                    jogadoresFora.remove(i);
                    jogadoresFora.add(teamFora.getJogadorByNumber(entry.getValue()));
                    jogadoresForaInt.remove(Integer.valueOf(entry.getKey()));
                    jogadoresForaInt.add(Integer.valueOf(entry.getValue()));
                }
            }
        }

        if(calculaProbMarcar(jogadoresCasa,jogadoresFora) == 0){
            golosCasa += rand.nextInt(5);
            golosFora += rand.nextInt(2);
        }else{
            golosCasa += rand.nextInt(2);
            golosFora += rand.nextInt(5);
        }

        LocalDate data = LocalDate.now();

        Jogo j = new Jogo(teamCasa.getNome(),teamFora.getNome(),golosCasa,golosFora,data,jogadoresCasaInt,subsCasa,jogadoresForaInt,subsFora);
        tsf.adicionarJogo(j);
        System.out.println(teamCasa.getNome()+" " +golosCasa+ " : "+golosFora+" "+teamFora.getNome());
    }

    public int calculaProbMarcar(List<Jogador> eCasa,List<Jogador> eFora){
        int resp = 0;
        double habCasa = 0;
        double habFora = 0;

        for(Jogador j : eCasa){
            habCasa += j.calculaHabilidade();
        }
        habCasa = habCasa/11;

        for(Jogador j : eFora){
            habFora += j.calculaHabilidade();
        }
        habFora = habFora/11;

        if(habCasa < habFora){
            resp = 1;
        }

        return resp;
    }

    public void listarEquipas(){
        Map<String, Equipa> equipas = this.tsf.getEquipas();
        for(Map.Entry<String,Equipa> entry : equipas.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void listarJogadores(){
        Map<String, Jogador> jogadores = this.tsf.getJogadores();
        for(Map.Entry<String,Jogador> entry : jogadores.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void listarJogadoresEquipa(){
        System.out.println("Equipa: ");
        String equipa = scin.nextLine();

        if(this.tsf.existeEquipa(equipa)){
            Equipa team = this.tsf.getEquipa(equipa);

            for(Jogador j : team.getJogadores()){
                System.out.println(j.getCamisola()+" - "+j.getNome());
            }
        }
        else System.out.println("Equipa não se encontra na base de dados!");
    }

    public void transferirJogador(){
        System.out.println("Jogador a transferir: ");
        String jogador = scin.nextLine();
        System.out.println("Equipa destino: ");
        String equipaDestino = scin.nextLine();

        this.tsf.transfereJogador(jogador,equipaDestino);
    }

    public void salvarJogo(){
        System.out.println("Guardar com nome (Sem espaços): ");
        String progresso = scin.nextLine();

        try {
            p.escreverFicheiro("estados/"+progresso+".txt",tsf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
