package com.company;

public class Lampadina {

    private StatoLampadina stato;
    private int click;
    public static boolean hasElectricity;

    public Lampadina(int click) {
        this.click = click;
        stato = StatoLampadina.SPENTA;
    }

    public StatoLampadina getStatoLampadina(){
        if (stato == StatoLampadina.ROTTA)
            return stato;
        
        if (!hasElectricity)
            return StatoLampadina.SPENTA;

        return stato;
    }

    public boolean click(){

        if (!hasElectricity)
            return false;

        if (stato.equals(StatoLampadina.ROTTA))
            return false;

        if (click == 0)
            stato = StatoLampadina.ROTTA;
        else
        {
            switch (stato){
                case ACCESA:
                    stato = StatoLampadina.SPENTA;
                    click--;
                    break;
                case SPENTA:
                    stato = StatoLampadina.ACCESA;
                    click--;
                    break;
            }
        }

        return true;
    }

}
