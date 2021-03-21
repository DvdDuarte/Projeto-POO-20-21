package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TripleSFootball tsf = new TripleSFootball();
        Scanner in = new Scanner(System.in);
        int op = 0;


        do {
            System.out.println("1 - Criar equipa\n2 - Criar Jogador\n3 - Saír");
            op = in.nextInt();

            switch(op){
                case 1 :
                case 2 :
            }

        }while(op != 3);
    }
}
