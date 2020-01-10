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

public class Character{
	public Image image;
	public String name;
	public int hp;

	public Character(String  name,int hp,String photo){
		this.hp = hp;
		this.name = name;
		image = new Image(photo);
	}
	public String introduce(){
		return "私の名前は" + name + "だ";
	}
	public String tell_hp(){
		return name+"のライフポイントは" + hp + "だ";
	}
	public String attack(Character enemy){
		enemy.hp -= 50;
		return this.name + "が" + enemy.name +"に攻撃する。";
	}
}