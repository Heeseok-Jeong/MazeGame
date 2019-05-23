import java.awt.Color;

import javax.swing.JPanel;

interface Movable{
	public void move(int x, int y, Player player);
}

class PlayerMoveLeft implements Movable{
	
	public void move(int x, int y, Player player) {
		if(x > 0 && Maze.map[x-1][y] == 1){
	    	player.setLocation(player.getX() - 25, player.getY());
	    	player.x--;
		}
	}
}

class PlayerMoveRight implements Movable{
	
	@Override
	public void move(int x, int y, Player player) {
		if(x < Maze.columns-1 && Maze.map[x+1][y] == 1){
	    	player.setLocation(player.getX()+25, player.getY());
	    	player.x++;
    	}
	}
}

class PlayerMoveUp implements Movable{
	
	@Override
	public void move(int x, int y, Player player) {
		if(y > 0 && Maze.map[x][y-1] == 1){
	    	player.setLocation(player.getX(), player.getY()-25);
	    	player.y--;
    	}
	}
}

class PlayerMoveDown implements Movable{

	@Override
	public void move(int x, int y, Player player) {
		if(y < Maze.rows-1 && Maze.map[x][y+1] == 1){
	    	player.setLocation(player.getX(), player.getY()+25);
	    	player.y++;
    	}
	}
}

public class Player extends JPanel{
	int x, y;
	
	private static Movable playerMove;
	
    public Player() {
//    	System.out.println("1");
    	this.setBackground(Color.getHSBColor(0.3f, 0.3f, 1));
    	this.setSize(Maze.panelSize, Maze.panelSize);
    }
    
    public void move() {
//    	System.out.println("2");
    	playerMove.move(x, y, this);
    }
    
    public void setPlayerMove(Movable playerMove) {
//    	System.out.println("playerMove : " + playerMove.toString());
    	Player.playerMove = playerMove;
    }

    
}