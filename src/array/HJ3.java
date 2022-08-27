package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @ClassName HJ3
 * @Description TODO
 * @Author katefu
 * @Date 7/30/22 12:47 PM
 * @Version 1.0
 **/
public class HJ3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String totalString  = br.readLine();
        int total = Integer.valueOf(totalString);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<total; i++){
            int cur = Integer.valueOf(br.readLine());
            set.add(cur);
        }

        for(int i=0; i<set.size(); i++){
            System.out.println(set.pollFirst());
        }
    }
}
