package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    private static final int TANK_WIDTH = 150;
    private static final int TANK_HEIGHT = 150;
    public static final int SPEED = 100;
    public static final int FUEL_DEC = 400;
    public static final int FUEL_MAX = 1420;
    public static final int HP_MAX = 1000;
    public static final int DEFAULT_Y = 105;
    private TextureRegion tank;
    private String player_region;
    private float x, y;
    private float fuel;
    private float hp;

    public Player(float x, String n, int option){
        this.x = x;
        this.y = DEFAULT_Y;
        this.player_region = n;
        if (option == 1) {
            this.tank = new TextureRegion(new Texture("abrams_tank.png"));
        }
        else if (option == 2){
            this.tank = new TextureRegion(new Texture("frost_tank.png"));
        }
        else{
            this.tank = new TextureRegion(new Texture("helios_tank.png"));
        }
        if(n.equals("right")){
            this.tank.flip(true, false);
        }
        this.fuel = FUEL_MAX;
        this.hp = HP_MAX;
    }

    public float getFuel() {
        return fuel;
    }
    public void refillFuel(){
        this.fuel = FUEL_MAX;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public void impact(float shift){
        this.x += shift;
        if(this.x + 150 > 1280) this.x = 1280 - 150;

    }

    public void incX (float deltaTime){
        if(this.fuel > 0) {
            this.x += SPEED * deltaTime;
            this.fuel -= FUEL_DEC * deltaTime;
        }
        if(this.x + 150 > 1280) this.x = 1280 - 150;
        if(this.x < 0) this.x = 0;
    }

    public void decX (float deltaTime){
        if(this.fuel > 0) {
            this.x -= SPEED * deltaTime;
            this.fuel -= FUEL_DEC * deltaTime;
        }
        if(this.x < 0) this.x = 0;
    }

    public boolean decHealth(int amt){
        this.hp -= amt;
        if(this.hp <= 0) return true;
        return false;
    }

    public void render (SpriteBatch batch){
        batch.draw(this.tank, this.x, this.y, TANK_WIDTH, TANK_HEIGHT);
    }
}
