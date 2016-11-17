package view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.PieceType;

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
     */
    public GamePieceGraphic(PieceType type) {

        Image image = new Image(getClass().getResourceAsStream("/resources/test_img.jpg"));
        setWidth(75);
        setHeight(75);
        setFill(new ImagePattern(image));
        setStroke(Color.BLACK);
    }
}
