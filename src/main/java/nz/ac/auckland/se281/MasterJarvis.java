package nz.ac.auckland.se281;

import java.util.HashMap;

public class MasterJarvis extends Jarvis implements HarderJarvis {

  public MasterJarvis(Strategy strategy) {
    super(strategy);
  }

  public void changeStrategy(int roundNum) {
    /*
        checks what round the game is on and changes the strategy to the
        average strategy if the round is more than 3 and even and changes
        it to top if the round is more than 3 and odd.
    */
    if (roundNum > 3 && roundNum % 2 == 0) {
      strategy = new AverageStrategy(roundNum);
      return;
    } else if (roundNum > 3 && roundNum % 2 == 1) {
      strategy = new TopStrategy();
      return;
    }
    strategy = new RandomStrategy();
  }

  @Override
  public void passPlayerFingers(HashMap<Integer, Integer> playerFingerOccurences) {
    /*
        checks what the current strategy is and passes the playerFingerOccurences
        from Morra to the current strategy
    */
    if (strategy instanceof TopStrategy) {
      ((TopStrategy) strategy).setPlayerFingerOccurences(playerFingerOccurences);
    } else if (strategy instanceof AverageStrategy) {
      ((AverageStrategy) strategy).setPlayerFingerOccurences(playerFingerOccurences);
    }
  }
}
