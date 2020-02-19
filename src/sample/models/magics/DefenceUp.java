package sample.models.magics;

public interface DefenceUp extends BasicMagic{

    void defenceUp();

    @Override
    default int requiresMagicPoints() {
        return 10;
    }
}
