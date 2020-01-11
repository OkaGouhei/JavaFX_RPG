import javafx.scene.image.*;
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
