package com.athenz;

import com.athenz.minis.movingball.BallScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Core extends Game {
	private BallScreen ballScreen;

	private ShapeRenderer renderer;

	@Override
	public void create() {
		// initialize members
		setScreen(ballScreen = new BallScreen(this));

		this.renderer = new ShapeRenderer();
	}

	@Override
	public  void render() {
		super.render();
	}

	@Override
	public void dispose() {
		// free memory
		super.dispose();

		this.renderer.dispose();
	}

	public ShapeRenderer getRenderer() { return this.renderer; }
}