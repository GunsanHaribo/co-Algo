# 문제 
~~~text
다음과 같은 내용이 주어집니다:

정수 배열 coins는 서로 다른 동전의 단위를 나타내고, 
정수 amount는 만들고자 하는 총 금액을 나타냅니다.

이 금액을 만들기 위해 필요한 가장 적은 수의 동전 개수를 반환하세요. 
만약 어떤 조합으로도 해당 금액을 만들 수 없다면, -1을 반환하세요.

각 동전은 무한히 가지고 있다고 가정할 수 있습니다.
~~~

# 분석
1. 미지 : amount를 만들기 위해 피룡한 가장 적은 동전의 개수 반환
2. 자료 : 정수배열 coins, 정수 amount 
3. 조건 :
- 어떤 조합으로도 해당 금액을 만들 수 없다면, -1 반환
- 가장 적은 수의 동전 갯수를 반환(최솟값)
- 코인 수는 무한정입니다.

# 풀이 
1. Example: 
~~~text
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
~~~

1. 남은 수로 해야되는게 맞고 음수나 0이면 종료 하거나 
2. 6, 9, 10 중 최소 갯수를 가지고 있으면 저장한다.
- 최소할떈 maxValue 조심 

# 링크
int subResult = coinChange(coins, amount - coin); -> 이부분이 이렇게 해도 될까가 있었네 

https://leetcode.com/problems/coin-change/submissions/1683756954
