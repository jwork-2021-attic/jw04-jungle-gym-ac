package com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;


import com.anish.calabashbros.SelectSorter;
import com.anish.calabashbros.Calabash;
import com.anish.calabashbros.World;
import com.anish.calabashbros.Matrix;

import asciiPanel.AsciiPanel;

public class WorldScreen implements Screen {

    private World world;
    private Calabash[][] bros;
    private Matrix<Calabash> matrix;
    String[] sortSteps;

    public WorldScreen() {
        world = new World();

        bros = new Calabash[16][16];

        int red,green,blue,random;
        Random r = new Random();
        boolean[] used=new boolean[256]; //generate random position!
        for(boolean number:used){
            number=false;
        }

        for(int i=0;i<16;i++)
            for(int j=0;j<16;j++)
        {
            //generate random number of position
            random=r.nextInt(256);
            while(used[random])
                random=(random+1)%256;
            used[random]=true;    
            //set color
            red=r.nextInt(256);
            green=r.nextInt(256);
            blue=r.nextInt(256);
            bros[i][j]=new Calabash(new Color(red,green,blue),random,world);
            
            world.put(bros[i][j],4*i+20,4*j+5);
        }

        matrix=new Matrix<>(16,16,bros);
        SelectSorter<Calabash> b = new SelectSorter<>();
        b.load(matrix);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Calabash[][] bros, String step) {
        String[] couple = step.split("<->");
        matrix.getBroByRank(Integer.parseInt(couple[0])).swap(matrix.getBroByRank(Integer.parseInt(couple[1])));
    }

    

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        if (i < this.sortSteps.length) {
            this.execute(bros, sortSteps[i]);
            i++;
        }
        return this;   
    }
}

