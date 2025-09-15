# 문제 
~~~text
이진 트리 root와 정수 target이 주어졌을 때, 값이 target인 모든 리프 노드를 삭제하세요.

단, 리프 노드를 삭제한 후에 그 부모 노드가 리프 노드가 되며 값이 target이라면, 
그 노드도 삭제해야 합니다.
이 작업을 더 이상 삭제할 수 없을 때까지 반복해야 합니다.
~~~

# 분석 
1. 미지 : 리프 = taget인 노드가 삭제된 트리
2. 자료 : 이진트리 root와 정수 target
3. 조건 : 
- 더 이상 삭제할 수 없을떄 까지 
- 부모가 리프가 되는 조건 = 자식이 없을떄 
  - 자식이 없을 떄 == left, right == null


# 풀이 
~~~text
Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left). 
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
~~~

# 링크 
https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/1653534174