# 문제
- 주어진 정수 배열 nums가 오름차순으로 정렬되어 있을 때,
- 각 숫자의 제곱을 오름차순으로 정렬된 배열로 반환하는 문제입니다.

### 1. 문제 분석
- 요구사항 : 배열
- 주어진 것 : 오름차순으로 정수 배열 nums
- 조건
    - 입력 배열의 숫자의 제곱
    - 오름차순으로 정렬


### 2. 풀이

#### Example 1:
~~~text
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
~~~
제곱했을때 가장 큰값은 양 끝값
1. left = 0, right = len(nums)-1
2. num[left] **2, num[right]**2 비교
3. 결과 배열에 넣어주기
4. left<right 면 right-=1, 반대면 left -=1
5. 결과배열의 인덱스 -=1
5. left<right할때까지 진행
5. 결과 배열 반환


### 풀이 링크
https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1586686623