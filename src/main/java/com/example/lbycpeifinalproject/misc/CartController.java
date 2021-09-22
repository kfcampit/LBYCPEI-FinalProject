package com.example.lbycpeifinalproject.misc;

import com.opencsv.*;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartController {

    public final int MAX_NUM = 100;
    public int numberCartItems;
    public CartObject[] cart = new CartObject[MAX_NUM];

    public void loadCart() throws Exception {
        Reader reader = Files.newBufferedReader(java.nio.file.Path.of("src/main/assets/userCart.csv"));
        List<String[]> data = readAll(reader);

        numberCartItems = data.size();

        for (int i = 0; i < numberCartItems; i++) {
            cart[i] = new CartObject();
            cart[i].setId(Integer.parseInt(data.get(i)[0]));
            cart[i].setQuantity(Integer.parseInt(data.get(i)[1]));
        }


    }

    private List<String[]> readAll(Reader reader) throws Exception {
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

    public void updateCart(int n) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("src/main/assets/userCart.csv"));
        String[] line = new String[2];
        List<String[]> stringArray = new ArrayList<>(Collections.emptyList());

        stringArray.add(new String[]{
                "PRODUCT_ID",
                "QUANTITY",
        });

        for (int i = 0; i < n + 1; i++) {
            line = new String[2];
            line[0] = String.valueOf(cart[i].getId());
            line[1] = String.valueOf(cart[i].getQuantity());

            stringArray.add(line);
        }
        writer.writeAll(stringArray);
        writer.close();
    }

}
