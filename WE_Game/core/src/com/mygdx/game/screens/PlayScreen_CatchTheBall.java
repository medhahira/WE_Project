package com.mygdx.game.screens;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayScreen_CatchTheBall implements Screen {
    private static final int BACKGROUND_WIDTH = 1280;
    private static final int BACKGROUND_HEIGHT = 720;
    public static final float SPEED = 1000;
    WE_Project game;
    Texture background;
    Texture bowlImg;
    Rectangle bowl;
    Texture ball;
    Texture ground;
    float bowl_x;
    float bowl_y;
    public int score;
    public int missed;
    private ArrayList<Rectangle> balls;
    private long lastBallTime;
    private void spawnBall() {
        Rectangle balldrop = new Rectangle();
        balldrop.x = MathUtils.random(0, 1280-40);
        balldrop.y = 720;
        balldrop.width = 40;
        balldrop.height = 40;
        balls.add(balldrop);
        lastBallTime = TimeUtils.nanoTime();
    }


    public PlayScreen_CatchTheBall(WE_Project game){
        this.game = game;
        background = new Texture("catch_the_ball_bg.png");
        bowl = new Rectangle();
        bowl.x = 27;
        bowl.y = 30;
        bowl.width = 241;
        bowl.height = 131;
        balls = new ArrayList<Rectangle>();
        spawnBall();
        score = 0;
        missed = 0;
    }
    @Override
    public void show() {
        bowlImg = new Texture("bowl.png");
        ball = new Texture("ball.png");
        ground = new Texture("catch_ground.png");
    }

    @Override
    public void render(float delta) {
        if(TimeUtils.nanoTime() - lastBallTime > 1000000000) spawnBall();
        for (Iterator<Rectangle> iter = balls.iterator(); iter.hasNext(); ) {
            Rectangle balldrop = iter.next();
            balldrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if(balldrop.y - 100 < 0) {
                missed++;
                iter.remove();
            }
            if(balldrop.overlaps(bowl)) {
                score++;
                iter.remove();
            }

        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            bowl.x -= SPEED * Gdx.graphics.getDeltaTime();
            if(bowl.x < 0) bowl.x = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            bowl.x += SPEED * Gdx.graphics.getDeltaTime();
            if(bowl.x > 1280 - 241) bowl.x = 1280 - 241;
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.draw(ground, 0, 0);
        game.batch.draw(bowlImg, bowl.x, bowl.y);
        for(Rectangle balldrop: balls) {
            game.batch.draw(ball, balldrop.x, balldrop.y);
        }
        if(missed >= 5){
            this.dispose();
            game.setScreen(new LoseScreen_CatchTheBall(game));
        }
        if(score >= 20){
            this.dispose();
            game.setScreen(new WinScreen_CatchTheBall(game));
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
