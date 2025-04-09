# 557. Reverse Words in a String III
- 문자열 s가 주어졌을 때, 문장 내 각 단어의 문자 순서를 뒤집되 공백과 단어의 원래 순서는 그대로 유지하시오.

## 문제 분석 
1. 요구 : 뒤집기 -> 대칭
2. 자료 : 문자열 s
3. 조건 : 공백과 단어의 원래 순서는 그대로 유지

## 문제 풀이
### 1. Example:
~~~text
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
~~~
1. 공백으로 나눈 다음
2. 뒤집기 = start < end 까지 진행합니다. 
   1. start, end 
   2. set'L -> 0,4
   3. s'teL -> 1 3
   4. s'teL -> 2 2

## 링크
https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/1601154114