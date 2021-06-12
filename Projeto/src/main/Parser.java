package main;
import gestão.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    public static Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
    public static Map<String, Jogador> jogadores = new HashMap<>(); //numero, jogador
    public static List<Jogo> jogos = new ArrayList<>();

    public static void parse(String ficheiro) throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro(ficheiro);

        Equipa ultima = null; Jogador j = null;
        String[] linhaPartida;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    j.addToHistorial(ultima.getNome());
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    j.addToHistorial(ultima.getNome());
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    j.addToHistorial(ultima.getNome());
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    j.addToHistorial(ultima.getNome());
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    j.addToHistorial(ultima.getNome());
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }

    }

    public Map<String, Equipa> getEquipas(){
        Map<String, Equipa> aux = new HashMap<>();

        for(Map.Entry<String,Equipa> entry : equipas.entrySet()){
            aux.put(entry.getKey(),entry.getValue().clone());
        }

        return aux;
    }

    public Map<String, Jogador> getJogadores(){
        Map<String, Jogador> aux = new HashMap<>();

        for(Map.Entry<String,Jogador> entry : jogadores.entrySet()){
            aux.put(entry.getKey(),entry.getValue().clone());
        }

        return aux;
    }

    public List<Jogo> getJogos(){
        List<Jogo> aux = new ArrayList<>();

        for(Jogo j : jogos){
            aux.add(j);
        }

        return aux;
    }

    public void escreverFicheiro(String nomeFicheiro, TripleSFootball tsf) throws IOException{
        FileWriter writer = new FileWriter(nomeFicheiro);
        List<String> linhas = estadoParaLista(tsf);
        for(String str: linhas) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static List<String> estadoParaLista(TripleSFootball tsf){
        List<String> aux = new ArrayList<>();

            for(Map.Entry<String,Equipa> entry : tsf.getEquipas().entrySet()){
                aux.add("Equipa:"+entry.getKey());
                for(Jogador j : entry.getValue().getJogadores()){
                    aux.add(j.jogadorParaLinha());
                }
            }

            for(Jogo j : tsf.getJogos()){
                aux.add(j.toString());
            }

        return aux;
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) {
            System.out.println("Ficheiro não encontrado!");
            lines = new ArrayList<>(); }
        return lines;
    }


}
