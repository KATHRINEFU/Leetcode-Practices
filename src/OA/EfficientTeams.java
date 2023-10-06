package OA;

import java.util.HashMap;

/**
 * @ClassName EfficientTeams
 * @Description TODO
 * @Author katefu
 * @Date 10/2/22 7:14 PM
 * @Version 1.0
 **/
public class EfficientTeams {
    public static void main(String[] args) {
        int[] skills = new int[]{5,4,2,1};
        int res = getTotalEfficiency(skills);
        System.out.println(res);
    }
    public static int getTotalEfficiency(int[] skills){
        int totalSkill = 0;
        int totalEfficiency = 0;
        for(int skill : skills){
            totalSkill+=skill;
        }
        int teamSkill = totalSkill/(skills.length/2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int skill: skills){
            map.put(skill, map.getOrDefault(skill, 0)+1);
        }

        for(Integer key: map.keySet()){
            int targetSkill = teamSkill - key;
            if(targetSkill==key){
                totalEfficiency+=key*targetSkill*2;
                continue;
            }
            if(map.get(targetSkill)!=map.get(key)) return -1;
            else {
                totalEfficiency+=key*targetSkill;
            }
        }
        return totalEfficiency/2;
    }
}
