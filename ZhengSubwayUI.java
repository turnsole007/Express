package ui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class ZhengSubwayUI { 
	public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() { 
        	public void run()
		    { 
        		createGUI(); 
		    } 
        	}); 
    } 
	private static void createGUI()
   {
		//创建一个窗口，创建一个窗口
		myframe frame = new myframe("郑州地铁"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//设置窗口大小 
		frame.setSize(1690, 900);
		//显示窗口
		frame.setVisible(true);
   }
}
