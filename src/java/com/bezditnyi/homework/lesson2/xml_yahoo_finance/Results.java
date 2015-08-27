package com.bezditnyi.homework.lesson2.xml_yahoo_finance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Viktor Bezditnyi
 */
@XmlRootElement(name = "results")
public class Results {
    @XmlElement(name = "rate")
    private List<Rate> rates = new ArrayList<>();

    public void add(Rate rate) {
        rates.add(rate);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(rates.toArray());
    }
}
