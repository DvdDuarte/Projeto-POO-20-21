package gestão;

import java.util.List;

public class GuardaRedes extends Jogador {

    private final double pVelocidade = 0.2;
    private final double pResistencia = 0.2;
    private final double pDestreza = 0.1;
    private final double pImpulsao = 0.1;
    private final double pJogoDeCabeca = 0.1;
    private final double pRemate = 0.1;
    private final double pCapacidadeDePasse = 0.2;
    private double elasticidade;


    public GuardaRedes(){
        super();
        this.elasticidade = 70;
    }

    public GuardaRedes(String n, int i, double vel, double res, double des, double imp, double jdc, double rem, double cdp, List<String> hist,double elas){
        super(n,i,vel,res,des,imp,jdc,rem,cdp,hist);
        this.elasticidade = elas;
    }

    public GuardaRedes(GuardaRedes a){
        super(a.getNome(),a.getIdade(),a.getVelocidade(),a.getResistencia(),a.getDestreza(),a.getImpulsao(),a.getJogoDeCabeca(),a.getRemate(),a.getCapacidadeDePasse(),a.getHistorial());
        this.elasticidade = a.getElasticidade();
    }

    public double getElasticidade(){
        return this.elasticidade;
    }

    public void setElasticidade(double elas){
        this.elasticidade = elas;
    }

    public String toString(){
        return super.toString()+
                "\nElasticidade :"+this.elasticidade;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        GuardaRedes gr = (GuardaRedes)o;
        return gr.getNome() == this.getNome();
    }

    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }
}
