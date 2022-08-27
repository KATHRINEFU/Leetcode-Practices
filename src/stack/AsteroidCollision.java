package stack;

import java.util.*;

/**
 * @ClassName AsteroidCollision
 * @Description TODO
 * @Author katefu
 * @Date 7/27/22 12:33 PM
 * @Version 1.0
 **/
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] nums = {-2,-2,1,-2};
        Solution735 test = new Solution735();
        test.asteroidCollision(nums);
    }
}

class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){
            if(asteroid>0){
                stack.push(asteroid);
            }else{
                if(stack.isEmpty()){
                    stack.push(asteroid);
                    continue;
                }
                else{
                    if(stack.peek()<0){
                        stack.push(asteroid);
                    }else{
                        while(!stack.isEmpty()){
                            int sign = Math.abs(stack.peek()) - Math.abs(asteroid);
                            if(sign>0) break;
                            else if(sign==0){
                                stack.pop();
                                break;
                            }else{
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }

        if(stack.isEmpty()) return new int[]{};
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        Collections.reverse(res);
        int[] resArr = new int[res.size()];
        for(int i=0; i<resArr.length; i++){
            resArr[i] = res.get(i);
        }

        return resArr;
    }

    public int[] asteroidCollisionSample(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                    s.pollLast();
                if (!s.isEmpty() && s.getLast() == -i)
                    s.pollLast();
                else if (s.isEmpty() || s.getLast() < 0)
                    s.add(i);
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}