package sample.models.magics;

public interface MoveMagic {

    void moveMagic(int x, int y);

    default int moveMagicRequiresMagicPoints() {
        return 10;
    }
}
