# 문제 (회고 필수)
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
- 사전순으로 가장 큰 -> 알파벳에서 더 뒤에 오는 문자를 가진다.
- 어떤 문제가 "연속"해서 repatLimit번 이상 나오면 안된다
- 사전순으로 같다면 더 긴 문자열이 사전순으로 더 큽니다. -> 이 조건을 사용할지느 모르겠네 

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

- zzcccac 
- zzccca -> c는 다시 넣는다, a는 넣고, 임시저장은 큐로 하자  
- zzccc -> 리미트에 걸림 다 -> 알파벳 필요 
- zzc -> 이전과 다른 알파벳 나오면 count = 0, 
- zz 
- z


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

- bbabaa -> 뽑았을떄 limit, 다른게 안나오고 바로 null이면 스탑  
- bbaba
- bbab
- bba -> 다음에 찾다가 있으면 올린다. 

이전값하고 비교하는게, 좀 까다로운데.. 이거 좋은 방법없을까?
다 뽑고 하는게 쉽지않은데, 솔직히 지금 null처리도 쉽지않고 

## 링크