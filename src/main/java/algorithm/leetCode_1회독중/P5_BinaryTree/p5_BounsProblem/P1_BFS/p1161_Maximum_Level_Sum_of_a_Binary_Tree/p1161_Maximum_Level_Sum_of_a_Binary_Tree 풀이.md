# 문제 
~~~text
이진 트리의 루트가 주어졌을 때, 루트의 레벨은 1이고, 
그 자식들의 레벨은 2이며, 그 이후로도 계속 그렇게 진행됩니다.

노드 값들의 합이 최대가 되는 레벨 x 중에서 가장 작은 레벨 x를 반환하세요.
~~~

# 분석 
1. 미지 : 레벨 반환
2. 자료 : 이진 트리의 루트 
3. 조건 : 
- 같은 레벨의 노드 값들의 합이 최대가 되는 레벨

# 풀이 
~~~text
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
~~~

1. 2
2. 레벨 별로 합 구하기
3. min
   1. 합이 만약에 min 이고, 
   2. 레벨도 min이면 기록합니다. 

# 링크 
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/1653586232