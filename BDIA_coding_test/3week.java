package code;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Score[] s = new Score[5];
        s[0] = new Score("A", 70);
        s[1] = new Score("B", 30);
        s[2] = new Score("C", 50);
        s[3] = new Score("D", 60);
        s[4] = new Score("E", 20);


        Arrays.sort(s, ascending);
        System.out.println("ascending : ");
        for(int i = 0; i < s.length; i++) {
            System.out.println(s[i].name + ", "+ s[i].score);
        }


        Arrays.sort(s, descending);
        System.out.println("\n"+"descending : ");
        for(int i = 0; i < s.length; i++) {
            System.out.println(s[i].name + ", "+ s[i].score);
        }

    }
    private static class Score {
        String name;
        int score;

        Score(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    static Comparator<Score> ascending = new Comparator<Score>(){
        public int compare(Score a, Score b) {
            if(a.score > b.score) return 1;
            if(a.score < b.score) return -1;
            return 0;
        }
    };

    static Comparator<Score> descending = new Comparator<Score>(){
        public int compare(Score a, Score b) {
            if(a.score < b.score) return 1;
            if(a.score > b.score) return -1;
            return 0;
        }
    };
}
