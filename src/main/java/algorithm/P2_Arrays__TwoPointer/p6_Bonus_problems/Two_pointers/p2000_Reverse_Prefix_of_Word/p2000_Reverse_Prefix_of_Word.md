# 문제 
~~~text
0부터 시작하는 인덱스를 갖는 문자열 word와 문자 ch가 주어집니다.
word에서 문자 ch가 처음 등장하는 인덱스를 찾아,
0번 인덱스부터 해당 인덱스까지의 구간을 뒤집습니다 (해당 인덱스 포함).
만약 word에 ch가 존재하지 않는다면, 아무 작업도 하지 않습니다.

예를 들어, word = "abcdefd"이고 ch = "d"라면,
0번 인덱스부터 3번 인덱스까지("abcd")를 뒤집게 됩니다.
그 결과 문자열은 "dcbaefd"가 됩니다.

결과 문자열을 반환하세요.
~~~

## 문제 분석
1. 요구 : 뒤집기
2. 자료 : 문자열 word, 문자 ch
3. 조건 :
- word에 ch가 없다면 아무 작업도 하지 않습니다.
- ch가 있다면 0부터 해당 문자열까지 뒤집습니다.
- 여려개 있으면 첫번쨰 것만하고 스탑합니다

## 문제 풀이
~~~text
Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
~~~

1. "dcbaefd" left = 0, right = 3
2. "abcdefd" left = 0, right = 0


## 링크