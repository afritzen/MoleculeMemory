package view;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.util.Constants;
import model.util.PieceType;

/**
 * Custom graphic for a game piece. Holds an image with the molecule/formula
 * on it and sets all common values such as width, height and a stroke.
 */
public class GamePieceGraphic extends Rectangle{

    /**
     * Sets the attributes all pieces share. From the type-parameter,
     * a filename is constructed and the image is loaded into the rectangle to be
     * displayed as soon as the player uncovers it in the game.
     * @param type type of the piece, used to create image
     * @param dX offset in x-direction
     * @param dY offset in y-direction
     */
    public GamePieceGraphic(PieceType type, int dX, int dY) {

        Image image = new Image(getClass().getResourceAsStream("/resources/pieces/" + type.toString()));
        setWidth(Constants.PIECE_SIZE);
        setHeight(Constants.PIECE_SIZE);
        setTranslateX(dX * Constants.GRID_WIDTH);
        setTranslateY(dY * Constants.GRID_WIDTH);
        setFill(new ImagePattern(image));
        setStroke(Color.BLACK);
        setCursor(Cursor.HAND);
    }
}
