# 문제
~~~
문자열 s가 주어졌을 때, 중복된 문자가 없는 가장 긴 부분 문자열의 길이를 구하세요.
~~~
## 문제 분석
1. 미지 : 부분 문자열의 길이(투포인터 사용)
2. 자료 : 문자열 s
3. 조건 : 
- 중복된 문자가 없어야 된다. -> Set
- 가장 긴 부분 문자열 : max 저장

## 문제 풀이
1. Example
~~~text
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
~~~

1. 진행과정 
2. b 
3. cb
4. abc
5. cab
6. bca 
   1. right++(a):다음요소가 현재 집합에 이미 있다면 
   2. set에서 삭제하고 left++(이걸 안겹칠때까지) 
   3. max 사이즈미교 
7. abc -> left, right 두고 


2. Example
~~~text
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
~~~

3. Example
~~~text
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
~~~


## 링크
https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1621602606