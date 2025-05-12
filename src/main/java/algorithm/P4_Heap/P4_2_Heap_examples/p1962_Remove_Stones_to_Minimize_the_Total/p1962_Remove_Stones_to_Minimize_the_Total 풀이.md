~~~text
당신에게는 정수 배열 piles가 주어집니다. 
이 배열은 0부터 시작하는 인덱스를 가지며, piles[i]는 i번째 더미(pile)에 있는 돌(stone)의 개수를 나타냅니다. 
또한 정수 k도 주어집니다.

당신은 정확히 k번 다음 연산을 수행해야 합니다:
	•	어떤 piles[i]를 선택하고, 그 pile에서 floor(piles[i] / 2)개의 돌을 제거합니다.

주의: 같은 pile에 대해 여러 번 연산을 수행할 수 있습니다.

이 연산을 k번 수행한 후 남아 있는 돌의 총 개수의 최솟값을 반환하세요.
여기서 floor(x)는 x보다 작거나 같은 가장 큰 정수(즉, 내림한 값)입니다.
~~~

## 문제 분석
1. 미지 : 남아있는 돌의 총 개수의 (최솟값을 반환)
2. 자료 : 정수배열 piles -> n번째 더미에 있는 돌의 개수를 나타냅니다.
3. 분석 :
- pile에서 floor(piles[i] / 2)
- 돌의 총갯수 구하는 기능
- 최솟값 -> 최대값인 것들을 계속 half 해줘야된다.
- floor -> 정수로 내림한 값 round 하면됨

## 문제 풀이
#### 1. Example 1:
~~~text 
Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
  The total number of stones in [3,4,5] is 12.
~~~


## 링크

https://leetcode.com/problems/remove-stones-to-minimize-the-to