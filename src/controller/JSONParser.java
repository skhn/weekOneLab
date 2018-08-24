package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import repository.beans.Stocks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    private ObjectMapper objectMapper;
    private List<String> rowList;
    private URL url;

    private static JSONParser single_instance = null;

    public List<String> getRowList() {
        return rowList;
    }


    private JSONParser() {
        this.objectMapper = new ObjectMapper();
        this.rowList = new ArrayList<>();
        {
            try {
                this.url = new URL("https://bootcamp-training-files.cfapps.io/week1/week1-stocks.json");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }


        {
            try {
                List<Stocks> stockList = objectMapper.readValue(url, new TypeReference<List<Stocks>>(){});
                for (Stocks stocks : stockList) {
                    rowList.add(stocks.toString());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONParser getJSONParserInstance()
    {
        if (single_instance == null)
            single_instance = new JSONParser();


        return single_instance;
    }



//    Stocks stock;

//    String json =
//
//            "{ \"symbol\" : \"AAPL\", \"price\" : 1000.00 , \"volume\" : 5000, \"date\" : \"2018-06-22T08:30:00.000+0000\" }";
//
//    {
//        try {
//            stock = objectMapper.readValue(json, Stocks.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    public static void main(String[] args) {
//        System.out.println(getJSONParserInstance().getRowList().get(3));
//    }

}
