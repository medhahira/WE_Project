package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;

public class TTT_Player {
    private Texture key_Texture;
    private int key;
    public TTT_Player(Texture key_Texture, int key){
        this.key_Texture = key_Texture;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public Texture getKey_Texture() {
        return key_Texture;
    }
}
