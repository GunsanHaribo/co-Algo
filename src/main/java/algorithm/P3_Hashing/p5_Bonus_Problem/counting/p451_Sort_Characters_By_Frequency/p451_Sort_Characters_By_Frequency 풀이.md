# 문제
~~~text
주어진 문자열 s가 있을 때, 
각 문자의 출현 빈도(문자가 문자열에 등장하는 횟수)를 기준으로 내림차순 정렬된 문자열을 반환하세요.

문자의 빈도가 높은 순서대로 정렬해야 합니다. 
가능한 결과가 여러 개일 수 있으므로, 그 중 아무거나 반환해도 됩니다.
~~~

## 문제 분석
1. 미지 : 내림차순 정렬된 문자열 
2. 자료 : 문자열 s
3. 조건 : 
- 출현 빈호를 기준으로 큰 -> 작
- 

## 문제 풀이 
### 1. Example
~~~text
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
~~~


1. char 카운팅하기 
2. key 조합 : key*value 해서 조합


## 링크
https://leetcode.com/problems/sort-characters-by-frequency/submissions/1627537105