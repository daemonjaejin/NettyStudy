package study.funzin.main;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JE on 2016-11-22.
 */
public class CsvMain {

    public static void main(String args[]){

        String filePath = "D:\\data\\oss\\skt\\fm\\20161123\\";
        String fileName = "test.csv";

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("name", "ALARM.1452.csv");
        map.put("path", "D:\\data\\oss\\skt\\fm\\20161123\\");
        list.add(map);

        Map<String, String> map2 = new HashMap<>();
        map2.put("name", "ALARM.1455.csv");
        map2.put("path", "D:\\data\\oss\\skt\\fm\\20161123\\");
        list.add(map2);

        System.out.println(list.size());

        try {

            File newFile = new File(filePath + fileName);
            if(!newFile.isFile()) newFile.createNewFile();

            List<String []> allElements2 = new ArrayList<>();

            for (int i = 0; i <list.size(); i++) {

                System.out.println(list.get(i).get("path"));
                System.out.println(list.get(i).get("name"));
                File empty = new File(list.get(i).get("path") + list.get(i).get("name"));
                CSVReader reader = new CSVReader(new FileReader(empty));
                List<String[]> allElements = reader.readAll();
                if(i!=0){
                    allElements.remove(0);
                }
                allElements2.addAll(allElements);
                reader.close();
            }

            FileWriter fileWriter = new FileWriter(newFile);
            CSVWriter writer = new CSVWriter(fileWriter, ',', CSVWriter.NO_QUOTE_CHARACTER);
            writer.writeAll(allElements2);
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }

}
