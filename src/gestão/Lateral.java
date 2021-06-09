package gestão;

import java.util.List;

public class Lateral extends Jogador {

    private final double pVelocidade = 0.14;
    private final double pResistencia = 0.14;
    private final double pDestreza = 0.14;
    private final double pImpulsao = 0.07;
    private final double pJogoDeCabeca = 0.07;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.14;
    private final double pCruzamento = 0.20;

    private double cruzamento;


    public Lateral() {
        super();
    }

    public Lateral(String n, int nc, int vel, int res, int des, int imp, int jdc, int rem, int cdp, int cruz) {
        super(n, nc, vel, res, des, imp, jdc, rem, cdp);
        this.cruzamento = cruz;
    }

    public Lateral(Lateral l) {
        super(l);
        this.cruzamento = l.getCruzamento();
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public double getPesoCruzamento(){
        return this.pCruzamento;
    }

    public double getCruzamento(){
        return this.cruzamento;
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
        double habilidade = 0;

        habilidade = super.getRemate()*this.pRemate + super.getCapacidadeDePasse()*this.pCapacidadeDePasse
                + super.getDestreza()*this.pDestreza + super.getImpulsao()*this.pImpulsao
                + super.getJogoDeCabeca()*this.pJogoDeCabeca + super.getResistencia()*this.pResistencia
                + super.getVelocidade()*this.pVelocidade;

        return habilidade;
    }

    public String toString() {
        return super.toString()+"\nCruzamento: "+this.cruzamento+"\n";
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
                && l.getPesoResistencia() == this.pResistencia
                && l.getCruzamento() == this.cruzamento
                && l.getPesoCruzamento() == this.pCruzamento;
    }

    public Lateral clone() {
        return new Lateral(this);
    }
}