package binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NestedIterator
 * @Description TODO
 * @Author katefu
 * @Date 6/5/22 9:39 AM
 * @Version 1.0
 **/
public class NestedIterator implements Iterator {
    private Queue<Integer> queue = new LinkedList();
    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    private void helper(List<NestedInteger> list){
        if (list == null)
            return;

        for (NestedInteger in: list){
            if (in.isInteger())
                queue.offer(in.getInteger());
            else{
                helper(in.getList());
            }
        }
    }


    @Override
    public boolean hasNext() {
        if (!queue.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public Integer next() {
        if (hasNext()){
            return queue.poll();
        }
        else
            return -1;
    }
}

