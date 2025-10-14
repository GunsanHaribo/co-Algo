# 문제 (회고 필요)
~~~text
당신은 모든 양의 정수 [1, 2, 3, 4, 5, ...]를 포함하는 집합을 가지고 있습니다.

SmallestInfiniteSet 클래스를 구현하세요:
	•	SmallestInfiniteSet() SmallestInfiniteSet 객체를 초기화하여 모든 양의 정수를 포함하도록 합니다.
	•	int popSmallest() 집합에 포함된 가장 작은 정수를 제거하고 반환합니다.
	•	void addBack(int num) **양의 정수 num**을 집합에 다시 추가합니다. 단, num이 이미 집합에 존재하지 않을 때만 추가합니다.
~~~

## 문제 분석
1. 미지 : 클래수 구현  
2. 자료 : 양의 정수인데 범위가 없습니다.
3. 조건 : 
- 가장 작은 정수 제거하고 반환
- 가장 작은 정수가 바뀔 수 있다는게 문제

## 문제 풀이

### 1. Example 
~~~text
Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
~~~

- 이미 있는 정수를 안넣는게 중요하네, 빠진 정수로 이미 있는 정수를 추적
- contain랑 같이하면될듯 
- 잠시만 넣을게 infinite네? 이러면 안됨 1000까지 넣어놓는것도 낫뱃, 최대 그것밖에 안되니깐 

## 링크 
https://leetcode.com/problems/smallest-number-in-infinite-set/submissions/1631762605