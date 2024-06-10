import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Activity7 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        Text title = new Text(275, 50, "MyCoffeeShop");
        title.setStyle("-fx-font-size: 35");
        ChoiceBox<String> box = new ChoiceBox<String>();
        ObservableList<String> list = box.getItems();
        list.add("Latte");
        list.add("Americano");
        list.add("Cappuccino");
        list.add("Black tea");
        list.add("Green tea");
        box.setTranslateX(325);
        box.setTranslateY(75);
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        vbox2.setTranslateX(650);
        vbox2.setTranslateY(200);
        vbox1.setTranslateX(50);
        vbox1.setTranslateY(200);
        RadioButton r1 = new RadioButton("Whole milk");
        RadioButton r2 = new RadioButton("Soy milk");
        RadioButton r3 = new RadioButton("Almond milk");
        RadioButton r4 = new RadioButton("No milk");
        ToggleGroup tg1 = new ToggleGroup();
        r1.setToggleGroup(tg1);
        r2.setToggleGroup(tg1);
        r3.setToggleGroup(tg1);
        r4.setToggleGroup(tg1);
        Text text1 = new Text(650, 180, "Add:");
        Text text2 = new Text(50, 180, "Milk option:");
        CheckBox c1 = new CheckBox("Sugar");
        CheckBox c2 = new CheckBox("Extra hot");
        CheckBox c3 = new CheckBox("Extra milk");
        CheckBox c4 = new CheckBox("Straw");
        CheckBox c5 = new CheckBox("Napkins");
        vbox2.getChildren().addAll(c1, c2, c3, c4, c5);
        vbox1.getChildren().addAll(r1, r2, r3, r4);
        Button bt = new Button("Place Order");
        bt.setTranslateX(340);
        bt.setTranslateY(350);
        TextArea txt1 = new TextArea();
        TextArea txt2 = new TextArea();
        TextArea txt3 = new TextArea();
        txt1.setMaxSize(200, 20);
        txt2.setMaxSize(200, 20);
        txt3.setMaxSize(200, 20);
        txt1.setTranslateX(50);
        txt1.setTranslateY(400);
        txt2.setTranslateX(290);
        txt2.setTranslateY(400);
        txt3.setTranslateX(530);
        txt3.setTranslateY(400);
        Text tx2 = new Text("");
        tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                RadioButton rb = (RadioButton)tg1.getSelectedToggle();
                if (rb != null) {
                    String s = rb.getText();
                    tx2.setText(s);
                }
            }
        });
        Text tx3 = new Text();
        EventHandler<ActionEvent> check = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                String sd = "";
                if(c1.isSelected()){
                    sd += c1.getText() + " ";
                }
                if(c2.isSelected()){
                    sd += c2.getText() + " ";
                }
                if(c3.isSelected()){
                    sd += c3.getText() + " ";
                }
                if(c4.isSelected()){
                    sd += c4.getText() + " ";
                }
                if(c5.isSelected()){
                    sd += c5.getText() + " ";
                }
                tx3.setText(sd);
            }
        };
        c1.setOnAction(check);
        c2.setOnAction(check);
        c3.setOnAction(check);
        c4.setOnAction(check);
        c5.setOnAction(check);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){ 
            @Override 
            public void handle(MouseEvent e){
                txt1.appendText(box.getValue() + "\n");
                txt2.appendText(tx2.getText() + "\n");
                txt3.appendText(tx3.getText() + "\n");
            } 
        };
        bt.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        Group group = new Group(title, box, vbox2, vbox1, text1, text2, bt, txt1, txt2, txt3);
        Scene scene = new Scene(group, 800, 600);
        stage.setTitle("CoffeeShop");
        stage.setScene(scene);
        stage.show();
    }
}
