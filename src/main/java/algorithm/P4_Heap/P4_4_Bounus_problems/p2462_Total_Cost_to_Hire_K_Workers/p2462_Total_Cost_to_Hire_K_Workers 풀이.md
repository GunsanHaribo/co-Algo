# 문제 
~~~text
정수 배열 costs가 주어집니다. costs[i]는 i번째 근로자를 고용하는 비용을 나타냅니다.

또한 정수 k와 candidates도 주어집니다. 우리는 아래 규칙에 따라 정확히 k명의 근로자를 고용하고자 합니다:
	•	k번의 고용 세션을 진행하며, 각 세션마다 정확히 한 명의 근로자를 고용합니다.
	•	각 고용 세션에서, 배열의 앞쪽 candidates명 또는 뒤쪽 candidates명 중에서 비용이 가장 낮은 근로자를 선택합니다.
	•	비용이 동일한 경우에는 인덱스가 더 작은 근로자를 선택합니다.

예를 들어, costs = [3,2,7,7,1,2]이고 candidates = 2인 경우,
	•	첫 번째 고용 세션에서는 앞쪽 두 명 [3,2]과 뒤쪽 두 명 [1,2] 중에서 비용이 가장 낮은 사람은 costs[4] = 1이므로 4번째 근로자를 선택합니다.
	•	두 번째 세션에서는 남은 인원 중 [3,2,7,7,2]에서 앞 2명 [3,2], 뒤 2명 [7,2] 중 가장 싼 사람은 1번 인덱스의 2입니다. 같은 값이더라도 더 작은 인덱스를 선택합니다.
	•	만약 남은 근로자가 candidates명보다 적다면, 남은 인원 전체에서 가장 낮은 비용의 근로자를 선택합니다.
	•	한 번 고용된 근로자는 다시 선택할 수 없습니다.

정확히 k명의 근로자를 고용하는 데 드는 총 비용을 반환하세요.
~~~

## 문제 분석 
1. 미지 : 고용하는데 드는 총 비용
2. 자료 : 정수배열 costs(근로자를 고용하는 비용), 정수 k - 고용세션, candidates - 
3. 조건 : 
- 고용 세션 K, 세션별로 정확히 한 명의 근로자를 고용
- candidates : 앞뒤 후보자
- 비용이 동일하면 인덱스가 더 작은 근로자를 선택

## 문제 풀이 

#### 1. Example
~~~text
Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
Output: 11
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. 
The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. 
The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. 
Notice that the worker with index 3 was common in the first and last four workers. # 7이 중복후보임을 확인 
  The total hiring cost is 11
 ~~~~

- [17,12,10,7], [7,11,20,8]
- [17,12,10,7], [2,11,20,8]
- (인덱스, 값)으로 하고 최소 찾기  
- 최소 인덱스 remove
- 만약에 작으면 예뭐 어쩔 수 없는거고, 하나만 찾습니다. 
- 비용이 동일하면 인덱스가 더 낮은거 활용

#### 첫번째는 타임리미트에 걸림 -> 흐음... 어떻게 줄일 수 있을까?  
- 굳이 다시 넣어다 뺼 이요가 있을까? 
## 링크 
