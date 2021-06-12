package gestão;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 */


public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substituicoesFora = new HashMap<>();

    /*
    public Jogo(String ec,String ef){
        setEquipaCasa(ec);
        setEquipaFora(ef);
        setDate(date.withDayOfMonth(3));

    }
    */

    public Jogo(){
        this.equipaCasa = "Chelsea";
        this.equipaFora = "Manchester City";
        this.golosCasa = 1;
        this.golosFora = 0;
        this.date = LocalDate.of(2021,5,29);
        this.jogadoresCasa = new ArrayList<>();
        this.jogadoresFora = new ArrayList<>();
        this.substituicoesCasa = new HashMap<>();
        this.substituicoesFora = new HashMap<>();
    }

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        setJogadoresCasa(jc);
        setJogadoresFora(jf);
        setSubstituicoesCasa(sc);
        setSubstitucoesFora(sf);
    }

    public Jogo(Jogo j){
        setEquipaCasa(j.getEquipaCasa());
        setEquipaFora(j.getEquipaFora());
        setGolosCasa(j.getGolosCasa());
        setGolosFora(j.getGolosFora());
        setDate(j.getDate());
        setJogadoresCasa(j.getJogadoresCasa());
        setJogadoresFora(j.getJogadoresFora());
        setSubstituicoesCasa(j.getSubstituicoesCasa());
        setSubstitucoesFora(j.getSubstitucoesFora());
    }

    /*
    public Jogo calculaResultado(Jogo j){
        1 - calcular habilidade dos 11's;
        2 - calcular se marcam golo ou não;
        3 - atualizar Jogo j;
        4 - devolver Jogo j;
    }
     */

    /*
    public Jogo partida(Jogo j){
        Jogo segundaParte = calculaResultado(j);
        1 - Verificar substituições ( efetuar )
        calculaResultado(segundaParte);
        Devolve jogo finalizado;
    }
     */

    public String getEquipaCasa() { return equipaCasa; }

    public void setEquipaCasa(String equipaCasa) { this.equipaCasa = equipaCasa; }

    public String getEquipaFora() { return equipaFora; }

    public void setEquipaFora(String equipaFora) { this.equipaFora = equipaFora; }

    public int getGolosCasa() { return golosCasa; }

    public void setGolosCasa(int golosCasa) { this.golosCasa = golosCasa; }

    public int getGolosFora() { return golosFora; }

    public void setGolosFora(int golosFora) { this.golosFora = golosFora; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public List<Integer> getJogadoresCasa() {
        List<Integer> resp;
        return jogadoresCasa; }

    public void setJogadoresCasa(List<Integer> jogadoresCasa) {
        this.jogadoresCasa = new ArrayList<>();

        for(Integer i : jogadoresCasa){
            this.jogadoresCasa.add(i);
        }
    }

    public List<Integer> getJogadoresFora() { return jogadoresFora; }

    public void setJogadoresFora(List<Integer> jogsFora) {
        this.jogadoresFora = new ArrayList<>();
        for (Integer i : jogsFora)
            this.jogadoresFora.add(i);
    }

    public Map<Integer, Integer> getSubstituicoesCasa() { return substituicoesCasa
            .entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(),v->v.getValue())); }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : substituicoesCasa.entrySet()){
            this.substituicoesCasa.put(entry.getKey(),entry.getValue());
        }
    }


    public Map<Integer, Integer> getSubstitucoesFora() {

        return substituicoesFora.entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(), v->v.getValue()));
    }

    public void setSubstitucoesFora(Map<Integer, Integer> substituicoesFora) {
        this.substituicoesFora = new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : substituicoesFora.entrySet()){
            this.substituicoesFora.put(entry.getKey(),entry.getValue());
        }
    }

    public void alteraTitulares(Integer out,Integer in){
        //
        jogadoresCasa.remove(out);
        jogadoresCasa.add(in);
    }

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }

        public static List<String> substituicoesParaLinha(Map<Integer,Integer> subs){
            List<String> aux = new ArrayList<>();

            for(Map.Entry<Integer,Integer> entry : subs.entrySet()){
                aux.add(entry.getKey()+"->"+entry.getValue());
            }

        return aux;
        }

        public static String auxString(List<String> subs){
            StringBuilder sb = new StringBuilder();
            for(String s : subs){
                sb.append(","+s);
            }
            return sb.toString();
        }
//<EquipaCasa>,<EquipaFora>,<ScoreCasa>,<ScoreFora>,<Data>,<JogadoresCasa>,<SubstituicoesCasa>,<JogadoresFora>,<SubstituicoesFora>
    public String toString() {
        return  "Jogo:"+equipaCasa
                +","+equipaFora
                +","+golosCasa
                +","+golosFora
                +","+date
                +","+jogadoresCasa.get(0)
                +","+jogadoresCasa.get(1)
                +","+jogadoresCasa.get(2)
                +","+jogadoresCasa.get(3)
                +","+jogadoresCasa.get(4)
                +","+jogadoresCasa.get(5)
                +","+jogadoresCasa.get(6)
                +","+jogadoresCasa.get(7)
                +","+jogadoresCasa.get(8)
                +","+jogadoresCasa.get(9)
                +","+jogadoresCasa.get(10)
                +auxString(substituicoesParaLinha(substituicoesCasa))
                +","+jogadoresFora.get(0)
                +","+jogadoresFora.get(1)
                +","+jogadoresFora.get(2)
                +","+jogadoresFora.get(3)
                +","+jogadoresFora.get(4)
                +","+jogadoresFora.get(5)
                +","+jogadoresFora.get(6)
                +","+jogadoresFora.get(7)
                +","+jogadoresFora.get(8)
                +","+jogadoresFora.get(9)
                +","+jogadoresFora.get(10)
                +auxString(substituicoesParaLinha(substituicoesFora));

                //+ " -> " + substituicoesCasa.toString()
                //+ " -> " + substitucoesFora.toString();
    }

    public Jogo clone(){
        return new Jogo(this);
    }


}
