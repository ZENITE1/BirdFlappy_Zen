package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class MenuState extends State {
    private Texture background;
    private Texture playGame;
    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg.png");
        playGame = new Texture("playbtn.png");
    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.draw(playGame,
                Gdx.graphics.getWidth()/2 - (playGame.getWidth()/2),
                Gdx.graphics.getHeight()/2 - (playGame.getHeight()/2));
        sb.end();
    }
    @Override
    public void dispose() {
      background.dispose();
      playGame.dispose();
    }
}
