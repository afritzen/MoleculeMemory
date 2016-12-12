package model.util;

import controller.MenuController;
import view.MenuView;

/**
 * Holds some frequently used controllers so they don't have to be
 * created new every.
 */
public class StandardControllerManager {

    /**
     * Standard menu controller.
     */
    private static MenuController menuController = new MenuController(new MenuView());

    public static MenuController getMenuController() {
        return menuController;
    }

}
