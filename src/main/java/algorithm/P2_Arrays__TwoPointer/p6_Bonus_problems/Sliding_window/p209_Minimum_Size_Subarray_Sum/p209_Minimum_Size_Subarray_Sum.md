# 문제
~~~text
양의 정수로 이루어진 배열 nums와 양의 정수 target이 주어졌을 때, 
합이 target 이상이 되는 부분 배열(subarray) 중 가장 짧은 길이를 반환하세요.

만약 그러한 부분 배열이 없다면, 대신 0을 반환하세요.
~~~
## 문제 분석
1. 요구 : 길이
2. 자료: 양의 정수 nums, 양의 정수 target
3. 조건 :
- 합이 target 이상이 되야됨
- 가장 짧아야 됨

## 문제 풀이
1. Example
~~~text
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
~~~
left, right | left < length 까지
1. [4,3]
2. [2,4,3]
3. [2,4]
4. [1,2,4]  크거나 같으면, sum에서 제외 후, left++
5. [3,1,2,4]
6. [3,1,2]  작으면,  right++, sum 에 추가
7. [2,3,1,2]


## 링크
https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1601381349