## 문제

- 정수 배열 nums가 주어집니다. 또한 양수인 초기값 startValue가 주어집니다.
- 각 반복마다, 왼쪽에서 오른쪽으로 nums의 원소들을 하나씩 더해가며, startValue에서 시작하는 단계별 누적합을 계산합니다.
- 모든 단계에서 누적합이 1 미만이 되지 않도록 보장하는 최소의 양수 startValue 값을 반환하세요.

### 문제 분석

1. 요구: 양수 startValue 반환
2. 자료: 정수 nums, startValue
3. 조건:

- 왼쪽에서 오른쪽으로 nums의 원소들을 하나씩 더한다(startValue에서 단계별 누적합 계산 )
- 누적합이 1미만이 되지 않도록 보장 -> 누적합 중에 1미만인 값이 있으면 startValue++
- 만족하는 startValue중에 최소여아합니다. -> 1부터 시작

### 문제 풀이

~~~text
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
~~~


1. 돌면서 가장 작은 누적합을 찾고
2. 0보다 작은 가장작은 누적합에 +1을 합니다.
3. 만약 0보다 크면 1을 반환합니다.

### 링크
https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/submissions/1594237677