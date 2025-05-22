# 문제 
~~~text
이진 트리의 루트가 주어졌을 때, 
그 트리가 자기 자신을 중심으로 대칭(즉, 좌우가 서로 거울처럼 대칭)인지 확인하시오.
~~~

## 분석 
1. 미지 : 대칭인지 확인 
2. 자료 : 이진트리 루트
3. 조건 : 
- 대칭 (투포인터가 생각나는 군요)

## 풀이 

### 1. Example
~~~text
Input: root = [1,2,2,3,4,4,3]
Output: true
~~~
- 양 옆에 비교 

### 2. Example
~~~text
Input: root = [1,2,2,null,3,null,3]
Output: false
~~~



## 링크
- 탐색으로 한 풀이 : https://leetcode.com/problems/symmetric-tree/submissions/1641060905
- 재귀에서 그떄 딱 비교하는 풀이 : https://leetcode.com/problems/symmetric-tree/submissions/1641090489


# 회고
- 일단 원본 로직짜는게 중요
- 다음이 재귀임, 어떻게 재귀적으로 표현할까