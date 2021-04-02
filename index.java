import java.util.Scanner;

public class index {
      public static void main(String args[])
      {
          //Creates town, prints First Generation
          int[][] arr = new int[10][10];
          createTown(arr);
          System.out.println("\n\nYour first town: \n");
          printTown(arr);

          //Gets amount of generations from user
          Scanner scan = new Scanner(System.in);
          System.out.print("\nHow many Generations will the town go through?: ");
          String input = scan.next();

          System.out.print("\n");




      }

      //Description: Simple void method that defines the 2D array arr
      //Params: 2D array representing town
      //Returns: void
      public static void createTown(int[][] arr)
      {
        for(int x = 0; x<arr.length; x++)
        {
          for(int y = 0; y<arr[0].length; y++)
          {
            arr[x][y] = 0;
          }
        }
      }

      //Description: Simple method that prints out entire town
      //Params: 2D array representing town
      //Returns: void
      public static void printTown(int arr[][])
      {
        for(int x = 0; x<arr.length; x++)
        {
          for(int y = 0; y<arr[0].length; y++)
          {
            System.out.print(arr[x][y] + " ");
          }

            System.out.print("\n");
        }
      }
}
