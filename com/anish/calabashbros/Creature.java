package com.anish.calabashbros;

import java.awt.Color;

public class Creature extends Thing {
    protected int rank;

    Creature(Color color, char glyph, World world) {
        super(color, glyph, world);
        rank=-1;
    }

    public void moveTo(int xPos, int yPos) {
        this.world.put(this, xPos, yPos);
    }

    public int getRank() {
        return this.rank;
    }
}
