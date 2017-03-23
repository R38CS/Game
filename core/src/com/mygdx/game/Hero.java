package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    static class Keycontrols {
        final int KEY_UP;
        final int KEY_DOWN;
        final int KEY_LEFT;
        final int KEY_RIGHT;
        final int KEY_ACCELERATION;
        final int KEY_FIRE;

        public Keycontrols (int KEY_UP, int KEY_DOWN, int KEY_LEFT, int KEY_RIGHT, int KEY_FIRE, int KEY_ACCELERATION) {
            this.KEY_UP = KEY_UP;
            this.KEY_DOWN = KEY_DOWN;
            this.KEY_LEFT = KEY_LEFT;
            this.KEY_RIGHT = KEY_RIGHT;
            this.KEY_ACCELERATION = KEY_ACCELERATION;
            this.KEY_FIRE = KEY_FIRE;
        }
    }
    private Texture texture;
    private Vector2 position;
    private float speed;
    private Keycontrols kc;
    private int fireCounter;
    private int fireRate;

    public Hero(int posX, int posY, Keycontrols kc) {
        texture = new Texture("Hero.png");
        position = new Vector2(100,100);
        speed = 10.0f;
        this.kc = kc;
        fireRate = 10;
    }

    public void render (SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(kc.KEY_UP)) {
            position.y += speed;
            if (position.y > 663) {
                position.y = 663;
            }
        }

        if (Gdx.input.isKeyPressed(kc.KEY_DOWN)) {
            position.y -= speed;
            if (position.y < -11) {
                position.y = -10;
            }
        }

        if (Gdx.input.isKeyPressed(kc.KEY_LEFT)) {
            position.x -= speed;
            if (position.x < 0) {
                position.x = 0;
            }
        }

        if (Gdx.input.isKeyPressed(kc.KEY_RIGHT)) {
            position.x += speed;
            if (position.x > 900) {
                position.x = 900;
            }
        }

        if (Gdx.input.isKeyPressed(kc.KEY_FIRE)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 0;
                bulletActivate(0, 0, 10);
            }
        }
    }

    public void bulletActivate(float dx, float dy, float speed) {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].setup(position.x + dx, position.y + dy, speed);
                break;
            }
        }
    }
}
