package main;

import static java.lang.System.nanoTime;
//calcula tempo de execucao

public class Crono {
    static long begin = 0L;
    static long end = 0L;

    public static void start() {
        end = 0L;
        begin = nanoTime();
    }

    public static double stop() {
        end = nanoTime();
        double elapsed_time = (end - begin) / 1E09;
        return elapsed_time;
    }
}