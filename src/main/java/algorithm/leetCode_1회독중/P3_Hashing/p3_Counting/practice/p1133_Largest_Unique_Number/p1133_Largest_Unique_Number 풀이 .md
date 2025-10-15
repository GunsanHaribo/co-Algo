# 문제
~~~text
정수 배열 nums가 주어졌을 때, 한 번만 등장하는 정수 중 가장 큰 값을 반환하세요.
만약 한 번만 등장하는 정수가 없다면, -1을 반환하세요.
~~~

## 문제 분석
1. 요구 : 한 번만 등장하는 정수 중 가장 큰값
2. 수정 : 정수배열 nums
3. 조건 : 
- 한번만 등장하는게 없다면 -1

## 문제 풀이
### 1. Example
~~~text
Input: nums = [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only
once, so it is the answer.
~~~

1. 8, 등장 횟수는 1
2. 등장횟수가 1인 값 중에서 가장 큰 값을 구한다.

## 링크
구독문제로 인한 패스