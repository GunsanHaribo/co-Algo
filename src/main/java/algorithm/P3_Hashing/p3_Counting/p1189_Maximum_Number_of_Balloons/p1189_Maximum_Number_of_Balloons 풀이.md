# 문제
~~~text
문자열 text가 주어졌을 때, 
이 문자열의 문자들을 사용해서 단어 "balloon"을 가능한 한 많이 만들고자 합니다.

각 문자는 최대 한 번만 사용할 수 있습니다. 만들 수 있는 "balloon"의 최대 개수를 반환하세요.
~~~

## 문제 분석
1. 요구 : 최대 갯수
2. 자료 : 문자열 text
3. 조건 : 
- 각 문자는 최대 한번만 사용 가능
- ballon의 최대 갯수

## 문제 풀이

### 1. Example
~~~text
Input: text = "nlaebolko"
Output: 1
~~~

### 2.  Example
~~~text
Input: text = "balon"
Output: 0
~~~

1. 횟수를 카운트 해놓고 
2. l의 값을 2로 나누고
3. ballon에서의 전체 최솟값과 l, O에서 2를 나눈 값 중 작은 걸 반환

## 링크
https://leetcode.com/problems/maximum-number-of-balloons/submissions/1608313617