package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class IntroScreen_CatchTheBall implements Screen {
    Texture background;
    WE_Project game;
    public IntroScreen_CatchTheBall(WE_Project game){
        this.game = game;
        background = new Texture("catch_the_ball_intro.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            this.dispose();
            game.setScreen(new PlayScreen_CatchTheBall(game));
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

