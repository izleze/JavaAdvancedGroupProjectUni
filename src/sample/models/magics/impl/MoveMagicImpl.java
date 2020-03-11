package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.MoveMagic;
import sample.models.monsters.BasicMonster;

public class MoveMagicImpl implements MoveMagic, BasicMagic {

    private BasicMonster moveMonster;
    private int posX;
    private int posY;

    public MoveMagicImpl() {
    }

    public MoveMagicImpl(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void setMonster(BasicMonster moveMonster) {
        this.moveMonster = moveMonster;
    }

    @Override
    public void doMagic() {
        moveMagic(posX, posY);
    }

    @Override
    public int magicPoints() {
        return moveMagicRequiresMagicPoints();
    }

    @Override
    public void moveMagic(int x, int y) {
        moveMonster.moveMagic(x, y);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
