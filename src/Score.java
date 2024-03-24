public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int points) {
        score += points;
    }


}
