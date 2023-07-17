package nz.ac.auckland.se281;

public class Player {

  private String name;
  private int fingers;
  private int sum;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getFingers() {
    return fingers;
  }

  public int getSum() {
    return sum;
  }

  public void getFingersAndSum() {
    /*
        gets the players fingers and sum while checking the the input is valid
    */
    String input;
    String[] inputArray;
    int maxFingers = 5;
    int maxSum = 10;

    do {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();

      inputArray = input.split(" ");

    } while (!this.isCorrectNumberOfInputs(inputArray)
        || !this.isValidInt(inputArray[0], maxFingers)
        || !this.isValidInt(inputArray[1], maxSum));
    this.fingers = Integer.parseInt(inputArray[0]);
    this.sum = Integer.parseInt(inputArray[1]);
  }

  public boolean isCorrectNumberOfInputs(String[] inputArray) {
    /*
        checks if the number of inputs was correct and prints an error message
        if it wasn't and also returns false.
    */
    if (inputArray.length != 2) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
    return true;
  }

  public boolean isValidInt(String input, int max) {
    /*
        checks is the inputs are within the valid range and prints an error message
        if they aren't and also returns false.
    */
    if (!Utils.isInteger(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
    int inputInt = Integer.parseInt(input);
    if (inputInt < 1 || inputInt > max) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
    return true;
  }
}
