package arraycunk;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

public class ChunkSolThree {
    public static void main(String[] args) {
        Chunk();
    }

    public static void Chunk(){
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = ListUtils.partition(intList, 3);
        for (List<Integer> sublist: subSets)
            System.out.println(sublist);
    }
    }

