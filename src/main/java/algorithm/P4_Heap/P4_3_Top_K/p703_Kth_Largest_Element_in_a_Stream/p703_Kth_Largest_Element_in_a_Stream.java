package algorithm.P4_Heap.P4_3_Top_K.p703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

public class p703_Kth_Largest_Element_in_a_Stream {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {0};

        p703_Kth_Largest_Element_in_a_Stream kkkk = new p703_Kth_Largest_Element_in_a_Stream(k, nums);

        System.out.println(kkkk.add(-1));
        System.out.println(kkkk.add(1));
        System.out.println(kkkk.add(-2));
        System.out.println(kkkk.add(-4));
        System.out.println(kkkk.add(3));
    }

    private PriorityQueue<Integer> heap;
    int k;

    public p703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        this.k =k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.remove();
            }
        }
    }

    public int add(int val) {
        heap.add(val);
        if(heap.size() > k){
            heap.remove();
        }

        return heap.peek();
    }
}
