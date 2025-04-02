## 문제 
- n개의 정수를 담은 0-인덱스 배열 nums와 정수 k가 주어집니다.
- 배열 nums에서 어떤 인덱스 i를 중심으로 반지름 k(즉, i - k부터 i + k까지)의 서브배열에 대한 k-반지름 평균은, 인덱스 i - k부터 i + k(양쪽 모두
  포함)까지에 있는 모든 원소들의 평균입니다.
    - 만약 인덱스 i의 앞이나 뒤에 k개의 원소가 충분하지 않다면, 해당 위치의 k-반지름 평균은 -1로 정의됩니다.
- 길이가 n인 배열 avgs를 구성하여, 각 avgs[i]가 인덱스 i를 중심으로 하는 서브배열의 k-반지름 평균을 담도록 합니다.
    - 여기서, x개의 원소 평균은 x개의 원소의 합을 x로 나눈 값(정수 나눗셈 사용, 즉 소수점을 버림)입니다. 예를 들어, 네 개의 원소 2, 3, 1, 5의 평균은 (
      2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75이며,
    - 정수 나눗셈에 의해 소수점 이하가 버려져 2가 됩니다.

### 문제 분석

### 문제 풀이
~~~text
Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]
Explanation:
- avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
- The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
  Using integer division, avg[3] = 37 / 7 = 5.
- For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
- For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
- avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.
~~~

1. 부분합을 구해놓는다 
2. result배열에 prefixSum[index+K] - prefixSum[index-K]를 반환한다 
3. 만약에 index-K, index+K가 범위에 벗어난다면 계산하지 않는다



### 링크 
https://leetcode.com/problems/k-radius-subarray-averages/submissions/1594281335



