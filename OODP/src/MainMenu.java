import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu {
	int level = 0;
    JFrame Menu = new JFrame("Maze");
    JButton Start = new JButton("Play");
    JButton Exit = new JButton("Exit");
    JButton MapMaker = new JButton("Map Maker");
    JButton Ranking = new JButton("Ranking");
    ImageIcon picture = new ImageIcon("res/Images/1.png");
    JLabel imageLabel = new JLabel(picture);
    ArrayList<String> mapList = new ArrayList<String>();
    ArrayList<String> modeList = new ArrayList<String>();
    JComboBox<String> lvlList, modeListBox;
    int menuWidth = 100; //Width of each button/item on display
    int menuHeight = 30;//Height of each button/item on display
    int menuY = 395; //Button/item location on display
    int WIDTH = 500;
    int HEIGHT = 500;
    MazeTimer mazeTimer;
            
	public MainMenu() {
    	//Load map list
    	getMapList();
    	lvlList = new JComboBox<String>(mapList.toArray(new String[mapList.size()]));
    	
    	//add mode list
    	modeList.add("Speed Mode");
    	modeListBox = new JComboBox<String>(modeList.toArray(new String[modeList.size()]));
    	
        //Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Start Button Variables
        Start.setSize(menuWidth,menuHeight);
        Start.setLocation(50, menuY);
        Menu.add(Start);
        Start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maze(("Level "+level+".map").toString(), 0);
				Menu.setVisible(false);
			}
        	
        });	
        
       //Map Maker Button Variables
        MapMaker.setSize(menuWidth,menuHeight);
        MapMaker.setLocation(200, menuY);
        Menu.add(MapMaker);
        MapMaker.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Access();
				Menu.setVisible(true);
			}
        });
        
      //Ranking Button Variables
        Ranking.setSize(menuWidth,menuHeight);
        Ranking.setLocation(350, menuY);
        Menu.add(Ranking);
        Ranking.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Ranking();
				Menu.setVisible(true);
			}
        });
        
        //Level Selector
        
/*        lvlList.setSize(menuWidth+35, menuHeight);
        lvlList.setLocation(230, menuY);
        Menu.add(lvlList);*/
        
        //Exit Button Variables
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(250,menuY);
       // Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            System.exit(0);
			}
        });
        
        //Display Picture
        imageLabel.setBounds(0, 0, 500, 470);
        imageLabel.setVisible(true);
        Menu.add(imageLabel);
        Menu.setVisible(true);
    }

    static boolean levelsExistAlready = false;

    public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
    			mapList.add("Level "+i+".map");
    			levelsExistAlready = true;
    		}
    	}
    }
}