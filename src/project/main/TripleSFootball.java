package project.main;
import project.gestão.Jogador;
import project.gestão.*;

import java.util.*;
import java.util.stream.Collectors;

public class TripleSFootball {
    private Map<String,Equipa> equipas;
    private Map<String,Jogador> jogadores;
    //private List<Jogo> jogos;

    public TripleSFootball(){
      //construtor do estado do jogo inicial
      equipas=new HashMap<>();
      Equipa f=criaEquipaFantasma();
      adicionaEquipa(f);
      jogadores= new HashMap<>();
    }
    public TripleSFootball(Map<String,Equipa> eqs, Map<String,Jogador> jogs) {
    //construtor do estado do jogo inicial
        setEquipas(eqs);
        setJogadores(jogs);
    }
    public TripleSFootball(TripleSFootball tsf){
    setEquipas(tsf.getEquipas());
    setJogadores(tsf.getJogadores());
    }

  public Map<String, Jogador> getJogadores() {
    return jogadores.entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
  }

  public void setJogadores(Map<String, Jogador> jogs) {
    this.jogadores = new HashMap<>();
    jogadores= jogs.entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(),v->v.getValue().clone()));
    }

  public Map<String,Equipa> getEquipas() {
    //rever
          return equipas.entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(), v->v.getValue().clone()));
  }

  public void setEquipas(Map<String,Equipa> lista) {
    //rever
    equipas = new HashMap();
    equipas =lista
            .entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(),v->v.getValue().clone()));
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
  public void adicionaJogNaEquipa(String j, String e){
      if(!existeEquipa(e)) criaEquipa(e);
      if(!equipas.get(e).equipaTemJogador(jogadores.get(j))) equipas.get(e).addJogador(jogadores.get(j));

      //acrescenta jogador a lista de jogadores da equipa eNova
      equipas.get(e).addJogador(jogadores.get(j));
      //acrescenta equipa eNova ao final do historial do jogador j
      jogadores.get(j).addToHistorial(e);

    }

  public Equipa getEquipa(String eq){
      Equipa resp;
      if(existeEquipa(eq)){
        resp=equipas.get(eq).clone();
      }else resp=null;
      return resp;
  }

    public void adicionaEquipa(Equipa eq){
        equipas.put(eq.getNome(),eq.clone());
    }
  //tambem criar equipa fantasma
    public Equipa criaEquipa(String nome){
        //rever argumentos
        if(existeEquipa(nome)) return null;
        Equipa e1= new Equipa(nome);
        adicionaEquipa(e1);
        return e1;//tem de retornar algo?
    }

  public Equipa criaEquipaFantasma(){
    Equipa e1= new Equipa();
    e1.setNome("fantasma");

    return e1;
  }
  public void adicionaJogador(Jogador j){
        jogadores.put(j.getNome(),j.clone());
  }
//rever com o Daniel
    public Jogador criaJogador(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, String posicao){
      //rever argumentos
        if(existeJogador(n)) return null;
      List<String> h= new ArrayList<>();
      h.add("fantasma");
      Jogador j;
      switch (posicao) {
        case "Defesa":
          j = new Defesa(n, i, vel, res, des, imp, jdc, rem, cdp, h);
          break;
        case "Medio":
          j = new Medio(n, i, vel, res, des, imp, jdc, rem, cdp, h);
          break;
        case "Avancado":
          j = new Avancado(n, i, vel, res, des, imp, jdc, rem, cdp,h);
          break;
        case "Lateral":
          j = new Lateral(n, i, vel, res, des, imp, jdc, rem, cdp, h);
          break;
        default:
          return null;
      }
      //acrescentar j a equipa fantasma

      return j;
    };


    public void transfereJogador(String nomeJ,String nomeEVelha, String nomeENova){
      adicionaJogNaEquipa(nomeJ,nomeENova);

      if(!existeEquipa(nomeENova)) criaEquipa(nomeENova);
      if(!equipas.get(nomeENova).equipaTemJogador(jogadores.get(nomeJ))) equipas.get(nomeENova).addJogador(jogadores.get(nomeJ));;
        //retira jogador da lista de jogadores da equipa eAntiga
        //acrescenta jogador a lista de jogadores da equipa eNova
       equipas.get(nomeENova).addJogador(jogadores.get(nomeJ));
       //acrescenta equipa eNova ao final do historial do jogador j
        jogadores.get(nomeJ).addToHistorial(nomeENova);

        //retira jogador da lista de jogadores da equipa eAntiga
        equipas.get(nomeEVelha).removeJogador(jogadores.get(nomeJ));
    }
    public TripleSFootball clone(){
      return new TripleSFootball(this);
    }

    public void apagaJogador(String nomeJ){
        //usa o nome para identificar o objeto Jogador j
        jogadores.remove(nomeJ);
        equipas.get("fantasma").removeJogador(jogadores.get(nomeJ));
        //apenas caso jogador j esteja na equipa fantasma?
    }
    public void apagaEquipa(String nomeE){
      //usa o nome para identificar o objeto Equipa E
        equipas.remove(nomeE);
      //caso a Equipa E tenha sido criada pelo utilizador
    }


}