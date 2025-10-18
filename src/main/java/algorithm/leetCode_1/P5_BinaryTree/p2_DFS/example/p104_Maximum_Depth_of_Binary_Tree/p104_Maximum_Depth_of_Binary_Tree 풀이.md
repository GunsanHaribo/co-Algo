# 문제

~~~text
Given the `root` of a binary tree, find the length of the longest path from the root to a leaf.
이진 트리의 `root` 가 주어지면, 루트에서 리프까지의 가장 긴 경로의 길이를 찾으세요.
~~~

## 분석

1. 미지 : 경로
2. 자료 : 이진 트리의 root
3. 조건 :

- 루트 -> 리프까지 : DFS
- 가장 긴 경로 : 최대 비교

## 풀이

### 1. Example

~~~text
[3,9,20,null,null,15,7]
~~~

1. 답 : 3
2. 3 -> 9(leaf)-> 0
3. 3-> 20 -> 15(leaf) -> 0
4. 3 -> 29 -> 7(leaf) -> 0

### 2. Example

~~~text
[1,null,2]
~~~

## 링크
https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1639663756