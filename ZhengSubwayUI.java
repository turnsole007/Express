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
		//����һ�����ڣ�����һ������
		myframe frame = new myframe("֣�ݵ���"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//���ô��ڴ�С 
		frame.setSize(1690, 900);
		//��ʾ����
		frame.setVisible(true);
   }
}
