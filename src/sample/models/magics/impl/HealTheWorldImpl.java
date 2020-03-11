package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.HealTheWorld;
import sample.models.monsters.BasicMonster;

public class HealTheWorldImpl implements HealTheWorld, BasicMagic {

    private BasicMonster healedMonster;

    @Override
    public void setMonster(BasicMonster healedMonster) {
        this.healedMonster = healedMonster;
    }

    @Override
    public void doMagic() {
        heal();
    }

    @Override
    public int magicPoints() {
        return healTheWorldRequiresMagicPoints();
    }

    @Override
    public void heal() {
        healedMonster.heal();
    }
}
