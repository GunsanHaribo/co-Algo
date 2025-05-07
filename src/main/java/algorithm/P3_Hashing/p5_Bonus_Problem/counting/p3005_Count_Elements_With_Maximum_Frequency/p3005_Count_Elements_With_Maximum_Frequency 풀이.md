# 문제
~~~text
양의 정수로 이루어진 배열 nums가 주어졌습니다.

nums에 있는 요소들 중 가장 많이 등장한 요소들을 모두 찾고,
그 요소들의 등장 횟수의 총합을 반환하세요.

요소의 **빈도(frequency)**란, 해당 요소가 배열에 몇 번 등장했는지를 의미합니다.
~~~

## 문제 분석

1. 미지 : 빈도 
2. 자료 : 배열 nums
3. 조건 : 
- 가장 많이 등장한 요소들 
- 요소들의 등장 횟수의 총합을 반환 ->  (요소들 갯수 * 등장 휫수)

## 문제 풀이

### 1. Example 1:
~~~text
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 
which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
~~~

1. max 찾기
2. 요소들 갯수 * 등장 휫수

## 링크 
https://leetcode.com/problems/count-elements-with-maximum-frequency/submissions/1627463724
