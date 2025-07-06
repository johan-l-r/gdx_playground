package com.athenz.minis.movingball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ball {
  private float movementSpeed; 
  private float radius; 
 
  private Vector2 direction; 
  private Vector2 position; 

  public Ball(float radius, float movementSpeed) {
    this.movementSpeed = movementSpeed; 
    this.radius = radius; 

    // set random direction when game starts
    this.direction = new Vector2(
      MathUtils.randomBoolean() ? 1 : -1, 
      MathUtils.randomBoolean() ? 1 : -1
    );

    this.position = new Vector2(
      MathUtils.random(0, Gdx.graphics.getWidth()),
      MathUtils.random(0, Gdx.graphics.getHeight())
    );
  }

  public void update(float delta) {
    if(this.position.x < 0) this.direction.x *= -1;
    if(this.position.y < 0) this.direction.y *= -1;
    if(this.position.x > Gdx.graphics.getBackBufferWidth()) this.direction.x *= -1;
    if(this.position.y > Gdx.graphics.getBackBufferHeight()) this.direction.y *= -1;

    // use delta to ensure frame rate independent movement
    this.position.add(
      this.direction.x * this.movementSpeed * delta,  
      this.direction.y * this.movementSpeed * delta
    );
  }

  public void draw(ShapeRenderer renderer) {
    renderer.circle(this.position.x, this.position.y, this.radius);
  }
}
