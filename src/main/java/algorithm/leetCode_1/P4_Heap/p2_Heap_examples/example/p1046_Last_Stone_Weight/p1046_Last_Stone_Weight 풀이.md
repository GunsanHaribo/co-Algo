# 문제 
~~~text 
정수 배열 stones가 주어집니다. 이때 stones[i]는 i번째 돌의 무게를 나타냅니다.

우리는 이 돌들을 가지고 게임을 합니다. 매 턴마다 가장 무거운 두 개의 돌을 선택해 서로 부딪치게 합니다. 
가장 무거운 두 돌의 무게를 각각 x와 y라고 할 때, x <= y라고 가정합니다. 이 두 돌을 부딪치면 다음과 같은 결과가 나옵니다:
	•	만약 x == y이면, 두 돌 모두 파괴됩니다.
	•	만약 x != y이면, 무게가 x인 돌은 파괴되고, 무게가 y인 돌은 y - x의 무게로 바뀝니다.

이 과정을 반복하여 더 이상 돌을 부딪칠 수 없을 때, 남아 있는 돌이 있다면 그 돌의 무게를 반환하고, 남아 있는 돌이 없다면 0을 반환합니다.
~~~
## 문제 분석
1. 미지 : 부딫수 없을떄, 남아있는 돌의 무게를 반환 
2. 자료 : stones
3. 조건 : 
- 가장 무거운 두개의 돌을 선택 x <= y : x는 두돌중 작은걸 나타냅니다.  
- 같으면 둘다 파괴
- 같지 않으면 x는 없애고 y-x로 무게를 바뀝니다, 그리고 다시 넣어주네


## 문제 풀이

#### 1. Example
~~~text
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
~~~

1. 만약에 힙사이즈가 1개거나 0개면 삭제한다. 


## 링크 
https://leetcode.com/problems/last-stone-weight/submissions/1631156069