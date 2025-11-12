package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.t2025_11_04_Failed;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

  public static void main(String[] args) {
    p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown solver = new p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
    int[] prices = {1, 2, 3, 0, 2};

    System.out.println(solver.maxProfit(prices));
  }

  // 애도 구매 판매 2가지 경우가 있을 것 같은데
  // 판매 후에 쿨다운이 새롭긴하네
  public int maxProfit(int[] prices) {
    int pricesSize = prices.length;
    List<List<State>> memos = new ArrayList<>();

    memos.add(List.of(
        new State(0, prices[0], true, false),
        new State(0, 0, false, false)
    ));
    for (int i = 1; i < pricesSize; i++) {
      List<State> states = memos.get(i - 1);
      PriorityQueue<State> temp = new PriorityQueue<>((v1, v2) -> v2.earn - v1.earn);
      for (State state : states) {
        if (state.isSelling) {
          continue;
        }
        // 사거나, 안사거나
        if (state.havingStock) {
          // 팔고 사야함, 아니 팔고 바로 못사네
          // 아니아니 한 요일에 하나빡에 못하는데
          // 판매
          temp.add(new State(state.earn + state.havingStockPrices - prices[i], 0, false, true));
        } else {
          // 구매
          temp.add(new State(state.earn, prices[i], true, false));
        }
        temp.add(state);
      }
      // 최대만 뽑아서 남기기
      State poll = temp.poll();
      int max = poll.earn;
      List<State> row = new ArrayList<>();
      row.add(poll);
      for (State maxCandidate : temp) {
        if (max > maxCandidate.earn) {
          break;
        }
        row.add(maxCandidate);
      }
      memos.add(row);
    }

    return memos.get(pricesSize - 1).get(0).earn;
  }

  // 이전 값을 보고
  private record State(int earn, int havingStockPrices, boolean havingStock, boolean isSelling) {

  }

}
