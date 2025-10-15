# 문제 
~~~text
0부터 n까지의 범위에 있는 "n개의 서로 다른 숫자"를 담고 있는 배열 nums가 주어졌을 때,
이 범위에서 빠진 하나의 숫자를 찾아 반환하시오.
~~~~

## 문제 분석
1. 요구 : 하나의 숫자를 반환 
2. 자료 : 0~n 까지의 nums
3. 조건 :
- 주어진 범위에서 빠진 숫자(숫자확인 set)
- n은 주어진 배열의 갯수

## 문제 풀이

### 1. Example
~~~text
Input: nums = [3,0,1]

Output: 2

Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
~~~

1. 최대(n) 구하고
2. set 사용해서 있는지 확인


## 링크
https://leetcode.com/problems/missing-number/submissions/1608139390