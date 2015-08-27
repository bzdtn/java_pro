package com.bezditnyi.homework.lesson3.http_server;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}