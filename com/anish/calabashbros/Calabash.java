package com.anish.calabashbros;

import java.awt.Color;

public class Calabash extends Creature implements Comparable<Calabash> {

    

    public Calabash(Color color, int rank, World world) {
        super(color, (char) 2, world);
        this.rank = rank;
    }

   

    @Override
    public String toString() {
        return String.valueOf(this.rank);
    }

    @Override
    public int compareTo(Calabash o) {
        //System.out.println(this.rank+"><="+o.rank);
        return Integer.valueOf(this.rank).compareTo(Integer.valueOf(o.rank));
    }

    public void swap(Calabash another) {
        int x = this.getX();
        int y = this.getY();
        this.moveTo(another.getX(), another.getY());
        another.moveTo(x, y);
    }

}
