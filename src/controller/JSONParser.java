package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import repository.Credentials;
import repository.beans.Stocks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class processes the dataset from the url and returns a list of strings (List of Quotes).
 *
 */

class JSONParser {

    private ObjectMapper objectMapper;
    private List<String> rowList;
    private URL url;

    private static JSONParser single_instance = null;

    List<String> getRowList() {
        return rowList;
    }


    private JSONParser() {
        this.objectMapper = new ObjectMapper();
        this.rowList = new ArrayList<>();
        {
            try {
                this.url = new URL(Credentials.getURL());
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

    static JSONParser getJSONParserInstance()
    {
        if (single_instance == null)
            single_instance = new JSONParser();


        return single_instance;
    }
}
