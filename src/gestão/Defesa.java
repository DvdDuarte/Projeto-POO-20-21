package gestão;

import java.util.List;

public class Defesa extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.2;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.2;


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


    public String toString() {
        return super.toString();
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o.getClass() == this.getClass() || o == null) return false;

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
