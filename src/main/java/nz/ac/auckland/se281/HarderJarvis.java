package nz.ac.auckland.se281;

import java.util.HashMap;

public interface HarderJarvis {
  /*
      interface for the AI's harder than easy
  */
  void changeStrategy(int roundNum);

  void passPlayerFingers(HashMap<Integer, Integer> playerFingerOccurences);
}
