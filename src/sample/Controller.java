package sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sample.models.customJx.MagicArea;
import sample.models.customJx.MonsterArea;
import sample.models.magics.BasicMagic;
import sample.models.monsters.BasicMonster;
import sample.models.player.Player;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable {

    private static final DataFormat BASIC_MONSTER = new DataFormat("basicMonster");

    private Player player1 = new Player();
    private Player player2 = new Player();

    ObjectMapper objectMapper = new ObjectMapper();

    int rndm1;
    int rndm2;
    int time = 180;

    private static final String defaultMonstersText = "Monsters in deck: ";
    private static final String defaultKilledMonstersText = "Killed Monsters: ";

    @FXML
    public BorderPane mainPanel;
    public Label magicPlayer1;
    public Label magicPlayer2;
    public Label Player1;
    public Label Player2;
    public Label timer;
    public Label randomNum1;
    public Label randomNum2;
    public Label deck1;
    public Label deck2;
    public Label killedMonsters1;
    public Label killedMonsters2;
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

        deck1.setText(defaultMonstersText + player1.getDeck().getMonsters().size());
        deck2.setText(defaultMonstersText + player2.getDeck().getMonsters().size());

        killedMonsters1.setText(defaultKilledMonstersText + player1.getKilledMonsters());
        killedMonsters2.setText(defaultKilledMonstersText + player2.getKilledMonsters());

        mainGrid.setOnDragOver(dragEvent -> {
            dragEvent.acceptTransferModes(TransferMode.MOVE);
            dragEvent.consume();
        });

        mainGrid.setOnDragDropped(dragEvent -> {
            Dragboard dragboard = dragEvent.getDragboard();
            try {
                mainGrid.add(objectMapper.readValue((String) dragboard.getContent(BASIC_MONSTER), Button.class),
                        ((int) dragEvent.getSceneX()), (int) dragEvent.getSceneY());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
                    timerForTime.cancel();
                }
            }
        }, 1000,1000);
    }

    private void updateMagicPoints() {
        magicPlayer1.textProperty().setValue(String.valueOf(player1.getMagicPower()));
        magicPlayer2.textProperty().setValue(String.valueOf(player2.getMagicPower()));
    }

    private MagicArea createMagicArea(BasicMagic basicMagic) {
        MagicArea magicArea = new MagicArea(basicMagic);
        magicArea.setText(basicMagic.getClass().getSimpleName().replace("Impl", "") +
                "\nRequires magic points: " + basicMagic.magicPoints());

        return magicArea;
    }

    private List<MagicArea> createMagicsForUser(Player player) {
        List<MagicArea> magics = new ArrayList<>();
        player.getRandomMagic()
                .ifPresent(basicMagic -> magics.add(createMagicArea(basicMagic))
        );
        return magics;
    }

    private List<MonsterArea> createMonstersForUser(Player player) {
        List<MonsterArea> monsters = new ArrayList<>();
        for (BasicMonster monster : player.getCurrentAliveMonsters()) {
            monsters.add(createMonsterArea(monster));
        }
        return monsters;
    }

    private MonsterArea createMonsterArea(BasicMonster basicMonster) {
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

        monsterArea.setOnDragDetected(event -> {
            Dragboard dragboard = monsterArea.startDragAndDrop(TransferMode.ANY);

            ClipboardContent clipboard = new ClipboardContent();

            try {
                clipboard.put(DataFormat.PLAIN_TEXT, objectMapper.writeValueAsString(monsterArea));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            dragboard.setContent(clipboard);

            event.consume();
        });

        monsterArea.setOnDragDone(dragEvent -> {
            HBox parent = (HBox) monsterArea.getParent();
            parent.getChildren().remove(monsterArea);
        });

        return monsterArea;
    }
}
