package algorithm.leetCode_1.P4_Heap.라이브코딩테스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 정렬된_연결_리스트_병합 {

  public static void main(String[] args) {
    정렬된_연결_리스트_병합 solver = new 정렬된_연결_리스트_병합();
//    // 1. 정상입력
    int[][] inputArray = new int[][]{
        {1, 2, 3, 10},
        {1, 4, 5},
        {3, 4}
    };
    // 돌면서 노드 만들기
    List<Node> input = new ArrayList<>();
    for (int[] nodes : inputArray) {
      System.out.println(Arrays.toString(nodes));
      Node node = new Node(nodes[0]);
      input.add(node);
      for (int i = 1; i < nodes.length; i++) {
        Node nextNode = new Node(nodes[i]);
        node.next = nextNode;
        node = nextNode;
      }
    }

    // 결과 출력
    Node nextNode = solver.solution(input);
    System.out.println(nextNode);
    while (nextNode != null) {
      System.out.print(nextNode.val + " ");
      nextNode = nextNode.next;
    }

    // 2. 빈 연결리스트일떄
//    List<Node> arr = List.of();
//    Node nextNode = solver.solution(arr);
//    System.out.println(nextNode);

    // 3. 입력 자체가 비어있을떄 -> null일떄? 흐음.. 이러면 노드를 만들수 있나?
//    List<Node> arr = null;
//    Node nextNode = solver.solution(arr);
//    System.out.println(nextNode);
  }


  public Node solution(List<Node> input) {
    if(input == null){
      return null;
    }

    PriorityQueue<Node> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    heap.addAll(input);
    Node startNode = null;
    Node nextNode = null;
    while (!heap.isEmpty()) {
      Node pollNode = heap.poll();
      if (pollNode == null) {
        break;
      }
      if (pollNode.next != null) {
        heap.add(pollNode.next);
      }
      if (nextNode == null) {  // 처음 노드 반환하는게 힘들다, while문이여서 그런가, 다른 방식을 찾아도 좋을듯
        nextNode = new Node(pollNode.val);
        startNode = nextNode;
        continue;
      }

      nextNode.next = new Node(pollNode.val);
      nextNode = nextNode.next;
    }

    return startNode;
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
