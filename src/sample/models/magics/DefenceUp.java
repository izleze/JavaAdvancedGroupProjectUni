package sample.models.magics;

public interface DefenceUp {

    void defenceUp();

    default int defenceUpRequiresMagicPoints() {
        return 10;
    }
}
