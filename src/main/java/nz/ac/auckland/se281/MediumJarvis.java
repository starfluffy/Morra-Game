package nz.ac.auckland.se281;

import java.util.HashMap;

public class MediumJarvis extends Jarvis implements HarderJarvis {

  public MediumJarvis(Strategy strategy) {
    super(strategy);
  }

  @Override
  public void changeStrategy(int roundNum) {
    /*
        checks what round the game is on and changes the strategy to the
        average strategy if the round is more than 3
    */
    if (roundNum > 3) {
      strategy = new AverageStrategy(roundNum);
      return;
    }
    strategy = new RandomStrategy();
  }

  @Override
  public void passPlayerFingers(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        passes the playerFingerOccurences from Morra to the strategy
    */
    if (strategy instanceof AverageStrategy) {
      ((AverageStrategy) strategy).setPlayerFingerOccurences(playerFingerOccurences);
    }
  }
}
