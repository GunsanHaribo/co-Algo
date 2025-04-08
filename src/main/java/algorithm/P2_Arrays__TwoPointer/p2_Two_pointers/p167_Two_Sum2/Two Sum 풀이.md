## 문제

- 1부터 시작하는 인덱스를 가진 오름차순(비내림차순)으로 정렬된 정수 배열 numbers가 주어집니다.

- 이 배열에서 두 개의 숫자를 선택하여 특정 target 값과 같아지도록 해야 합니다.
- 이 두 숫자를 numbers[index1]과 numbers[index2]라고 할 때, 다음 조건을 만족해야 합니다.
    - 1 <= index1 < index2 <= numbers.length

- 두 숫자의 인덱스 index1과 index2에 1을 더한 값을 [index1, index2] 형태의 정수 배열로 반환하세요.

- 추가 조건:
    - 문제의 테스트 케이스는 항상 정확히 하나의 해만 존재하도록 생성됩니다.
    - 같은 요소를 두 번 사용할 수 없습니다.
    - 상수(O(1))의 추가 공간만 사용해야 합니다.

### 문제 분석

- 요구 사항 : [실제인덱스index1+1, 실제 인덱스index2+1]을 더한 값의 정수 배열
- 주어진 것 : 오름차순으로 정렬된 정수 배열
- 조건
    - numbers[index1]과 numbers[index2]라고 할 때,
        - 1 <= index1 < index2 <= numbers.length 만족
    - 두 개의 숫자를 선택하여 특정 target 값과 같은 인덱스

### 풀이 과정

#### Example 1:

~~~text
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
~~~

1. 실제 인덱스 : [0, 3]
    1. target < numbers[index1] + numbers[index2] -> index2 -=1
2. 실제 인덱스 [0, 2]:
    1. target < numbers[index1] + numbers[index2] -> index2 -=1
3. 실제 인덱스 : [0, 1]
4. 답 : [0+1. 1+1]

### 풀이 링크

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1586789127
