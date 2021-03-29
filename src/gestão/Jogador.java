package gestão;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int idade;
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double impulsao;
    private double jogoCabeca;
    private double remate;
    private double capacidadePasse;
    private String posicao;
    private List<String> historial;

    public Jogador(String nome,int idade,double velocidade, double resistencia, double destreza, double impulsao, double jogoCabeca,
                   double remate,double capacidadePasse, String posicao, List<String> historial) {
        //completar
        setNome(nome);
        setIdade(idade);
        setHistorial(historial);
    }

    public String getNome() {
        //nao pode retornar nome
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRemate() {
        return remate;
    }

    public void setRemate(double remate) {
        this.remate = remate;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getDestreza() {
        return destreza;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public double getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(double impulsao) {
        this.impulsao = impulsao;
    }

    public double getJogoCabeca() {
        return jogoCabeca;
    }

    public void setJogoCabeca(double jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }

    public double getCapacidadePasse() {
        return capacidadePasse;
    }

    public void setCapacidadePasse(double capacidadePasse) {
        this.capacidadePasse = capacidadePasse;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    //rever isto
    public List<String> getHistorial() {
        //nao pode retornar apontador
        List<String>aux= new ArrayList<>();
        for(String h:historial){
            aux.add(h);
        }
        return aux;
    }

    public void setHistorial(List<String> historial) {
        this.historial = new ArrayList<>();
        for(String team : historial) this.historial.add(team);

    }


    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", velocidade=" + velocidade +
                ", resistencia=" + resistencia +
                ", destreza=" + destreza +
                ", impulsao=" + impulsao +
                ", jogoCabeca=" + jogoCabeca +
                ", remate=" + remate +
                ", capacidadePasse=" + capacidadePasse +
                ", posicao='" + posicao + '\'' +
                ", historial=" + historial +
                '}';
    }

    public void imprimeJogador(Jogador j){
        System.out.println("O jogador "+j.nome+"de "+j.idade+"anos foi criado");
    }
}