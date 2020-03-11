package sample.models.magics;

import sample.models.monsters.BasicMonster;

public interface BasicMagic {
    void doMagic();

    int magicPoints();

    void setMonster(BasicMonster basicMonster);
}
