package sample.models.customJx;

import javafx.scene.control.TextArea;
import sample.models.monsters.BasicMonster;

public class MonsterArea extends TextArea {

    private BasicMonster basicMonster;

    public MonsterArea() {}

    public MonsterArea(BasicMonster monster) {
        this.basicMonster = monster;
    }

    public BasicMonster getBasicMonster() {
        return basicMonster;
    }

    public void setBasicMonster(BasicMonster basicMonster) {
        this.basicMonster = basicMonster;
    }

    public void updateData() {
        super.setText(basicMonster.getClass()
                .getSimpleName() +
                "\nAttackPower: " +
                basicMonster.getAttackPower() +
                "\nDefencePower: " +
                basicMonster.getDefencePower() +
                "\nMagicPower: " +
                basicMonster.getMagicPower() +
                "\nSpeed: " +
                basicMonster.getSpeed());
    }
}
