# 문제

~~~text
이진 배열 nums가 주어졌을 때, 0과 1의 개수가 같은 연속 부분 배열의 최대 길이를 반환하세요.
~~~

## 문제 분석

1. 요구 : 최대 길이 반환
2. 자료 : 이진 배열 nums가 주어 졌을떄
3. 조건 :

- 0과 1의 갯수가 같아야한다

## 문제 풀이

### 1. Example

~~~text
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
~~~

1. 0을 -1로 변환(gpt 아이디어, 후에 슬라이싱 윈도우로 한번 풀어보기)
2. -1,1,1,1,1,1,-1,-1,-1 
3. -1,0,1,2,3,4,3,2,1  -> 1-1이되는 마지막인덱스와 2번인덱스를 삭제한다 
4. 1,1,0,0 -> 2,2 삭제
5. 1,0 -> 3,3 삭제

#### 2. Example

~~~text
Input: nums = [0,1,0,1]
Output: 4
~~~

## 링크
https://leetcode.com/problems/contiguous-array/submissions/1608427721