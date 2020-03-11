package sample.models.customJx;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import sample.models.magics.BasicMagic;

import java.io.Serializable;

public class MagicArea extends Button implements Serializable {

    private BasicMagic basicMagic;

    public MagicArea() {}

    public MagicArea(BasicMagic basicMagic) {
        super.setFont(Font.font(10));
        this.basicMagic = basicMagic;
    }

    public BasicMagic getBasicMonster() {
        return basicMagic;
    }

    public void setBasicMonster(BasicMagic basicMagic) {
        this.basicMagic = basicMagic;
    }
}
