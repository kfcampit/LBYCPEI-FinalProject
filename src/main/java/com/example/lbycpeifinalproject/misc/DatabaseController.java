package com.example.lbycpeifinalproject.misc;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseController {

    private static final int MAX_NUM = 100;
    public static int numberProducts;
    public static ProductObject[] products = new ProductObject[MAX_NUM];

    public static void loadDatabase() throws Exception {
        Reader reader = Files.newBufferedReader(java.nio.file.Path.of("src/main/assets/database.csv"));
        List<String[]> data = readAll(reader);

        numberProducts = data.size();

        for (int i = 0; i < numberProducts; i++) {
            products[i].setId(Integer.parseInt(data.get(i)[0]));
            products[i].setName(data.get(i)[1]);
            products[i].setPrice(Double.parseDouble(data.get(i)[2]));
            products[i].setQuantityInStock(Integer.parseInt(data.get(i)[3]));
            products[i].setImageFileName(data.get(i)[4]);
            products[i].setDescription(data.get(i)[5]);
            products[i].setCategory(data.get(i)[6].split(";"));
            products[i].setRating(Double.parseDouble(data.get(i)[2]));
        }


    }

    public static List<String[]> readAll(Reader reader) throws Exception {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(false)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        List<String[]> list;
        list = csvReader.readAll();

        reader.close();
        csvReader.close();
        return list;
    }

    public static void updateDatabase() {

    }

    public static void main(String[] args) throws Exception {
        loadDatabase();
    }
}
