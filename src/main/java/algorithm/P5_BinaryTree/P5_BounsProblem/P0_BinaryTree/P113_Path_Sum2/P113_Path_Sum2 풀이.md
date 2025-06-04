# 문제 
~~~text
주어진 이진 트리의 루트 노드와 정수 targetSum이 있을 때,
노드 값들의 합이 targetSum과 같은 모든 루트-리프 경로를 반환하세요.
각 경로는 노드 값들의 리스트로 반환하며, 노드 참조가 아닌 값만 포함해야 합니다.

루트-리프 경로란 루트 노드에서 시작해 리프 노드에서 끝나는 경로를 말합니다.
리프 노드는 자식 노드가 하나도 없는 노드를 의미합니다.
~~~

# 분석 
1. 미지 : 합 == targetSum 경로
2. 자료 : 이진트리와 루트노드
3. 조건 : 
- 합이 같아야합 

# 풀이 
~~~text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
~~~
1. 일단 넣어놓고 만약에 리프까지 갔을떄, 합이 아니면 뺸다.


# 링크 
GPT 풀이 : https://leetcode.com/problems/path-sum-ii/submissions/1646915643