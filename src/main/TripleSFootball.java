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


    //tambem criar equipa fantasma
    public void criaEquipa(){
        //rever argumentos
        //Equipa e1= new Equipa();


    }


    public void criaJogador(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp){
      //rever argumentos
      //falta definir posicao do jogador
      Jogador j1= new Jogador();
      j1.setNome(n);
      j1.setIdade(i);
      j1.setDestreza(des);
      j1.setCapacidadeDePasse(cdp);
      j1.setJogoDeCabeca(jdc);
      j1.setVelocidade(vel);
      j1.setResistencia(res);
      j1.setImpulsao(imp);
      j1.setRemate(rem);

      List<String> h= new ArrayList<>();
      h.add("fantasma");
      j1.setHistorial(h);

    }
    public void transfereJogador(String nomeJ, String nomeENova){
        //usa os nomes para identificar os objetos Jogador j, Equipa eAntiga e Equipa eNova


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