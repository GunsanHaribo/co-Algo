# 문제

~~~text
이진 트리가 주어졌을 때, 해당 트리에서 두 노드 p와 q의 최저 공통 조상(LCA, Lowest Common Ancestor) 을 찾아라.

Wikipedia에서의 LCA 정의에 따르면:
“최저 공통 조상이란 두 노드 p와 q에 대해, 트리 T에서 p와 q를 모두 자손으로 가지는 가장 낮은(즉, 가장 깊은) 노드를 의미한다. 
 여기서 노드 자신도 자신의 자손으로 간주할 수 있다.”
~~~

## 분석

1. 미지 : 두 노드 pq의 "공통조상" "찾기(탐색)", 루트
2. 자료 : 이진 트리
3. 조건 :
- 최저 공통조상 찾기
    - p, q를 자손으로 가지는 가장 낮은, 깊은 노드
    - 노드 자신도 자신의 자손
    - All Node.val are unique.
    - p,q는 존재하고 null이 아닙니다.

## 풀이

### 1. Example

~~~text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
~~~

1. 3
2. 내가 pq에 속하지 않고
3. right, left에 각각 하나씩 pq 있으면 루트 추출,

- False + (True && True) -> 루트 엔티티가 정답
- False + (False ||, && False) => 정답은 아니지만 루트 엔티티 반환
- False + (True || False) => 자식 중 True 반환

### 2. Example

~~~text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
~~~

1. 5
2. 내가 pq에 중 하나에 속하고
3. 자식 중에 나머지 하나가 있으면 5+
    - True && (False || True) -> 루트
    - True && (False ||  False) -> 루트
    - True && (False || False) -> 루데

- 숫자 안넘겨주고 true. false로만 해도 괜찮았을 것 같은데
- 아근데 저렇게하면 ㄴㄴ, 애매한 관련된거가 조금 힘든데 


## 회고 
- 재귀적으로 바꾸는게 어렵네 -> 조금 더 찾아보자 
- 그대로 핵심은 먼저 답에대한 로직을 찾는것 
- 재귀적으로 어떻게 바꿀지는 생각해보자, 지금은 뭔가.. 
- 다른 노드로 올라갔을떄 어떻게 할 것인가에서 left, right가 반복적으로 나와야하는것같아서 넣었는데, 이게 맞는지는 모르겠다.
- 종료 조건도 살짝 이상하게 써주면 안좋아하네

- 그니깐 공통 로직 짜는건 쉬운데 
- 그걸 재귀로 바꾸는데는 훈련이 필요
-  F 
- T T 일떄 F를 그대로 반환하면 안된다. 
- F가 올라가서 T가 될 수 있도록 정답에 추가 해줘야합니다. 

## 링크
- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/1641054323