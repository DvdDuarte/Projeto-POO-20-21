package gestão;

import java.util.ArrayList;
import java.util.List;


public class Equipa {

    private String nome;
    private ArrayList<Jogador> jogadores;

    public Equipa() {

        this.nome = "";
        this.jogadores = new ArrayList<Jogador>();

    }
    public Equipa(String nome) {

        setNome(nome);
        this.jogadores = new ArrayList<Jogador>();

    }

    public Equipa(String nome, List<Jogador> jogadores) {

        this.nome = nome;
        this.setJogadores(jogadores);
    }

    public Equipa (Equipa equipa) {

        this.nome = equipa.getNome();
        this.jogadores = equipa.getJogadores();

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

    public void addJogador(Jogador jogador) {

        this.jogadores.add(jogador);

    }

    public boolean equipaTemJogador(Jogador jogador){


        for (int i = 0; i < this.jogadores.size() ; i++) {

            if (jogadores.get(i).equals(jogador))

                return true;
        }

        return false;
    }

    public void  removeJogador(Jogador jogador){

        if(equipaTemJogador(jogador)) {

            for (int i = this.jogadores.size() - 1; i >= 0; i--) {

                if (jogadores.get(i).equals(jogador)) jogadores.remove(i);

            }
        }
    }

    public String toString() {

        return "Nome: " + this.nome +
                "\nJogadores: " + this.jogadores.toString();

    }

    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || this.getClass() != o.getClass()) {

            return false;

        }

        Equipa t = (Equipa) o;

        return t.getNome() == this.nome &&
                this.jogadores.equals(t.getJogadores());

    }


    // Definir após ser definida habilidade_jogador na classe Jogador
    public int habilidade_Equipa (Equipa e) {

        int tamanho_equipa = e.jogadores.size();

      //  int habilidade_total_jogadores = ..... ;

       // int habilidade_equipa = habilidade_total_jogadores / tamanho_equipa;

     //   return habilidade_equipa;
        return 0;
    }

    public Equipa clone() {

        return new Equipa(this);
    }
}
