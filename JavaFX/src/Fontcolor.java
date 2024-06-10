import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fontcolor extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public int a = 3;
    public void start(Stage stage){
        RadioButton r1 = new RadioButton("Red");
        RadioButton r2 = new RadioButton("Yellow");
        RadioButton r3 = new RadioButton("Black");
        RadioButton r4 = new RadioButton("Orange");
        RadioButton r5 = new RadioButton("Green");
        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);
        r5.setToggleGroup(group);
        HBox box = new HBox();
        box.getChildren().addAll(r1, r2, r3, r4, r5);
        Text text = new Text("Programming is fun");
        text.setX(200);
        text.setY(150);
        Button bt1 = new Button("<=");
        Button bt2 = new Button("=>");
        bt1.setTranslateX(200);
        bt1.setTranslateY(250);
        bt2.setTranslateX(250);
        bt2.setTranslateY(250);
        EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                a -= 1;
            }
        };
        EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                a += 1;
            }
        };
        r3.setSelected(true);
        bt1.addEventFilter(MouseEvent.MOUSE_CLICKED, event1);
        bt2.addEventFilter(MouseEvent.MOUSE_CLICKED, event2);
        int e = a%5;
        if(e == 1){
            r5.setSelected(false);
            r2.setSelected(false);
            r1.setSelected(true);
        }
        else if(e == 2){
            r1.setSelected(false);
            r3.setSelected(false);
            r2.setSelected(true);
        }
        else if(e == 3){
            r2.setSelected(false);
            r4.setSelected(false);
            r3.setSelected(true);
        }
        else if(e == 4){
            r3.setSelected(false);
            r5.setSelected(false);
            r4.setSelected(true);
        }
        else{
            r4.setSelected(false);
            r1.setSelected(false);
            r5.setSelected(true);
        }
        if(r1.isSelected()){
            text.setFill(Color.RED);
        }
        else if(r2.isSelected()){
            text.setFill(Color.YELLOW);
        }
        else if(r3.isSelected()){
            text.setFill(Color.BLACK);
        }
        else if(r4.isSelected()){
            text.setFill(Color.ORANGE);
        }
        else if(r5.isSelected()){
            text.setFill(Color.GREEN);
        }
        Group g = new Group(box, bt1, bt2, text);
        Scene scene = new Scene(g, 600, 300);
        stage.setTitle("SettingColor");
        stage.setScene(scene);
        stage.show();
    } 
}
