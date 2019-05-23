import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.*;
import java.util.List;


/** 
 * 
 * @author heeseok
 *
 */
public class Ranking extends JFrame{
	JLabel labelRank;
	static HashMap rankHashMap = new HashMap();
	static String name, time;
	
	
	public Ranking() {
		super("Ranking");
		setLayout(new GridLayout(2,1));
		this.setLocation(100, 280);
		
		if(rankHashMap.isEmpty())
			initializeRank();
	
		// sort		
		Iterator it = sortByValue(rankHashMap).iterator();

		// show
		int i = 0;
		labelRank = new JLabel("<html>");
		
		while(it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key : " + key + ", value : " + rankHashMap.get(key));
			labelRank.setText(labelRank.getText() + (i+1) +". " + key + ", " + rankHashMap.get(key) + "<br>");
			if(i == 4) break;
			i++;
        }
		
		labelRank.setText(labelRank.getText() + "</html>");
		labelRank.setFont(new Font("GOTHIC", Font.BOLD, 17));
		add(labelRank);
		setSize(300, 300);
		setVisible(true);
	}
	
	public Ranking(String name2, float time2) {
		super("Ranking");
		setLayout(new GridLayout(2,1));
		this.setLocation(100, 280);
		
		name = name2;
		time = Float.toString(time2);
		
		if(rankHashMap.isEmpty())
			initializeRank();
		
		insertRank();
		
	
		// sort
		Iterator it = sortByValue(rankHashMap).iterator();

		// show
		int i = 0;
		labelRank = new JLabel("<html>");
	
		while(it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key : " + key + ", value : " + rankHashMap.get(key));
			labelRank.setText(labelRank.getText() + (i+1) +". " + key + ", " + rankHashMap.get(key) + "<br>");
			if(i == 4) break;
			i++;
        }
		
		labelRank.setText(labelRank.getText() + "</html>");
		labelRank.setFont(new Font("GOTHIC", Font.BOLD, 17));
		add(labelRank);
		setSize(300, 300);
		setVisible(true);
	}
	

	public void initializeRank() {
		rankHashMap.put("Issac", 24.620);
		rankHashMap.put("Mathew", 27.274);
		rankHashMap.put("Peter", 31.122);
		rankHashMap.put("Lee", 35.982);
		rankHashMap.put("John", 28.015);
	}
	
	private void insertRank() {
		rankHashMap.put(name, time);
	}
	
	public void showRank() {
		
	}
	
	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list,new Comparator() {
			public int compare(Object o1,Object o2) {
				Float v1 = Float.parseFloat(map.get(o1).toString());
				Float v2 = Float.parseFloat(map.get(o2).toString());
				System.out.println("v1 : " + v1 + ", v2 : " + v2);
		
				return ((Comparable) v2).compareTo(v1);
			}
		});

		Collections.reverse(list); // 주석시 오름차순
		return list;
	}


}
