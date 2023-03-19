package com.example.snakeladder;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> positionCoordinates;   //attributes
    private ArrayList<Integer> ladderandSnakeBite;

    public Board() {
        populatePositionCoordinates();
        setSnakeLadder();
    }

    private void populatePositionCoordinates() {   //Method
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<>(0, 0)); // dummy value
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                // X-axis
                int XCord = 0;
                if (i % 2 == 0) {
                    XCord = j * SnakeLadder.tileSize + SnakeLadder.tileSize / 2;
                } else {
                    XCord = SnakeLadder.tileSize * SnakeLadder.height - j * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;
                }
                //Y-axis
                int YCord = SnakeLadder.tileSize * SnakeLadder.height - i * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;

                positionCoordinates.add(new Pair<>(XCord, YCord));
            }

        }
    }

    private void setSnakeLadder() {
        ladderandSnakeBite = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            ladderandSnakeBite.add(i);
        }
        ladderandSnakeBite.set(4, 25);
        ladderandSnakeBite.set(4, 25);
        ladderandSnakeBite.set(13, 46);
        ladderandSnakeBite.set(27, 5);
        ladderandSnakeBite.set(33, 49);
        ladderandSnakeBite.set(40, 3);
        ladderandSnakeBite.set(42, 63);
        ladderandSnakeBite.set(43, 18);
        ladderandSnakeBite.set(50, 69);
        ladderandSnakeBite.set(54, 31);
        ladderandSnakeBite.set(62, 81);
        ladderandSnakeBite.set(66, 45);
        ladderandSnakeBite.set(76, 58);
        ladderandSnakeBite.set(89, 53);
        ladderandSnakeBite.set(99, 41);
    }

    public int getXCoordinate(int position) {
        if (position <= 100) {
            return positionCoordinates.get(position).getKey();
        }
        return -1;
    }

    public int getYCoordinates(int position) {
        if (position > 0 && position < 100) {
            return positionCoordinates.get(position).getValue();
        }
        return -1;
    }

    public int getSnakeLadder(int position) {
        return ladderandSnakeBite.get(position);
    }

    public static void main(String[] args) {
        Board board = new Board();

        for (int i = 0; i < board.positionCoordinates.size(); i++) {
            System.out.println(" X : " + board.positionCoordinates.get(i).getKey()
                    + " Y : " + board.positionCoordinates.get(i).getValue());
        }
    }
}