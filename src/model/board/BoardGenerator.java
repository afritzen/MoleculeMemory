package model.board;

import model.GamePiece;
import model.util.PieceType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Generates a board via static method with different difficulty-levels.
 */
public class BoardGenerator {

    /**
     * Default constructor, not needed.
     */
    public BoardGenerator(){}

    /**
     * Generates a board form a list of game pieces, which has been shuffled before to
     * guarantee that the pairs positions will differ everytime a new game is started.
     * This method only generates a very easy board for beginners who just got into the game.
     * @return the board, a 2d array consisting of GamePiece objects
     */
    public static GamePiece[][] generateEasyBoard() {

        // create list of all pieces and shuffle it
        ArrayList<GamePiece> boardEasy = new ArrayList<>();
        boardEasy.addAll(Arrays.asList(new GamePiece(PieceType.H2O), new GamePiece(PieceType.H2O),
                new GamePiece(PieceType.N2), new GamePiece(PieceType.N2), new GamePiece(PieceType.CO2),
                new GamePiece(PieceType.CO2)));
        Collections.shuffle(boardEasy);

        GamePiece[][] board = new GamePiece[2][3];
        Iterator<GamePiece> iterator = boardEasy.iterator();

        // push randomized list objects to final board
        while (iterator.hasNext()) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = iterator.next();
                    board[i][j].setxPos(i);
                    board[i][j].setyPos(j);
                }
            }
        }
        return board;
    }



}
