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
            if (    objectville.hasStation("֣�ݻ�վ") &&
                    objectville.hasStation("�����վ") &&
                    objectville.hasStation("��ׯվ")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }
            
            System.out.println("\nTesting connections...");
            if (objectville.hasConnection("֣�ݴ�ѧվ", "��ͩ��վ", "1����") &&
                objectville.hasConnection("ɳ��վ", "������վ", "2����") &&
                objectville.hasConnection("�����վ", "��ԭ����վ", "5����")) {
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
