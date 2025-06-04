# 문제 
~~~text
이진 트리의 모든 리프 노드를 왼쪽에서 오른쪽 순서로 고려할 때,
그 리프 노드들의 값들은 하나의 리프 값 시퀀스(leaf value sequence) 를 이룹니다.

예를 들어, 위에 주어진 트리에서 리프 값 시퀀스는 (6, 7, 4, 9, 8)입니다.

두 이진 트리는 리프 값 시퀀스가 동일할 때 “leaf-similar”하다고 간주합니다.

루트 노드가 각각 root1과 root2인 두 트리가 leaf-similar하다면 true를 반환하고,
그렇지 않다면 false를 반환하세요.
~~~

# 분석 
1. 미지 : 두 트리의 리프값의 시퀀스가 일정한지 확인
2. 자료 : 두 트리 리프노드
3. 조건 : 
- 리프노드의 시퀀스를 가져와야 합니다.

# 풀이 
~~~text
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], 
root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
~~~

- 6,7,4- 98 = 6,7 - 4,9,8
- 리프노드를 끌어 올릴 필요가 있어보입니다. 
- 위에서 봤을떄 같아야한다면, 문자열로 올리되 



# 링크 
https://leetcode.com/problems/leaf-similar-trees/submissions/1653512699
