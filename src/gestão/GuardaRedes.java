package gestão;

import java.util.List;

public class GuardaRedes extends Jogador {

    private final double pVelocidade = 0.05;
    private final double pResistencia = 0.08;
    private final double pDestreza = 0.11;
    private final double pImpulsao = 0.18;
    private final double pJogoDeCabeca = 0.11;
    private final double pRemate = 0.11;
    private final double pCapacidadeDePasse = 0.16;
    private final double pElasticidade = 0.20;

    private int elasticidade;


    public GuardaRedes() {
        super();
        this.elasticidade = 70;
    }

    public GuardaRedes(String n, int nc,int vel, int res, int des, int imp, int jdc, int rem, int cdp,int e) {
        super(n, nc, vel, res, des, imp, jdc, rem, cdp);
        this.elasticidade = e;
    }

    public GuardaRedes(GuardaRedes gr) {
        super(gr);
        this.elasticidade = gr.getElasticidade();
    }

    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public int getElasticidade(){
        return this.elasticidade;
    }

    public double getPesoElasticidade(){
        return this.pElasticidade;
    }

    public double getPesoVelocidade(){
        return pVelocidade;
    }

    public double getPesoResistencia(){
        return pResistencia;
    }

    public double getPesoDestreza(){
        return pDestreza;
    }

    public double getPesoImpulsao(){
        return pImpulsao;
    }

    public double getPesoJogoDeCabeca(){
        return pJogoDeCabeca;
    }

    public double getPesoRemate(){
        return pRemate;
    }

    public double getPesoCapacidadeDePasse(){
        return pCapacidadeDePasse;
    }

    public double calculaHabilidade(){
        double habilidade;

        habilidade = super.getRemate()*this.pRemate + super.getCapacidadeDePasse()*this.pCapacidadeDePasse
                + super.getDestreza()*this.pDestreza + super.getImpulsao()*this.pImpulsao
                + super.getJogoDeCabeca()*this.pJogoDeCabeca + super.getResistencia()*this.pResistencia
                + super.getVelocidade()*this.pVelocidade + this.elasticidade*this.pElasticidade;

        return habilidade;
    }

    public String toString() {
        return super.toString()+"\nElasticidade: "+this.elasticidade+"\n";
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o.getClass() != this.getClass() || o == null) return false;

        GuardaRedes gr = (GuardaRedes)o;
        return super.equals(o) && gr.getPesoVelocidade() == this.pVelocidade
                && gr.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && gr.getPesoDestreza() == this.pDestreza
                && gr.getPesoImpulsao() == this.pImpulsao
                && gr.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && gr.getPesoRemate() == this.pRemate
                && gr.getPesoResistencia() == this.pResistencia
                && gr.getElasticidade() == this.elasticidade
                && gr.getPesoElasticidade() == this.pElasticidade;
    }

    public GuardaRedes clone() {
        return new GuardaRedes(this);
    }
}