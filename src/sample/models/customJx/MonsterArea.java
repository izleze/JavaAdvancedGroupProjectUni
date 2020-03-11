package sample.models.customJx;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import sample.models.monsters.BasicMonster;

public class MonsterArea extends Button {

    private BasicMonster basicMonster;

    public MonsterArea() {}

    public MonsterArea(BasicMonster monster) {
        super.setFont(Font.font(10));
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
