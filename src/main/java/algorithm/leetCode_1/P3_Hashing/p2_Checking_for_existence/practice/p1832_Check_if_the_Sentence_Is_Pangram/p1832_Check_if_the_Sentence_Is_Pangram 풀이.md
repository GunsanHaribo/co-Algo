# 문제
~~~text
pangram은 영어 알파벳의 모든 글자가 최소 한 번 이상 등장하는 문장을 의미합니다.

소문자 영어 알파벳으로만 이루어진 문자열 sentence가 주어졌을 때, 이 문자열이 pangram인지 아닌지를 판별해서:
•	pangram이면 true를, 아니면 false를 반환하는 문제
~~~ 

## 문제 분석
1. 요구: pargram 판별 
2. 자료: 문자열 sentence
3. 조건:
- 영어 알파벳의 모든 글자가 최소 한번이상

## 문제 풀이

#### 1. Example
~~~text
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
~~~
1. set을 넣는다
2. 영어 알파벳 순서대로 char 돌린다
3. g 있네!느낌
4. true


## 링크 
https://leetcode.com/problems/check-if-the-sentence-is-pangram/submissions/1608127748