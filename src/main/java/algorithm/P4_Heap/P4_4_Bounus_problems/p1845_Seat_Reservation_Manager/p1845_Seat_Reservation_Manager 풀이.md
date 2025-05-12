# 문제 
~~~text
좌석 예약 상태를 관리하는 시스템을 설계하세요. 
좌석은 1번부터 n번까지 번호가 매겨져 있습니다.

다음과 같이 SeatManager 클래스를 구현하세요:
	•	SeatManager(int n) : 번호가 1부터 n까지 매겨진 n개의 좌석을 관리하는 SeatManager 객체를 초기화합니다. 모든 좌석은 처음에 예약되지 않은 상태입니다.
	•	int reserve() : 가장 번호가 작은 예약되지 않은 좌석을 찾아 예약하고, 해당 좌석 번호를 반환합니다.
	•	void unreserve(int seatNumber) : 주어진 seatNumber에 해당하는 좌석의 예약을 취소합니다.
~~~

## 문제 분석 
1. 미지 : 예약 상태 관리 : 취소, 예약 
2. 자료 : n -> n개의 좌석, 
3. 조건 : 
- reverse -> 가장 번호가 작은, 예약되지 않은 
- unreserve -> 좌석의 예약을 취소합니다.
- 아마 예약 상태 기록하는 배열이 있을듯

## 문제 풀이 
### 1. Example
~~~text
Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
~~~


## 링크
https://leetcode.com/problems/seat-reservation-manager/submissions/1631749788