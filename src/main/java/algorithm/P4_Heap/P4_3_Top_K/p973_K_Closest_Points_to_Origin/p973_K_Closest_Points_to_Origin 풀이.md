# 문제 
~~~text
점들의 배열 points가 주어지며,
여기서 points[i] = [xi, yi]는 X-Y 평면 위의 하나의 점을 나타낸다.
또한 정수 k가 주어졌을 때, 원점 (0, 0) 에서 가장 가까운 k개의 점을 반환하시오.

X-Y 평면에서 두 점 사이의 거리는 유클리드 거리
(즉, √((x1 - x2)² + (y1 - y2)²))로 계산한다.

정답은 아무 순서로 반환해도 상관없으며,
정답은 순서를 제외하면 유일함이 보장된다.
~~~

## 문제 분석 
1. 미지 : 원점에서 가장 가까운 k개의 점
2. 자료 : 원점과 points[]
3. 조건 : 
- 가장 가까운 = 유클리드 거리
- k개 -> heap 가장 먼점 

## 문제 풀이 
### 1. Example 1
~~~text
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]

Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
~~~


- 제곱의 합 구하는 기능 
- k만 남겨ㅈ놓기 

heap.toArray(new int[k][]) -> k크기만 정해주면 가능 

## 링크 
https://leetcode.com/problems/k-closest-points-to-origin/submissions/1631691442