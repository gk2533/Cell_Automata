//Gabriel Klass - ProducePay Exercise

//Task: Produce a Cellular Automata meighborhood with speicfic growth changes
//      depending on the value of neighbor cells

import java.util.Scanner;

public class index {
      public static void main(String args[])
      {
          //Creates town, prints First Generation
          int[][] arr = new int[10][10];
          createTown(arr);
          System.out.println("\n\n0th Generation Town: \n");
          printTown(arr);

          //Gets amount of generations from user
          Scanner scan = new Scanner(System.in);
          System.out.print("\nHow many Generations will the town go through?: ");
          int generations = scan.nextInt();
          System.out.print("\n");

          //Runs age() on the entire town generations times.
          for(int i=1; i<=generations; i++)
          {
            arr = age(arr);

            System.out.print("Generation " + i + " Town: \n");
            printTown(arr);

            System.out.print("\n");
          }
      }

      //Description: Ages the town one by generation bsaed upon the given ruleset
      //Params: 2D array representing town
      //Return: 2D array representing new generation of town
      public static int[][] age(int[][] arr)
      {
        //creates newTown which will be returned at the end of the method
        int[][] newTown = new int[arr.length][arr[0].length];
        createTown(newTown);

        //Sets Adults and Neighbors at 0 to use when calculating amounts
        int adults = 0;
        int neighbors = 0;

        //uses FOUR for loops. First and second are to iterate through the
        //town, the third and fourth are to iterate through the neighbor of the
        //cell at (a, b)
        for(int a = 0; a<arr.length; a++)
        {
          for(int b = 0; b<arr.length; b++)
          {
            for(int c = a-1; c<a+2; c++)
            {
              for(int d = b-1; d<b+2; d++)
              {
                //check to see if neighbor is outside the bounds of the town
                if(c==-1 || c==arr.length || d==-1 || d==arr[0].length)
                {
                    continue;
                }else{
                  //checks to see if (c, d) is the cell at (a, b) and thus not
                  //a neighbor of (a, b)
                  if(c==a && d==b)
                  {
                      continue;
                  }

                  //if adult, adult++ and neighbor++. If not an adult, then just
                  //neighbor++
                  if(arr[c][d] == 2)
                  {
                      adults++;
                      neighbors++;
                  }else if(arr[c][d] != 0)
                  {
                      neighbors++;
                  }
                }
              }
            }

            //-----------------------------------------------------
            //Now, We check each cell (a, b) to see how many neighbors and
            //adults it has, and then, based on the given ruleset, defines
            //the same cell in the newTown as either 0, 1, 2, or 3

            //EMPTY CELLS (val = 0)
            if(arr[a][b]==0 && adults==2)
            {
              newTown[a][b] = 1;
            }

            //NEWBORN CELLS (val = 1)
            if(arr[a][b]==1 && neighbors>=5)
            {
                newTown[a][b] = 0;
            }else if(arr[a][b]==1 && neighbors<=1)
            {
                newTown[a][b] = 0;
            }else if(arr[a][b]==1)
            {
                newTown[a][b] = 2;
            }
            //ADULT CELLS (val = 2)
            if(arr[a][b]==2 && neighbors>=3)
            {
                newTown[a][b] = 0;
            }else if(arr[a][b]==2 && neighbors==0)
            {
                newTown[a][b] = 0;
            }else if(arr[a][b]==2)
            {
                newTown[a][b] = 3;
            }

            //SENIOR CELLS (val = 3)
            if(arr[a][b] == 3)
            {
              newTown[a][b] = 0;
            }

            adults = 0;
            neighbors = 0;
          }
        }

        return(newTown);
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

        arr[0][2] = 2;
        arr[0][3] = 2;
        arr[1][4] = 1;

        arr[1][5] = 3;
        arr[1][6] = 1;

        arr[2][3] = 2;
        arr[2][5] = 3;
        arr[2][8] = 1;
        arr[2][9] = 3;

        arr[3][4] = 1;
        arr[3][5] = 3;
        arr[3][9] = 3;

        arr[4][1] = 2;
        arr[4][2] = 2;
        arr[4][6] = 1;
        arr[4][7] = 3;
        arr[4][8] = 1;

        arr[5][5] = 2;
        arr[5][6] = 2;

        arr[6][2] = 2;
        arr[6][4] = 2;

        arr[7][4] = 2;

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
            if(y!=arr[0].length-1)
            {
              System.out.print(arr[x][y] + " ");
            }else
            {
              System.out.print(arr[x][y]);
            }
          }

            System.out.print("\n");
        }
      }
}
