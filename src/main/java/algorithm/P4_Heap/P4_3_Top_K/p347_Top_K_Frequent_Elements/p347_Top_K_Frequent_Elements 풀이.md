# 문제 
~~~text 
주어진 정수 배열 nums와 정수 k가 있을 때, 
가장 자주 등장하는 k개의 요소를 반환하시오.

결과는 아무 순서로나 반환해도 됩니다.
~~~

## 문제 분석 
1. 미지 : 가장 많이 등장하는 k개의 요소를 반환
2. 자료 : 정수 배열 nums, 정수 k
3. 조건 : 
- 가장 많이 등장하는 k개의 요소
- O(n log n)

## 문제 풀이 

### 1. Example: 
~~~text
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
~~~

### 2. Example:
~~~text
Input: nums = [1], k = 1
Output: [1]
~~~

- 등장 count -> Map
- k개 -> 순위, Map의 value로 키들을 Count
- Map쓸거면 근데 그냥 sorting 해도 되지않나
- 빈번한 sort가 있어야하는데, sorting 한번에 할꺼면 굳이 라는 생각이 들긴하네요
- 전체수를 정렬을 안하고 k개만 정렬을 한다는 점에서 개선일 수도 // 그냥 정렬하고 어떤 차이가 있는가? 


## 링크 
https://leetcode.com/problems/top-k-frequent-elements/submissions/1631637236