package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.MoveMagic;
import sample.models.monsters.BasicMonster;

public class MoveMagicImpl implements MoveMagic, BasicMagic {

    private BasicMonster moveMonster;

    public void setMoveMonster(BasicMonster moveMonster) {
        this.moveMonster = moveMonster;
    }

    @Override
    public void doMagic() {
        moveMagic();
    }

    @Override
    public void moveMagic(int x, int y) {
        moveMonster.moveMagic();
    }
}
