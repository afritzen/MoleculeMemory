package model;

/**
 * Holds all possible types of gamepieces, named after different molecules.
 */
public enum PieceType {

    COVERED, H2O, N2, CO2;

    //TODO: create more!

    /**
     * Overrides the default toString()-method to return
     * image names that are used to load images onto the GamePieceGraphic object
     * depending on it's given type.
     * @return filename for piece graphic
     */
    @Override
    public String toString() {
        switch (this) {
            case H2O:
                return "h2o_mol.jpg";
            case N2:
                return "n2_mol.jpg";
            case CO2:
                return "co2_mol.jpg";
            default:
                return "cover.jpg";
        }
    }
}
