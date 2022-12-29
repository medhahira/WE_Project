package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Weapon {
    private static final int BULLET_WIDTH = 30;
    private static final int BULLET_HEIGHT = 30;
    private static Texture bullet;
    public float power = 100;
    public float angle = 0;
    public final static float GRAVITY = -10;
    public Vector2 initialVelocity = new Vector2();
    public Vector2 initialPoint = new Vector2();
    private boolean remove = false;

    public Weapon(float x0, float y0, float angle_, float power_){
        this.initialPoint.x = x0;
        this.initialPoint.y = y0;
        this.initialVelocity.x = power_;
        this.initialVelocity.y = 0;
        this.initialVelocity.rotateDeg(angle_);
//        this.initialVelocity.x = 100;
        if(this.bullet == null) {
            this.bullet = new Texture("bullet.png");
        }
    }

//    public void rotateAnticlockwise(float deg){
//        this.initialVelocity.rotateDeg(deg);
//    }
//    public void rotateClockwise(float deg){
//        this.initialVelocity.rotateDeg(deg);
//    }
    public void setAngle(float angle_){
        this.angle = angle_;
    }
    public void setPower(float power_){
        this.power = power_;
    }

//    public void changeX(float deltaTime){
//        //sx = s0x + uxt
//        (this.initialPoint.x) += (this.initialVelocity.x * deltaTime);
//    }
//
//    public void changeY(float deltaTime){
//        //sy = s0y + uyt + 1/2*g*t**2
//        (this.initialPoint.y) += (this.initialVelocity.y * deltaTime) + (0.5f * GRAVITY * deltaTime * deltaTime);
//    }

    public void fire(float deltaTime){
//        float y0 = this.initialPoint.y - 10;
//        this.changeX(deltaTime);
//        this.changeY(deltaTime);
//        this.initialVelocity.x = this.power;
//        this.initialVelocity.rotateDeg(this.angle);
        this.initialVelocity.y += GRAVITY;
        (this.initialPoint.x) += (this.initialVelocity.x * deltaTime);
//        (this.initialPoint.y) += (this.initialVelocity.y * deltaTime) + (0.5f * GRAVITY * deltaTime * deltaTime);
        (this.initialPoint.y) += (this.initialVelocity.y * deltaTime);
    }

    public void render (SpriteBatch batch){
        batch.draw(this.bullet, this.initialPoint.x, this.initialPoint.y, BULLET_WIDTH, BULLET_HEIGHT);
    }

}
