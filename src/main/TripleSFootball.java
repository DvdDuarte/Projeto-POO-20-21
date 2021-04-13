package main;
import gestão.Jogador;
import gestão.*;

import java.util.ArrayList;
import java.util.List;

public class TripleSFootball {
  private List<Equipa> equipas;

  //resto das propriedades do jogo por definir

    //private List<Jogador> jogadores;
    //lista de equipas
    //lista de jogadores
    public TripleSFootball(){
      //construtor do estado do jogo inicial
      this.equipas=new ArrayList<>();
    }
  public TripleSFootball(List<Equipa> lista){
    //construtor do estado do jogo inicial
    this.equipas=new ArrayList<>();
    setEquipas(lista);

  }

  public List<Equipa> getEquipas() {
    //rever
          return this.equipas;
  }


  public void setEquipas(List<Equipa> lista) {
    //rever
    for (Equipa e : lista) {
      this.equipas.add(e);
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
    public void apagaJogador(String nomeJ){
        //usa o nome para identificar o objeto Jogador j


        //caso jogador j esteja na equipa fantasma
    }
    public void apagaEquipa(String nomeE){
      //usa o nome para identificar o objeto Equipa E

      //caso a Equipa E tenha sido criada pelo utilizador
    }


}