# 문제
~~~text
양의 정수로 이루어진 배열 nums가 주어집니다. 
한 번의 연산에서, nums에서 임의의 숫자를 선택하여 그 수의 절반으로 줄일 수 있습니다. 
(줄인 숫자는 이후 연산에서 다시 선택할 수 있습니다.)

nums의 합을 최소 절반 이상 줄이기 위해 필요한 최소 연산 횟수를 반환하세요
~~~

## 문제 분석
1. 미지 : (합을 절반이상 줄이는)최소 연산횟수 -> 큰것 부터 줄이기
2. 자료 : 양의 정수 배열 nums
3. 조건 : 
- 임의의 숫자르 선택하여 절반으로 줄이기
- 합을 절반이상 줄입니다. 

## 문제 풀이
### 1. Example
~~~text
Input: nums = [5,19,8,1]
Output: 3
Explanation: The initial sum of nums is equal to 5 + 19 + 8 + 1 = 33.
The following is one of the ways to reduce the sum by at least half:
Pick the number 19 and reduce it to 9.5.
Pick the number 9.5 and reduce it to 4.75.
Pick the number 8 and reduce it to 4.
The final array is [5, 4.75, 4, 1] with a total sum of 5 + 4.75 + 4 + 1 = 14.75.
The sum of nums has been reduced by 33 - 14.75 = 18.25, which is at least half of the initial sum, 18.25 >= 33/2 = 16.5.
Overall, 3 operations were used so we return 3.
It can be shown that we cannot reduce the sum by at least half in less than 3 operations.
~~~

1. 소수접 계산이 가능해야합니다. 
2. 합계산 어떻게 하냐

## 링크 
https://leetcode.com/problems/minimum-operations-to-halve-array-sum/submissions/1631178684
