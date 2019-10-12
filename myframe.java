package ui;

import java.awt.Container; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import subway.Subway;
import subway.SubwayLoader;
import subway.SubwayPrinter;

public class myframe extends JFrame{
	
	JLabel labelImg = new JLabel(new ImageIcon("src/subway.png"));
	
	JLabel startlabel = new JLabel("起始站："); 
	JLabel endlabel = new JLabel("终点站：");
	Font font = new Font("", Font.BOLD, 22);
	
	//创建JTextField，16表示16列，用于JTextField的宽度显示而不是限制字符个数
	JTextField startField = new JTextField(16);
	JTextField endField = new JTextField(16);
	JTextArea textArea=new JTextArea(17,80);
    JScrollPane scrollPanel=new JScrollPane(textArea);
	
	JButton button = new JButton("查询路线");
	
	//构造函数 
	public myframe(String title)
	{ 
		//继承父类， 
		super(title); 
		//内容面板
		Container contentPane = getContentPane();
		//contentPane.setLayout(new FlowLayout());
		contentPane.setLayout(null);
		//设置文字大小
		startlabel.setFont(font); 
		endlabel.setFont(font);
		startField.setFont(font);
		endField.setFont(font);
		button.setFont(font);
		textArea.setFont(font);
		//设置位置
		labelImg.setBounds(15, 10, 1123, 785); //指定插入的位置
		startlabel.setBounds(1145, 10, 100, 50);
		startField.setBounds(1245, 10, 300, 50);
		endlabel.setBounds(1145, 70, 100, 50);
		endField.setBounds(1245, 70, 300, 50);
		button.setBounds(1300, 130, 150, 50);
		scrollPanel.setBounds(1145, 190, 500, 610);
		//添加控件
		contentPane.add(labelImg);
		contentPane.add(startlabel); 
		contentPane.add(startField);
		contentPane.add(endlabel);
		contentPane.add(endField);
		contentPane.add(button);
		contentPane.add(scrollPanel);
		//按钮点击处理 lambda表达式 
		button.addActionListener((e) -> { Quary(); }); 
	}

    //事件处理
	private void Quary()
	{
		String start = startField.getText();//获取输入内容
		String end = endField.getText();//获取输入内容
		
		ArrayList<String> output = new ArrayList<String>();//输出缓存		
		
		try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("src/ZhengSubway.txt"));
            
            if(start.equals("")) {
            	output.add("始发站未输入！！\n");
            }
            else if (!objectville.hasStation(start)) {
              
                output.add(start + " 不在地铁路线中，请检查输入是否有误\n");
               
            }
            else if(end.equals("")) {
            	output.add("终点站未输入！！\n");
            }
            else if (!objectville.hasStation(end)) {
                
            	output.add(end + " 不在地铁路线中，请检查输入是否有误\n");
                
            }
            
            List route = objectville.getDirections(start, end);
            SubwayPrinter printer = new SubwayPrinter();
            output = printer.printDirections(route);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
		
		Iterator it1 = output.iterator();
        while(it1.hasNext()){
        	textArea.append((String) it1.next());
        }
	}
	
}

