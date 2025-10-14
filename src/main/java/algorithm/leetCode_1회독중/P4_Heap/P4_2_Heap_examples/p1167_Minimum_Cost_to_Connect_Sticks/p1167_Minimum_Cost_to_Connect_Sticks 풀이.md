# 문제 
~~~text 
당신은 양의 정수 길이를 가진 여러 개의 막대를 가지고 있습니다. 
이 막대들의 길이는 배열 sticks로 주어지며, sticks[i]는 i번째 막대의 길이를 나타냅니다.

길이가 x와 y인 두 막대를 연결하여 하나의 막대로 만들 수 있으며, 이때 드는 비용은 x + y입니다.
모든 막대를 하나로 만들 때까지 위의 과정을 반복해야 합니다.

이렇게 모든 막대를 하나로 연결하는 데 드는 최소 비용을 반환하세요.
~~~

## 문제 분석
1. 미지 : 막대 연결 최소 비용
2. 자료 : 양의 정수 길이를 가진 막대, sticks[i]는 i번째 막대의 길이
3. 조건 : 
- 막대를 하나로 연결
- 연결 비용은 x+y
- 최소 비용 -> 총합나오는 것 같으니, 처음에 작은 것부터 합쳐

## 문제 풀이

### 1. Example
~~~text 
Input: sticks = [2,4,3]
Output: 14
Explanation: You start with sticks = [2,4,3].
1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks =
   [5,4].
2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
   There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
~~~


#### Example 2:
~~~text
Input: sticks = [1,8,3,5]
Output: 30
Explanation: You start with sticks = [1,8,3,5].
1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks =
   [4,8,5].
2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks =
   [9,8].
3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks =
   [17].
   There is only one stick left, so you are done. The total cost is 4 + 9 + 17 =
~~~


### Example 3: 
~~~text
Example 3:
Input: sticks = [5]
Output: 0
Explanation: There is only one stick, so you don't need to do anything. The
total cost is 0.
~~~


## 링크 
프리미엄 문제랑 채점 불가