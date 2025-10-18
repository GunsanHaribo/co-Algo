# 문제(DFS 안에 DFS, 회고 필요)
- 8, 1, 14 이었으면 어떤게 필요했을까? -> 이걸 추론 못함

~~~text
이진 트리의 루트가 주어졌을 때, 다음 조건을 만족하는 최대 값 v를 구하세요:

서로 다른 노드 a와 b가 존재하고, a는 b의 **조상(ancestor)**이며,
v = |a.val - b.val| (즉, a와 b의 값 차이의 절댓값)일 때, 이 v의 최대값을 구하는 것입니다.

여기서 노드 a가 노드 b의 조상이라는 뜻은 다음 중 하나입니다:
	•	a의 자식 중 하나가 b인 경우, 또는
	•	a의 자식 중 하나가 b의 조상인 경우입니다.
(즉, a에서 시작해 아래로 내려가는 경로에 b가 있으면 a는 b의 조상입니다.)
~~~

## 분석
1. 미지 : v = |a.val - b.val|의 최대 값
2. 자료 : 이진트리, 루트
3. 조건 : 
- v = |a.val - b.val|인 최댓값을 구합니다. 


## 풀이

### 1. Example
~~~text
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
~~~

- |8 - 1| = 7 -> 계산 값을 올려줘야됨. -35를 어떻게 하지 
- 1 - 3 - 8  => 끝부터 시작하는게 맞
- 어떻게 하냐, 어떻게 끌어 올릴 수 있을까?, 일반화를 어떻게 해야할까?    

## 회고 
- 예시를 바탕으로 규칙을  잡지 못했다. 
- 이전 조상 문제에서 이 문제를 어떻게 유추 할 수 있었을까? -> 이전 조상 문제를 생각해 낼 수 있었나?
  - 있었으나 노드를 1개만 올린다는 생각에 ~를 하지 않았다. 
- 절댓값일떄 왜 최대 최소를 생각하지 못했을까?  v = |a.val - b.val|의 최대 값 
  - 이거에 대한 충분한 분석이 없었다. 어떨떄 최대가 나오는지 규칙을 봤어야했다
- 8, 1, 14 이었으면 어떤게 필요했을까? -> 이걸 추론 못함
- 숫자가 말도 안되게 뒤에 있는걸 보니...하하... 뭔가 잘못됬는데

## 링크
- https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/1645602212
