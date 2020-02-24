package sample.models.magics;

public interface HealTheWorld {

    void heal();

    default int healTheWorldRequiresMagicPoints() {
        return 20;
    }
}
