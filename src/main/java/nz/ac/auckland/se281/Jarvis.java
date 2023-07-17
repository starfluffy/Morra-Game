package nz.ac.auckland.se281;

public abstract class Jarvis {

  protected Strategy strategy;

  public Jarvis(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    /*
       sets the strategy to use.
    */
    this.strategy = strategy;
  }

  public int playFingers() {
    /*
        calls the function of the current strategy to get the number of fingers to play.
    */
    return strategy.getFingers();
  }

  public int playSum() {
    /*
        calls the function of the current strategy to get the sum.
    */
    return strategy.getSum();
  }
}
