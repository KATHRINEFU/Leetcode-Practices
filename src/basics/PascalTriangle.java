package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-01-30 17:50
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int num = 5;
        Solution118 test = new Solution118();
        test.generateSample2(num);

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

    //recursion
    public List<List<Integer>> generateSample2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        generateSample2(list, numRows);
        return list;

    }

    public void generateSample2(List<List<Integer>> list, int numRows) {
        if (numRows == 1) list.add(Arrays.asList(1));
        else if (numRows > 1) {
            generateSample2(list, numRows -1);
            List<Integer> previousList = list.get(numRows -2);
            List<Integer> thisList = new ArrayList<>();
            for (int i = 0; i < previousList.size(); i++) {
                if (i == 0) thisList.add(1);
                if (i > 0) thisList.add(previousList.get(i) + previousList.get(i-1));
                if (i == previousList.size() -1) thisList.add(1);
            }
            list.add(thisList);
        }
    }
}
