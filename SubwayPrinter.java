package subway;

import java.io.*;
import java.util.*;

public class SubwayPrinter
{
    //private PrintStream out;
    
    /*public SubwayPrinter(OutputStream out) {
        this.out = new PrintStream(out);
    }*/
    
    public ArrayList<String> printDirections(List route) {
    	ArrayList<String> output = new ArrayList<String>();
    	
        Connection connection = (Connection) route.get(0);
        String currentLine = connection.getLineName();
        String previousLine = currentLine;
        
        output.add("���� " + connection.getStation1().getName() + " �ϳ�.\n");
        
        output.add("����� " + currentLine + " ���� " + connection.getStation2().getName() + " ����.\n");
        for (int i = 1; i < route.size(); i++) {
            connection = (Connection) route.get(i);
            currentLine = connection.getLineName();
            if (currentLine.equals(previousLine)) {
            	output.add("  ��һվ��  " + connection.getStation1().getName() + "\n");
            }
            else {
                output.add("  ��һվ��  " + connection.getStation1().getName() + "\n" + previousLine + "���ó̼�����������׼������.\n");
                output.add("*** "+connection.getStation1().getName()+" ���ˣ��뻻��  " + currentLine + " ���� " + connection.getStation2().getName() + " ***.\n");
                previousLine = currentLine;
            }
        }
        output.add("###��һվ�� " + connection.getStation2().getName() + " ����\n��׼���³���ף����;��죡\n");
        
        
        return output;
    }
}
