package main;

import gestão.Jogador;

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
    Map<Integer, Integer> substitucoesFora = new HashMap<>();

    /*
    public Jogo(String ec,String ef){
        setEquipaCasa(ec);
        setEquipaFora(ef);
        setDate(date.withDayOfMonth(3));

    }
    */
    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    public Jogo(Jogo j){
        setEquipaCasa(getEquipaCasa());
        setEquipaFora(getEquipaFora());
        setGolosCasa(getGolosCasa());
        setGolosFora(getGolosFora());
        setDate(getDate());
        setJogadoresCasa(getJogadoresCasa());
        setJogadoresFora(getJogadoresFora());
        setSubstituicoesCasa(getSubstituicoesCasa());
        setSubstitucoesFora(getSubstitucoesFora());
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
//rever
    public List<Integer> getJogadoresCasa() {
        List<Integer> resp;
        return jogadoresCasa; }
//rever
    public void setJogadoresCasa(List<Integer> jogadoresCasa) {
        this.jogadoresCasa = jogadoresCasa;
    }
//rever
    public List<Integer> getJogadoresFora() { return jogadoresFora; }
//rever
    public void setJogadoresFora(List<Integer> jogsFora) {
        this.jogadoresFora = new ArrayList<>();
        for (Integer i : jogsFora)
            this.jogadoresFora.add(i);
    }
//rever
    public Map<Integer, Integer> getSubstituicoesCasa() { return substituicoesCasa
            .entrySet()
            .stream()
            .collect(Collectors.toMap(k->k.getKey(),v->v.getValue())); }
//rever
    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa; }


    public Map<Integer, Integer> getSubstitucoesFora() {

        return substitucoesFora.entrySet()
                .stream()
                .collect(Collectors.toMap(k->k.getKey(), v->v.getValue()));
    }
//rever
    public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {

        this.substitucoesFora = substitucoesFora;
    }

    /*
    public boolean substituiJogador(int out, int in){
    }*/
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


    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
                //+ " -> " + substituicoesCasa.toString()
                //+ " -> " + substitucoesFora.toString();
    }


}
