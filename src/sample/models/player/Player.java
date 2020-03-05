package sample.models.player;

import sample.models.actions.SacrificeMonster;
import sample.models.deck.Deck;
import sample.models.monsters.BasicMonster;

import java.util.ArrayList;
import java.util.List;

public class Player implements SacrificeMonster{

    private Deck deck = new Deck();

    private int magicPower = 10;

    private final List<BasicMonster> currentAliveMonsters = new ArrayList<>();

    public Player() {
        currentAliveMonsters.addAll(deck.drawInitialMonsters());
    }

    public void startOfTheTurn() {

    }

    public void firstTurn() {

    }

    @Override
    public void sacrifice(BasicMonster basicMonster) {
        this.magicPower +=
                basicMonster.getDefencePower();
    }

    public List<BasicMonster> getCurrentAliveMonsters() {
        return currentAliveMonsters;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }
}
