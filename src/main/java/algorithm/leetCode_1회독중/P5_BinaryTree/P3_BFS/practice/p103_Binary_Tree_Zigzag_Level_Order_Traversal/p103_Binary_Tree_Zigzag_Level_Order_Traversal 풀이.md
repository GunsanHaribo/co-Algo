# IDE 자동완성 기능 사용하지 말기

# 분석

1. 미지(반환) : 노드 값의 지그재그 수준 순서 순회를 반환 -> 지그재그 : addFirst()[역순 출력], addLast()[];
2. 자료 : 하나의 이진 트리
3. 조건(결과는 역방향, 함수는 정방향) :
4. 미지 연산(조상 갱신, 형제 연산, 레벨의 경계) :

- 지그재그라... 어디는 앞에서 어디는 뒤에서 꺼내라 이건데
- 방향이 반대인지 판단하는 로직은 넣을 수 밖에 없을 것 같다.
- 꺼낼떄는 신경쓰지 않게하고 넣을떄 잘 넣어주는거 -> addFirst()[역순으로 정렬해서 꺼내기]

---


# 회고

1. 생각 순서

- 결과는 역순, 동작 추출은 원래순서
- 함수 추출을 역순으로 하면 헥갈림, 빨리 문제 풀려고 하는건데 너무 시간이 오래 걸려

---

1. 코드가 상당히 더럽긴한데;;;

- 처음부터 이렇게 풀것 그랬나
- 근데 이건 처음에 이렇게 풀릴지 더 좋은 방식으로 풀라고 바꾼거 잖아
- 코드가 너무 더럽긴함, 왜이렇게 더럽지, 코드가 길어지면 실수가 잦을 수 밖에 없어, 어떻게 커팅을 해야되는데

---

## 링크드 리스트와 Deque, Queue의 차이


## Comparator.reverseOrder()랑 Collection.reverse()의 차이

- 아래에서 왜 reverse Order()가 동작하지 않았지
- -> 아니 sort 썼잖아요, Collection.reverse() 쓰셔야지

```text
//        rowNodeValues = rowNodeValues.stream()
//            .sorted(Comparator.reverseOrder())
//            .toList();
```

```text
List<Integer> reversed = new ArrayList<>(rowNodeValues); // toList()는 불변이니 복사
Collections.reverse(reversed);
```

## queue 인터페이스

---

• add / offer → 삽입 (실패 시 예외 vs 특별 값 반환)
• remove / poll → 제거 (실패 시 예외 vs 특별 값 반환)
• element / peek → 조회 (실패 시 예외 vs 특별 값 반환)
---

첫번쨰 : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1759961660
개선(크게 다른건 없음) : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/1760058102

