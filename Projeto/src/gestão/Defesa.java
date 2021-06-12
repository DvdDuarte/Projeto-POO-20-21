package gestão;

import java.util.List;

public class Defesa extends Jogador {

    private final double pVelocidade = 0.08;
    private final double pResistencia = 0.22;
    private final double pDestreza = 0.12;
    private final double pImpulsao = 0.16;
    private final double pJogoDeCabeca = 0.20;
    private final double pRemate = 0.10;
    private final double pCapacidadeDePasse = 0.12;



    public Defesa() {
        super();
    }

    public Defesa(String n, int nc, int vel, int res, int des, int imp, int jdc, int rem, int cdp) {
        super(n, nc, vel, res, des, imp, jdc, rem, cdp);
    }

    public Defesa(Defesa d) {
        super(d);
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    public String jogadorParaLinha(){
        return "Defesa:"+getNome()
                +","+getCamisola()
                +","+getVelocidade()
                +","+getResistencia()
                +","+getDestreza()
                +","+getImpulsao()
                +","+getJogoDeCabeca()
                +","+getRemate()
                +","+getCapacidadeDePasse();
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
