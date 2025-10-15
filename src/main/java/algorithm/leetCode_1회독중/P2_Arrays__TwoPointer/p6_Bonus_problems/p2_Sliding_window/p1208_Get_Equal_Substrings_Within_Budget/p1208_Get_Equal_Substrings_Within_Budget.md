# 문제
~~~text
두 개의 길이가 같은 문자열 s와 t, 그리고 정수 maxCost가 주어집니다.

당신은 문자열 s를 t로 변경하고자 합니다. s의 i번째 문자를 t의 i번째 문자로 변경하는 데 드는 비용은 |s[i] - t[i]|입니다 (즉, 두 문자의 ASCII 값의 절댓값 차이입니다).

이때, 총 비용이 maxCost 이하인 조건 하에, s의 어떤 연속된 부분 문자열(서브스트링)을 t의 해당 위치의 서브스트링으로 바꿀 수 있는 최대 길이를 구하세요.

만약 조건을 만족하는 서브스트링이 없다면, 0을 반환하세요.
~~~

## 문제 분석
1. 요구 : 서브 스트링(부분 문자열)의 최대 길이
2. 자료 : 문자열 s,t(길이가 같음) | 정수 maxCost
3. 조건 :
- 조건을 만족하는 서브 스트링이 없으면 0
- 총 비용이 maxCost 이하, 연속된 부분 문자열을 
- 비용은 char의 절댓값

## 풀이
### 1. Example
~~~text
Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd".
That costs 3, so the maximum length is 3.
~~~

1. left, right 존재 
2. right는 계속 증가, 증가하면서 만약에 maxCost를 넘지 않으면 최대 길이 체크
3. abcd -> 만약에 숫자는 넘는다면 숫자를 뺴고, left증가

## 링크 

https://leetcode.com/problems/get-equal-substrings-within-budget/submissions/1601420433