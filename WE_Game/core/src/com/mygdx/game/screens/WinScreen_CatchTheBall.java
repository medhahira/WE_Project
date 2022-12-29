package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class WinScreen_CatchTheBall implements Screen {
    private static final int BUTTON_WIDTH = 478;
    private static final int BUTTON_HEIGHT = 165;
    private static final int RESTART_BUTTON_Y = 292;
    private static final int EXIT_BUTTON_Y = 79;
    Texture background;
    Texture restartButtonActive;
    Texture exitButtonActive;
    WE_Project game;
    public WinScreen_CatchTheBall(WE_Project game){
        this.game = game;
        background = new Texture("catch_the_ball_won.png");
        restartButtonActive = new Texture("restartbutton_active.png");
        exitButtonActive = new Texture("exitbutton_active.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        int x = 1280 / 2 - BUTTON_WIDTH / 2;
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && 720 - Gdx.input.getY() < RESTART_BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > RESTART_BUTTON_Y) {
            game.batch.draw(restartButtonActive,1280 / 2 - BUTTON_WIDTH / 2, RESTART_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new PlayScreen_CatchTheBall(game));
            }
        }
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && 720 - Gdx.input.getY() < EXIT_BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > EXIT_BUTTON_Y) {
            game.batch.draw(exitButtonActive,1280 / 2 - BUTTON_WIDTH / 2, EXIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new ChoiceScreen(game));
            }
        }
        game.batch.end();
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

