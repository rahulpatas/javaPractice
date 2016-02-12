package SQL;

import java.io.*;
import java.util.*;

public class Joins {

    public static void joins (String joinType, String p1, String p2) throws IOException {

        File file = new File("C:\\Users\\rahul\\Documents\\filename.txt");
        BufferedWriter w1 = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        BufferedReader f1 = new BufferedReader(new FileReader(p1));
        BufferedReader f2 = new BufferedReader(new FileReader(p2));

        final Map<String, List<String>> keyValueMap = new HashMap<>();


        Iterator<String> iterator1 = f1.lines().iterator();

        while (iterator1.hasNext()){

            String[] keyValue = iterator1.next().split(",");

            if(keyValueMap.containsKey(keyValue[0])){
                keyValueMap.get(keyValue[0]).add(keyValue[1]);
            }else {

                List<String> values = new ArrayList<>();
                values.add(keyValue[1]);
                keyValueMap.put(keyValue[0], values);
            }

        }

        Iterator<String> iterator = f2.lines().iterator();

        while (iterator.hasNext()){

            String[] keyValue = iterator.next().split(",");

            if(keyValueMap.containsKey(keyValue[0])){

                for(Map.Entry<String, List<String>> line : keyValueMap.entrySet()){

                    for(String value : line.getValue()) {
                        w1.write((line.getKey() + ",," + value));
                        w1.newLine();
                    }
                }

                keyValueMap.remove(keyValue[0]);

            }else if(joinType.equals("left") || joinType.equals("outer")){

                w1.write(keyValue[0] + ","+ keyValue[1] +  ",");
                w1.newLine();
            }
        }

        if(joinType.equals("outer")){
            for(Map.Entry<String, List<String>> line : keyValueMap.entrySet()){

                for(String value : line.getValue()) {
                    w1.write((line.getKey() + ",," + value));
                    w1.newLine();
                }
            }
        }

        w1.close();
    }

    public static void main(String[] args) throws IOException {
        joins("left", "C:\\Users\\rahul\\Documents\\test.txt", "C:\\Users\\rahul\\Documents\\test2.txt");
    }
}
