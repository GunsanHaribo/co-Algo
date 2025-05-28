# 문제 
~~~text
이진 트리의 루트 노드가 주어졌을 때, 
노드들의 값을 레벨 순서대로 순회한 결과를 반환하시오. 
(즉, 왼쪽에서 오른쪽으로, 레벨별로 순회)
~~~

# 분석 
1. 미지 : 레벨 순서대로 순회한 결과
2. 자료 : 
3. 조건 : 
- BFS

# 풀이 
~~~text
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
~~~

1. 전형적인 BFS
2. 레벨로 순회하고 Queue 사용

# 링크 
https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/1646889549