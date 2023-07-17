package nz.ac.auckland.se281;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopStrategy implements Strategy {

  private int fingers;
  private int sum;
  private HashMap<Integer, Integer> fingerOccurences;

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
        Gets the element (fingers) with the biggest value (occurences) from a hashmap
        of player finger occurences,adds that to fingers and returns it.
    */
    int top = Collections.max(fingerOccurences.entrySet(), Map.Entry.comparingByValue()).getKey();
    sum = fingers + top;
    return sum;
  }

  public void setPlayerFingerOccurences(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        Gets the hashmap of player finger occurneces from Morra.
    */
    fingerOccurences = new HashMap<>(playerFingerOccurences);
  }
}
