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


    public Defesa(){
        super();
    }

    public Defesa(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist){
        super(n,i,vel,res,des,imp,jdc,rem,cdp,hist);
    }

    public Defesa(Defesa a){
        super(a.getNome(),a.getIdade(),a.getVelocidade(),a.getResistencia(),a.getDestreza(),a.getImpulsao(),a.getJogoDeCabeca(),a.getRemate(),a.getCapacidadeDePasse(),a.getHistorial());
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object o){
        return super.equals(o);
    }

    public Defesa clone(){
        return new Defesa(this);
    }
}
