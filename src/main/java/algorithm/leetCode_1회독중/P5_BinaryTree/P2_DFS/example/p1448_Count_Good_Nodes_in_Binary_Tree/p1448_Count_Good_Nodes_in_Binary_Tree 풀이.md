# 문제 
~~~text
이진 트리의 루트가 주어졌을 때, 
트리 내의 어떤 노드 X는 루트에서 X까지의 경로 상에 X보다 큰 값을 가진 노드가 하나도 없을 경우 “좋은 노드(good node)“라고 불립니다.

이진 트리에서 좋은 노드의 개수를 반환하세요.
~~~

## 분석 
1. 미지 : 좋은 노드의 갯수(count)
2. 자료 : 이진 트리의 루트
3. 조건 : 
- 좋은 노드 : 
  - 루트에서 X까지의 경로상 -> 경로
  - X 보다 큰값을 가진 노드가 하나도 없을 경우 -> 본인, 큰값 비교

## 풀이 

### 1. Example 
~~~text
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
~~~

1. 3 : 루트노드, 무조건 3
2. 3 : max == curr
3. 4 : max < curr
4. 5 : max < curr 

## 링크 
https://leetcode.com/problems/count-good-nodes-in-binary-tree/submissions/1639844899