package com.mcmurchie.mariobros.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mcmurchie.mariobros.MarioBros;

import static com.badlogic.gdx.Input.Keys.T;
import static com.badlogic.gdx.Input.Keys.V;

/**
 * Created by adammcmurchie on 31/01/2017.
 */

public class Hud implements Disposable{

    public Stage stage;
    private Viewport viewport; // this one should be independent from the other viewport fixed constructed below

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;


    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        // CONSTRUCT LABELS
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        // string representation of our integer (d for integer)
        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
       // 6 digits long this time
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
       // Dont need string format, just the TIME
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        // ADD LABELS TO TABLE
        // expandX, fills the whole row, but if you have three then they share it
        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();// takes a new row
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);

    }


    @Override
    public void dispose() {
        stage.dispose();
    }
}
