package gestão;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Equipa {

    private String nome;
    private List<Jogador> jogadores;

    public Equipa() {

        this.nome = "";
        this.jogadores = new ArrayList<>();

    }
    public Equipa(String nome) {

        setNome(nome);
        this.jogadores = new ArrayList<>();

    }

    public Equipa(String nome, List<Jogador> jogadores) {

        this.nome = nome;
        this.setJogadores(jogadores);
    }

    public Equipa (Equipa equipa) {

        this.nome = equipa.getNome();
        this.jogadores = equipa.getJogadores();

    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public List<Jogador> getJogadores() {

        return this.jogadores.stream().map(j->j.clone()).collect(Collectors.toList());
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

    public Jogador getJogadorByNumber(int number){
        for(Jogador j : jogadores){
            if(j.getCamisola() == number){
                return j;
            }
        }
        return null;
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
//rever aqui, para ficar mais especifico
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


    //Definir função que calcula o nive lde habilidade da equipa titular (ex: recebe lista de jogardores, soma os niveos de habilidade individuais e divide pelo total do array que deve ser 11 :) )

    // Definir após ser definida habilidade_jogador na classe Jogador
    public double habilidade_Equipa () {
        int tamanho_equipa = jogadores.size();

        double sum = 0;

        for(Jogador j : jogadores){
            sum += j.calculaHabilidade();
        }

        sum = sum/tamanho_equipa;


        return sum;
    }

    public Equipa clone() {

        return new Equipa(this);
    }
}
