package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChoiceScreen implements Screen {
    private SpriteBatch batch;
    private Sprite back_sprite;
    private Texture back;
    private Texture ts_inactive;
    private Texture ts_active;
    private Texture ttt_inactive;
    private Texture ttt_active;
    private Texture ctb_inactive;
    private Texture ctb_active;
    private Texture fb_inactive;
    private Texture fb_active;
    WE_Project game;
    public ChoiceScreen(WE_Project game){
        this.game = game;
        batch = new SpriteBatch();
        back = new Texture("1a.png");
        back_sprite = new Sprite(back);
        ts_inactive = new Texture("ts_inactive.png");
        ts_active = new Texture("ts_active.png");
        ttt_inactive = new Texture("ttt_inactive.png");
        ttt_active = new Texture("ttt_active.png");
        ctb_inactive = new Texture("ctb_inactive.png");
        ctb_active = new Texture("ctb_active.png");
        fb_inactive = new Texture("fb_inactive.png");
        fb_active = new Texture("fb_active.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        back_sprite.draw(batch);
        if (Gdx.input.getX()>=118 && Gdx.input.getX()<=1280-684 && Gdx.input.getY()>=146 && Gdx.input.getY()<=720-409) {
            batch.draw(ts_active, 118, 409);
            if (Gdx.input.isTouched()){
                game.setScreen(new MainMenuScreen(game));
            }
        } else {
                batch.draw(ts_inactive,118,409);
        }
        if (Gdx.input.getX()>=683 && Gdx.input.getX()<=1280-119 && Gdx.input.getY()>=146 && Gdx.input.getY()<=720-409){
                batch.draw(ttt_active,683,409);
            if (Gdx.input.isTouched()) {
                game.setScreen(new Main_TTT(game));
            }
        }
        else {
                batch.draw(ttt_inactive,683,409);
            }
        if (Gdx.input.getX()>=118 && Gdx.input.getX()<=1280-684 && Gdx.input.getY()>=409 && Gdx.input.getY()<=720-146){
            batch.draw(ctb_active,118,146);
            if (Gdx.input.isTouched()){
                game.setScreen(new IntroScreen_CatchTheBall(game));
            }
        }
        else {
            batch.draw(ctb_inactive,118,146);
        }
        if (Gdx.input.getX()>=683 && Gdx.input.getX()<=1280-119 && Gdx.input.getY()>=409 && Gdx.input.getY()<=720-146){
            batch.draw(fb_active,683,146);}
        else {
            batch.draw(fb_inactive,683,146);
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
