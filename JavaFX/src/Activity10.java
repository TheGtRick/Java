import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Activity10 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Circle circle = new Circle(200);
        Button prev = new Button();
        Button next = new Button();
        Label label = new Label();
        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.CRIMSON);
        colors.add(Color.CYAN);
        colors.add(Color.INDIGO);
        colors.add(Color.PALEGREEN);
        colors.add(Color.ORCHID);
        circle.setFill(colors.get(0));
        ArrayList<String> items = new ArrayList<String>();
        items.add("CRIMSON");
        items.add("CYAN");
        items.add("INDIGO");
        items.add("PALEGREEN");
        items.add("ORCHID");
        label.setText(items.get(0));
        prev.setText("Previous");
        next.setText("Next");
        EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int i = colors.indexOf(circle.getFill());
                if(i == 0) circle.setFill(colors.get(4));
                else circle.setFill(colors.get(i - 1));
                label.setText(items.get(colors.indexOf(circle.getFill())));
            }
        };
        prev.setOnMouseClicked(event1);
        EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int i = colors.indexOf(circle.getFill());
                if(i == 4) circle.setFill(colors.get(0));
                else circle.setFill(colors.get(i + 1));
                label.setText(items.get(colors.indexOf(circle.getFill())));
            }
        };
        next.setOnMouseClicked(event2);
        hbox.getChildren().addAll(label, prev, next);
        vbox.getChildren().addAll(circle, hbox);
        label.setTranslateX(0);
        prev.setTranslateX(100);
        next.setTranslateX(150);
        hbox.setTranslateX(0);
        hbox.setTranslateY(30);
        vbox.setStyle("-fx-background-color: #fff");
        vbox.setLayoutX(120);
        vbox.setLayoutY(0);
        Scene scene = new Scene(vbox, 600, 550);
        stage.setScene(scene);
        stage.show();
    }
}