package sample.models.magics;

public interface HealTheWorld extends BasicMagic{

    void heal();

    @Override
    default int requiresMagicPoints() {
        return 20;
    }
}
