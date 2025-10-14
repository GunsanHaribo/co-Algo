## 문제
- 문자열 s와 정수 k가 주어졌을 때, 문자열의 처음부터 2k 문자 단위로 나누어 첫 k 문자를 뒤집어라.
- • 남은 문자가 k개 미만이라면, 모든 문자를 뒤집는다.
- • 남은 문자가 k 이상 2k 미만이라면, 첫 k 문자만 뒤집고 나머지는 그대로 둔다.

### 1. 문제 분석

- 요구 : 뒤집기 == 대칭
- 주어진 것: 문자열 s, 배열, 정수 k
- 조건
    - 문자열의 처음부터 2k 문자 단위로 나누어 첫 k 문자 뒤집기?
        - 문자를 2k 단위로 나누기 (투포인터)
            - k개 미만이면 전체 뒤집기(투포인터)
            - k이상 2k미만이면 첫 k문자 뒤집기

### 2. 풀이

#### Example 1:

~~~text
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
~~~


#### 복잡한 풀이
1. 2k = 4 단위로 쪼개기, 구간 -> 투포인터 사용
    1. start = 0 end = start+2k-1
2. abcd -> bacd 범위 체크
    1. k이상 2k이하이므로
    2. left= start ~ right=start+k-1 구간을 뒤집는다
3. efg -> feg, 다만, 범위는2 뒤집기 함수 등장,
    1. k이상 2k이하이므로
    2. start = end+1, end = start+2k-1
        1. 만약에 end가 len()-1 초과라면, end = len()-1
    2. left= start, right=start+k-1 사용해서 뒤집는다

---------k미만과 종료조건-----------
1. start,end의 범위가 -> k미만이면
    1. (end - start) +1 < k
    2. start~end를 뒤집는다
2. start가 마지막인데스(len-1)을 넘어버리면 종료한다


#### 간단한 풀이(end를 움직일 푤요가 없다)
1. start =0, end = len(s)
2. start가 n이 될때까지 이동
3. end의 범위를 벗어나지 않도록 min으로 계산
4. reverseOrder로 특정 구간 k 또는
5. 다음 2k칸 이동


### 풀이 링크

1. 처음 풀이 : https://leetcode.com/problems/reverse-string-ii/submissions/1586620981
2. GPT 개선 : https://leetcode.com/problems/reverse-string-ii/submissions/1586629925


### 회고
1. k미만일 경우는 끝부분 밖에 없었다. 그래서 min으로 처리가 가능했다 - 굳이 일일이 비교할 이유가 없었다는 이야기
2. 조건을 볼떄는 문제 예시 그대로 따라가는 것도 좋지만 현재 조건이 특수한 경우인지 생각해 보는 것도 괜찮을 것 같다
3. 