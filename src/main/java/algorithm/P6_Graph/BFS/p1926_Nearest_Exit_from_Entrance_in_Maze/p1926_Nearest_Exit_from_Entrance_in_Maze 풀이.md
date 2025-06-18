# 문제 
~~~text
당신에게는 m x n 크기의 미로(maze)가 주어집니다.
	•	빈 칸은 '.'로 표시되어 있고,
	•	벽은 '+'로 표시되어 있습니다.
또한, 미로의 입구 위치도 주어집니다.
	•	entrance = [entrance(row), entrance(col)] 형태로, 입구의 행(row)과 열(column) 위치를 나타냅니다.
이동 규칙:
	•	한 번의 이동으로 상, 하, 좌, 우 방향 중 한 칸 이동할 수 있습니다.
	•	벽(’+’)에는 들어갈 수 없으며, 미로의 범위를 벗어나서도 안 됩니다.
목표:
입구에서 가장 가까운 출구(exit) 까지의 최단 경로의 이동 횟수(steps) 를 구하세요.
	•	출구는 **미로의 가장자리에 위치한 빈 칸(’.’)**을 의미합니다.
	•	입구 위치는 출구로 간주하지 않습니다.
반환값:
	•	최단 경로의 이동 횟수를 반환하세요.
	•	출구로 갈 수 없다면 -1을 반환하세요.
~~~

# 분석 
1. 문제 : 입구에서 가장 가까운 출구까지의 최단 경로의 이동횟수를 구하세요
2. 자료 : 
3. 조건 :
- 이동규칙  
  - 상하좌우, 벽에는 들어갈 수 없습니다.
  - 입구 위치는 출구로 간주하지 않습니다.
- 출구는 가장 자리에 위지한 빈칸 입니다. 

# 풀이
~~~text
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
~~~

1. 입구에서 부터 BFS 진행
2. 진행시 출구가 있으면 종료
3. 출구는  가장 자리(벽쪽)에 있어야합니다

# 링크 
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/submissions/1668129451
