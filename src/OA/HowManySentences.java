package OA;

import java.util.*;

/**
 * @ClassName HowManySentences
 * @Description TODO
 * @Author katefu
 * @Date 9/3/22 12:36 PM
 * @Version 1.0
 **/
public class HowManySentences {
    public static void main(String[] args) {
        String[] words = new String[]{"listen","it","is","silent"};
        String[] sentences = new String[]{"listen it is silent"};
        int[] out = test(words, sentences);
        System.out.println(out[0]);
    }

    public static int[] test(String[] words, String[] sentences){
        HashMap< List<Character>, Integer> map = new HashMap<>();
        for(String word: words){
            char[] arr = word.toCharArray();
            List<Character> list = new ArrayList<>();
            for(int j=0; j<arr.length; j++){
                list.add(arr[j]);
            }
            Collections.sort(list);
            map.put(list, map.getOrDefault(list, 0)+1);
        }
        int[] res = new int[sentences.length];
        Arrays.fill(res, 1);
        for(int i=0; i<sentences.length; i++){
            for( String word: sentences[i].split(" ")){
                char[] arr = word.toCharArray();
                List<Character> list = new ArrayList<>();
                for(int j=0; j<arr.length; j++){
                    list.add(arr[j]);
                }
                Collections.sort(list);
                if(map.containsKey(list)) res[i] *= map.get(list);
            }
        }
        return res;
    }

}
