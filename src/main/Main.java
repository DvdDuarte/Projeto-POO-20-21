package main;
import gestão.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Parser p = new Parser();

        try {
            p.parse("./estados/output.txt");
        } catch (LinhaIncorretaException e) {
            e.printStackTrace();
        }

        TripleSFootball tsf = new TripleSFootball(p.getEquipas(),p.getJogadores(),p.getJogos());


        try {
            p.escreverFicheiro("./estados/estadoNovo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    File[] var = new File("./estados").listFiles();
        for(File f : var){
            if(f.isFile()) System.out.println(f.getName());
        }

    }
}
