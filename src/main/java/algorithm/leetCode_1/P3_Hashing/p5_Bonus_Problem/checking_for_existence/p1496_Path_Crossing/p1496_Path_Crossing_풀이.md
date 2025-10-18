# 문제
~~~text
문자열 path가 주어집니다. 
path[i]는 각각 북쪽(N), 남쪽(S), 동쪽(E), 서쪽(W)으로 한 칸 이동하는 것을 나타냅니다. 
당신은 2D 평면의 원점 (0, 0)에서 시작하여 path에 지정된 경로를 따라 이동합니다.

이동 중에 한 번이라도 이전에 방문한 위치를 다시 방문하면 true를 반환하고, 그렇지 않으면 false를 반환하세요
~~~

## 문제 분석
1. 미지 : 재방문여부
2. 자료 : 문자열 path, NES 나옵니다.
3. 조건 : 
- (0,0)에서 시작하여 path에 지정된 경로를 따라 이동

## 문제 풀이

### 1. Example
~~~text
Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.
~~~
1. 해당 좌표가 등록되어 있으면 true
2. 다 돌지 말고 있으면 다시 방문하면 true

## 링크 
https://leetcode.com/problems/path-crossing/submissions/1627438582