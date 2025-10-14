# 문제 
~~~text
당신은 대학 입학처의 일원으로서, 지원자들의 시험 점수 중 k번째로 높은 점수를 실시간으로 추적해야 합니다. 
이는 새로운 지원자가 점수를 제출할 때마다 면접 및 입학 커트라인을 동적으로 결정하는 데 도움이 됩니다.

당신의 과제는, 주어진 정수 k에 대해 시험 점수 스트림을 유지하고, 새로운 점수가 제출될 때마다 현재까지의 점수 중 k번째로 높은 점수를 반환하는 클래스를 구현하는 것입니다.
보다 구체적으로, 우리는 모든 점수를 정렬했을 때 k번째로 큰 점수를 찾고자 합니다.
⸻
KthLargest 클래스 구현:
	•	KthLargest(int k, int[] nums)
정수 k와 초기 시험 점수 스트림 nums로 객체를 초기화합니다.
	•	int add(int val)
새로운 시험 점수 val을 스트림에 추가하고, 지금까지의 점수 중 k번째로 큰 요소를 반환합니다.
~~~

## 문제 분석
1. 미지 : k번째로 큰요소 반환-> TopK
2. 자료 : k와 nums 
3. 조건 : 
- k번쨰로 높은 점수를 실시간으로 추적



## 문제 풀이 
### 1. Example
~~~text
Input:
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

Output: [null, 4, 5, 5, 8, 8]

Explanation:

KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3); // return 4
kthLargest.add(5); // return 5
kthLargest.add(10); // return 5
kthLargest.add(9); // return 8
kthLargest.add(4); // return 8
~~~


- 4 -> 8
- 9 -> 8
- 10 -> 5 -> 5, 8 10 
- 5 -> 5 -> 5,5,8
- 3 -> 4 : (4,5,8)  
작은게 먼저빠지고, add할떄 peek해줘야합니다. 

## 링크 
https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/1631718270
