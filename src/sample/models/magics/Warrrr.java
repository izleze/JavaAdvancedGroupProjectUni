package sample.models.magics;

public interface Warrrr extends BasicMagic{

    void warTime();

    @Override
    default int requiresMagicPoints() {
        return 20;
    }
}
