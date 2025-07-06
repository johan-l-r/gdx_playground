package com.athenz;

import com.athenz.minis.movingball.BallScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Core extends Game {
  private SpriteBatch batch; 
  private ShapeRenderer shapeRenderer; 
    
  private BallScreen ballScreen; 

  @Override
  public void create() {
    // initialize members here
    this.shapeRenderer = new ShapeRenderer();
    this.batch = new SpriteBatch(); 

    this.ballScreen = new BallScreen(this);

    this.setScreen(this.ballScreen);
  }

  @Override
  public void render() {
    super.render();
  }

  @Override
  public void dispose() {
    super.dispose();

    this.batch.dispose();
    this.shapeRenderer.dispose();
  }

  public SpriteBatch getBatch() { return this.batch; }
  public ShapeRenderer getShapeRenderer() { return this.shapeRenderer; }
}