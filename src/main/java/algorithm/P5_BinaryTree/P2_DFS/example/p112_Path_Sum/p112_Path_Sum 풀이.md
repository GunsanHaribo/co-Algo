# 문제

~~~ text
이진 트리의 루트 노드(root)와 정수 targetSum이 주어졌을 때, 
루트에서 리프 노드(자식이 없는 노드)까지 가는 경로 중에서 노드의 값을 모두 더한 합이 targetSum이 되는 경로가 하나라도 있다면 true를 반환하세요.

리프 노드는 자식 노드가 없는 노드를 의미합니다
~~~

## 분석

1. 미지 : 노드의 값을 모두 더한 합 == targetSum
2. 자료 : 루트, targetSum
3. 조건 :

- 노드의 값을 더한 값
- 루트 -> 리프 : 중간경로말고 끝과 끝에
- 하나라도 있으면 -> 하나 틀린다고 전체 false 불가
    - 하나라도?? contains? -> 밑에꺼 하나만 -> T||F

## 풀이

### 1. Example1:

~~~text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
~~~

1. 22일떄를 생각, 2일떄 어떻게 할 것인가

### 2. Example 2:

~~~text
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
~~~

## 링크

처음부터 null일떄만 : https://leetcode.com/problems/path-sum/submissions/1639817083

자식노드 기준 판단 : https://leetcode.com/problems/path-sum/submissions/1639819554

교재방법으로 따로 Sum을 할수 있는 함수를 만들어서 사용해도 됩니다.