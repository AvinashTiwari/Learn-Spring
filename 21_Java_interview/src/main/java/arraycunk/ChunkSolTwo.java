package arraycunk;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkSolTwo {
    public static void main(String[] args) {
        List<Integer> numbers
                = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> lists = Lists.partition(new ArrayList<>(numbers), 3);
        for (List<Integer> sublist: lists)
            System.out.println(sublist);
    }
}

