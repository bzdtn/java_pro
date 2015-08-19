package com.bezditnyi.homework.lesson1.task2v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Viktor Bezditnyi
 */
@SaveTo(path = "src/resources/lesson1/zoo.txt")
public class TextContainer {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Saver
    public void save(String path){
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(this.text);
        } catch (IOException e) {
            System.out.println("TextContainer save " + e);
        }
    }

//    @Saver
    public void secureSave(String path) {
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file.getParent() + "/tmp/" + file.getName())) {
            fw.write(this.text);
        } catch (IOException e) {
            System.out.println("TextContainer secureSave " + e);
        }
    }

}
