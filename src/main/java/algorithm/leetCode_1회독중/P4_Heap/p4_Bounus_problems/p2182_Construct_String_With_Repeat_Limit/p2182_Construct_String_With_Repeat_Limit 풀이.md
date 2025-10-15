# 문제 (회고 필수, 속도 개선 필요)

~~~text
“주어진 문자열 s와 정수 repeatLimit가 있을 때, s의 문자들을 사용하여 repeatLimitedString이라는 새 문자열을 생성합니다. 
단, 어떤 문자가 연속해서 repeatLimit번 이상 나타나지 않도록 해야 합니다. s의 모든 문자를 사용하지 않아도 됩니다.

가능한 가장 사전순으로 큰 repeatLimitedString을 반환하세요.

문자열 a가 문자열 b보다 사전순으로 크다는 것은, a와 b가 처음으로 다른 위치에서 a가 해당 위치의 b보다 알파벳에서 더 뒤에 오는 문자를 가진 경우를 의미합니다. 
만약 a와 b의 앞에서부터 min(a.length, b.length)개의 문자들이 모두 같다면, 더 긴 문자열이 사전순으로 더 큽니다.
~~~

## 문제 분석

1. 미지 : (기존 것을 사용한) 새로운 문자열 -> string
2. 자료 : 문자열 s, 정수 repeatLimit
3. 조건 :

- 사전순으로 가장 큰
- 어떤 문제가 "연속"해서 repatLimit번 이상 나오면 안된다
    - 연속 방지(투포인터? 최대연속인데 그건 연속을 잡을 수 있으니깐 괜찮을 수도)
    - count -> HashMap
- 사전순으로 같다면 더 긴 문자열이 사전순으로 더 큽니다.

## 문제 풀이

#### 1. Example

~~~text
Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
~~~

- zzcccac : right == length -1이므로 끝
- zzccca  : c는 다시 넣는다, a는 넣고, 임시저장은 큐로 하자
    - zzcccc : left = 2, right = 5 ->  (right-left +1) > k의 경우
    - c를 다른 곳에 넣어놓고 힙에서 다른 요소를 붙인다
    - sb[left] != sb[right] 이면, left = right 진행
    - 다른 곳에 넣어논 c를 다시 heap에 넣는다
- zzccc   : left = 2, right = 4
- zzc     : 만약 sb[left] != sb[right] 이면, left = right 진행
- zz      : left = 0, right = 1 =>
- z       : left = 0, right = 0 => 크기는 (right-left +1)

- 리미트가 걸렸을떄 따로 다른 곳에 넣어줬다가 다시 넣어줘서 우선순위 큐가 필요
- 연속이니, 투 포인터로 진행, 이전 값 일일이 확인하기가 어려움

### 2. Example:

~~~text
Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa". 
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
~~~

- bbabaa -> limit가 걸려있는데, heap에서 계속 뽑은 값이 null이라면 stop
- bba -> 만약 sb[left] != sb[right] 이면, left = right 진행

### Time Limit Exceeded

- 단어를 하나하나 넣지말고 문장으로 넣어보자
- 리미트에 걸리면, 어쩔 수 없으니깐
- zzccc + a -> z: 0 c:1 a:1 : peek 해서 하나
- zzccca + c -> (c, limit) 들고오기 min(limit, left)해서 들고오자
- 계속 넣어주지만 않으면 되니깐

1. set하고 heap에 넣기
2. map으로 Count하기
3. heap poll해서 나온 가장큰
    1. Map에서 min(limit, leftSize), 까주고,
        1. repeat한것 StringBuilder로 넣어줍니다.
        2. 까준이후 
           1. 만약에 해당 문자가 남아있으면
               1. peek한 수하나를 append합니다. map은 까주고 
               2. 여기서 peek이 null이면 종료
               3. 그런 다음 뻇던 문자를 넣어줍니다.
           2. 해당 숫자가 남아있지 않으면 처음으로 돌아갑니다.
              1. 0이되면 삭제 시켜줘야합니다.
- Map으로 따로 관리하니깐 커졌을때 잔버그가 조금씩 보임 
- 그렇다면 Entry를 같이 넣어 볼까... 

### Time Limit Exceeded -> Map 최적화, Entry 직접적으로 넣기 
1. map으로 Count하기
2. heap에 Map의 Entry 넣어주기
3. heap poll해서 나온 가장 늦은 알파벳과 그 총합이 나옵니다.
   1. min(limit, leftSize) 계산합니다. 
   2. repeat * min => StringBuilder로 넣어줍니다.
   3. left를 계산합니다. 현재 count - min
      1. left == 0
         1. 그냥 다음걸로 넘어가기
      2. left > 0
         1. 두번째로 늦은 수를 하나만 더 해준다
         2. 뺄셈이후로 두번쨰 수가 남아있다면 다시 넣어준다

### 속도가 너무 안나오는데 개선 할 방법(회고중)
- TreeMap을 사용해볼까
- map.tailMap(maxChar, false).navigableKeySet();
- 정렬이 필요하다면 heap말고 트리 맵으로 다시 도전해 보는것도 괜찮을지도, 어차피 같은 트리긴하니깐


## 링크
https://leetcode.com/problems/construct-string-with-repeat-limit/submissions/1632910767

## 회고

- 이전 값하고 비교하고 이런거는 조금 힘들어서 망설였던게 있었고
- 더 좋을 만한 풀이, 빠른 풀이를 한번에 생각하는게 힘들긴하네
- 레코드말고, 이미 존재하는 자료형들 중에 충분히 상황을 커버할 수 있는 것들이 있다. 