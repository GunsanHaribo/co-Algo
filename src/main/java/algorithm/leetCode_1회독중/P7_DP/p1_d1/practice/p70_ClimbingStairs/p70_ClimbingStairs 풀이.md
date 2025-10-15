# 문제
~~~text
당신은 계단을 오르고 있습니다. 꼭대기에 도달하려면 총 n 계단을 올라야 합니다.

한 번에 1계단 또는 2계단을 오를 수 있습니다.
이때, 꼭대기까지 올라가는 서로 다른 방법의 수는 몇 가지일까요?
~~~

# 분석
1. 미지 : 꼭대기를 올라가는 방법의 수 
2. 자료 : n개의 계단
3. 조건 :
- 한번에 1계단 또는 2계단을 오를 수 있습니다.
  - n개 에서 시작해서 2 또는 1을 뺴주면서 진행합니다.
- 0이면 종료

# 풀이
## 1. Example
~~~text
Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
~~~
1. 1~n까지 다 돌린다.
2. 그리고 n이 되면 찾는다. 
------
1. n부터 내려깐다. 근데 이러면 메모는 어떻게 하지? 
2. ==0 일떄 종료


# 링크 
https://leetcode.com/problems/climbing-stairs/submissions/1683650243


+) pdf 에서
~~~text
Map<Integer, Integer> memo = new HashMap<>(); 
이 부분이 좋네요 예전에는 그냥 배열로 했던것 같은 
~~~