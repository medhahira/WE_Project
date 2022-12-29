package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChooseTankScreen implements Screen {
    private SpriteBatch batch;
    private static final int BANNER_WIDTH = 343;
    private static final int BANNER_HEIGHT = 91;
    private static final int BUTTON_WIDTH = 204;
    private static final int BUTTON_HEIGHT = 59;
    private static final int TANK_WIDTH = 700;
    private static final int TANK_HEIGHT = 700;
    private static final int PLAYER_BANNER_Y = 650;
    private static final int PLAYER_BANNER_X = 41;
    private static final int TANK_BANNER_Y = 591;
    private static final int TANK_Y = -50;
    private static final int BUTTON_Y = 54;
    private static final int BACK_BUTTON_X = 41;
    private static final int CHOOSE_BUTTON_X = 1035;
    private static final int ARROW_Y = 298;
    private static final int LEFT_ARROW_X = 160;
    private static final int RIGHT_ARROW_X = 1068;
    private static final int ARROW_WIDTH = 52;
    private static final int ARROW_HEIGHT= 80;
    private int page = 1;
    private int currTank = 1;
    private boolean left_arrow = false;
    private boolean right_arrow = true;
    private int player1 = 1;
    private int player2 = 1;
    Texture background;
    Texture tankBanner;
    Texture player1Banner;
    Texture player2Banner;
    Texture tank;
    Texture leftArrowInactive;
    Texture leftArrowActive;
    Texture rightArrowInactive;
    Texture rightArrowActive;
    Texture backButtonInactive;
    Texture backButtonActive;
    Texture chooseButtonInactive;
    Texture chooseButtonActive;
    WE_Project game;

    public ChooseTankScreen(WE_Project game){

        this.game = game;
        batch = new SpriteBatch();
    }
    @Override
    public void show() {
        background = new Texture("choose_tank_bg.png");
        tankBanner = new Texture("abrams_tank_banner.png");
        player1Banner = new Texture("player_1_banner.png");
        player2Banner = new Texture("player_2_banner.png");
        tank = new Texture("abrams_tank.png");
        leftArrowActive = new Texture("left_arrow_active.png");
        leftArrowInactive = new Texture("left_arrow_inactive.png");
        rightArrowActive = new Texture("right_arrow_active.png");
        rightArrowInactive = new Texture("right_arrow_inactive.png");
        backButtonActive = new Texture("back_button_active.png");
        backButtonInactive = new Texture("back_button_inactive.png");
        chooseButtonActive = new Texture("choose_button_active.png");
        chooseButtonInactive = new Texture("choose_button_inactive.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       batch.begin();
       batch.draw(background, 0, 0);
        int tank_x = 1280 / 2 - TANK_WIDTH / 2;
        int banner_x = 1280 / 2 - BANNER_WIDTH / 2;

       batch.draw(tank, tank_x, TANK_Y);
       batch.draw(tankBanner, banner_x, TANK_BANNER_Y);
//       batch.draw(player1Banner, PLAYER_BANNER_X, PLAYER_BANNER_Y);

        if(left_arrow && Gdx.input.getX() < LEFT_ARROW_X + ARROW_WIDTH && Gdx.input.getX() > LEFT_ARROW_X && 720 - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT && 720 - Gdx.input.getY() > ARROW_Y) {
           batch.draw(leftArrowActive, LEFT_ARROW_X, ARROW_Y);
            if(Gdx.input.justTouched() && page == 2){
                page = 1;
                left_arrow = false;
                right_arrow = true;
                tank = new Texture("abrams_tank.png");
                tankBanner = new Texture("abrams_tank_banner.png");
               batch.draw(tank, tank_x, TANK_Y);
               batch.draw(tankBanner, banner_x, TANK_BANNER_Y);
            }
            else if(Gdx.input.justTouched() && page == 3){
                page = 2;
                left_arrow = true;
                right_arrow = true;
                tank = new Texture("frost_tank.png");
                tankBanner = new Texture("frost_tank_banner.png");
               batch.draw(tank, tank_x, TANK_Y);
               batch.draw(tankBanner, banner_x, TANK_BANNER_Y);
            }
        } else {
           batch.draw(leftArrowInactive, LEFT_ARROW_X, ARROW_Y);
        }
        if(right_arrow && Gdx.input.getX() < RIGHT_ARROW_X + ARROW_WIDTH && Gdx.input.getX() > RIGHT_ARROW_X && 720 - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT && 720 - Gdx.input.getY() > ARROW_Y) {
           batch.draw(rightArrowActive, RIGHT_ARROW_X, ARROW_Y);
            if(Gdx.input.justTouched() && page == 1){
                page = 2;
                left_arrow = true;
                right_arrow = true;
                tank = new Texture("frost_tank.png");
                tankBanner = new Texture("frost_tank_banner.png");
               batch.draw(tank, tank_x, TANK_Y);
               batch.draw(tankBanner, banner_x, TANK_BANNER_Y);
            }
            else if(Gdx.input.justTouched() && page == 2){
                page = 3;
                left_arrow = true;
                right_arrow = false;
                tank = new Texture("helios_tank.png");
                tankBanner = new Texture("helios_tank_banner.png");
               batch.draw(tank, tank_x, TANK_Y);
               batch.draw(tankBanner, banner_x, TANK_BANNER_Y);
            }
        } else {
           batch.draw(rightArrowInactive, RIGHT_ARROW_X, ARROW_Y);
        }
        if(Gdx.input.getX() < BACK_BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > BACK_BUTTON_X && 720 - Gdx.input.getY() < BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > BUTTON_Y) {
           batch.draw(backButtonActive, BACK_BUTTON_X, BUTTON_Y);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        } else {
           batch.draw(backButtonInactive, BACK_BUTTON_X, BUTTON_Y);
        }
        if(Gdx.input.getX() < CHOOSE_BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > CHOOSE_BUTTON_X && 720 - Gdx.input.getY() < BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > BUTTON_Y) {
           batch.draw(chooseButtonActive, CHOOSE_BUTTON_X, BUTTON_Y);
            if(currTank == 2 && Gdx.input.justTouched()){
                player2 = page;
                this.dispose();
                game.setScreen(new PlayGameScreen(game, player1, player2));
            }
            else if(currTank == 1 && Gdx.input.justTouched()){
                player1 = page;
                currTank = 2;
//               batch.draw(player2Banner, PLAYER_BANNER_X, PLAYER_BANNER_Y);
            }
        } else {
           batch.draw(chooseButtonInactive, CHOOSE_BUTTON_X, BUTTON_Y);
        }
        if(currTank == 2){
           batch.draw(player2Banner, PLAYER_BANNER_X, PLAYER_BANNER_Y);
        } else{
           batch.draw(player1Banner, PLAYER_BANNER_X, PLAYER_BANNER_Y);
        }

       batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
