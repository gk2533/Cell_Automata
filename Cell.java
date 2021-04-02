public class Cell
{
  int value;

  public Cell(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int newVal)
  {
    this.value = newVal;
  }

  public String toAString()
  {
    String toReturn = "" + value;
    return toReturn;
  }
}
