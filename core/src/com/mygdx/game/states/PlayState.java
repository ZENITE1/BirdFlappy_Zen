package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Player;

public class PlayState extends State{
    Player plane;
    Texture background;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        plane = new Player(50,100);
        cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        background = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            plane.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        plane.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(plane.getPane(),plane.getPosition().x,plane.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
     plane.dispose();
     background.dispose();
    }
}
