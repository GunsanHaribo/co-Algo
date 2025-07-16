# 문제 
~~~text
정수 배열 nums가 길이 n으로 주어지고, 정수 배열 queries가 길이 m으로 주어집니다.

각 queries[i]에 대해, 
그 값 이하가 되도록 nums에서 부분 수열(subsequence)을 선택할 수 있을 때(의합), 
선택 가능한 부분 수열의 최대 크기를 구해서 배열 answer에 저장하세요. 
최종적으로 answer 배열을 반환하면 됩니다. 여기서 answer[i]는 queries[i]에 대한 정답입니다.

부분 수열이란, 
원래 배열에서 몇 개의 요소를 삭제(또는 아무 것도 삭제하지 않음)하여 
원래 순서를 유지한 채 얻을 수 있는 배열을 말합니다.
~~~

# 풀이
1. 미지 : 합이 query[i] 값 이하가 되는 "부분 수열"의 "최대 크기"
2. 자료 : nums, queries
3. 조건 : 
- 최대 크기는 max 밖에 기억이 안나긴하는데
- 부분수열은 순서만 맞으면 됩니다. -> 중간에 어떤 숫자가 생략되도 상관 없습니다.

# 분석 
## 1. Example
~~~text
Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
~~~

- 부분 수열 구하는 기능 -> prefixSum? ㄴㄴ, 부분 수열이라고 하긴엔 연속 되지 않아서 조금 힘들것 같기도 한데
- 최대 크기 구하는 기능 -> max를 어떻게 구할까?, 고민이 되는 구만
- sum이 = 0 이면 0반환합니다.

1. 3, [2,1] -> 합을 구하다가 뺴주면 되지 않나? 
   - query보다 작은 수를 찾아서 돌려줍니다. 
   - 작은 수를 기반으로 prefix sum을 실시합니다. 
2. 10, [4,5,2(넘으니깐 패스), 1] -> 넘으니깐 패스 한던가 아니면 2에서 그대로 다시 시작하던가
   - [4,5,1], [5,1,2], [2,1], [1,2,4] -> 포인터를 몇번 다시 돌려야 되는거지? 근데 난 그러기 싫은데
   - sort를 한번 하는것도 나쁘지 않은 전략인것 같긴한데 
3. 21, [4,5,2,1]

--------
1. [1,2,4,5] -> [1, 3, 7, 12] 
2. 여기서 query[]랑 같거나 작은 수의 인덱스를 출력합니다. 
3. 중복안되니깐 이전처럼 left 인덱스 뱉으면 될 듯 합니다.



# 링크 
https://leetcode.com/problems/longest-subsequence-with-limited-sum/submissions/1699746613
