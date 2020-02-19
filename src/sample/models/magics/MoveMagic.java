package sample.models.magics;

public interface MoveMagic extends BasicMagic{

    void moveMagic();

    @Override
    default int requiresMagicPoints() {
        return 10;
    }
}
