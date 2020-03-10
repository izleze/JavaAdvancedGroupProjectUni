package sample.models.customJx;

import javafx.scene.control.TextArea;
import sample.models.magics.BasicMagic;

public class MagicArea extends TextArea {

    private BasicMagic basicMagic;

    public MagicArea() {}

    public MagicArea(BasicMagic basicMagic) {
        this.basicMagic = basicMagic;
    }

    public BasicMagic getBasicMonster() {
        return basicMagic;
    }

    public void setBasicMonster(BasicMagic basicMagic) {
        this.basicMagic = basicMagic;
    }
}
