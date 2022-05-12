package com.kodilla.snake.score;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HighScore {

    private final Score score;
    private final List<Integer> scoresList = new LinkedList<>();
    private final File savedScoresList = new File("src/main/resources/snake/scores.list");

    public HighScore(Score score) {
        this.score = score;
    }

    public void saveScoreToList() {
        if (score.getScore() >= 1) {
            scoresList.add(score.getScore());
        }
    }

    public void saveScoresToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedScoresList));
            oos.writeObject(scoresList);
            oos.close();
        } catch (Exception e) {
            System.out.println("scores file write error" + "\n" + e);
        }
    }

    public void loadScoresFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedScoresList));
            Object readList = ois.readObject();
            if (readList instanceof LinkedList) {
                scoresList.addAll((LinkedList)readList);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("scores file read error or file is empty" + "\n" + e);
        }
    }

    public void closeApplicationEvent() {
        saveScoreToList();
        saveScoresToFile();
    }

    public List<Integer> topTenScores() {
        return scoresList.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .distinct()
                .collect(Collectors.toList());
    }

    public String showTopTenScores() {
        return IntStream.range(0, topTenScores().size())
                .mapToObj(index -> index + 1 + ":    " + topTenScores().get(index))
                .collect(Collectors.joining("\n"));
    }
}