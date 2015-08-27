package com.bezditnyi.homework.lesson3.http_server;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;

public class FileManager {
    private String path;
    private static ConcurrentHashMap<String, CacheRecord> map = new ConcurrentHashMap<>();

    public FileManager(String path) {
        // "c:\folder\" --> "c:\folder"
        if (path.endsWith("/") || path.endsWith("\\"))
            path = path.substring(0, path.length() - 1);

        this.path = path;
    }

    public byte[] get(String url) {
        try {
            CacheRecord cacheRecord = map.get(url);
            String fullPath = path.replace('\\', '/') + url;
            File file = new File(fullPath);

            if (cacheRecord != null) { // in cache
                if (!file.exists()){ // file disappeared
                    map.remove(url);
                    System.out.println("Can\'t find " + url + ", cache has been cleaned");
                    return null;
                }
                long modificationTime = file.lastModified();
                if (modificationTime == cacheRecord.getTime()) {
                    return cacheRecord.getBuf();
                }
            }

            // "c:\folder" + "/index.html" -> "c:/folder/index.html"
//            String fullPath = path.replace('\\', '/') + url;

            byte[] buf;
//            RandomAccessFile f = new RandomAccessFile(fullPath, "r");
//            try with resources
            try (RandomAccessFile f = new RandomAccessFile(fullPath, "r")) {
                buf = new byte[(int) f.length()];
                f.read(buf, 0, buf.length);
            }
//            finally {
//                f.close();
//            }
            cacheRecord = new CacheRecord(buf, file.lastModified());
            System.out.println(url + ", cache updated - " + file.lastModified());
            map.put(url, cacheRecord); // put to cache
            return buf;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private class CacheRecord {
        private byte[] buf;
        private long time;

        public CacheRecord(byte[] buf, long time){
            this.buf = buf;
            this.time = time;
        }

        public byte[] getBuf() {
            return buf;
        }

        public long getTime() {
            return time;
        }
    }
}
