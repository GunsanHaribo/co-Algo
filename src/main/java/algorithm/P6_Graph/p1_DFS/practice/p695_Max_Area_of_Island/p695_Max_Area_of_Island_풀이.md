# 문제

~~~text
정점이 n개 있는 양방향 그래프가 있습니다. 각 정점은 0부터 n - 1까지의 정수로 라벨링되어 있습니다. 
그래프의 간선들은 2차원 정수 배열 edges로 주어지며, edges[i] = [ui, vi]는 정점 ui와 정점 vi 사이에 양방향 간선이 존재함을 나타냅니다. 각 정점 쌍 사이에는 최대 하나의 간선만 존재하며, 자기 자신에게 연결된 간선은 없습니다.

당신은 정점 source에서 정점 destination까지 유효한 경로가 존재하는지를 판단하고자 합니다.

edges, 정수 n, source, destination이 주어졌을 때, source에서 destination으로 가는 유효한 경로가 존재한다면 true를, 
존재하지 않는다면 false를 반환하세요.
~~~

# 분석

1. 문제 : 유효한 경로가 있는지 판단
2. 자료 : source, destination
3. 조건 :
- 길이 있는지 없는지 판단 

# 풀이

~~~text
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
~~~

1. 그래프 만들고 
2. 노드별로 연결되 노드 기록해보고
3. source - destination 연결 되어있는지 확인

# 링크 
https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/1660720404
