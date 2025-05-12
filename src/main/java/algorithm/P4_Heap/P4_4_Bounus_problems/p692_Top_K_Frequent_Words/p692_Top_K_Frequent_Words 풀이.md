# 문제 
~~~text
문자열 배열 words와 정수 k가 주어졌을 때, 가장 자주 등장하는 문자열 k개를 반환하세요.

반환값은 등장 빈도순으로 내림차순 정렬되어 있어야 하며, 
빈도가 같은 경우에는 사전 순(lexicographical order)으로 정렬해야 합니다.
~~~

## 문제 분석
1. 미지 : 가장 자주 등장하는 문자열 k개
2. 자료 : 문자열 배열 words 
3. 조건 : 
- 가장 많이 등장 
- 빈도순으로 내림차순 정렬 
- 빈도가 같은 경우 사전순으로 
- 삭제할때 빈도가 같다면 알파벳 느린게 앞으로

## 문제 풀이 
### 1. Example
~~~text
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
~~~
- Counting으로 정렬하고, 작은게 앞으로 가게 정렬합니다.  
- 2개 유지하고, 나중에 반환할떄, count 기준 내림차순, 빈도가 같은 경우는 사전순으로 
- 삭제할때 빈도가 같다면 알파벳 느린게 앞으로 

## 링크
https://leetcode.com/problems/top-k-frequent-words/submissions/1631735092