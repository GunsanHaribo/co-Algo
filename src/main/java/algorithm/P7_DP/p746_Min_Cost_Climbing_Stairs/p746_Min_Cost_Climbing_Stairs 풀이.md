# 문제 
~~~text
당신에게 정수 배열 cost가 주어집니다. 
여기서 cost[i]는 계단의 i번째 칸을 밟을 때 드는 비용을 의미합니다.
비용을 지불하면 한 번에 1칸 또는 2칸을 오를 수 있습니다.

당신은 인덱스 0번 또는 인덱스 1번에서 시작할 수 있습니다.

층의 꼭대기까지 도달하는 데 드는 최소 비용을 반환하세요.
~~~


# 분석 
1. 미지 : 꼭대기까지 도달하는데 최소비용 
2. 자료 : 계단을 밟을 떄 드는 비용 리스트 cost[i]
3. 조건 : 
- 비용을 지불하면 1,2 칸을 오를 수 있습니다.
- cost.length 만큼 칸이 있습니다.
- 시작을 0번 또는 1번 인덱스에서 할 수 있습니다.


# 풀이 
1. Example 1:
~~~text
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
~~~
1. i.length로 하나 해놓고 
2. 1,2씩 뺐을떄 최소
3. 시작은 0,1 또는 음수 
   - 음수는 0
   - 0,1은 해당 cost

# 링크 
https://leetcode.com/problems/min-cost-climbing-stairs/submissions/1683727504
