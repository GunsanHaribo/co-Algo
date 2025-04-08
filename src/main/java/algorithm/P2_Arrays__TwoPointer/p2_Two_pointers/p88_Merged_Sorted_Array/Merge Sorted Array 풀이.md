## 문제

- 두 개의 정수 배열 nums1과 nums2가 주어지며, 두 배열은 오름차순으로 정렬되어 있습니다. 또한, 두 정수 m과 n이 주어지는데, 각각 nums1과 nums2의 원소 개수를 나타냅니다.
- nums1과 nums2를 하나의 배열로 병합하여 오름차순으로 정렬된 배열을 만드세요.
- 최종적으로 정렬된 배열은 함수에서 반환되지 않고, nums1 배열에 저장되어야 합니다. 이를 위해 nums1의 길이는 m + n이며, 처음 m개의 원소는 병합해야 할 원소들을 나타내고, 마지막 n개의 원소는
  0으로 설정되어 있으며 무시되어야 합니다. nums2는 길이가 n입니다.

### 문제 분석

- 요구사항 : 배열(배열 자체를 분리했다고 생각해도될듯)
- 주어진 것 : 오름 차순인 두배열 , 정수 m,n(두 배열의 원소의 갯수)
- 조건
    - 오름차순인 두 배열이 병합됨
    - nusm1 배열에 통합되어야 한다. - len(nums1)은 m+n. [1,2,3,0,0,0] 이런식으로 m+n이 되어 있다
    - num1

### 풀이

#### Example 1

~~~text
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1
~~~

#### 개선된 풀이

자료 : [1,2,3,0,0,0], [2,5,6]

[1,2,2,3,5,6] pointer1 = 5, pointer2 = 2, len = 5

[1,2,2,3,5,0] pointer1 = 4, pointer2 = 2, len = 4

[1,2,2,3,0,0] pointer1 = 3, pointer2 = 1, len = 3

[1,2,2,0,0,0] pointer1 = 2, pointer2 = 1, len = 2

[1,2,0,0,0,0] pointer1 = 2, pointer2 = 1, len = 2

[1,0,0,0,0,0] pointer1 = 1, pointer2 = 0, len = 1

[1,0,0,0,0,0] pointer1 = 0, pointer2 = 0, len = 0

[1,2,3,0,0,0] pointer1 = 0, pointer2 = 0, len = 0 -> 이 조건에 맞지 않음, 이 조건을 생각해봐야한다


///// 내가 생각한 풀이가 틀렸거나 도중에 복잡할 것 같다는 것을 느꼈을떄, 어떻게 대처를 할 것인가?
// 항상 내가 하는 방법이 맞겠구나라고 할 순 없지 않는가
// 맞게 풀순 있겠지... 근데...  최적의 방법이라고 좋은 방법이라고 할 순 없지 않는가

[1*,2,2,3,5,6] pointer1 = 0, pointer2 = 0 (1,2) 1

[1,2*,2,3,5,6] pointer1 = 1, pointer2 = 0 (2,2) 2

[1,2,2*,3,5,6] pointer1 = 2, pointer2 = 0 (3,2) 2

[1,2,2,3*,5,6] pointer1 = 3, pointer2 = 1 (3,5) 3

[1,2,3,0,5*,6] pointer1 = 4, pointer2 = 1 (0,5) 5

[1,2,3,0,0,6*] pointer1 = 5, pointer2 = 2 (0,6) 6

[1,2,3,0,0,0]







#### 복잡한 풀이

1. [1,2,3,0,0,0], [2, 5, 6]
    1. 두 배열을 비교
    2. nums1_pointer = 0, nums2_pointer = 0
        1. num1 <= num2면 요소 삽입을 하지 않고 단순히
        2. num_pointer +=1
    3. nums1_pointer = 1, nums2_pointer = 0
2. [1,2,3,0,0,0] + 2, [2,5,6] => [1,2,2,3,0,0]
    1. 현재 nums1_pointer = 2, nums2_pointer = 0
    2. nums1 > nums2
        1. 두 수를 교체하고 sort합니다.
    3. 현재 nums1_pointer = 3, nums2_pointer = 0
3. [1,2,2,0,0,0] + 5, [3,5,6]
    1. nums1_pointer = 2, nums2_pointer = 0
    2. nums1_pointer >= m-1 이면 num2가 남은걸 채웁니다
    3. nums1_pointer = 2, nums2_pointer = 1 -> 3
4. [1,2,2,3,5,6]

### 풀이 링크

처음 풀이 : https://leetcode.com/problems/merge-sorted-array/submissions/1586762371
개선된 풀이 : https://leetcode.com/problems/merge-sorted-array/submissions/1586765246