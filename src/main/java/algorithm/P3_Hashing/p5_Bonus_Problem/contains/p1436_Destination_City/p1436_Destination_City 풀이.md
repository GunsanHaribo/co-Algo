# 문제
~~~text
배열 paths가 주어집니다. 여기서 paths[i] = [cityAi, cityBi]는 cityAi에서 cityBi로 가는 직행 경로가 존재함을 의미합니다.

**목적지 도시(destination city)**를 반환하세요. 목적지 도시는 다른 도시로 나가는 경로가 하나도 없는 도시입니다.

경로로 이루어진 그래프는 하나의 직선(line) 형태이며, 루프는 존재하지 않음이 보장되므로, 목적지 도시는 정확히 하나만 존재합니다.
~~~

## 문제 분석
1. 미지 : 목적지 도시 : 나가는 경로가 하나도 없는 도시
2. 자료 : 이중 리스트 - start -> end
3. 조건 :
- 경로는 일직선, 루프는 없다 : 목적지 도시는 정확히 하나만 존재

## 문제 풀이

### 1. Example
~~~text
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
~~~

1.  end에는 있는데, start에는 없는 놈 반환

## 링크 

https://leetcode.com/problems/destination-city/submissions/1627420214