# 문제 
~~~text
0번부터 n - 1번까지 번호가 매겨진 n개의 노드로 이루어진 무방향 트리가 있습니다.
edges라는 2차원 정수 배열이 주어지며, 길이는 n - 1입니다. 
edges[i] = [ai, bi]는 노드 ai와 노드 bi 사이에 간선이 있음을 나타냅니다.
또한 restricted라는 정수 배열이 주어지며, 이는 방문이 제한된 노드들을 나타냅니다.

제한된 노드를 방문하지 않고, 노드 0번에서 도달할 수 있는 최대 노드 수를 반환하세요.
단, 노드 0번은 제한된 노드가 아님이 보장됩니다.
~~~

# 분석 
1. 미지 : 0에서 도달할 수 있는 최대 노드 수
2. 자료 : 엣지(노드 사이에 간선이 있음), restrict(방문이 제한되 노드)
3. 조건 : 
- 

# 풀이 
~~~text
Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
Output: 4
Explanation: The diagram above shows the tree.
We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
~~~

1. 다 연결하고 
2. 0에서 dft하면서 count, restrict된 곳을 제외

# 링크
GPT 풀이: https://leetcode.com/problems/reachable-nodes-with-restrictions/submissions/1660739367