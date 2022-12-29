package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TTT_Final implements Screen {
    private SpriteBatch batch;
    private Texture back;
    private Sprite back_sprite;
    private Texture p1_won;
    private Texture p2_won;
    private Texture tie;
    private Texture restart_inactive;
    private Texture exit_inactive;
    private Texture restart_active;
    private Texture exit_active;
    private int status;
    WE_Project game;
    public TTT_Final(WE_Project game, int status){
        batch = new SpriteBatch();
        back = new Texture("1a.png");
        back_sprite = new Sprite(back);
        p1_won = new Texture("p1_won.png");
        p2_won = new Texture("p2_won.png");
        tie = new Texture("tie.png");
        restart_inactive = new Texture("restart_inactive.png");
        restart_active = new Texture("restart_active.png");
        exit_inactive = new Texture("exit_inactive.png");
        exit_active = new Texture("exit_active.png");
        this.status = status;
        this.game = game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        back_sprite.draw(batch);
        if (this.status == 1){
            batch.draw(p1_won, 157, 474);
        }else if (this.status == 2){
            batch.draw(p2_won, 157, 474);
        }else if (this.status == 0){
            batch.draw(tie, 157, 474);
        }
        if (Gdx.input.getX()>=400 && Gdx.input.getX()<= 1280-402 && Gdx.input.getY()>=292 && Gdx.input.getY()<=720-263){
            batch.draw(restart_active, 400, 263);
            if (Gdx.input.isTouched()){
                game.setScreen(new Main_TTT(game));
            }
        } else {
            batch.draw(restart_inactive, 400, 263);
        }
        if (Gdx.input.getX()>=400 && Gdx.input.getX()<= 1280-402 && Gdx.input.getY()>=505 && Gdx.input.getY()<=720-50){
            batch.draw(exit_active, 400, 50);
            if (Gdx.input.isTouched()){
                game.setScreen(new ChoiceScreen(game));
            }
        } else {
            batch.draw(exit_inactive, 400, 50);
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
