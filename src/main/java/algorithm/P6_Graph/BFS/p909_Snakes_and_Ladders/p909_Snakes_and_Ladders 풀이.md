# 문제 
~~~text
당신은 n x n 크기의 정수 행렬 board를 받게 되며, 이 보드는 Boustrophedon 방식으로 번호가 매겨져 있습니다.
번호는 왼쪽 아래 칸(board[n - 1][0])에서 시작하여 각 행마다 방향을 번갈아가며 1부터 n²까지 매겨집니다.

당신은 보드의 1번 칸에서 게임을 시작합니다. 
현재 칸이 curr일 때, 한 번의 이동에서 다음을 수행합니다:
	•	도착지 칸 next는 [curr + 1, min(curr + 6, n²)] 범위 내의 번호 중 하나입니다.
이것은 일반적인 6면체 주사위의 결과를 시뮬레이션한 것으로, 보드 크기와 관계없이 항상 최대 6개의 이동 후보가 존재합니다.
	•	만약 next 칸에 뱀이나 사다리가 있다면, 반드시 그 목적지 칸으로 이동해야 합니다.
그렇지 않다면 next 칸으로 그대로 이동합니다.
	•	게임은 당신이 n²번 칸에 도착하면 끝납니다.

보드의 r행, c열에 위치한 칸은 board[r][c] != -1일 경우, 뱀이나 사다리가 있는 칸이며
그 칸의 값 board[r][c]는 이동해야 하는 도착지 번호를 의미합니다.

단, 1번 칸과 n²번 칸은 뱀이나 사다리의 시작점이 될 수 없습니다.
또한, 주사위 한 번에 따라 이동한 후에는 단 한 번만 뱀이나 사다리를 탈 수 있습니다.
즉, 뱀이나 사다리로 이동한 그 목적지가 또 다른 뱀이나 사다리의 시작점이라 하더라도 추가로 타지 않습니다.

예를 들어, 보드가 [[–1, 4], [–1, 3]]이고, 첫 번째 이동에서 도착한 칸이 2라고 가정합시다.
그러면 3번 칸으로 이어지는 사다리를 타지만, 그 다음의 4번 칸으로 이어지는 사다리는 타지 않습니다.
n²번 칸에 도달하기까지 필요한 주사위 굴림 횟수의 최소값을 반환하세요.
도달할 수 없다면 –1을 반환하세요.
~~~

# 분석 
1. 문제 : n^2번 칸에 도달하기까지 필요한 주사위 굴림 횟수의 최솟값을 반환
2. 자료 : board, (각 행마다 방향을 번갈아가면 1~n^2까지 구성)
3. 조건 : 
- 시작 : 보드의 1번칸
- 뱀이나 사다리 타기 
  - board[r][c] != -1  -> 뱀이나 사다리
  - board[r][c] 값은 이동해야하는 번호
- -1이면? 주사위를 굴립니다. curr은 현재 위치
  - 도착지는 next는 +[curr + 1, min(curr + 6, n²)] 중에 하나입니다. 
  - 초과하면 안되니깐

# 풀이
~~~
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
~~~

1. 굴림 횟수의 최솟값
2. step에 굴림횟수 저장 
3. 한칸씩 저장을 해야되나? 아니면 갈수있는 칸들을 다 신행을 해봐야되나? 
4. 1~6(짤리기 전까지) 진행 하고 안짤렸으면 
5. 넣어주면서 진행 
6. dice돌리다가 숫자를 넘으면, 올려줘야되지않나? 

# 링크 
gpt풀이 : https://leetcode.com/problems/snakes-and-ladders/submissions/1668193884