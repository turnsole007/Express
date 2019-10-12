package test;



import java.io.File;

import subway.Subway;
import subway.SubwayLoader;

public class LoadTester
{
    public static void main(String[] args) {
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("src/ZhengSubway.txt"));
            
            System.out.println("Testing stations");
            if (    objectville.hasStation("郑州火车站") &&
                    objectville.hasStation("东大街站") &&
                    objectville.hasStation("孟庄站")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }
            
            System.out.println("\nTesting connections...");
            if (objectville.hasConnection("郑州大学站", "梧桐街站", "1号线") &&
                objectville.hasConnection("沙门站", "北三环站", "2号线") &&
                objectville.hasConnection("七里河站", "中原福塔站", "5号线")) {
                System.out.println("...connections test passed succesfully.");
            }
            else
            {
                System.out.println("...connections test FAILED");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
