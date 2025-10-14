# 문제

~~~text
이진 트리가 Even-Odd(짝홀) 트리라고 불리려면 다음 조건을 모두 만족해야 합니다:
	1.	이진 트리의 루트는 레벨 인덱스 0에 있으며, 그 자식들은 레벨 인덱스 1, 그 자식들은 레벨 인덱스 2, 이런 식으로 레벨 인덱스가 증가합니다.
	2.	짝수 인덱스(0, 2, 4, …) 레벨에서는, 해당 레벨의 모든 노드 값이 홀수 정수이며, 왼쪽에서 오른쪽으로 strictly(엄격히) 증가해야 합니다.
	3.	홀수 인덱스(1, 3, 5, …) 레벨에서는, 해당 레벨의 모든 노드 값이 짝수 정수이며, 왼쪽에서 오른쪽으로 strictly(엄격히) 감소해야 합니다.
가
이진 트리의 루트 노드가 주어졌을 때, 해당 트리가 Even-Odd 트리 조건을 만족하면 true를, 그렇지 않으면 false를 반환하세요.
~~~

# 분석

1. 미지 : Even-Odd 트리 조건을 만족
2. 자료 : 이진 트리
3. 조건 :

- 레벨에 따라서 짝수 레벨이면 모든 노드 값이 홀수, (->)증가
- 레벨에 따라서 홀수 레벨이면 모든 노드 값이 짝수, (->)감소

# 풀이

~~~text
Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
~~~

# 링크

https://leetcode.com/problems/even-odd-tree/submissions/1653615386