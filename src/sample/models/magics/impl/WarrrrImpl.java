package sample.models.magics.impl;

import sample.models.magics.BasicMagic;
import sample.models.magics.Warrrr;
import sample.models.monsters.BasicMonster;

public class WarrrrImpl implements Warrrr, BasicMagic {

    private BasicMonster gearUpMonster;

    public void setGearUpMonster(BasicMonster gearUpMonster) {
        this.gearUpMonster = gearUpMonster;
    }

    @Override
    public void doMagic() {
        warTime();
    }

    @Override
    public int magicPoints() {
        return warRequiresMagicPoints();
    }

    @Override
    public void warTime() {
        gearUpMonster.warTime();
    }
}
