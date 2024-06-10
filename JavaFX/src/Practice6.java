import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Practice6 extends Application{
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Line line = new Line();
        line.setStartX(40);
        line.setStartY(40);
        line.setEndX(120);
        line.setEndY(150);
        line.getStrokeWidth();
        pane.getChildren().addAll(line);
        Circle circle1 = new Circle();
        circle1.setRadius(10);
        circle1.setCenterX(40);
        circle1.setCenterY(40);
        Circle circle2 = new Circle(10);
        circle2.setRadius(10);
        circle2.setCenterX(120);
        circle2.setCenterY(150);
        pane.getChildren().addAll(circle1, circle2);
        Scene scene = new Scene(pane, 200, 200);
        stage.setTitle("Two circles");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
