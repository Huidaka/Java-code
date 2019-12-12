package cn.Huidaka;
//先连接再排序
public class LinkSort {
    public Node linkSort(Node l1,Node l2){
        if(l1 == null && l2 != null){
            return l2;
        }
        else if(l1 != null && l2 == null){
            return l1;
        }
        else if(l1 == null && l2 == null){
            return l1;
        }
        Node temp = l1;
        while (temp.getNext()!= null){
            temp = temp.getNext();
        }
        temp.setNext(l2);
        Node count = l1;
        while(count.getNext() != null) {
            temp = l1;
            while (temp.getNext() != null) {
                if (temp.getData() > temp.getNext().getData()) {
                    int itemp = temp.getData();
                    temp.setData(temp.getNext().getData());
                    temp.getNext().setData(itemp);
                }
                temp = temp.getNext();
            }
            count = count.getNext();
        }
        return l1;
    }
}
