package cn.Huidaka;
//边连接边排序
class MainClass {
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null && l2 != null){
            return l2;
        }
        else if(l1 != null && l2 == null){
            return l1;
        }
        else if(l1 == null && l2 == null){
            return l1;
        }
        Node temp1 = l1;
        Node temp2 = l2;
        while (temp2 != null) {
            temp1 = l1;
            if (temp2.getData() <= temp1.getData()) {
                Node tempright = temp2.getNext();
                temp2.setNext(temp1);
                l1 = temp2;
                temp2 = tempright;
                continue;
            }
            else {
                boolean a = false;
                if(temp1.getNext() == null){
                    Node temp = temp2.getNext();
                    temp2.setNext(temp1.getNext());
                    temp1.setNext(temp2);
                    temp2 = temp;
                    continue;
                }
                while (temp1.getNext() != null) {
                    if (temp2.getData() > temp1.getNext().getData()) {
                        temp1 = temp1.getNext();
                        continue;
                    } else {
                        Node temp = temp2.getNext();
                        temp2.setNext(temp1.getNext());
                        temp1.setNext(temp2);
                        temp2 = temp;
                        a = true;
                        break;
                    }
                }
                if(!a){
                    Node temp = temp2.getNext();
                    temp2.setNext(temp1.getNext());
                    temp1.setNext(temp2);
                    temp2 = temp;
                }
            }
        }
        return l1;
    }
}