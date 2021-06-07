package gestão;

import java.util.List;

public class Defesa extends Jogador {

    private final double pVelocidade = 0.08;
    private final double pResistencia = 0.11;
    private final double pDestreza = 0.07;
    private final double pImpulsao = 0.13;
    private final double pJogoDeCabeca = 0.13;
    private final double pRemate = 0.07;
    private final double pCapacidadeDePasse = 0.11;
    private final double pCorte = 0.15;
    private final double pMarcacao = 0.15;

    private double corte;
    private double marcacao;


    public Defesa() {
        super();
    }

    public Defesa(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist) {
        super(n, i, vel, res, des, imp, jdc, rem, cdp, hist);
    }

    public Defesa(Defesa d) {
        super(d);
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
                + super.getVelocidade()*this.pVelocidade;

        return habilidade;
    }

    public String toString() {
        return super.toString();
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o.getClass() != this.getClass() || o == null) return false;

        Defesa d = (Defesa)o;
        return super.equals(o) && d.getPesoVelocidade() == this.pVelocidade
                && d.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && d.getPesoDestreza() == this.pDestreza
                && d.getPesoImpulsao() == this.pImpulsao
                && d.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && d.getPesoRemate() == this.pRemate
                && d.getPesoResistencia() == this.pResistencia;
    }

    public Defesa clone() {
        return new Defesa(this);
    }

}
