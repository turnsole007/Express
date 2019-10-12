package test;

import java.io.*;
import java.util.*;

import subway.Subway;
import subway.SubwayLoader;
import subway.SubwayPrinter;

public class SubwayTester
{
    public static void main(String[] args) {
    	/*
        if (args.length != 2) {
            System.err.println("Usage: SubwayTester [StartStation] [endStation]");
            System.exit(-1);
        }
        */
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("src/ZhengSubway.txt"));
            
            String start = "郑州大学站";
            String end = "五一公园站";
            //if (!objectville.hasStation(args[0])) {
            if (!objectville.hasStation(start)) {
                System.err.println(args[0] + " is not a station in Objecville");
                System.exit(-1);
            } //else if (!objectville.hasStation(args[1])) {
            else if (!objectville.hasStation(end)) {
                System.err.println(args[1] + " is not a station in Objecville");
                System.exit(-1);
            }
            
            //List route = objectville.getDirections(args[0], args[1]);
            List route = objectville.getDirections(start, end);
            SubwayPrinter printer = new SubwayPrinter();
            ArrayList<String> output = new ArrayList<String>();//输出缓存
            output = printer.printDirections(route);
            
            Iterator it = output.iterator();
            while(it.hasNext()){
            	System.out.println(it.next());
            }
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
