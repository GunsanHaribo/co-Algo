# 문제 
~~~text
이진 탐색 트리(BST)의 루트 노드와 두 정수 low와 high가 주어졌을 때, 
값이 [low, high] 범위(포함)에 있는 모든 노드의 값을 더한 합계를 반환하시오.
~~~

# 분석 
1. 미지 : (low, high)사이의 합계
2. 자료 : 이진 탐색 트리
3. 조건 :
- (low, high)사이 
- 이진 탐색 트리 -> 왼작 오크


# 풀이 

### 1. Example
~~~text
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
~~~

1. low, high를 찾는다. 
2. low는 본인 포함 오른 쪽 것만 넣는다
3. hight는 폰인포함 왼쪽 것만 넣는다 

# 링크 
- https://leetcode.com/problems/range-sum-of-bst/submissions/1644744123