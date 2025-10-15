# 문제 
- 문자열 s가 주어졌을 때, 다음 규칙에 따라 문자열을 뒤집으세요:
  - 영문자가 아닌 모든 문자는 원래 위치를 그대로 유지합니다.
  - **영문자(소문자 또는 대문자)**는 뒤집은 순서로 배치합니다.
- 문자열을 뒤집은 결과를 반환하세요.

## 문제 분석
1. 요구 : 뒤집기
2. 자료 : 문자열 s
3. 조건 : 
   - 영문자가 아닌 문자는 그대로 유지
   - 영문자는 뒤집은 순서로 배치합니다

## 문제 풀이
1. Example:
~~~text
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
~~~

1.  j - I h - g  f E - d C b a
2.  j - I h - g  d E - f C b a
3. left, right -> left<right 까지 진행
4. 만약에 포인터에 해당하는 문자가 알파벳이 아니면 해당 포인터를 이동시킵니다
   1. left--, right ++

## 링크
https://leetcode.com/problems/reverse-only-letters/submissions/1601166718