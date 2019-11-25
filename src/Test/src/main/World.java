package main;


import java.util.ArrayList;
//import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import main.Element.*;


public abstract class World extends Pane {
    private AnimationTimer timer;
    private ArrayList<Controller> myControllers;
    
    public World() {

        this.myControllers = new ArrayList<Controller>();
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							for (Controller anController: myControllers) {
								if (anController.getViewer().getOnKeyReleased() != null) {
									anController.getViewer().getOnKeyReleased().handle(event);
								}
							}
						}

					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							for (Controller anController: myControllers) {
								if (anController.getViewer().getOnKeyPressed() != null) {
									anController.getViewer().getOnKeyPressed().handle(event);
								}
							}
						}

					});
				}

			}

		});
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                
                for (Controller anController: myControllers) {
                	anController.act(now);
                }
      
            }
        };
    }

    public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void add(Controller Controller) {
        getChildren().add(Controller.getViewer());
        this.myControllers.add(Controller);
    }

    public void remove(Controller Controller) {
        getChildren().remove(Controller.getViewer());
        this.myControllers.remove(Controller);
    }
    public <A extends Viewer> ArrayList<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Controller anController: myControllers) {
            if(cls.isInstance(anController.getViewer())){
                someArray.add((A)(anController.getViewer()));
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
