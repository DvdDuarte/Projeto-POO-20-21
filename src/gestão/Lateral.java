package gestão;

import java.util.List;

public class Lateral extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.2;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.2;


    public Lateral() {
        super();
    }

    public Lateral(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist) {
        super(n, i, vel, res, des, imp, jdc, rem, cdp, hist);
    }

    public Lateral(Lateral l) {
        super(l);
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

        Lateral l = (Lateral)o;
        return super.equals(o) && l.getPesoVelocidade() == this.pVelocidade
                && l.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && l.getPesoDestreza() == this.pDestreza
                && l.getPesoImpulsao() == this.pImpulsao
                && l.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && l.getPesoRemate() == this.pRemate
                && l.getPesoResistencia() == this.pResistencia;
    }

    public Lateral clone() {
        return new Lateral(this);
    }
}