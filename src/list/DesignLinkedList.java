package list;

/**
 * @ClassName DesignLinkedList
 * @Description TODO
 * @Author katefu
 * @Date 5/14/22 3:52 PM
 * @Version 1.0
 **/
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        for(int i=0; i<list.size; i++){
            System.out.println(list.get(i));
        }
    }
}

class MyLinkedList {
    int size;
    Node head;

    public MyLinkedList() {
        size=0;
        head = new Node(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        Node toAdd = new Node(val);
        toAdd.next = pred.next;
        pred.next = toAdd;

    }

    public void deleteAtIndex(int index) {
        if(index==0){
            head = head.next;
            return;
        }
        if(index>=size){
            return;
        }
        Node cur = head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

class Node{
    int val;
    Node next;

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

    public Node(int val){
        this.val = val;
    }

    public Node(){

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */