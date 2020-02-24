package sample.models.deck;

import sample.models.magics.BasicMagic;
import sample.models.magics.impl.AttackOnImpl;
import sample.models.monsters.*;

import java.util.*;

public class Deck {

    private final List<BasicMonster> monsters = Arrays.asList(
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
            new SophisticatedSam()
    );

    private Set<BasicMagic> magics = Set.copyOf(Arrays.asList(
            new AttackOnImpl()
    ));

    public List<BasicMonster> drawInitialMonsters() {
        List<BasicMonster> drawMonsters = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            drawMonsters.add(getRandomMonster());
        }
        return drawMonsters;
    }

    public BasicMonster getRandomMonster() {
        int randomNumber = new Random().nextInt() % monsters.size();
        BasicMonster basicMonster = monsters.get(randomNumber);
        monsters.remove(randomNumber);
        return basicMonster;
    }
}
