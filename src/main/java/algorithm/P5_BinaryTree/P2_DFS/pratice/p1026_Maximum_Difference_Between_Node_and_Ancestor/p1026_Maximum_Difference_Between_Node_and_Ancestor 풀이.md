# 문제(아직 못품)
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
1. 미지 : v = |a.val - b.val|의 최대 값 : 간선의 가능한 합의 최댓값? 아 근데 간선 구하기가 싫음 
2. 자료 : 이진트리의 루트 
3. 조건 : 
- a -> b ; a는 b의 조상
  - b가 서브트리에 있으면 된다.
- 루트가 a일수도 서브트리의 루트가 최소일수도 있음 


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

1.  1 <- 8 -> 10  이러면 좋긴할텐데, 내가 귀찮네
2.  아니면, 간선으로 해서   2 <- 5 <- 0 -> 2 -> 2 이렇게도 낫뱃 

## 링크