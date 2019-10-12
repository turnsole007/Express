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
        
        output.add("您在 " + connection.getStation1().getName() + " 上车.\n");
        
        output.add("请乘坐 " + currentLine + " 开往 " + connection.getStation2().getName() + " 方向.\n");
        for (int i = 1; i < route.size(); i++) {
            connection = (Connection) route.get(i);
            currentLine = connection.getLineName();
            if (currentLine.equals(previousLine)) {
            	output.add("  下一站：  " + connection.getStation1().getName() + "\n");
            }
            else {
                output.add("  下一站：  " + connection.getStation1().getName() + "\n" + previousLine + "的旅程即将结束，请准备换乘.\n");
                output.add("*** "+connection.getStation1().getName()+" 到了，请换乘  " + currentLine + " 开往 " + connection.getStation2().getName() + " ***.\n");
                previousLine = currentLine;
            }
        }
        output.add("###下一站： " + connection.getStation2().getName() + " 到了\n请准备下车，祝您旅途愉快！\n");
        
        
        return output;
    }
}
