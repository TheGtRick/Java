import javafx.application.Application;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Activity6 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){
        VBox box = new VBox();
        Circle circle = new Circle(50, Color.CORAL);
        circle.setCenterX(150);
        circle.setCenterY(150);
        TextArea text = new TextArea();
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
            @Override 
            public void handle(MouseEvent e) {
                text.appendText("Mouse event handler has been called\n");
            } 
        };  
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
        box.getChildren().addAll(circle, text);
        box.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        Scene scene = new Scene(box, 600, 600);
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();
    }
}