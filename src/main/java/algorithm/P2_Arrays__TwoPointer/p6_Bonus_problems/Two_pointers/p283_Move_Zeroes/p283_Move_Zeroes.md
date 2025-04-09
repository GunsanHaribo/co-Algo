# 문제({1,2} 재확인 필요)

- 정수 배열 nums가 주어졌을 때, 모든 0을 배열의 끝으로 이동시키되, 0이 아닌 요소들의 상대적인 순서는 유지하세요.
- 이 작업은 배열을 복사하지 않고 제자리(in-place)에서 수행해야 합니다.

## 문제 분석

1. 요구 : 모든 0을 끝으로 이동 ->  0과 기존 숫자들 swap
2. 자료 : 정수 nums
3. 조건 :

- 제자리에서 수행
- 0이 아닌 요소들의 상대적인 순서

## 문제 풀이

1. Example

~~~text
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
~~~

1. start, end
    1. 0이 아닌 숫자가 있으면 채워 넣는다, end가 length-1이 되면 종료한다
        1. start : 4, end : 4  [1,3,12,0,0]
        2. start : 2, end : 4   [1.3,0,0,12]
        3. start : 1, end : 3   [1,0,0,3,12]
        4. start : 0, end : 1  [0,1,0,3,12]
    2. start와 end를 비교한다, 만약 end가 0이 이라면 교체합니다.
       1. 그리고 start를 이동시킵니다.
 

## 링크
https://leetcode.com/problems/move-zeroes/submissions/1601586708


## 이해가 안되는 부분
![img.png](img.png)