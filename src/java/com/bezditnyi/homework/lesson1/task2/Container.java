package com.bezditnyi.homework.lesson1.task2;

import java.io.*;

/**
 * @author Viktor Bezditnyi
 */

@SaveTo(path = "src/resources/lesson1/file.txt")
public class Container {
    private TextContainer textContainer;

    public Container() {
        this.textContainer = new TextContainer("Default text for Container");
    }

    public Container(String text){
        this.textContainer = new TextContainer(text);
    }

    public Container(TextContainer textContainer){
        this.textContainer = textContainer;
    }

    @Saver
    public void save(String path){
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(this.textContainer.getText());
        } catch (IOException e) {
            System.out.println("Container save " + e);
        }
    }

//    @Saver
    public void secureSave(String path) {
        File file = new File(path);
        //file.
        try (FileWriter fw = new FileWriter(file.getParent() + "/tmp/" + file.getName())) {
            fw.write(this.textContainer.getText());
        } catch (IOException e) {
            System.out.println("Container secureSave " + e);
        }
    }
}
