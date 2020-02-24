package sample.models.magics;

public interface Warrrr {

    void warTime();

    default int warRequiresMagicPoints() {
        return 20;
    }
}
