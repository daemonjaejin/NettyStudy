package study.funzin.main4;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by jin on 17. 2. 4.
 */
public class CsvReaderMain {

    public static void main(String [] args){

        try {

            File file = new File("D:\\data\\oss\\skt\\cm\\20170204\\Relation-1010.csv");
            CSVReader reader2 = new CSVReader(new FileReader(file));
            List<String[]> allElements = reader2.readAll();
            allElements.remove(2);
            FileWriter sw = new FileWriter(file);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
