package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.StartScreen;

public class WE_Project extends Game {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		this.setScreen(new StartScreen(this));
	}

	@Override
	public void render () {
//		ScreenUtils.clear(1, 0, 0, 1);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
