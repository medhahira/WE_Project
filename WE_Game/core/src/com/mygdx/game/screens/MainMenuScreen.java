package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
    private SpriteBatch batch;
    private static final int BACKGROUND_WIDTH = 1280;
    private static final int BACKGROUND_HEIGHT = 720;
    private static final int BUTTON_WIDTH = 343;
    private static final int BUTTON_HEIGHT = 91;
    private static final int NEW_GAME_BUTTON_Y = 429;
    private static final int RESUME_BUTTON_Y = 315;
    private static final int EXIT_BUTTON_Y = 201;
    WE_Project game;
    Texture background;
    Texture newGameButtonActive;
    Texture newGameButtonInactive;
    Texture resumeButtonActive;
    Texture resumeButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    public MainMenuScreen(WE_Project game){
        batch = new SpriteBatch();
        this.game = game;
        background = new Texture("main_menu_bg.png");
    }

    @Override
    public void show() {
        newGameButtonInactive = new Texture("new_game_button_inactive.png");
        newGameButtonActive = new Texture("new_game_button_active.png");
        resumeButtonInactive = new Texture("resume_button_inactive.png");
        resumeButtonActive = new Texture("resume_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        int x = 1280 / 2 - BUTTON_WIDTH / 2;
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && 720 - Gdx.input.getY() < NEW_GAME_BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > NEW_GAME_BUTTON_Y) {
           batch.draw(newGameButtonActive, 1280 / 2 - BUTTON_WIDTH / 2, NEW_GAME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new ChooseTankScreen(game));
            }
        } else {
           batch.draw(newGameButtonInactive, 1280 / 2 - BUTTON_WIDTH / 2, NEW_GAME_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        if(Gdx.input.getX() < x + BUTTON_WIDTH && Gdx.input.getX() > x && 720 - Gdx.input.getY() < EXIT_BUTTON_Y + BUTTON_HEIGHT && 720 - Gdx.input.getY() > EXIT_BUTTON_Y) {
           batch.draw(exitButtonActive, 1280 / 2 - BUTTON_WIDTH / 2, EXIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.justTouched()){
                game.setScreen(new ChoiceScreen(game));
            }
        } else {
           batch.draw(exitButtonInactive, 1280 / 2 - BUTTON_WIDTH / 2, EXIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
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
