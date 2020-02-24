package sample.models.magics.impl;

import sample.models.magics.AttackOn;
import sample.models.magics.BasicMagic;
import sample.models.monsters.BasicMonster;

public class AttackOnImpl implements AttackOn, BasicMagic {

    private BasicMonster monsterAttackOn;

    public AttackOnImpl() {
    }

    @Override
    public void attackOn() {
        monsterAttackOn.attackOn();
    }

    public void setMonsterAttackOn(BasicMonster monsterAttackOn) {
        this.monsterAttackOn = monsterAttackOn;
    }

    @Override
    public void doMagic() {
        attackOn();
    }
}
