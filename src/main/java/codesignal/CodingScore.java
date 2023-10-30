package codesignal;

import java.util.*;

/*
The marketing team at CodeSignal would like to know how many users there are in each Coding Score range, so that they can share that information on our website. They've asked you to create a report containing that information.

Your Mission

As input, you are given a list of scores. Coding Score can be anywhere between 300 and 850. For the purpose of this task, levels are defined in the following way:

Poor: 300-599
Fair: 600-699
Good: 700-749
Excellent: 750-799
Elite: 800+

Calculate how many users are there in each level, then return a list of strings where each string represents a level and a number of users within that level, formatted like LevelName - Number. The levels should be sorted in decreasing order of those numbers, omitting any levels that have no users. In case of a tie, the higher level should appear first.

For example, if you had this input...

  [330, 723, 730, 825]

then you should return the following:

[
  'Good - 2',
  'Elite - 1',
  'Poor - 1'
] */

public class CodingScore {


    static class ScoreLevel{
        String level;
        Integer value;
        ScoreLevel(String level, Integer value){
            this.level = level;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] scores = {330, 723, 730, 825};
        Map<String,Integer> levelCount = new HashMap<>();
        List<ScoreLevel> finalCount = new ArrayList<>();


        for(int score: scores){
            String level = getLevel(score);
            levelCount.put(level,levelCount.getOrDefault(level,0)+1);
        }

        levelCount.forEach((k,v)->finalCount.add(new ScoreLevel(k,v)));
        finalCount.sort((e1,e2)->e2.value.compareTo(e1.value));

        String[] result = new String[finalCount.size()];

        int i=0;
        for(ScoreLevel scoreLevel: finalCount){
            result[i++] = scoreLevel.level + " - " +scoreLevel.value;
        }

        System.out.println(Arrays.toString(result));

    }

    private static String getLevel(int score) { // int[] scores = {330, 723, 730, 825};
        if (score >= 800) {
            return "Elite";
        } else if (score >= 750) {
            return "Excellent";
        } else if (score >= 700) {
            return "Good";
        } else if (score >= 600) {
            return "Fair";
        } else if (score >= 300) {
            return "Poor";
        }else return "None";
    }

}
