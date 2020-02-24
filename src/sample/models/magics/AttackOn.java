package sample.models.magics;

public interface AttackOn {

    void attackOn();

    default int attackOnRequiresMagicPoints() {
        return 20;
    }
}
