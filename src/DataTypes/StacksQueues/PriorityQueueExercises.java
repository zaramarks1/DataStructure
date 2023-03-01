package DataTypes.StacksQueues;

import java.util.*;

public class PriorityQueueExercises {

    // TODO 692. Top K Frequent Words MEDIUM
    // https://leetcode.com/problems/top-k-frequent-words/description/
    // Runtime 5 ms Beats 99.88%
    // Memory 43 MB Beats 20.90%

    public List<String> topKFrequent(String[] words, int k) {

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());

        Map<String, Integer> map = new HashMap<>();

        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(entry);

        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty() && k-- > 0 ){
            res.add(pq.poll().getKey());
        }

        return res;
    }

    // TODO 1046. Last Stone Weight EASY
    // https://leetcode.com/problems/last-stone-weight/?envType=study-plan&id=level-1
    // Runtime 1 ms Beats 98%
    // Memory 40.3 MB Beats 22.65%

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);

        for(int s : stones) pq.offer(s);

        while(pq.size() > 1){
            pq.offer(pq.poll() - pq.poll());
        }

        if (!pq.isEmpty())return pq.poll();

        return 0;

    }
}
