package model.board;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import model.GamePiece;
import model.util.Constants;
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
     * Contains all pieces that belong to a board with easy difficulty.
     */
    private ArrayList<GamePiece> boardEasy;
    /**
     * Contains all pieces that belong to a board with medium difficulty.
     */
    private ArrayList<GamePiece> boardMedium;
    /**
     * Contains all pieces that belong to a board with hard difficulty.
     */
    private ArrayList<GamePiece> boardHard;
    private Iterator<GamePiece> iterator;

    /**
     * Fills all array lists with content for board generation.
     */
    public BoardGenerator(){

        boardEasy = new ArrayList<>();
        boardEasy.addAll(Arrays.asList(new GamePiece(PieceType.H2O), new GamePiece(PieceType.H2O),
                new GamePiece(PieceType.N2), new GamePiece(PieceType.N2), new GamePiece(PieceType.CO2),
                new GamePiece(PieceType.CO2)));

        //TODO: fill!
        boardMedium = new ArrayList<>();
        boardHard = new ArrayList<>();

    }

    /**
     * Generates a board form a list of game pieces, which has been shuffled before to
     * guarantee that the pairs positions will differ every time a new game is started.
     * This method only generates a very easy board for beginners who just got into the game.
     * @return the board, a 2d array consisting of GamePiece objects
     */
    public GamePiece[][] generateEasyBoard() {

        // shuffle list of all pieces
        Collections.shuffle(boardEasy);
        GamePiece[][] board = new GamePiece[2][3];
        iterator = boardEasy.iterator();

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

    /**
     * {@link #generateEasyBoard()}.
     */
    public GamePiece[][] generateMediumBoard() {

        Collections.shuffle(boardMedium);
        GamePiece[][] board = new GamePiece[10][10];
        iterator = boardMedium.iterator();

        while (iterator.hasNext()) {
            for(int i = 0; i < Constants.BOARD_MEDIUM_SIZE; i++) {
                for(int j = 0; j < Constants.BOARD_MEDIUM_SIZE; j++)  {
                    board[i][j] = iterator.next();
                    board[i][j].setxPos(i);
                    board[i][j].setyPos(j);
                }
            }
        }
        return board;
    }

    /**
     * {@link #generateEasyBoard()}.
     */
    public GamePiece[][] generateHardBoard() {

        Collections.shuffle(boardHard);
        GamePiece[][] board = new GamePiece[20][20];
        iterator = boardHard.iterator();

        while (iterator.hasNext()) {
            for(int i = 0; i < Constants.BOARD_HARD_SIZE; i++) {
                for(int j = 0; j < Constants.BOARD_HARD_SIZE; j++)  {
                    board[i][j] = iterator.next();
                    board[i][j].setxPos(i);
                    board[i][j].setyPos(j);
                }
            }
        }
        return board;
    }

}
