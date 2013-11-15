package com.kuan.miniGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.kuan.miniGame.screens.miniGameScreen;

public class miniGame extends Game {

	@Override
	public void create() {
		setScreen(new miniGameScreen(this));
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
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
}
