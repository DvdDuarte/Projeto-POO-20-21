package gestão;

import java.util.List;

public class Medio extends Jogador {

    private final double pVelocidade = 0.11;
    private final double pResistencia = 0.12;
    private final double pDestreza = 0.12;
    private final double pImpulsao = 0.09;
    private final double pJogoDeCabeca = 0.09;
    private final double pRemate = 0.13;
    private final double pCapacidadeDePasse = 0.16;
    private final double pRecuperacao = 0.18;

    private int recuperacao;



    public Medio() {
        super();
    }

    public Medio(String n, int nc, int vel, int res, int des, int imp, int jdc, int rem, int cdp, int rec) {
        super(n, nc, vel, res, des, imp, jdc, rem, cdp);
        this.recuperacao = rec;
    }

    public Medio(Medio m) {
        super(m);
        this.recuperacao = m.getRecuperacao();
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public String jogadorParaLinha(){
        return "Medio:"+getNome()
                +","+getCamisola()
                +","+getVelocidade()
                +","+getResistencia()
                +","+getDestreza()
                +","+getImpulsao()
                +","+getJogoDeCabeca()
                +","+getRemate()
                +","+getCapacidadeDePasse()
                +","+this.recuperacao;
    }

    public int getRecuperacao(){
        return this.recuperacao;
    }

    public double getPesoRecuperacao(){
        return this.pRecuperacao;
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
        return super.toString()+"\nRecuperacao: "+this.recuperacao+"\n";
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o.getClass() != this.getClass() || o == null) return false;

        Medio m = (Medio)o;
        return super.equals(o) && m.getPesoVelocidade() == this.pVelocidade
                && m.getPesoCapacidadeDePasse() == this.pCapacidadeDePasse
                && m.getPesoDestreza() == this.pDestreza
                && m.getPesoImpulsao() == this.pImpulsao
                && m.getPesoJogoDeCabeca() == this.pJogoDeCabeca
                && m.getPesoRemate() == this.pRemate
                && m.getPesoResistencia() == this.pResistencia
                && m.getPesoRecuperacao() == this.pRecuperacao
                && m.getRecuperacao() == this.recuperacao;
    }

    public Medio clone() {
        return new Medio(this);
    }
}
