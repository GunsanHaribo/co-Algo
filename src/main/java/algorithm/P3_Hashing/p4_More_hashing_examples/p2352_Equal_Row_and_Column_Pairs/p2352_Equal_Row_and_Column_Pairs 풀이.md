# 문제
~~~text
0부터 시작하는 인덱스를 사용하는 n x n 정수 행렬 grid가 주어졌을 때, 다음 조건을 만족하는 쌍 (ri, cj)의 개수를 반환하세요:

행 ri와 열 cj가 서로 같은 경우입니다.

행과 열이 같다는 것은 같은 순서로 동일한 요소들을 포함하는 경우를 의미합니다 (즉, 같은 배열이라는 뜻입니다).
~~~

## 문제 분석
1. 미지 : 쌍 (ri, cj)의 개수를 반환 -> 어떻게 탐색할 것인가가 문제
2. 자료 : "n x n" 정수 행렬 grid(이중리스트)
3. 조건 :
- 행과 열이 서로 같은 경우
  - 같은 순서
  - 동일한 요소

    
## 문제 풀이
1. Example
~~~text
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
~~~

1. 2,7,7
2. ㅗ 모양으로 같네 
3. 어떻게 탐색할 것인가가 문제, 어떻게 탐색을 해야되지?
4. 키는 String
5. 일단 행탐색
6. 열탐색은 행렬 바꾸는 함수 도입 -> 행렬을 어떻게 바꿀까? 

2. Example
~~~text
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
~~~


## 링크
https://leetcode.com/problems/equal-row-and-column-pairs/submissions/1621748974