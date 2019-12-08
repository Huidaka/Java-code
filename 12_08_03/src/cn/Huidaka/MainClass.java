package cn.Huidaka;

class MainClass {
    public Node mergeTwoLists(Node l1, Node l2) {
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
                while (temp1.getNext() != null) {
                    if (temp2.getData() > temp1.getNext().getData()) {
                        temp1 = temp1.getNext();
                        continue;
                    } else {
                        Node temp = temp2.getNext();
                        temp2.setNext(temp1.getNext());
                        temp1.setNext(temp2);
                        temp2 = temp;
                        break;
                    }
                }
            }
        }
        return l1;
    }
}