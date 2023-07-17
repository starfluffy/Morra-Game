package nz.ac.auckland.se281;

import java.util.HashMap;

public class AverageStrategy implements Strategy {

  private int fingers;
  private int sum;
  private HashMap<Integer, Integer> playerFingerOccurences;
  private int roundNum;

  public AverageStrategy(int roundNum) {
    this.roundNum = roundNum;
  }

  @Override
  public int getFingers() {
    /*
        Gets a random number from 1 to 5 as the fingers and returns that number.
    */
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  @Override
  public int getSum() {
    /*
        Calcualtes the average of the players fingers and adds it to jarvis'
        fingers and returns that number.
    */
    int totalFingers = this.getTotalFingers(playerFingerOccurences);
    double avgDouble = (double) totalFingers / (double) (roundNum - 1);
    int avg = (int) Math.round(avgDouble);
    sum = fingers + avg;
    return sum;
  }

  private int getTotalFingers(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        Calculates the total number of fingers that the player has played in the
        previous rounds by iterating through the hashmap.
    */
    int total = 0;
    for (var fingers : playerFingerOccurences.entrySet()) {
      int finger = fingers.getKey();
      int times = fingers.getValue();
      total += finger * times;
    }
    return total;
  }

  public void setPlayerFingerOccurences(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        Gets the hashmap of player finger occurneces from Morra.
    */
    this.playerFingerOccurences = playerFingerOccurences;
  }
}
