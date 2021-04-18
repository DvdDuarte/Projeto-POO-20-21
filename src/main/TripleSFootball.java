package main;
import gestão.Jogador;
import gestão.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripleSFootball {
  private Map<String,List<Equipa>> equipas;
 //private Map<String,List<Jogador>> jogadores;

  //resto das propriedades do jogo por definir

  //lista de equipas
    //lista de jogadores
    public TripleSFootball(){
      //construtor do estado do jogo inicial
      equipas= new HashMap<>();
      //jogadores= new HashMap<>();
    }
  public TripleSFootball(Map<String,List<Equipa>> lista){
    //construtor do estado do jogo inicial
        setEquipas(lista);

  }
  public TripleSFootball(TripleSFootball tsf){
    setEquipas(tsf.getEquipas());
    }

  public Map<String,List<Equipa>> getEquipas() {
    //rever
          return this.equipas;
  }


  public void setEquipas(Map<String,List<Equipa>> lista) {
    //rever
    equipas = new HashMap();
    for (Map.Entry<String, List<Equipa>>
            l : lista.entrySet()) {
      List<Equipa> lista_aux =
              new ArrayList<>(l.getValue());
      equipas.put(l.getKey(), lista_aux);
    }
  }
  //tambem criar equipa fantasma
    public Equipa criaEquipa(){
        //rever argumentos
        Equipa e1= new Equipa();
        //fazer algo
        return e1;
    }
  public Equipa criaEquipaFantasma(){
    Equipa e1= new Equipa();
    e1.setNome("fantasma");
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
      Jogador j=new GuardaRedes(n,i,vel,res,des,imp,jdc,rem,cdp,h,elas);
      //acrescentar j a equipa fantasma

      return j;
    }

    public void transfereJogador(String nomeJ,String nomeEVelha, String nomeENova){
       //usa os nomes para identificar os objetos Jogador j, Equipa eAntiga e Equipa eNova
       //procurar o jogador pelo nome
       //procurar equipas pelo nome
       //retira jogador da lista de jogadores da equipa eAntiga
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