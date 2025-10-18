package algorithm.leetCode_1.P4_Heap.라이브코딩테스트;

import java.util.List;
import java.util.PriorityQueue;

public class GPT보완 {

  public Node solution(List<Node> input) {
    if (input == null) {
      return null;
    }

    PriorityQueue<Node> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    heap.addAll(input);

    Node dummyHead = new Node(0); // dummy node로 첫 노드 분기 제거
    Node current = dummyHead;

    while (!heap.isEmpty()) {
      Node pollNode = heap.poll();

      if (pollNode == null) {
        continue; // null이면 그냥 넘어가고 루프 진행
      }

      current.next = new Node(pollNode.val);
      current = current.next;

      if (pollNode.next != null) {
        heap.add(pollNode.next);
      }
    }

    return dummyHead.next; // TODO: 6/25/25 이 부분이 좋은데?, 시작 부분을 패스하고 줘버리니깐
  }

  public static class Node {

    private int val;
    private Node next;

    public Node(int val) {
      this.val = val;
    }

    public int getVal() {
      return val;
    }

    public void setNext(Node node) {
      this.next = node;
    }

    public Node getNext() {
      return next;
    }
  }

}
