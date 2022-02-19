package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-01-30 17:50
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int num = 5;
        Solution118 test = new Solution118();
        test.generateSample(num);

    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) return null;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0; i<numRows; i++){
            row.add(0,1);
            for(int j=1; j<=i; j++){
                row.set(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(new ArrayList<Integer>(row));
        }

        return list;
    }

    public List<List<Integer>> generateSample(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }
}
