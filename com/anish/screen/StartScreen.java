package com.anish.screen;

import asciiPanel.AsciiPanel;
import com.anish.calabashbros.World;

public class StartScreen extends RestartScreen {

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("This is the start screen.", World.WIDTH/2-15, World.HEIGHT/2-1);
        terminal.write("Press ENTER to continue...",World.WIDTH/2-15, World.HEIGHT/2+1);
    }

}
