package com.bezditnyi.homework.lesson2.xml_yahoo_finance;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

/**
 * @author Viktor Bezditnyi
 */

public class Main {

    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";
        URL url = new URL(request);

        Query yahooQuery;
        JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        yahooQuery = (Query) unmarshaller.unmarshal(url);

        System.out.println(yahooQuery);
    }
}