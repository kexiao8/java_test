package kexiao8.javatest.springtest;

import org.springframework.stereotype.Component;

/**
 * Created by tommyxiao on 3/27/21 19:23
 */
@Component
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing " + title + " by" + artist);
    }
}
