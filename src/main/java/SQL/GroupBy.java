package SQL;

import java.io.*;
import java.util.*;

public class GroupBy {

    public static void groupBy(String p1, String method) throws IOException {

        File file = new File("C:\\Users\\rahul\\Documents\\filename.txt");
        BufferedWriter w1 = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        BufferedReader f1 = new BufferedReader(new FileReader(p1));

        Map<String, Double> kvMap = new HashMap<>();


        Iterator<String> iterator1 = f1.lines().iterator();

        while (iterator1.hasNext()){

            String[] kv = iterator1.next().split(",");

            if(kvMap.containsKey(kv[0])){

                switch (method){

                    case "Sum": kvMap.put(kv[0], kvMap.get(kv[0]) + Double.valueOf(kv[1]));
                        break;
                    case "Count": kvMap.put(kv[0], kvMap.get(kv[0]) + 1.0);
                        break;
                    case "Max": kvMap.put(kv[0], Math.max(kvMap.get(kv[0]), Double.valueOf(kv[1])));
                        break;
                    case "Min": kvMap.put(kv[0], Math.min(kvMap.get(kv[0]), Double.valueOf(kv[1])));
                        break;
                    case "First":
                        break;
                    case "Last": kvMap.put(kv[0], Double.valueOf(kv[1]));
                        break;
                    default:System.out.println("Please select a correct method");
                        break;
                }

            }else {
                switch (method) {
                    case "Count":
                        kvMap.put(kv[0], 1.0);
                        break;
                    default: kvMap.put(kv[0], Double.valueOf(kv[1]));
                        break;
                }
            }

        }

        for(Map.Entry<String, Double> line : kvMap.entrySet()){
            w1.write((line.getKey() + "," + line.getValue()));
            w1.newLine();
        }

        w1.close();
    }

    public static void main(String[] args) throws IOException {
        groupBy( "C:\\Users\\rahul\\Documents\\test.txt", "Max");
    }

}
