# 문제

- 두 개의 정수 배열 nums1과 nums2가 오름차순(비내림차순)으로 정렬되어 주어집니다.
- 두 배열에 공통으로 존재하는 정수 중 가장 작은 정수를 반환하세요.
-
- 만약 공통된 정수가 없다면 -1을 반환하세요.
    - 여기서 “공통된 정수”란, nums1과 nums2 양쪽 모두에 적어도 한 번 이상 등장하는 정수를 의미합니다.

## 문제 분석

1. 요구 : 가장 작은 "정수" -> min
2. 자료 : num1,2 -> 정수(양수), 오름차순(비내림순)으로 정렬됨
3. 조건 :

- 두 배열에 공통하는 수
- 공통된 정수가 없다면 -1반환

## 문제 풀이

### 2. Example:

~~~text
Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
~~~

1. numPointer, num2Pointer
2. 공통적으로 들어있는지 확인
   1. 비교했을떄 같으면 둘다 증가
   2. 비교했을때 다르면 수가 작은게 증가
      1. 6, 5
      2. 6, 4
      3. 3, 3
      4. 2, 2
      5. 1, 2
3. 공통적으로 적용되는것은 min 비교

## 링크 
https://leetcode.com/problems/minimum-common-value/submissions/1601562089
