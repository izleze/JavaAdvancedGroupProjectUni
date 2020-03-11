package sample.models.deck;

import sample.models.magics.BasicMagic;
import sample.models.magics.impl.*;
import sample.models.monsters.*;

import java.util.*;

public class Deck {

    private List<BasicMonster> monsters = new ArrayList<>();

    {
        monsters.addAll(Arrays.asList(
                new DogEatingBug(),
                new DogEatingBug(),
                new DogEatingBug(),
                new DrunkenKnight(),
                new DrunkenKnight(),
                new DrunkenKnight(),
                new MagicCat(),
                new MagicCat(),
                new MagicCat(),
                new ReclesCannibal(),
                new ReclesCannibal(),
                new ReclesCannibal(),
                new SandTurtle(),
                new SandTurtle(),
                new SandTurtle(),
                new SophisticatedSam(),
                new SophisticatedSam(),
                new SophisticatedSam()));
    }

    private final Set<BasicMagic> magics = Set.copyOf(Arrays.asList(
            new AttackOnImpl(),
            new DefenceUpImpl(),
            new HealTheWorldImpl(),
            new MoveMagicImpl(),
            new WarrrrImpl()
    ));


    public List<BasicMonster> getMonsters() {
        return monsters;
    }

    public List<BasicMonster> drawInitialMonsters() {
        List<BasicMonster> drawMonsters = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            drawMonsters.add(getRandomMonster());
        }
        return drawMonsters;
    }

    public BasicMonster getRandomMonster() {
        int randomNumber = new Random().nextInt(monsters.size());
        BasicMonster basicMonster = monsters.get(randomNumber);
        monsters.remove(basicMonster);
        return basicMonster;
    }

    public Optional<BasicMagic> getRandomMagic() {
        return magics
                .stream()
                .findAny();
    }
}
