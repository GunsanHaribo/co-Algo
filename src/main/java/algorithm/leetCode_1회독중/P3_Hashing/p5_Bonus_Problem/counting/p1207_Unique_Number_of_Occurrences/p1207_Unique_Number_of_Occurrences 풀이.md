# 문제
~~~text
정수 배열 arr이 주어졌을 때, 
배열 안의 각 값이 등장하는 횟수가 모두 서로 다르면 true를 반환하고, 중복되는 횟수가 있다면 false를 반환하세요
~~~

## 문제 분석
1. 미지 : boolean 
2. 자료 : 정수배열 arr
3. 조건 : 
- 각 값이 등장하는 횟수가 모두 다르면 true
- 같은게 있으면 false

## 문제 풀이

### 1. Example
~~~text
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
~~~

1. counting
2. Set<value>.size == Map.size : true  

## 링크 
https://leetcode.com/problems/unique-number-of-occurrences/submissions/1627524264