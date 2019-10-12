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
	
	JLabel startlabel = new JLabel("��ʼվ��"); 
	JLabel endlabel = new JLabel("�յ�վ��");
	Font font = new Font("", Font.BOLD, 22);
	
	//����JTextField��16��ʾ16�У�����JTextField�Ŀ����ʾ�����������ַ�����
	JTextField startField = new JTextField(16);
	JTextField endField = new JTextField(16);
	JTextArea textArea=new JTextArea(17,80);
    JScrollPane scrollPanel=new JScrollPane(textArea);
	
	JButton button = new JButton("��ѯ·��");
	
	//���캯�� 
	public myframe(String title)
	{ 
		//�̳и��࣬ 
		super(title); 
		//�������
		Container contentPane = getContentPane();
		//contentPane.setLayout(new FlowLayout());
		contentPane.setLayout(null);
		//�������ִ�С
		startlabel.setFont(font); 
		endlabel.setFont(font);
		startField.setFont(font);
		endField.setFont(font);
		button.setFont(font);
		textArea.setFont(font);
		//����λ��
		labelImg.setBounds(15, 10, 1123, 785); //ָ�������λ��
		startlabel.setBounds(1145, 10, 100, 50);
		startField.setBounds(1245, 10, 300, 50);
		endlabel.setBounds(1145, 70, 100, 50);
		endField.setBounds(1245, 70, 300, 50);
		button.setBounds(1300, 130, 150, 50);
		scrollPanel.setBounds(1145, 190, 500, 610);
		//��ӿؼ�
		contentPane.add(labelImg);
		contentPane.add(startlabel); 
		contentPane.add(startField);
		contentPane.add(endlabel);
		contentPane.add(endField);
		contentPane.add(button);
		contentPane.add(scrollPanel);
		//��ť������� lambda���ʽ 
		button.addActionListener((e) -> { Quary(); }); 
	}

    //�¼�����
	private void Quary()
	{
		String start = startField.getText();//��ȡ��������
		String end = endField.getText();//��ȡ��������
		
		ArrayList<String> output = new ArrayList<String>();//�������		
		
		try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("src/ZhengSubway.txt"));
            
            if(start.equals("")) {
            	output.add("ʼ��վδ���룡��\n");
            }
            else if (!objectville.hasStation(start)) {
              
                output.add(start + " ���ڵ���·���У����������Ƿ�����\n");
               
            }
            else if(end.equals("")) {
            	output.add("�յ�վδ���룡��\n");
            }
            else if (!objectville.hasStation(end)) {
                
            	output.add(end + " ���ڵ���·���У����������Ƿ�����\n");
                
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

