package algorithm.leetCode_1.P8_Binary_Search.p1_on_arrays.example.p2300_Successful_Pairs_of_Spells_and_Potions;

public class p2300_Successful_Pairs_of_Spells_and_Potions {

  public static void main(String[] args) {
    p2300_Successful_Pairs_of_Spells_and_Potions solver = new p2300_Successful_Pairs_of_Spells_and_Potions();
    int[] spells = {5, 1, 3};
    int[] potions = {1, 2, 3, 4, 5};
    int success = 7; //[4,0,3]

//    int[] spells = {3,1,2};
//    int[] potions = {8,5,8};
//    int success = 16; // 2,0,2

    System.out.println(solver.successfulPairs(spells, potions, success));
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    return new int[2];
  }

}
