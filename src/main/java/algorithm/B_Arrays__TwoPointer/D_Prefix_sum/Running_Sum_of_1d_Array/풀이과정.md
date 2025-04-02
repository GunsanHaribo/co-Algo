## 문제
- 배열 nums가 주어집니다. 배열의 누적합은 runningSum[i] = sum(nums[0] … nums[i])로 정의됩니다.
- nums의 누적합을 반환하세요.

### 문제 분석 
1. 요구 : 누적합
2. 자료 : 배열 nums 
3. 조건 :

### 문제풀이
~~~text
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
~~~

1. [1,2,3,4] 1~4 까지의 합
2. prefixSum으로 구한다


### 링크
https://leetcode.com/problems/running-sum-of-1d-array/submissions/1594197965