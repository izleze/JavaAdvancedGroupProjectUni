package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sample.models.monsters.BasicMonster;
import sample.models.player.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Player player1 = new Player();
    private Player player2 = new Player();

    @FXML
    public BorderPane mainPanel;
    public HBox monstersPlayer1;
    public Label magicPlayer1;
    public HBox monstersPlayer2;
    public Label magicPlayer2;
    public Button startGame;
    public GridPane mainGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        magicPlayer1.setDisable(true);
        magicPlayer2.setDisable(true);
        updateMagicPoints();

        monstersPlayer1.getChildren()
                .addAll(createMonstersForUser(player1));

        monstersPlayer2.getChildren()
                .addAll(createMonstersForUser(player2));
    }

//    private List<> createMonsters()
    private void updateMagicPoints() {
        magicPlayer1.textProperty().setValue(String.valueOf(player1.getMagicPower()));
        magicPlayer2.textProperty().setValue(String.valueOf(player2.getMagicPower()));
    }

    private List<TextArea> createMonstersForUser(Player player) {
        List<TextArea> monsters = new ArrayList<>();
        for (BasicMonster monster : player.getCurrentAliveMonsters()) {
            monsters.add(createMonsterText(monster));
        }
        return monsters;
    }

    private TextArea createMonsterText(BasicMonster basicMonster) {
        TextArea textArea = new TextArea(
                basicMonster.getClass()
                        .getSimpleName() +
                "\nAttackPower: " +
                basicMonster.getAttackPower() +
                "\nDefencePower: " +
                basicMonster.getDefencePower() +
                "\nMagicPower: " +
                basicMonster.getMagicPower() +
                "\nSpeed: " +
                basicMonster.getSpeed());
        textArea.setEditable(false);

        textArea.setOnDragEntered(
                dragEvent -> {
                    Dragboard dragboard = dragEvent.getDragboard();

                    Node node = dragEvent.getPickResult().getIntersectedNode();
                    Integer cIndex = GridPane.getColumnIndex(node);
                    Integer rIndex = GridPane.getRowIndex(node);
                    mainGrid.add(node, cIndex, rIndex);
                    dragEvent.consume();
                }
                );
        return textArea;
    }
}
