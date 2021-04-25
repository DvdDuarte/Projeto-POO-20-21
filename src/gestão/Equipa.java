package gestão;

import java.util.ArrayList;
import java.util.List;


public class Equipa {

    private String nome;
    private ArrayList<Jogador> jogadores;
    private Jogador[] titulares;
    private Jogador[] reservas;


    public Equipa() {

        this.nome = "";
        this.jogadores = new ArrayList<Jogador>();
        this.titulares = new Jogador[11];
        this.reservas = new Jogador[7];

    }
    public Equipa(String nome) {

        setNome(nome);
        this.jogadores = new ArrayList<Jogador>();
        this.titulares = new Jogador[11];
        this.reservas = new Jogador[7];

    }

    public Equipa(String nome, List<Jogador> jogadores, Jogador[] titulares, Jogador[] reservas) {

        this.nome = nome;
        this.setJogadores(jogadores);
        this.setTitulares(titulares);
        this.setReservas(reservas);

    }

    public Equipa (Equipa equipa) {

        this.nome = equipa.getNome();
        this.jogadores = equipa.getJogadores();
        this.titulares = equipa.getTitulares();
        this.reservas = equipa.getReservas();

    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public ArrayList<Jogador> getJogadores() {

        return this.jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {

        this.jogadores = new ArrayList<>();

            for (Jogador l : jogadores) {

                this.jogadores.add(l.clone());

            }

    }

    public Jogador[] getTitulares() {

        return titulares;

    }

    public void setTitulares(Jogador[] titulares) {

        this.titulares = titulares;

    }

    public Jogador[] getReservas() {

        return reservas;

    }

    public void setReservas(Jogador[] reservas) {

        this.reservas = reservas;

    }

//rever!!!
    public Equipa clone() {

        return new Equipa(this);

    }


    public void addJogador(Jogador jogador) {

        this.jogadores.add(jogador);

    }

}
