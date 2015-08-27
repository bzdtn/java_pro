package com.bezditnyi.homework.lesson2.xml_yahoo_finance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;

/**
 * @author Viktor Bezditnyi
 */
@XmlRootElement(name = "rate")
public class Rate {
    private String name;
    private double rate;
    private String  date;
    private String time;
    private double ask;
    private double bid;

    public Rate(){}

    public Rate(String name, double rate, String date, String time, double ask, double bid) throws ParseException {
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }
    @XmlElement(name = "Rate")
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }
    @XmlElement(name = "Date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    @XmlElement(name = "Time")
    public void setTime(String time) {
        this.time = time;
    }

    public double getAsk() {
        return ask;
    }
    @XmlElement(name = "Ask")
    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }
    @XmlElement(name = "Bid")
    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "[" + name +
                ", rate=" + rate +
                ", " + date +
                " " + time +
                ", ask=" + ask +
                ", bid=" + bid +
                ']';
    }
}
