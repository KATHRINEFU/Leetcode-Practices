package stack_heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author katefu
 * @Date 4/25/23 4:10 PM
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        String pathString = "???rrurdr?";
        System.out.println(correctPath(pathString));
    }

    public static String correctPath(String s) {
        Random random = new Random();
        while (true) {
            List<Character> route = new ArrayList<>();
            List<String> tracepos = new ArrayList<>();
            int x = 1, y = 5, answer = 1;
            for (char i : s.toCharArray()) {
                if (i == '?') {
                    i = "lrud".charAt(random.nextInt(4));
                }
                if (i == 'u') {
                    y += 1;
                } else if (i == 'd') {
                    y -= 1;
                } else if (i == 'r') {
                    x += 1;
                } else if (i == 'l') {
                    x -= 1;
                }
                String currentPosition = x + "," + y;
                if (tracepos.contains(currentPosition)) {
                    answer = 0;
                    break;
                } else {
                    tracepos.add(currentPosition);
                }
                route.add(i);
                if (x == 6 || x == 0 || y == 0 || y == 6) {
                    answer = 0;
                    break;
                }
            }
            if (x == 5 && y == 1 && answer == 1) {
                StringBuilder sb = new StringBuilder();
                for (char c : route) {
                    sb.append(c);
                }
                return sb.toString();
            }
        }
    }
}
