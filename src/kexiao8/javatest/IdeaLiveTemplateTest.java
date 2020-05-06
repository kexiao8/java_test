package kexiao8.javatest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tommyxiao on 2/23/20 11:36
 * demonstrate how to use idea live template
 * test environment：Mac OS
 * Replace Key Cmd with Win when test on Windows
 */
public class IdeaLiveTemplateTest {
    //psfi
    public static final int psfi = 1;

    //psfs
    public static final String psfs = "psfs";

    // psvm
    public static void main(String[] args) {
        //Cmd+J select live template

        //Cmd+Option+T, then select Surround code fragments
        try {
            int j = 100;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //St
        String str = "str";

        // ifn
        if (str == null) {

        }

        //inn
        if (str != null) {

        }

        // for i
        for (int i = 0; i < 100; i++) {
            //sout
            System.out.println("sout");
        }

        List<String> list = new ArrayList<>();
        //itco
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object next =  iterator.next();

        }

        //iter
        for (String s : list) {

        }

        //itli
        for (int i = 0; i < list.size(); i++) {
            String s =  list.get(i);

        }

    }
}
