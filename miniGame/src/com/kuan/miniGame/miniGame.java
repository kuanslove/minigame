package com.kuan.miniGame;

import com.badlogic.gdx.Game;
import com.kuan.miniGame.screens.miniGameScreen;

public class miniGame extends Game {

	@Override
	public void create() {		
		setScreen(new miniGameScreen(this));
	}

	@Override
	public void dispose(){
		
	}

	@Override
	public void render() {
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
