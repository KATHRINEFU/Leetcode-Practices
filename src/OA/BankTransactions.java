package OA;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName BankTransactions
 * @Description TODO
 * @Author katefu
 * @Date 10/2/22 5:14 PM
 * @Version 1.0
 **/
public class BankTransactions {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,-5, -6, -1, 4};
        int res = maximizeTransaction(arr);
        System.out.println(res);
    }

    public static int maximizeTransaction(int[] transactions){
        Queue<Integer> queue = new PriorityQueue<>();
        int i = 0, n = transactions.length;
        int bill = 0;
        for(int transaction: transactions){
            queue.offer(transaction);
            bill+=transaction;
            if(bill<0){
                bill-=queue.poll();
            }
        }
        return  queue.size();
    }
}
