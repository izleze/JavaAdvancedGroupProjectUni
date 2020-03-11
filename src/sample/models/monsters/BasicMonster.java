package sample.models.monsters;

import sample.models.actions.Attack;
import sample.models.magics.*;

import java.io.Serializable;

public class BasicMonster implements Serializable, Attack, HealTheWorld, MoveMagic, DefenceUp, AttackOn, Warrrr {

    protected int attackPower;
    protected int defencePower;
    protected int magicPower;
    protected int speed;

    private int positionX;
    private int positionY;
    private boolean moveForward = true;
    private boolean attackTwice = false;

    private int currAttackPower;
    private int currDefencePower;
    private boolean diesThisTurn = false;

    protected BasicMonster(int attackPower, int defencePower,
                           int magicPower, int speed) {
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.magicPower = magicPower;
        this.speed = speed;
        currAttackPower = attackPower;
        currDefencePower = attackPower;
    }

    public int getAttackPower() {
        return currAttackPower;
    }

    public void setAttackPower(int attackPower) {
        this.currAttackPower = attackPower;
    }

    public int getDefencePower() {
        return currDefencePower;
    }

    public void setDefencePower(int defencePower) {
        this.currDefencePower = defencePower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setMoveForward(boolean moveForward) {
        this.moveForward = moveForward;
    }

    public void moveToPosition(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void moveX(int x) {
        positionX = x;
    }

    public void moveY(int y) {
        positionY = y;
    }

    private void increaseX() {
        positionX++;
    }

    private void increaseY() {positionY++;}

    private void decreaseX() {positionX--;}

    private void decreaseY() {positionY--;}

    private void increaseX(int x) {
        positionX += x;
    }

    private void increaseY(int y) {
        positionY += y;
    }

    private void decreaseX(int x) {
        positionX -= x;
    }

    private void decreaseY(int y) {
        positionY -= y;
    }

    public void moveForwardOnce() {
        if (moveForward) {
            increaseX();
        } else {
            decreaseX();
        }
    }

    public void moveForwardWithDefaultSpeed() {
        if (moveForward) {
            increaseX(this.speed);
        } else {
            decreaseX(this.speed);
        }
    }

    public void moveForwardWithSpeed(int speed) {
        if (moveForward) {
            increaseX(speed);
        } else {
            decreaseX(speed);
        }
    }

    @Override
    public boolean attack(BasicMonster basicMonster) {
        if (this.positionX == basicMonster.positionX
            && (this.positionY == basicMonster.positionY + 1
                || this.positionY == basicMonster.positionY - 1)) {

            if(getAttackPower() > basicMonster.getDefencePower()) {
                basicMonster.diesThisTurn = true;
            } else {
                basicMonster.setDefencePower(basicMonster.getDefencePower() - getAttackPower());
                this.diesThisTurn = true;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean doesAttackTwice() {
        return attackTwice;
    }

    public void setAttackTwice() {
        this.attackTwice = true;
    }

    public void setAttackOnce() {
        this.attackTwice = false;
    }

    @Override
    public void moveMagic(int x, int y) {
        this.moveToPosition(x, y);
    }

    @Override
    public void attackOn() {
        setAttackTwice();
    }

    @Override
    public void heal(){
        this.diesThisTurn = false;
    }

    @Override
    public void defenceUp() {
        this.currDefencePower = defencePower;
    }

    @Override
    public void warTime() {
        this.currAttackPower *= 2;
    }
}
