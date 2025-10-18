# 문제 
~~~ text
정수 배열 nums가 주어졌을 때, 다음과 같은 여러 쿼리를 처리하세요:

쿼리 유형:
left에서 right(포함)까지의 인덱스에 해당하는 nums 요소들의 합을 계산합니다.
여기서 left <= right입니다.

NumArray 클래스를 다음과 같이 구현하세요:
•	NumArray(int[] nums)

→ 정수 배열 nums로 객체를 초기화합니다.
•	int sumRange(int left, int right)

→ left에서 right까지의 인덱스에 해당하는 nums 요소들의 합을 반환합니다.
(예: nums[left] + nums[left + 1] + ... + nums[right])
~~~


## 문제 분석
1. 요구 : 부분합
2. 자료 : 정수 배열 nums
3. 조건 : 


## 문제 풀이
1. Example
~~~text
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
~~~

1. 프리픽스 썸 사용해서 right - left 실행

## 링크
https://leetcode.com/problems/range-sum-query-immutable/submissions/1601556144
