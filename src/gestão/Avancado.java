package gestão;

import java.util.List;

public class Avancado extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.1;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.2;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.2;
    private final double pCapacidadeDePasse = 0.1;


    public Avancado() {
        super();
    }

    public Avancado(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist) {
        super(n, i, vel, res, des, imp, jdc, rem, cdp, hist);
    }

    public Avancado(Avancado a) {
        super(a);
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

        Avancado a = (Avancado)o;
        return super.equals(o) && a.getPesoVelocidade() == this.pVelocidade
                && a.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && a.getPesoDestreza() == this.pDestreza
                && a.getPesoImpulsao() == this.pImpulsao
                && a.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && a.getPesoRemate() == this.pRemate
                && a.getPesoResistencia() == this.pResistencia;
    }

    public Avancado clone() {
        return new Avancado(this);
    }
}