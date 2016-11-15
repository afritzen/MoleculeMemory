package controller;

import model.Board;
import view.BoardView;

public class BoardController {

    private Board board;
    private BoardView boardView;

    public BoardController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
    }

    public void showBoardView() {
        boardView.showGame();
    }

}