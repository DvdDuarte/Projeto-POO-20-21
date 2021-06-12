package gestão;

import java.util.ArrayList;
import java.util.List;

public abstract class Jogador {

    private String nome;
    private int camisola;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoDeCabeca;
    private int remate;
    private int capacidadeDePasse;
    private List<String> historial;

    public Jogador() {
        this.nome = "Jogador";
        this.camisola = 20;
        this.velocidade = 70;
        this.resistencia = 70;
        this.destreza = 70;
        this.impulsao = 70;
        this.jogoDeCabeca = 70;
        this.remate = 70;
        this.capacidadeDePasse = 70;
        this.historial = new ArrayList<>();
    }

    public Jogador(String n, int camisola, int vel, int res, int des, int imp, int jdc, int rem, int cdp) {

        this.nome = n;
        this.camisola = camisola;
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.jogoDeCabeca = jdc;
        this.remate = rem;
        this.capacidadeDePasse = cdp;
        this.historial = new ArrayList<>();

    }

    public Jogador(Jogador j) {

        this.nome = j.getNome();
        this.camisola = j.getCamisola();
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogoDeCabeca = j.getJogoDeCabeca();
        this.remate = j.getRemate();
        this.capacidadeDePasse = j.getCapacidadeDePasse();
        this.historial = j.getHistorial();

    }

    public abstract String jogadorParaLinha();

    public abstract double calculaHabilidade();

    public void addToHistorial(String nome){
        this.historial.add(nome);
    }

    public int getCamisola(){
        return this.camisola;
    }

    public void setCamisola(int n){
        this.camisola = n;
    }
    public String getNome() {

        return nome;

    }

    public int getVelocidade() {

        return velocidade;

    }

    public int getResistencia() {

        return resistencia;

    }

    public int getDestreza() {

        return destreza;

    }

    public int getImpulsao() {

        return impulsao;

    }

    public int getJogoDeCabeca() {

        return jogoDeCabeca;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public int getRemate() {

        return remate;

    }

    public int getCapacidadeDePasse() {

        return capacidadeDePasse;

    }

    public List<String> getHistorial() {

        return this.historial;

    }


    public void setVelocidade(int velocidade) {

        this.velocidade = velocidade;

    }

    public void setResistencia(int resistencia) {

        this.resistencia = resistencia;

    }

    public void setDestreza(int destreza) {

        this.destreza = destreza;

    }

    public void setImpulsao(int impulsao) {

        this.impulsao = impulsao;

    }

    public void setJogoDeCabeca(int jogoDeCabeca) {

        this.jogoDeCabeca = jogoDeCabeca;

    }

    public void setRemate(int remate) {

        this.remate = remate;

    }

    public void setCapacidadeDePasse(int capacidadeDePasse) {

        this.capacidadeDePasse = capacidadeDePasse;

    }

    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>();
        for (String s : historial) {
            this.historial.add(s);
        }
    }


    public String toString() {

        return "Nome :" + this.nome +
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

        return j.getNome() == this.nome && j.getVelocidade() == this.velocidade &&
                j.getDestreza() == this.destreza && j.getImpulsao() == this.impulsao && j.getJogoDeCabeca() == this.jogoDeCabeca &&
                j.getResistencia() == this.resistencia && j.getRemate() == this.remate && j.getCapacidadeDePasse() == this.capacidadeDePasse &&
                this.historial.equals(j.getHistorial());

    }

    public abstract Jogador clone();

}
