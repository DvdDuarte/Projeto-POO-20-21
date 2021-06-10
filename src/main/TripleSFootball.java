package main;

import gestão.*;
import gestão.Equipa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripleSFootball {
    private Map<String,Equipa> equipas;
    private Map<String,Jogador> jogadores;
    private List<Jogo> jogos;

    public TripleSFootball(){
        equipas= new HashMap<>();
        jogadores= new HashMap<>();
        jogos = new ArrayList<>();
    }
    public TripleSFootball(Map<String,Equipa> eqs, Map<String,Jogador> jogs, List<Jogo> jogos) {
        setEquipas(eqs);
        setJogadores(jogs);
        setJogos(jogos);
    }
    public TripleSFootball(TripleSFootball tsf){
        setEquipas(tsf.getEquipas());
        setJogadores(tsf.getJogadores());
        setJogos(tsf.getJogos());
    }

    public void addJogador(Jogador j){
        jogadores.put(j.getNome(),j);
    }

    public Map<String, Jogador> getJogadores() {
        return jogadores.entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
    }

    public void adicionarJogo(Jogo j){
        this.jogos.add(j);
    }

    public void setJogadores(Map<String, Jogador> jogs) {
        this.jogadores = new HashMap<>();
        jogadores= jogs.entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(),v->v.getValue().clone()));
    }

    public Map<String,Equipa> getEquipas() {

        return equipas.entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(),v->v.getValue().clone()));
    }

    public List<Jogo> getJogos(){
        return jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    public void setEquipas(Map<String,Equipa> lista) {

        this.equipas = new HashMap<>();

        this.equipas = lista
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(),v->v.getValue().clone()));


    }

    public void setJogos(List<Jogo> jogos){
        this.jogos = new ArrayList<>();

        for(Jogo j : jogos){
            this.jogos.add(j);
        }
    }

    public boolean existeJogador(String j){
        return jogadores.containsKey(j);
    }
    public boolean existeEquipa(String eq){
        return equipas.containsKey(eq);
    }
    public Jogador getjogador(String j){
        Jogador resp=null;
        if(existeJogador(j)){
            resp=jogadores.get(j).clone();
        }
        return resp;
    }
    public boolean existeJogadorNaEquipa(String j,String e){
        boolean resp=false;
        if(existeEquipa(e)&& existeJogador(j)){
            if(equipas.values().contains(j))resp=true;
        }
        return resp;
    }

    public Equipa getEquipa(String eq){
        Equipa resp;
        if(existeEquipa(eq)){
            resp=equipas.get(eq).clone();
        }else resp=null;
        return resp;
    }

    public void adicionaEquipa(Equipa eq){
        this.equipas.put(eq.getNome(),eq.clone());
    }

    public void transfereJogador(String nomeJ, String nomeENova){
        if(existeEquipa(nomeENova)) {
            if (equipas.get(nomeENova).equipaTemJogador(jogadores.get(nomeJ))) {
                System.out.println("O jogador já se encontra nesta equipa!");
            }else{
                if(jogadores.get(nomeJ).getHistorial().size()>0) {
                    String equipaVelha = jogadores.get(nomeJ).getHistorial().get(jogadores.get(nomeJ).getHistorial().size() - 1);
                    equipas.get(equipaVelha).removeJogador(jogadores.get(nomeJ));
                    equipas.get(nomeENova).addJogador(jogadores.get(nomeJ));
                    jogadores.get(nomeJ).addToHistorial(nomeENova);
                    System.out.println("Transferencia efetuada com sucesso!");
                }else{
                    equipas.get(nomeENova).addJogador(jogadores.get(nomeJ));
                    jogadores.get(nomeJ).addToHistorial(nomeENova);
                    System.out.println("Transferencia efetuada com sucesso!");
                }
            }
        }else{
            System.out.println("A equipa destino não se encontra na base de dados!");
        }
    }

    public TripleSFootball clone(){
        return new TripleSFootball(this);
    }

    public void apagaJogador(String nomeJ){
        //usa o nome para identificar o objeto Jogador j
        jogadores.remove(nomeJ);
        //caso jogador j esteja na equipa fantasma
    }
    public void apagaEquipa(String nomeE){
        //usa o nome para identificar o objeto Equipa E
        equipas.remove(nomeE);
        //caso a Equipa E tenha sido criada pelo utilizador
    }

}