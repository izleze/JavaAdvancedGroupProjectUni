package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sample.models.customJx.MagicArea;
import sample.models.customJx.MonsterArea;
import sample.models.magics.BasicMagic;
import sample.models.monsters.BasicMonster;
import sample.models.player.Player;

import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable {

    private Player player1 = new Player();
    private Player player2 = new Player();

    int rndm1;
    int rndm2;
    int time = 180;

    @FXML
    public BorderPane mainPanel;
    public Label magicPlayer1;
    public Label magicPlayer2;
    public Label Player1;
    public Label Player2;
    public Label timer;
    public Label randomNum1;
    public Label randomNum2;
    public Button startGame;
    public Button placeMonsters;
    public Button placeMonster;
    public Button activateMagic;
    public Button atack;
    public Button move;
    public Button endTurn;
    public GridPane mainGrid;
    public HBox monstersPlayer1;
    public HBox monstersPlayer2;
    public HBox magicCards1;
    public HBox magicCards2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rndm1 = new Random().nextInt(6);
        do {
            rndm2 = new Random().nextInt(6);
        } while (rndm1 == rndm2);
        randomNum1.setText(randomNum1.getText() + " " + new Random().nextInt(6));
        randomNum2.setText(randomNum2.getText() + " " + new Random().nextInt(6));
        timer.setText(String.valueOf(time));
    }

    public void startGame() {
        randomNum1.setVisible(false);
        randomNum1.setDisable(true);
        randomNum2.setVisible(false);
        randomNum2.setDisable(true);

        if (rndm1 > rndm2) {
            Player1.setDisable(true);
        } else {
            Player2.setDisable(true);
        }
        magicPlayer1.setDisable(true);
        magicPlayer2.setDisable(true);
        updateMagicPoints();

        monstersPlayer1.getChildren()
                .addAll(createMonstersForUser(player1));

        monstersPlayer2.getChildren()
                .addAll(createMonstersForUser(player2));

        magicCards1.getChildren().addAll(createMagicsForUser(player1));
        magicCards2.getChildren().addAll(createMagicsForUser(player2));

        startGame.setVisible(false);
        startGame.setDisable(true);

        placeMonsters.setDisable(false);
        placeMonsters.setVisible(true);
        startTimer();
    }

    private void startTurn() {

    }

    private void endOfTurn() {
        if (Player1.isDisabled()) {
            Player1.setDisable(false);
            Player2.setDisable(true);
        } else {
            Player2.setDisable(false);
            Player1.setDisable(true);
        }
        startTimer();
    }

    public void placeMonsters() {
        endTurn.setVisible(true);
        endTurn.setDisable(false);

    }

    public void endTurn() {

        startTimer();
    }

    private void startTimer() {
        AtomicInteger defTime = new AtomicInteger(time);
        Timer timerForTime = new Timer();
        timerForTime.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(defTime.get() > 0)
                {
                    Platform.runLater(() -> {
                        timer.setText(String.valueOf(defTime.get()));
                        defTime.getAndDecrement();
                    });
                }
                else {
                    endOfTurn();
                    timerForTime.cancel();
                }
            }
        }, 1000,1000);
    }

    private void updateMagicPoints() {
        magicPlayer1.textProperty().setValue(String.valueOf(player1.getMagicPower()));
        magicPlayer2.textProperty().setValue(String.valueOf(player2.getMagicPower()));
    }

    private MagicArea createMagicText(BasicMagic basicMagic) {
        MagicArea magicArea = new MagicArea(basicMagic);
        magicArea.setText(basicMagic.getClass().getSimpleName().replace("Impl", "") +
                "\nRequires magic points: " + basicMagic.magicPoints());

        return magicArea;
    }

    private List<MagicArea> createMagicsForUser(Player player) {
        List<MagicArea> magics = new ArrayList<>();
        player.getRandomMagic()
                .ifPresent(basicMagic -> magics.add(createMagicText(basicMagic))
        );
        return magics;
    }

    private List<MonsterArea> createMonstersForUser(Player player) {
        List<MonsterArea> monsters = new ArrayList<>();
        for (BasicMonster monster : player.getCurrentAliveMonsters()) {
            monsters.add(createMonsterText(monster));
        }
        return monsters;
    }

    private MonsterArea createMonsterText(BasicMonster basicMonster) {
//        AtomicReference<Node> node = null;
        MonsterArea monsterArea = new MonsterArea(basicMonster);
        monsterArea.setText(basicMonster.getClass()
                .getSimpleName() +
                "\nAttackPower: " +
                basicMonster.getAttackPower() +
                "\nDefencePower: " +
                basicMonster.getDefencePower() +
                "\nMagicPower: " +
                basicMonster.getMagicPower() +
                "\nSpeed: " +
                basicMonster.getSpeed());
        monsterArea.setEditable(false);
//        textArea.setDisable(true);
//        textArea.setOpacity(1);
//        textArea.setOnMouseClicked(
//                mouseEvent -> {
//                    Stage dialogStage = new Stage();
//
//                    Scene scene =new Scene(root,300,150);
//                    dialogStage.setScene(scene);
//                    dialogStage.setTitle("alert");
//                    dialogStage.initModality(Modality.WINDOW_MODAL);
//                    Label lab_alert= new Label("title");
//                    grd_pan.add(lab_alert, 0, 1);
//                    Button btn_ok = new Button("fermer");
//                    btn_ok.setOnAction(new EventHandler<ActionEvent>() {
//                        grd_pan.add(btn_ok, 0, 2);
//                        dialogStage
//                    });
//                }
//        );
//        textArea.setOnMouseDragReleased(
//                dragEvent -> {
//                    Integer cIndex = GridPane.getColumnIndex(node.get());
//                    Integer rIndex = GridPane.getRowIndex(node.get());
//                    mainGrid.add(node.get(), cIndex, rIndex);
//                    dragEvent.consume();
//                });
        return monsterArea;
    }
}
