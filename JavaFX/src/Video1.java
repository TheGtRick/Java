import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Video1 extends Application{
    @Override
    public void start(Stage primaryStage){

        Pane pane = new Pane();
        StackPane pane2 = new StackPane();
        FlowPane pane3 = new FlowPane();
        pane3.setPadding(new Insets(11, 12, 13, 14));
        pane3.setHgap(5);
        pane3.setVgap(5);

        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.widthProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        pane2.getChildren().add(new Button("OK"));
        
        Stage stage2 = new Stage();
        stage2.setTitle("Pane");
        Scene scene2 = new Scene(pane, 200, 200);
        stage2.setScene(scene2);
        stage2.show();

        Scene scene1 = new Scene(pane2, 200, 200);
        primaryStage.setTitle("StackPane");
        primaryStage.setScene(scene1);
        primaryStage.show();

        Stage stage3 = new Stage();
        stage3.setTitle("FlowPane");
        Scene scene3 = new Scene(pane3, 200, 200);
        stage3.setScene(scene3);
        stage3.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}