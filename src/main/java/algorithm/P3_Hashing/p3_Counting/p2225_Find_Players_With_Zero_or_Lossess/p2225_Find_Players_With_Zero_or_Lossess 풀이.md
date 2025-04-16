# 문제
~~~text
정수 배열 matches가 주어집니다. matches[i] = [winneri, loseri]는 선수 winneri가 선수 loseri를 이긴 경기 결과를 나타냅니다.

크기 2의 리스트 answer를 반환하세요:
	•	answer[0]은 한 번도 진 적이 없는 선수들의 리스트입니다.
	•	answer[1]은 정확히 한 번만 진 선수들의 리스트입니다.

두 리스트 모두 오름차순으로 정렬되어야 합니다.

주의 사항:
	•	최소 한 번이라도 경기에 참여한 선수만 고려해야 합니다.
	•	테스트 케이스는 동일한 결과의 경기가 중복해서 주어지지 않도록 생성됩니다.
~~~
## 문제 분석
1. 요구 : 이중리스트, 한번도 진적 없을때, 정확히 한번 졌을때 
2. 자료 : 정수 배열 matches(이중리스트), 승자, 패자로 나뉨 
3. 조건 : 
- 반환 배열 오름 차순 정렬
- 한번이라도 경기에 참여한 선수만 고려

## 문제 풀이

### 1. Example
~~~text
Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
~~~
1. loser 맵 에서 0일때 
2. loser 맵에서 1일때, filter+sort해서 반환


## 링크
https://leetcode.com/problems/find-players-with-zero-or-one-losses/submissions/1608265133