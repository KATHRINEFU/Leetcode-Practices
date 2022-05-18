package string;

import java.util.Scanner;

/**
 * @ClassName KMP
 * @Description TODO
 * @Author katefu
 * @Date 5/17/22 10:55 PM
 * @Version 1.0
 **/
public class KMP {
    static char[] s,p;
    static int[] nxt = new int[10000];

    public static void main(String[] args) {
        input();
        buildNxt();
        search();
        output();
    }

    private static void input() {
        String str = "ababaabaabac";
        String pat = "abaabac";
        s = str.toCharArray();
        p = pat.toCharArray();
    }

    private static void buildNxt(){
        int i=1, now=0;
        while(i<p.length){
            if(p[i]==p[now]){
                now++;
                nxt[i] = now;
                i++;
            }
            else if(now!=0){
                now = nxt[now-1];
            }
            else{
                i++;
                nxt[i] = now;
            }
        }
    }

    private static void search(){
        int tar=0, pos=0;
        while(tar<s.length){
            if(s[tar]==p[pos]){
                tar++;
                pos++;
            }
            else if(pos!=0){
                pos = nxt[pos-1];
            }
            else{
                tar++;
            }

            if(pos==p.length){
                System.out.println(tar-pos+1);
                pos = nxt[pos-1];
            }
        }
    }

    private static void output(){
        for(int i=0; i<p.length; i++){
            System.out.printf("%d", nxt[i]);
        }
    }

}
