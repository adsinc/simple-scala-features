package javainterop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author a.dolgiy
 * Date: 2019-06-27 18:35
 */
public class CallScalaCode {

    public static List<String> getStrings() {
        return Arrays.asList("Hello", "World");
    }

    public static void main(String[] args) {
        Hello greeter = new Hello("John", "Snow");
        System.out.println(greeter.getName());
        System.out.println(greeter.name());
    }
}
