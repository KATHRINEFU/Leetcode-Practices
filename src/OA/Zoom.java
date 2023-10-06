package OA;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Zoom
 * @Description TODO
 * @Author katefu
 * @Date 10/26/22 7:16 PM
 * @Version 1.0
 **/
public class Zoom {
    public static void main(String[] args) {
        String[] members = {"id123", "id234", "id7","id321"};
        String[] messages = {"Hey @id123,id321 review this PR played by @id123", "Hey @id7 nice appro@ch!"};
        String[] res = test(members, messages);
        for(String s: res) System.out.println(s);

    }
    public static String[] test(String[] members, String[] messages){
        HashMap<String, Integer> count = new HashMap<>();
        HashSet<String> me = new HashSet<>();
        me.addAll(Arrays.asList(members));

        for(String s: messages){
            HashSet<String> set = new HashSet<>();
            Pattern p=Pattern.compile("@id(\\d)+(, id(\\d)+)*");
            Matcher m=p.matcher(s);
            while(m.find()) {
                String[] ids = m.group().split(",");
                for(String id: ids){
                    if(!me.contains(id)) continue;
                    if(id.startsWith("@")){
                        id = id.substring(1);
                    }
                    if(set.add(id)) count.put(id, count.getOrDefault(id, 0)+1);
                }
            }
        }

        for(String s1: me){
            if(!count.containsKey(s1)) count.put(s1, 0);
        }

        Object[] a = count.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                int c1 =  ((Map.Entry<String, Integer>) o2).getValue() - ((Map.Entry<String, Integer>) o1).getValue();
                if(c1!=0) return c1;
                else return ((Map.Entry<String, Integer>) o1).getKey().compareTo(((Map.Entry<String, Integer>) o2).getKey());
            }
        });



        String[] res = new String[count.size()];
        int i=0;

        for (Object e : a) {
            String tmp = ((Map.Entry<String, Integer>) e).getKey() + "="+ ((Map.Entry<String, Integer>) e).getValue();
            res[i++] = tmp;
        }

        return res;
    }
}
