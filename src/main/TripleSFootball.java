package main;
import gestão.Jogador;
import gestão.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripleSFootball {
  private Map<String,Equipa> equipas;
 private Map<String,Jogador> jogadores;

  //resto das propriedades do jogo por definir

  //lista de equipas
    //lista de jogadores
    public TripleSFootball(){
      //construtor do estado do jogo inicial
      equipas= new HashMap<>();
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
    /*
    for (Map.Entry<String, Equipa>
            l : lista.entrySet()) {
      List<Equipa> lista_aux =
              new ArrayList<>(l.getValue());
      equipas.put(l.getKey(), lista_aux);
    }*/
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
    if(!existeJogadorNaEquipa(j,e)) equipas.get(e).addJogador(getjogador(j));
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
        Equipa e1= new Equipa(nome);
        //fazer algo
        return e1;
    }
  public Equipa criaEquipaFantasma(){
    Equipa e1= new Equipa();
    e1.setNome("fantasma");
    //adiciona a equipa
    return e1;
  }

    public Jogador criaJogador(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, String posicao){
      //rever argumentos
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
          j = new Avancado(n, i, vel, res, des, imp, jdc, rem, cdp, h);
          break;
        case "Lateral":
          j = new Lateral(n, i, vel, res, des, imp, jdc, rem, cdp, h);
          break;
        default:
          return null;
      }
      //acrescentar j a equipa fantasma

      return j;
    }
    public Jogador criaGuardaRedes(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, Double elas){
      List<String> h= new ArrayList<>();
      h.add("fantasma");
      Jogador j=new GuardaRedes(n,i,vel,res,des,imp,jdc,rem,cdp,elas,h);
      //acrescentar j a equipa fantasma

      return j;
    }

//
// !!!! Funçaõ contem informação de outro projeto !!!!
//
    public void transfereJogador(String nomeJ,String nomeEVelha, String nomeENova){
      if(!existeEquipa(nomeENova)) criaEquipa(nomeENova);
      //if(!equipas.get(nomeENova).equipaTemJogador(nomeJ)) equipas.get(nomeENova).addJogador(jogadores.get(nomeJ));;
        //retira jogador da lista de jogadores da equipa eAntiga
       //equipas.get(nomeEVelha).removeJogador(nomeJ);
        //acrescenta jogador a lista de jogadores da equipa eNova
       //acrescenta equipa eNova ao final do historial do jogador j

    }
    public TripleSFootball clone(){
      return new TripleSFootball(this);
    }

    public void apagaJogador(String nomeJ){
        //usa o nome para identificar o objeto Jogador j


        //caso jogador j esteja na equipa fantasma
    }
    public void apagaEquipa(String nomeE){
      //usa o nome para identificar o objeto Equipa E

      //caso a Equipa E tenha sido criada pelo utilizador
    }


}