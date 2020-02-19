package sample.models.magics;

public interface AttackOn extends BasicMagic {

    void attackOn();

    @Override
    default int requiresMagicPoints() {
        return 20;
    }
}
