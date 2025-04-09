# 문제
~~~text
한 명의 바이커가 로드 트립을 떠납니다. 
이 로드 트립은 서로 다른 고도를 가진 n + 1개의 지점을 포함합니다. 
바이커는 고도 0인 지점 0에서 여행을 시작합니다.

정수 배열 gain이 주어지며, 길이는 n입니다. 
이때 gain[i]는 지점 i와 지점 i + 1 사이의 고도의 변화량을 나타냅니다. (0 <= i < n)

여행 중 도달할 수 있는 가장 높은 고도를 반환하세요.
~~~


## 문제 풀이
1. 요구 : 도달할 수 있는 가장 높은 고도 = max, 0->i로 나아가는 부분합
2. 자료 : 로드트림 n+1, 시작점 0, 정수배열 gain, i i+1 사이의 고도의 변화량을 나타냄
3. 조건 :


## 문제 분석

1. Example:
~~~text
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
~~~

1. 부분합 풀이 사용
    1. -6은 result[n] = result[n-1] + gain[n-1]

## 링크
https://leetcode.com/problems/find-the-highest-altitude/submissions/1601496419