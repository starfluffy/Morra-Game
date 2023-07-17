package nz.ac.auckland.se281;

import java.util.HashMap;

public class HardJarvis extends Jarvis implements HarderJarvis {

  public HardJarvis(Strategy strategy) {
    super(strategy);
  }

  public void changeStrategy(int roundNum) {
    /*
        checks what round the game is on and changes the strategy to the
        top strategy if the round is more than 3
    */
    if (roundNum > 3) {
      strategy = new TopStrategy();
      return;
    }
    strategy = new RandomStrategy();
  }

  @Override
  public void passPlayerFingers(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        passes the playerFingerOccurences from Morra to the strategy
    */
    if (strategy instanceof TopStrategy) {
      ((TopStrategy) strategy).setPlayerFingerOccurences(playerFingerOccurences);
    }
  }
}
