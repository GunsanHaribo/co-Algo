# 문제(좀 더 고민 필요)
~~~text
BST(이진 탐색 트리)의 루트 노드 참조(root)와 삭제할 키(key)가 주어졌을 때,
해당 키를 가진 노드를 BST에서 삭제하고,
(변경되었을 수도 있는) BST의 루트 노드 참조를 반환하세요.

기본적으로 삭제 과정은 두 단계로 나뉩니다:
	1.	삭제할 노드를 찾는다.
	2.	노드를 찾았다면, 해당 노드를 삭제한다.
~~~

# 분석 
1. 미지 : 
2. 자료 : 
3. 조건 : 
- 삭제 = 부모 트리가 삭제될시 right가 채워집니다.
- 참조가 바뀌어야합니다. 

# 풀이 
~~~text
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
~~~

# 링크 
