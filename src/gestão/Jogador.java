package gestão;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jogador {

    private String nome;
    private int idade;
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double impulsao;
    private double jogoDeCabeca;
    private double remate;
    private double capacidadeDePasse;
    private List<String> historial;

    public Jogador() {

        this.nome = "Jogador";
        this.idade = 20;
        this.velocidade = 70;
        this.resistencia = 70;
        this.destreza = 70;
        this.impulsao = 70;
        this.jogoDeCabeca = 70;
        this.remate = 70;
        this.capacidadeDePasse = 70;
        this.historial = new ArrayList<>();

    }

    public Jogador(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist) {

        this.nome = n;
        this.idade = i;
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.jogoDeCabeca = jdc;
        this.remate = rem;
        this.capacidadeDePasse = cdp;
        setHistorial(hist);

    }

    public Jogador(Jogador j) {

        this.nome = j.getNome();
        this.idade = j.getIdade();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogoDeCabeca = j.getJogoDeCabeca();
        this.remate = j.getRemate();
        this.capacidadeDePasse = j.getCapacidadeDePasse();
        this.historial = j.getHistorial();

    }


    public String getNome() {

        return nome;

    }

    public int getIdade() {

        return idade;

    }

    public double getVelocidade() {

        return velocidade;

    }

    public double getResistencia() {

        return resistencia;

    }

    public double getDestreza() {

        return destreza;

    }

    public double getImpulsao() {

        return impulsao;

    }

    public double getJogoDeCabeca() {

        return jogoDeCabeca;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public double getRemate() {

        return remate;

    }

    public double getCapacidadeDePasse() {

        return capacidadeDePasse;

    }

    public List<String> getHistorial() {

        return this.historial;

    }

    public void setIdade(int idade) {

        this.idade = idade;

    }

    public void setVelocidade(double velocidade) {

        this.velocidade = velocidade;

    }

    public void setResistencia(double resistencia) {

        this.resistencia = resistencia;

    }

    public void setDestreza(double destreza) {

        this.destreza = destreza;

    }

    public void setImpulsao(double impulsao) {

        this.impulsao = impulsao;

    }

    public void setJogoDeCabeca(double jogoDeCabeca) {

        this.jogoDeCabeca = jogoDeCabeca;

    }

    public void setRemate(double remate) {

        this.remate = remate;

    }

    public void setCapacidadeDePasse(double capacidadeDePasse) {

        this.capacidadeDePasse = capacidadeDePasse;

    }

    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>();
        for (String s : historial) {
            this.historial.add(s);
        }
    }
//public void add2Historial(String equipa){//adiciona a nova equipa ao historial de um jogador}

    public String toString() {

        return "Nome :" + this.nome +
                "\nIdade :" + this.idade +
                "\nVelocidade :" + this.velocidade +
                "\nResistencia :" + this.resistencia +
                "\nDestreza :" + this.destreza +
                "\nImpulsao :" + this.impulsao +
                "\nJogo De Cabeça :" + this.jogoDeCabeca +
                "\nRemate :" + this.remate +
                "\nCapacidade De Passe :" + this.capacidadeDePasse +
                "\nHistorial :" + this.historial.toString();

    }

    public boolean equals(Object o) {

        if (this == o) {

            return true;

        }

        if (o == null || this.getClass() != o.getClass()) {

            return false;

        }

        Jogador j = (Jogador) o;

        return j.getNome() == this.nome && j.getIdade() == this.idade && j.getVelocidade() == this.velocidade &&
                j.getDestreza() == this.destreza && j.getImpulsao() == this.impulsao && j.getJogoDeCabeca() == this.jogoDeCabeca &&
                j.getResistencia() == this.resistencia && j.getRemate() == this.remate && j.getCapacidadeDePasse() == this.capacidadeDePasse &&
                this.historial.equals(j.getHistorial());

    }

    public Jogador clone(){

        return new Jogador(this);

    }

}
