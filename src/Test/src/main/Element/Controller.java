package main.Element;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class Controller {

    public abstract void act(long timer);

    public abstract Viewer getViewer();
}
