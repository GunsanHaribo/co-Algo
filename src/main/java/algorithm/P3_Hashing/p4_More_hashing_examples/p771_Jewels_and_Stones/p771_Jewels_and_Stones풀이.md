# 문제
~~~
당신은 보석(jewels)을 나타내는 문자열 jewels와, 당신이 가지고 있는 돌(stones)을 나타내는 문자열 stones를 가지고 있습니다.
stones의 각 문자는 당신이 가진 돌의 한 종류를 나타냅니다.
이제 당신이 가진 돌들 중 몇 개가 보석인지 알고 싶습니다.

문자들은 대소문자를 구분하므로, "a"는 "A"와 다른 종류의 돌로 간주됩니다
~~~
## 문제 분석
1. 미지 : 가진 돌 중 몇개가 보석인지, stone의 보석의 갯수 구하기  
2. 자료 : 문자열 jewels와 문자열 stones(내가 가진돌)
3. 조건 : 
- 문자는 대소문자 구분
- 문자열 

## 문제 풀이

1. Example
~~~text
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
~~~
1. stones을 통해 몇개 가지고 있는지 저장
2. jewels을 통해 개수 합계 

2. Example 2:
~~~text
Input: jewels = "z", stones = "ZZ"
Output: 0
~~~

~~~
sum()은 IntStream, LongStream, DoubleStream에서만 사용할 수 있습니다.
mapToInt()
map()은 사용 불가
.chars() 좋네요
~~~

## 링크

https://leetcode.com/problems/jewels-and-stones/submissions/1621548480