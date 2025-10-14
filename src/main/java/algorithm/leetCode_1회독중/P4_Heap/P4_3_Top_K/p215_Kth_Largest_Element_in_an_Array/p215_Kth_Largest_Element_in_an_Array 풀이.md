# 문제
~~~text
정수 배열 nums와 정수 k가 주어졌을 때,
배열에서 k번째로 큰 요소를 반환하시오.

단, 여기서 말하는 k번째는 정렬된 순서상의 k번째 큰 요소이며,
서로 다른 값 중에서의 k번째가 아님에 유의하시오.

정렬을 사용하지 않고 이 문제를 해결할 수 있겠는가?
~~~

## 문제 분석 
1. 미지 : k번째로 큰요소를 반환
2. 자료 : 정수 배열 nums, 정수 k
3. 조건 : 
- k번쨰 
- 큰 요소  

## 문제 풀이 
#### 1. Example
~~~text
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
~~~

- 5 
- 5,6
- 4,5,6
- 1, 5 + 6 -> 5,6

## 링크 
https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1631677993