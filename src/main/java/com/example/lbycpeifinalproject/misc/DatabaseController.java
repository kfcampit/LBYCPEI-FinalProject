package com.example.lbycpeifinalproject.misc;
import com.opencsv.*;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.util.*;

public class DatabaseController {

    private final int MAX_NUM = 100;
    public int numberProducts;
    public ProductObject[] products = new ProductObject[MAX_NUM];

    public void loadDatabase() throws Exception {
        Reader reader = Files.newBufferedReader(java.nio.file.Path.of("src/main/assets/database.csv"));
        List<String[]> data = readAll(reader);

        numberProducts = data.size();

        for (int i = 0; i < numberProducts; i++) {
            products[i] = new ProductObject();
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

    public List<String[]> readAll(Reader reader) throws Exception {
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

    public void updateDatabase() throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("src/main/assets/database.csv"));
        String[] line = new String[8];
        List<String[]> stringArray = new ArrayList<>(Collections.emptyList());

        stringArray.add(new String[]{
                "PRODUCT_ID",
                "PRODUCT_NAME",
                "PRODUCT_PRICE",
                "QUANTITY_IN_STOCK",
                "IMAGE_FILE_NAME",
                "PRODUCT_DESC",
                "PRODUCT_CATEG",
                "PRODUCT_RATING"
        });

        for (int i = 0; i < numberProducts; i++) {
            line = new String[8];
            line[0] = String.valueOf(products[i].getId());
            line[1] = products[i].getName();
            line[2] = String.valueOf(products[i].getPrice());
            line[3] = String.valueOf(products[i].getQuantityInStock());
            line[4] = products[i].getImageFileName();
            line[5] = products[i].getDescription();
            line[6] = String.join(";", products[i].getCategory());
            line[7] = String.valueOf(products[i].getRating());

            stringArray.add(line);
        }
        writer.writeAll(stringArray);
        writer.close();
    }

}
