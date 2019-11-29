module Frogger {
    requires javafx.media;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.deploy;
    requires javafx.graphics;
    requires javafx.swing;

    opens main.Stage.StageController;

    exports main;
    exports main.Stage.StageController;
}