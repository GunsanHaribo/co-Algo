# 문제 
~~~text
이진 탐색 트리(BST)가 주어졌을 때, 
두 노드 p와 q의 가장 낮은 공통 조상(LCA, Lowest Common Ancestor) 노드를 찾아라.

Wikipedia에서의 LCA 정의에 따르면:
“LCA는 두 노드 p와 q에 대해, 두 노드 모두의 후손인 노드들 중 가장 낮은(가장 깊은) 노드이다. 
여기서 하나의 노드가 자기 자신을 후손으로 포함하는 것도 허용한다.”
~~~

# 분석 
1. 미지 : 가장 낮은 공통조상 찾기
2. 자료 : 이진 탐색 트리 
3. 조건 : 
- LCA는 하나의 노드가 자기 자신을 후손으로 포함하는 것도 허용한다

# 풀이
~~~text
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
~~~

1. p, q가 부모 노드의 수에 따라서 오른쪽 왼쪽으로 보낸다. 
2. p < 6 이면, 왼쪽으로 크면 오른쪾으로 보낸다.  
3. 같으면 루트를 반환합니다.

# 링크
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/1646880382