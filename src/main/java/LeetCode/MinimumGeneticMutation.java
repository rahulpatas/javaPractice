package LeetCode;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> validGenes = new HashSet<>();
        Set<String> geneVisited = new HashSet<>();
        Queue<String> genQueue = new LinkedList<>();

        genQueue.offer(start);
        geneVisited.add(start);
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Collections.addAll(validGenes, bank);

        int numChanges = 0;

        while (genQueue.size() > 0) {
            Queue<String> layer = genQueue;
            genQueue = new LinkedList<>();

            while (!layer.isEmpty()) {
                String currentGene = layer.poll();
                char[] chars = currentGene.toCharArray();

                for (int i = 0; i < chars.length ; i++) {
                    char org = chars[i];
                    for (char c: charSet) {

                        if (c != org) {
                            chars[i] = c;
                            String nextGene = new String(chars);

                            if (!geneVisited.contains(nextGene) && validGenes.contains(nextGene)) {

                                if (nextGene.equals(end)) {
                                    return numChanges + 1;
                                }

                                geneVisited.add(nextGene);
                                genQueue.offer(nextGene);
                            }
                        }
                    }

                    chars[i] = org;
                }
            }

            numChanges++;
        }

        return - 1;
    }
}
