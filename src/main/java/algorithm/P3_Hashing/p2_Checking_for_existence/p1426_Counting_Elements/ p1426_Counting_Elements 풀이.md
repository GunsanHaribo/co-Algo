# 문제
~~~text
정수 배열 arr가 주어졌을 때, 
배열 안에서 x + 1 또한 존재하는 요소 x의 개수를 세어라.

만약 arr에 중복된 값이 있다면, 각각 개별적으로 계산한다.
~~~

## 문제 분석
1. 요구 : 갯수를 센다
2. 자료 : 정수배열 arr
3. 조건 :
- x+1 또한 존재하는 x의 개수를 세기
- 중복된 값이 있으면 개별적으로 계산

## 문제 풀이

### 1. Example:
~~~text
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
~~~
1. 2 -> 3이있으니
2. 1 -> 2가 있으니

### 2. Example
~~~text
Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
~~~
1. 아무것도 없음 

------
1. 처음에 set에 넣어두고 x+1이 있는지 탐색
2. 있으면 count 추가


## 링크
구독해야 채점을 할 수 있네요;;