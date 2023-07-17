package nz.ac.auckland.se281;

import java.util.HashMap;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundNum;
  private Player player;
  private int playerFingers;
  private int playerSum;
  private Jarvis jarvis;
  private int jarvisFingers;
  private int jarvisSum;
  private int fingersSum;
  private HashMap<Integer, Integer> playerFingerOccurences;
  private boolean gameStarted;
  private int playerPoints;
  private int jarvisPoints;
  private int pointsToWin;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    /*
        Starts a new game and initialises all the variables. Also welcomes the player.
    */
    jarvis = JarvisFactory.createJarvis(difficulty);
    playerPoints = 0;
    jarvisPoints = 0;
    this.pointsToWin = pointsToWin;
    gameStarted = true;
    playerFingerOccurences = new HashMap<>();
    roundNum = 0;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = new Player(options[0]);
  }

  public void play() {
    /*
        Plays a round of Morra. It gets the fingers and sum of the player and the AI,
        then prints the outcome of the round. It also adds the fingers of the
        player to the HashMap of the playerFingerOccurences.

        Also checks if the game has started.
    */
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    roundNum++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNum));

    if (jarvis instanceof HarderJarvis) {
      ((HarderJarvis) jarvis).changeStrategy(roundNum);
      ((HarderJarvis) jarvis).passPlayerFingers(playerFingerOccurences);
    }

    player.getFingersAndSum();
    playerFingers = player.getFingers();
    playerSum = player.getSum();

    jarvisFingers = jarvis.playFingers();
    jarvisSum = jarvis.playSum();

    this.printInfoHand();
    this.showOutcome();

    this.addPlayerFingers();

    if (playerPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage(player.getName(), Integer.toString(roundNum));
      gameStarted = false;
    }

    if (jarvisPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(roundNum));
      gameStarted = false;
    }
  }

  public void addPlayerFingers() {
    /*
        Adds the fingers of the player to the HashMap of the playerFingerOccurences.
    */
    if (!(playerFingerOccurences.containsKey(playerFingers))) {
      playerFingerOccurences.put(playerFingers, 1);
      return;
    }
    playerFingerOccurences.put(playerFingers, playerFingerOccurences.get(playerFingers) + 1);
  }

  public void showStats() {
    /*
        Prints the stats of the current game. Also checks if the game has started.
    */
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player.getName(),
        Integer.toString(playerPoints),
        Integer.toString(pointsToWin - playerPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", Integer.toString(jarvisPoints), Integer.toString(pointsToWin - jarvisPoints));
  }

  public void printInfoHand() {
    /*
        Prints the info of the hand of the player and the AI.
    */
    MessageCli.PRINT_INFO_HAND.printMessage(
        player.getName(), Integer.toString(playerFingers), Integer.toString(playerSum));
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(jarvisFingers), Integer.toString(jarvisSum));
  }

  public void showOutcome() {
    /*
        Prints the outcome of the round (i.e. who won the round)
    */
    String outcome = getOutcome();
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(outcome);
  }

  public String getOutcome() {
    /*
        Returns the outcome of the round (i.e. who won the round).
        Also increments the player's and Jarvis' points accordingly.
    */
    fingersSum = playerFingers + jarvisFingers;
    if (fingersSum == playerSum && fingersSum != jarvisSum) {
      playerPoints++;
      return "HUMAN_WINS";
    } else if (fingersSum == jarvisSum && fingersSum != playerSum) {
      jarvisPoints++;
      return "AI_WINS";
    }
    return "DRAW";
  }
}
