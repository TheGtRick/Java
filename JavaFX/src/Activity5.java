import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.*;

public class Activity5 extends Application{
    @Override
    public void start(Stage primarystage){
        Pane pane = new Pane();
        Ellipse node = new Ellipse();
        node.centerXProperty().bind(pane.widthProperty().divide(2));
        node.centerYProperty().bind(pane.widthProperty().divide(3));
        node.setRadiusX(200);
        node.setRadiusY(100);
        node.setStroke(Color.BLACK);
        node.setFill(Color.RED);
        pane.getChildren().add(node);
        Scene scene = new Scene(pane, 600, 400);
        primarystage.setTitle("Ellipse");
        primarystage.setScene(scene);
        primarystage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}