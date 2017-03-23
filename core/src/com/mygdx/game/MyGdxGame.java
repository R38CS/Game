package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Background background;
	Hero hero;
	private final int AST_COUNT=50;
	Asteroid[] asteroids;
	private final int BULLETS_COUNT = 20;
	public static Bullet[] bullets;
	private Texture textbullet;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero(100,100, new Hero.Keycontrols(Input.Keys.UP, Input.Keys.DOWN, Input.Keys.LEFT, Input.Keys.RIGHT, Input.Keys.T, Input.Keys.R));
		asteroids = new Asteroid[AST_COUNT];
		for (int i = 0; i < AST_COUNT; i++) {
		    asteroids[i] = new Asteroid();
        }
        bullets = new Bullet[BULLETS_COUNT];
		for (int i = 0; i < BULLETS_COUNT; i++) {
			bullets[i] = new Bullet();
		}
		textbullet = new Texture("bullet.png");
	}

	@Override
	public void render () {
	    update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
        hero.render(batch);
        for (int i = 0; i < AST_COUNT; i++) {
            asteroids[i].render(batch);
        }
        for (int i = 0; i < BULLETS_COUNT; i++) {
        	if (bullets[i].isActive())
        		batch.draw(textbullet, bullets[i].getPosition().x, bullets[i].getPosition().y);
		}
		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for (int i = 0; i < AST_COUNT; i++) {
		    asteroids[i].update();
        }
        for (int i = 0; i <BULLETS_COUNT; i++) {
			if (bullets[i].isActive())
				bullets[i].update();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
