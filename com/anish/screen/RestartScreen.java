package com.anish.screen;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import com.anish.calabashbros.World;

public class RestartScreen implements Screen{

    @Override
    public void displayOutput(AsciiPanel terminal){
        System.out.println(World.WIDTH+","+World.HEIGHT);
        terminal.write("You WIN!!! Congratulations!",World.WIDTH/2-20, World.HEIGHT/2-3);
        terminal.write("Press ENTER to challenge new RANDOM Maze...",World.WIDTH/2-20, World.HEIGHT/2-1);
        terminal.write("CLOSE the terminal to EXIT...",World.WIDTH/2-20, World.HEIGHT/2+1);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new WorldScreen();
            default:
                return this;
        }
    }
}
