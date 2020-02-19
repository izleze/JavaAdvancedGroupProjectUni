package sample.models.monsters;

import sample.models.actions.Attack;

import java.util.function.ToDoubleBiFunction;

public class BasicMonster implements Attack {

    protected int attackPower;
    protected int defencePower;
    protected int magicPower;
    protected int speed;

    private int positionX;
    private int positionY;
    private boolean moveForward = true;

    protected BasicMonster(int attackPower, int defencePower,
                           int magicPower, int speed) {
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.magicPower = magicPower;
        this.speed = speed;
    }

    protected int getAttackPower() {
        return attackPower;
    }

    protected void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    protected int getDefencePower() {
        return defencePower;
    }

    protected void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    protected int getMagicPower() {
        return magicPower;
    }

    protected void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    protected int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected int getPositionX() {
        return positionX;
    }

    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    protected int getPositionY() {
        return positionY;
    }

    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    protected void setMoveForward(boolean moveForward) {
        this.moveForward = moveForward;
    }

    protected void moveToPosition(int x, int y) {
        positionX = x;
        positionY = y;
    }

    protected void moveX(int x) {
        positionX = x;
    }

    protected void moveY(int y) {
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

    protected void moveForwardOnce() {
        if (moveForward) {
            increaseX();
        } else {
            decreaseX();
        }
    }

    protected void moveForwardWithDefaultSpeed() {
        if (moveForward) {
            increaseX(this.speed);
        } else {
            decreaseX(this.speed);
        }
    }

    protected void moveForwardWithSpeed(int speed) {
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
                //TODO kill basicMonster
            } else {
                basicMonster.setDefencePower(basicMonster.getDefencePower() - getAttackPower());
                //TODO kill this
            }
            return true;
        } else {
            return false;
        }
    }
}
