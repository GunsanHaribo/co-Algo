# 문제 
~~~text
정수 배열 nums와 정수 k가 주어졌을 때, 
nums를 k개의 **비어 있지 않은 연속된 부분 배열(subarray)**로 나누세요.
이때 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 나누는 것이 목표입니다.

그렇게 나누었을 때의 최소화된 가장 큰 부분 배열의 합을 반환하세요.

🔹 부분 배열(subarray)은 배열에서 연속된 요소들의 집합입니다.
~~~

# 분석 
1. 미지 : k개의 부분 배열로 나눴을떄 "최소화(나눌 수 있는 경우에서 최소화)"된 "가장 큰(하나의 경우에서)" "부분 배열"의 합 
2. 자료 : 정수 배열 nums와 정수 k
3. 조건 : 
- nums를 k개의 비어 있지 않은 연속된 부분배열의 합
- 비어있지 않은 연속되 부분배열은 말그대로 비어있지 않은 것 의미합니다. 
- k는 50까지 있습니다.(length하고 둘중에 작은거 선택)

# 풀이 
1. Example 1:
~~~text
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] 
and [10,8], where the largest sum among the two subarrays is only 18.
~~~
1. [ 7 | 2,  5, 10, 8 ] -> 25
2. [ 7,  2 | 5, 10, 8 ] -> 23
3. [ 7 , 2, 5 | 10, 8 ] -> 18
4. [ 7 , 2, 5, 10 | 8 ] -> 24
--------------------------

1. 한번 다 나눠보고 합을 보던가.
2. 


# 링크 
