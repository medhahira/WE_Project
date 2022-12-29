package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class TTT_PlayGame implements Screen {


    private SpriteBatch batch;
    public int turn = 1;
    private Texture playgame;
    private Sprite playgame_sprite;
    private Texture turn1;
    private Texture turn2;
    private Texture X_active;
    private Texture O_active;
    ArrayList<ArrayList<Integer>> arr_2d;
    private TTT_Player p1;
    private TTT_Player p2;
    WE_Project game;
    public int check_win(){
        // row 0
        if (arr_2d.get(0).get(0) == arr_2d.get(0).get(1) && arr_2d.get(0).get(1) == arr_2d.get(0).get(2)){
            return arr_2d.get(0).get(0);
        }
        //column 0
        if (arr_2d.get(0).get(0) == arr_2d.get(1).get(0) && arr_2d.get(1).get(0) == arr_2d.get(2).get(0)){
            return arr_2d.get(0).get(0);
        }
        // row 1
        if (arr_2d.get(1).get(0) == arr_2d.get(1).get(1) && arr_2d.get(1).get(1) == arr_2d.get(1).get(2)){
            return arr_2d.get(1).get(0);
        }
        //column 1
        if (arr_2d.get(0).get(1) == arr_2d.get(1).get(1) && arr_2d.get(1).get(1) == arr_2d.get(2).get(1)){
            return arr_2d.get(0).get(1);
        }
        // row 2
        if (arr_2d.get(2).get(0) == arr_2d.get(2).get(1) && arr_2d.get(2).get(1) == arr_2d.get(2).get(2)){
            return arr_2d.get(2).get(0);
        }
        //column 2
        if (arr_2d.get(0).get(2) == arr_2d.get(1).get(2) && arr_2d.get(1).get(2) == arr_2d.get(2).get(2)){
            return arr_2d.get(0).get(2);
        }
        // diag \
        if (arr_2d.get(0).get(0) == arr_2d.get(1).get(1) && arr_2d.get(1).get(1) == arr_2d.get(2).get(2)){
            return arr_2d.get(0).get(0);
        }
        //diag /
        if (arr_2d.get(0).get(2) == arr_2d.get(1).get(1) && arr_2d.get(1).get(1) == arr_2d.get(2).get(0)){
            return arr_2d.get(0).get(2);
        }
        return -1;
    }
    public int check_tie(){
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (arr_2d.get(i).get(j) == -1){
                    //not tie, more cells can be filled
                    return 0;
                }
            }
        }
        if (check_win() == -1){
            return 1;
        }
        return 2;
    }
    public TTT_PlayGame(TTT_Player p1, TTT_Player p2, WE_Project game){
        batch = new SpriteBatch();
        X_active = new Texture("X_active.png");
        O_active = new Texture("O.png");
        playgame = new Texture("TTT_PlayGame.png");
        turn1 = new Texture("turn1.png");
        turn2 = new Texture("turn2.png");
        playgame_sprite = new Sprite(playgame);
        this.p1 = p1;
        this.p2 = p2;
        this.game = game;
        arr_2d = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<3; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j=0; j<3; j++){
                arr.add(-1);
            }
            arr_2d.add(arr);
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        playgame_sprite.draw(batch);

        if (turn == 1){
            batch.draw(turn1, 838, 291);
        } else {
            batch.draw(turn2, 838, 291);
        }

        if (check_tie() == 1){
            System.out.println("TIE");
            game.setScreen(new TTT_Final(game, 0));
        }
        if (check_win() == p1.getKey()){
            game.setScreen(new TTT_Final(game, 1));
            System.out.println("P1 won");
        } else if (check_win() == p2.getKey()){
            game.setScreen(new TTT_Final(game, 2));
            System.out.println("P2 won");
        }

        if (arr_2d.get(0).get(0)!=-1){
            if (arr_2d.get(0).get(0) == 1){
                batch.draw(X_active, 78, 511);
            } else {
                batch.draw(O_active, 78, 511);
            }
        }if (arr_2d.get(0).get(1)!=-1){
            if (arr_2d.get(0).get(1) == 1){
                batch.draw(X_active, 299, 511);
            } else {
                batch.draw(O_active, 299, 511);
            }
        }
        if (arr_2d.get(0).get(2)!=-1){
            if (arr_2d.get(0).get(2) == 1){
                batch.draw(X_active, 522, 511);
            } else {
                batch.draw(O_active, 522, 511);
            }
        }
        if (arr_2d.get(1).get(0)!=-1){
            if (arr_2d.get(1).get(0) == 1){
                batch.draw(X_active, 78, 291);
            } else {
                batch.draw(O_active, 78, 291);
            }
        }
        if (arr_2d.get(1).get(1)!=-1){
            if (arr_2d.get(1).get(1) == 1){
                batch.draw(X_active, 299, 291);
            } else {
                batch.draw(O_active, 299, 291);
            }
        }
        if (arr_2d.get(1).get(2)!=-1){
            if (arr_2d.get(1).get(2) == 1){
                batch.draw(X_active, 522, 291);
            } else {
                batch.draw(O_active, 522, 291);
            }
        }
        if (arr_2d.get(2).get(0)!=-1){
            if (arr_2d.get(2).get(0) == 1){
                batch.draw(X_active, 78, 72);
            } else {
                batch.draw(O_active, 78, 72);
            }
        }
        if (arr_2d.get(2).get(1)!=-1){
            if (arr_2d.get(2).get(1) == 1){
                batch.draw(X_active, 299, 72);
            } else {
                batch.draw(O_active, 299, 72);
            }
        }
        if (arr_2d.get(2).get(2)!=-1){
            if (arr_2d.get(2).get(2) == 1){
                batch.draw(X_active, 522, 72);
            } else {
                batch.draw(O_active, 522, 72);
            }
        }
        // 0 0
        if (Gdx.input.getX()>=78 && Gdx.input.getX()<=1280-1059 && Gdx.input.getY()>=65 && Gdx.input.getY()<=720-511 && arr_2d.get(0).get(0) == -1){
            if (turn == 1){
                batch.draw(p1.getKey_Texture(),78,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(0,p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            }
            else if (turn == 2){
                batch.draw(p2.getKey_Texture(),78,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(0,p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 0 1
        if (Gdx.input.getX()>=299 && Gdx.input.getX()<=1280-838 && Gdx.input.getY()>=65 && Gdx.input.getY()<=720-511 && arr_2d.get(0).get(1) == -1){
            if (turn == 1){
                batch.draw(p1.getKey_Texture(),299,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(1,p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            }
            else if (turn == 2){
                batch.draw(p2.getKey_Texture(),299,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(1,p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 0 2
        if (Gdx.input.getX()>=522 && Gdx.input.getX()<=1280-615 && Gdx.input.getY()>=65 && Gdx.input.getY()<=720-511 && arr_2d.get(0).get(2) == -1){
            if (turn == 1){
                batch.draw(p1.getKey_Texture(),522,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(2,p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            }
            else if (turn == 2){
                batch.draw(p2.getKey_Texture(),522,511);
                if (Gdx.input.isTouched()){
                    arr_2d.get(0).set(2,p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 1 0
        if (Gdx.input.getX()>=78 && Gdx.input.getX()<=1280-1059 && Gdx.input.getY()>=285 && Gdx.input.getY()<=720-291 && arr_2d.get(1).get(0) == -1){
            if (turn == 1){
                batch.draw(p1.getKey_Texture(),78,291);
                if (Gdx.input.isTouched()){
                    arr_2d.get(1).set(0,p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            }
            else if (turn == 2){
                batch.draw(p2.getKey_Texture(),78,291);
                if (Gdx.input.isTouched()){
                    arr_2d.get(1).set(0,p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 1 1
        if (Gdx.input.getX()>=299 && Gdx.input.getX()<=1280-838 && Gdx.input.getY()>=285 && Gdx.input.getY()<=720-291 && arr_2d.get(1).get(1) == -1) {
            if (turn == 1) {
                batch.draw(p1.getKey_Texture(), 299, 291);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(1).set(1, p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            } else if (turn == 2) {
                batch.draw(p2.getKey_Texture(), 299, 291);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(1).set(1, p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
            // 1 2
        if (Gdx.input.getX()>=522 && Gdx.input.getX()<=1280-615  && Gdx.input.getY()>=285 && Gdx.input.getY()<=720-291 && arr_2d.get(1).get(2) == -1) {
            if (turn == 1) {
                batch.draw(p1.getKey_Texture(), 522, 291);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(1).set(2, p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            } else if (turn == 2) {
                batch.draw(p2.getKey_Texture(), 522, 291);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(1).set(2, p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 2 0
        if (Gdx.input.getX()>=78 && Gdx.input.getX()<=1280-1059  && Gdx.input.getY()>=504 && Gdx.input.getY()<=720-72 && arr_2d.get(2).get(0) == -1) {
            if (turn == 1) {
                batch.draw(p1.getKey_Texture(), 78, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(0, p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            } else if (turn == 2) {
                batch.draw(p2.getKey_Texture(), 78, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(0, p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 2 1
        if (Gdx.input.getX()>=299 && Gdx.input.getX()<=1280-838  && Gdx.input.getY()>=504 && Gdx.input.getY()<=720-72 && arr_2d.get(2).get(1) == -1) {
            if (turn == 1) {
                batch.draw(p1.getKey_Texture(), 299, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(1, p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            } else if (turn == 2) {
                batch.draw(p2.getKey_Texture(), 299, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(1, p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        // 2 2
        if (Gdx.input.getX()>=522 && Gdx.input.getX()<=1280-615  && Gdx.input.getY()>=504 && Gdx.input.getY()<=720-72 && arr_2d.get(2).get(2) == -1) {
            if (turn == 1) {
                batch.draw(p1.getKey_Texture(), 522, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(2, p1.getKey());
                    System.out.println(arr_2d);
                    turn = 2;
                }
            } else if (turn == 2) {
                batch.draw(p2.getKey_Texture(), 522, 72);
                if (Gdx.input.isTouched()) {
                    arr_2d.get(2).set(2, p2.getKey());
                    System.out.println(arr_2d);
                    turn = 1;
                }
            }
        }
        batch.end();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
