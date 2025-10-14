### 1. 문제 분석

- 요구사항 : 뒤집기 == 대칭
- 주어진 것 : 문자열
- 조건 :  O(1)의 메모리를 사용
    - 특정한 순서, 패턴 = 대칭, 공간복잡도를 참고한다면 투 포인터 사용!!

### 2. 풀이

#### Example 1:

~~~text
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
~~~

1. left =0, right = length-1 설정
2. h <->0
    1. s[left] <-> s[right] swap
    2. left++, right--
3. e <-> l
    1. 2-1. 2-2와 같이 진행
4. l
    1. left>=right 이면 종료합니다.

#### Example 2:
~~~text
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
~~~
1. left =0, right = length-1 설정
2. H <-> h
    1. s[left] <-> s[right] swap
    2. left++, right--
3. a <-> a
    1. s[left] == s[right] 이면 no swap
    2. left++, right--
4. n <-> n
    1. s[left] == s[right] 이면 no swap
    2. left++, right--
5. left>=right가 되면 종료합니다


### 풀이 링크
https://leetcode.com/problems/reverse-string/submissions/1586552569


