# 문제 
~~~text
정수 배열 nums와 정수 threshold가 주어집니다. 우리는 양의 정수 divisor를 하나 선택하고, 
배열의 모든 원소를 이 divisor로 나눈 후, 그 나눈 값들을 모두 더합니다. 

이때, **나눈 결과는 각 원소마다 “해당 값을 divisor로 나눈 후, 그 결과를 올림한 값”**으로 계산합니다.
(예: 7 ÷ 3 = 2.33… → 올림하여 3, 10 ÷ 2 = 5)

이러한 연산의 합이 threshold 이하가 되도록 하는 가장 작은 divisor를 찾아 반환하세요.
테스트 케이스는 항상 정답이 존재하도록 생성됩니다.
~~~

# 분석 
1. 미지 : 가장 작은 divisor
2. 자료 : 정수배열 nums, 정수 threshold 
3. 조건 : 
- 연산의 압이 threshold 이하가 되도록
- 나머지가 있으면 무조건 올림합니다 -> ceil()


# 풀이 
~~~text
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) 
and if the divisor is 5 the sum will be 5 (1+1+1+2).
~~~


# 링크 
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/submissions/1699924392