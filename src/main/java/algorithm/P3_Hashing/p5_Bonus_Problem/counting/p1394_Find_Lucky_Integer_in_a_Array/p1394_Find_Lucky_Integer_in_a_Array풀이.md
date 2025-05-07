# 문제
~~~text
정수 배열 arr이 주어졌을 때, 
**행운의 정수(lucky integer)**란 배열에서 등장 횟수(빈도)가 자신의 값(value)과 같은 정수를 말합니다.

배열에서 가장 큰 행운의 정수를 반환하세요.
만약 행운의 정수가 없다면 -1을 반환하세요.
~~~

## 문제 분석
1. 미지 : key == value 중 가장 큰 key
2. 자료 : 정수배열 arr
3. 조건 : 
- 없다면 "-1" 반환


## 문제 풀이

### 1. Example
~~~text
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
~~~

1. counting 실시 맵으로  
2. 등장 횟수가 같은:  Key 저장
   1. Value : Key 변환
3. 가장 큰 값 반환 
    1. Key중에 큰거 반환


1. 리스트 안의 정수들을 하나의 스트림으로 펼치는 작업



## 링크

https://leetcode.com/problems/find-lucky-integer-in-an-array/submissions/1627515944