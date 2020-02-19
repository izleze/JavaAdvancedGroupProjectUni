package sample.models.monsters;

import sample.models.magics.HealTheWorld;

public final class DogEatingBug extends BasicMonster implements HealTheWorld {

    private int attackPower;
    private int defencePower;
    private int magicPower;
    private int speed;

    public DogEatingBug() {
        super(10, 2, 8, 5);
        this.attackPower = super.attackPower;
        this.defencePower = super.defencePower;
        this.magicPower = super.magicPower;
        this.speed = super.speed;
    }

    @Override
    public void heal(){
        this.defencePower = super.defencePower;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public int getDefencePower() {
        return defencePower;
    }

    @Override
    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    @Override
    public int getMagicPower() {
        return magicPower;
    }

    @Override
    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
