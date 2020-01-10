import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ImageViewTest extends Application implements Initializable {
  @FXML private ImageView monster1;
  @FXML private ImageView monster2;
  @FXML private ImageView monster3;
  @FXML public Button monster_button_1;
  @FXML public Button monster_button_2;
  @FXML public Button monster_button_3;
  @FXML private ImageView background;
  @FXML private Label label_Output;
  private Image image3;
  public Character[] team= {new Character("ルパン",400,"image.jpg"), new Character("五右衛門",250,"image2.jpg"),new Character("次元",350,"image3.jpg")};
  public Character[] teamB= {new Character("ルシファー",1000,"image.jpg"), new Character("マリック",1000,"image.jpg"),new Character("ポケモン",1000,"image.jpg")};
  int k;
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) throws Exception{
    Pane root = FXMLLoader.load(getClass().getResource("ImageViewTest.fxml"));
    stage.setTitle("ImageView Test");
    stage.setScene(new Scene(root));
    stage.show();
  }
  @Override
  public void initialize(java.net.URL url, java.util.ResourceBundle bundle) {
    monster1.setImage(team[0].image);
    monster2.setImage(team[1].image);
    monster3.setImage(team[2].image);
    monster_button_1.setText(team[0].name);
    monster_button_2.setText(team[1].name);
    monster_button_3.setText(team[2].name);
    image3 = new Image("doukutu.jpg");
    background.setOpacity(0.75);
    background.setImage(image3);
  }
  @FXML
  public void onClick1(ActionEvent e) {
 	text_show(team[0]);
  }
  @FXML
  public void onClick2(ActionEvent e) {
  	text_show(team[1]);
  }
  @FXML
  public void onClick3(ActionEvent e) {
  	text_show(team[2]);
  }
  public void text_show(Character object_enemy){
    label_Output.setText("");
    label_Output.setBackground(new Background(new BackgroundFill( Color.WHITE , CornerRadii.EMPTY , Insets.EMPTY )));
    label_Output.setFont(new Font(20));
    label_Output.setPrefHeight(50);

    List<String> list = new ArrayList<>();
    action(list,object_enemy);
    k=0;
    Timeline timer = new Timeline(new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
        	label_Output.setText(list.get(k));
        	k = k + 1;
        }
    }));
    timer.setCycleCount(list.size());
    timer.play();
  }
  public void action(List<String> list,Character object_enemy){
    for(int i = 0;i<teamB.length;i++){
    	list.add(teamB[i].attack(object_enemy));
    }
    if(object_enemy.hp<=0){
    	list.add(object_enemy.name + "のライフポイントは0になりました コメント");
    }else{
    	list.add(object_enemy.tell_hp());
    }
    list.add("");
  }
}

