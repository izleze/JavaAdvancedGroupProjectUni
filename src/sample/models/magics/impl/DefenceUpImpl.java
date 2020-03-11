package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.DefenceUp;
import sample.models.monsters.BasicMonster;

public class DefenceUpImpl implements DefenceUp, BasicMagic {

    private BasicMonster defenceUpMonster;

    @Override
    public void setMonster(BasicMonster defenceUpMonster) {
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
