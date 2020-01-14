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

public class imageViewTest extends Application implements Initializable {
  @FXML private ImageView monster1;
  @FXML private ImageView monster2;
  @FXML private ImageView monster3;
  @FXML public Button monsterButton1;
  @FXML public Button monsterButton2;
  @FXML public Button monsterButton3;
  @FXML private ImageView background;
  @FXML private Label labelOutput;
  private Image image3;
  Timeline timer;
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
    monsterButton1.setText(team[0].name);
    monsterButton2.setText(team[1].name);
    monsterButton3.setText(team[2].name);
    image3 = new Image("doukutu.jpg");
    background.setOpacity(0.75);
    background.setImage(image3);
  }
  @FXML
  public void onClick1(ActionEvent e) {
 	textShow(team[0]);
  }
  @FXML
  public void onClick2(ActionEvent e) {
  	textShow(team[1]);
  }
  @FXML
  public void onClick3(ActionEvent e) {
  	textShow(team[2]);
  }
  public void textShow(Character objectEnemy){
    labelOutput.setText("");
    labelOutput.setBackground(new Background(new BackgroundFill( Color.WHITE , CornerRadii.EMPTY , Insets.EMPTY )));
    labelOutput.setFont(new Font(20));
    labelOutput.setPrefHeight(50);
    List<String> list = new ArrayList<>();
    action(list,objectEnemy);
    k=0;
    timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
        	labelOutput.setText(list.get(k));
        	k = k + 1;
          if(k >= list.size()){
              timer.stop();
          }
        }
    }));
    timer.setCycleCount(list.size());
    timer.play();
  }
  public void action(List<String> list,Character objectEnemy){
    for(int i = 0;i<teamB.length;i++){
    	list.add(teamB[i].attack(objectEnemy));
    }
    if(objectEnemy.hp<=0){
    	list.add(objectEnemy.name + "のライフポイントは0になりました");
    }else{
    	list.add(objectEnemy.tellHp());
    }
    list.add("");
  }
}

