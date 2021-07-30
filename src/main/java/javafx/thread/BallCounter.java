package javafx.thread;

public class BallCounter {
    //volatile powoduje, że wartość pola jest zawsze odczytywana z pamięci (brak cache'wania)
    private volatile int counter;
    //synchronized uniemożliwia jednoczesne wywołanie metody przez kilka wątków.
    //Wątek, który pierwszy wywoła metodę, blokuje możliwość jej wywołania pozostałym wątkom
    //(wchodzą do stanu BLOCKED).
    //Gdy wątek opuści metodę, jeden z zablokowanych wątków zostanie odblokowany
    //(przejdzie w stan RUNNABLE), wejdzie do metody i ją wykona, co spowoduje odblokowanie jednego z pozostałych itd.
    //Blokadą jest obiekt klasy BallCounter.
    public synchronized void  increment(){
        counter++;
    }

    public int get(){
        return counter;
    }
}
