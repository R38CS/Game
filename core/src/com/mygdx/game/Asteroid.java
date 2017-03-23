package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Vector2 position;
    private float speed;
    private float angle;
    private static Texture texture;


    public Asteroid() {
        position = new Vector2(1280 + (float)Math.random() * 1280,(float)Math.random() *720);
        speed = 5.0f + (float)Math.random() * 7.0f;
        if (texture == null)
            texture = new Texture("Aster.png");

    }

    public void recreate() {
        position.x = 1280 + (float)Math.random() * 1280;
        position.y = (float)Math.random() * 720;
        speed = 5.0f + (float)Math.random() * 7.0f;
        angle = (float)Math.random() * 360;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 30, 30, 60, 60, 1.0f, 1.0f, angle, 0, 0, 60, 60,false, false);
    }

    public void update() {
        position.x -= speed;
        angle += speed/2;
        if (position.x < -40) {
            recreate();
        }
    }
}
