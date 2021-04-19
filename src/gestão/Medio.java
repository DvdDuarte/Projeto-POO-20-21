package gestão;

import java.util.List;

public class Medio extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.2;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.2;


    public Medio() {
        super();
    }

    public Medio(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist) {
        super(n, i, vel, res, des, imp, jdc, rem, cdp, hist);
    }

    public Medio(Medio m) {
        super(m);
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
        return super.toString();
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o.getClass() == this.getClass() || o == null) return false;

        Medio m = (Medio)o;
        return super.equals(o) && m.getPesoVelocidade() == this.pVelocidade
                && m.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && m.getPesoDestreza() == this.pDestreza
                && m.getPesoImpulsao() == this.pImpulsao
                && m.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && m.getPesoRemate() == this.pRemate
                && m.getPesoResistencia() == this.pResistencia;
    }

    public Medio clone() {
        return new Medio(this);
    }
}
