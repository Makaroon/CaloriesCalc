package com.caloriescalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    String fileName;

    public CSVReader(String fileName) {
        this.fileName = fileName;

    }

    public ArrayList<Food> readCSV(){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Food> foodList= new ArrayList<Food>();
        try {

            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] foodInfo = line.split(cvsSplitBy);
                Food f = new Food(foodInfo[0], Double.parseDouble(foodInfo[1]));
                foodList.add(f);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return foodList;
    }
}
