package GUI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View extends Application{
    private Controller controller;
    public final static int Y_OFFSET = 7;
    private Image[][] pieces;

    public static void main(String args) {
        launch(args);
    }
    private void createMVC() {
        Model model = new Model();
        pieces = new Image[model.getBoard().GRID_SIZE][model.getBoard().GRID_SIZE];
        this.controller = new Controller(this, model);
    }

    public static final int TILE_SIZE = 100;

    private Parent createContent() {
        Group root = new Group();
        root.getChildren().add(controller.getModel().getBoard());

        return root;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        createMVC();
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
    
    public Image[][] getPieces() {
    	return this.pieces;
    }



}
