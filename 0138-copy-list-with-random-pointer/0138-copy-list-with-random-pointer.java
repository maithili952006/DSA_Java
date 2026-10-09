/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node,Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        Node oldTemp = head;
        Node newTemp = newHead;

        map.put(oldTemp, newTemp);

        while(oldTemp.next != null){
            Node copyNode = new Node(oldTemp.next.val);

            map.put(oldTemp.next, copyNode);
            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;

        }

        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null){
            newTemp.random = map.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}