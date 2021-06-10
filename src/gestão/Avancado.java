package gestão;

import java.util.List;

public class Avancado extends Jogador {

    private final double pVelocidade = 0.11;
    private final double pResistencia = 0.08;
    private final double pDestreza = 0.08;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.13;
    private final double pRemate = 0.15;
    private final double pCapacidadeDePasse = 0.08;


    public Avancado() {
        super();
    }

    public Avancado(String n, int nc, int vel, int res, int des, int imp, int jdc, int rem, int cdp) {
        super(n, nc, vel, res, des, imp, jdc, rem, cdp);
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    public String jogadorParaLinha(){
        return "Avancado:"+getNome()
                +","+getCamisola()
                +","+getVelocidade()
                +","+getResistencia()
                +","+getDestreza()
                +","+getImpulsao()
                +","+getJogoDeCabeca()
                +","+getRemate()
                +","+getCapacidadeDePasse();
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