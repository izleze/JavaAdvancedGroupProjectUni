package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.DefenceUp;
import sample.models.monsters.BasicMonster;

public class DefenceUpImpl implements DefenceUp, BasicMagic {

    private BasicMonster defenceUpMonster;

    public void setDefenceUpMonster(BasicMonster defenceUpMonster) {
        this.defenceUpMonster = defenceUpMonster;
    }

    @Override
    public void defenceUp() {
        defenceUpMonster.defenceUp();
    }

    @Override
    public void doMagic() {
        defenceUp();
    }

    @Override
    public int magicPoints() {
        return defenceUpRequiresMagicPoints();
    }
}
