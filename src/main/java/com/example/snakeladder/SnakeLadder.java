package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SnakeLadder extends Application {
    public static final int tileSize = 40, width = 10,  height = 10,

        buttonLine = height*tileSize + 50, infoLine = height*tileSize + 20;


    Player playerFirst, playerSecond;
    boolean firstPlayerTurn=true, gamestart=false;
    private int diceValue;
    private Pane createContent(){
    Pane root = new Pane();
    root.setPrefSize(400, 500);
  //  int height = 0, width = 0, tileSize;
        //   root.setPrefSize(width*tileSize, height*tileSize*100);

    //putting 100 tiles on the UI
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                tile tile = new tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().addAll(tile);
            }
        }

        //putting Image on the root
        Image img = new Image(C:\Users\Manoj\Pictures\snakeladder.png);
        ImageView boarImage = new ImageView();
        boarImage.setFitWidth(width*tileSize);
        boarImage.setFitHeight(height*tileSize);
        root.getChildren().addAll(boarImage);

        //root.getChildren().addAll(boarImage);

        //Buttons and Info
        Button startButton = new Button("Start");
        startButton.setTranslateX(180);
        startButton.setTranslateY(buttonLine);

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(10);
        playerOneButton.setTranslateY(buttonLine);

        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(buttonLine);

        Label diceLabel = new Label("Start the Game");
        diceLabel.setTranslateX(165);
        diceLabel.setTranslateY(infoLine);

        // players
        playerFirst = new Player("Arjun", Black, tileSize/2);
        playerSecond = new Player("Balvan", White,tileSize/2-5);

        playerOneButton.setAction(new EventHandler<ActionEvent>() {
                                      @Override
                                      public void handle(ActionEvent actionEvent) {
                                          if (gamestart) {
                                              if (firstPlayerTurn) {
                                                  diceValue = rollDice();
                                                  diceLabel.setText("Dice Number" + diceValue);
                                                  playerFirst.movePlayer(diceValue);
                                                  firstPlayerTurn = !firstPlayerTurn;
                                                  if (playerFirst.checkWinner()) {
                                                      diceLabel.setText("Winner is" + playerFirst.getName());
                                                      startButton.setText("Restart");
                                                      startButton.setDisable(false);
                                                      firstPlayerTurn = true;
                                                      gamestart = false;
                                                  }
                                              }
                                          }
                                      }
                                  });
                                  playerTwoButton.setAction(new EventHandler<ActionEvent>()){
            @Override
                    public void handle(ActionEvent ActionEvent){
                if(gamestart){
                    if(!firstPlayerTurn){
                        diceValue=rollDice();
                        diceLabel.setText("Dice Number" + diceValue);
                        playerSecond.movePlayer(diceValue);
                        firstPlayerTurn=!firstPlayerTurn;
                        if(playerSecond.checkWinner()){
                            diceLabel.setText("Winner is" + playerSecond.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn=true;
                            gamestart=false;
                        }
                    }
                }
            }
        });
        startButton.setAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                gamestart=true;
                startButton.setDisable(true);
                playerFirst.setstart();
                playerSecond.setstart();
            }
                              });
        root.getChildren().addAll(boarImage, startButton, playerOneButton, playerTwoButton, diceLabel,
               playerFirst.getCoin(), playerSecond.getCoin());

        return root;
    }
    private int rollDice(){
        return (int) (Math.random()*6+1);
    }
    @Override
    public void start(Stage Stage) throws IOException {
        Scene scene = new Scene(createContent());
        Stage.setTitle("Snake & Ladder");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
    private void launch() {
    }