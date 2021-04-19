package gestão;

import java.util.List;

public class GuardaRedes extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.2;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.2;
    private final double pElasticidade = 0.1;
    private double elasticidade;


    public GuardaRedes() {
        super();
        this.elasticidade = 70;
    }

    public GuardaRedes(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp,double e, List<String> hist) {
        super(n, i, vel, res, des, imp, jdc, rem, cdp, hist);
        this.elasticidade = e;
    }

    public GuardaRedes(GuardaRedes gr) {
        super(gr);
        this.elasticidade = gr.getElasticidade();
    }

    public double getElasticidade(){
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


    public String toString() {
        return super.toString()+"\nElasticidade: "+this.elasticidade;
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