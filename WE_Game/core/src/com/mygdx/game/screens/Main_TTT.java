package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main_TTT implements Screen {
    private SpriteBatch batch;
    private Sprite back;
    private Texture back_tex;
    private Texture X_inactive;
    private Texture O_inactive;
    private Texture X_active;
    private Texture O_active;
    WE_Project game;
    public Main_TTT(WE_Project game){
        this.game = game;
        batch = new SpriteBatch();
        back_tex = new Texture("TTT_Main.png");
        X_inactive = new Texture("X_inactive.png");
        O_inactive = new Texture("O_inactive.png");
        X_active = new Texture("X_active.png");
        O_active = new Texture("O_active.png");
        back = new Sprite(back_tex);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        back.draw(batch);
        if (Gdx.input.getX()>=384 && Gdx.input.getX()<=1280-753 && Gdx.input.getY()>=360 && Gdx.input.getY()<=720-217){
            batch.draw(X_active,384,217);
            if (Gdx.input.isTouched()){
                TTT_Player p1 = new TTT_Player(X_active, 1);
                TTT_Player p2 = new TTT_Player(O_active, 0);
                game.setScreen(new TTT_PlayGame(p1, p2, game));
            }
        }
        else {
            batch.draw(X_inactive,384,217);
        }
        if (Gdx.input.getX()>=746 && Gdx.input.getX()<=1280-384 && Gdx.input.getY()>=360 && Gdx.input.getY()<=720-217){
            batch.draw(O_active,746,217);
            if (Gdx.input.isTouched()){
                TTT_Player p2 = new TTT_Player(X_active, 1);
                TTT_Player p1 = new TTT_Player(O_active, 0);
                game.setScreen(new TTT_PlayGame(p1, p2, game));
            }
        }
        else {
            batch.draw(O_inactive,746,217);
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
