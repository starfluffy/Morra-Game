package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  private int fingers;
  private int sum;

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
        Gets a random number from its fingers + 1 to its fingers + 5 as the fingers
        and returns that number.
    */
    sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    return sum;
  }
}
