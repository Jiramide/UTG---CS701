package com.company;

import java.util.Scanner;
import java.util.Set;
import java.lang.Math;

public class Main {

  public static void main(String[] args) {

      System.out.println("Proper String");
      Scanner in = new Scanner(System.in);
      int iter = in.nextInt();

      for (; iter > 0; iter--) {
        System.out.println(
          ParenthesizedString.IsProper(in.next())
            ? "Yes"
            : "No"
        );
      }

      System.out.println("Longest Alimentary Chain");
      int creatures;
      int relations;

      while ((creatures = in.nextInt()) != 0 & (relations = in.nextInt()) != 0) {
        DisjointSet<String> creatureChain = new DisjointSet<>(creatures);

        for (; creatures > 0; creatures--) {
          creatureChain.add(in.next());
        }

        for (; relations > 0 ; relations--) {
          creatureChain.union(in.next(), in.next());
        }

        int biggestChain = 0;

        for (Set<String> chain : creatureChain.sets()) {
          biggestChain = Math.max(biggestChain, chain.size());
        }

        System.out.println(biggestChain);
      }

      System.out.println("Maximal Connected Subgraph");
      int cases = in.nextInt();

      for (; cases > 0; cases--) {
        DisjointSet<Character> graph = new DisjointSet<>();
        char max = in.next().charAt(0);

        for (char curr = 'A'; curr <= max; curr++) {
          graph.add(curr);
        }

        in.nextLine();

        String rel = in.nextLine();
        while (!rel.trim().isEmpty()) {
          graph.union(rel.charAt(0), rel.charAt(1));
          rel = in.nextLine();
        }

        System.out.println(graph.numSets());
      }

  }

}
