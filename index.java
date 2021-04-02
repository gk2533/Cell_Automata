import java.util.Scanner;

public class index {
      public static void main(String args[])
      {
          //Creates town, prints First Generation
          int[][] arr = new int[5][5];
          createTown(arr);
          System.out.println("\n\nYour first town: \n");
          printTown(arr);

          //Gets amount of generations from user
          Scanner scan = new Scanner(System.in);
          System.out.print("\nHow many Generations will the town go through?: ");
          String generations = scan.next();
          System.out.print("\n");

          arr = age(arr);

          System.out.print("New Town: \n");
          printTown(arr);
      }

      public static int[][] age(int[][] arr)
      {
        int[][] newTown = new int[arr.length][arr[0].length];
        createTown(newTown);

        //calculate neighbors
        int adults = 0;
        int neighbors = 0;
        for(int a = 0; a<arr.length; a++)
        {
          for(int b = 0; b<arr.length; b++)
          {
            for(int c = a-1; c<a+2; c++)
            {
              for(int d = b-1; d<b+2; d++)
              {
                if(c==-1 || c==arr.length || d==-1 || d==arr[0].length)
                {
                    continue;
                }else{
                  if(c==a || d==b)
                  {
                      continue;
                  }

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
            //-----------------------------------
            //EMPTY CELLS (val = 0)

            if(arr[a][b]==0 && adults==2)
            {
              newTown[a][b] = 1;
            }

            //newborn cells (val = 1)
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
            //adult cells (val = 2)
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

            //senior cells (val = 3)
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

        arr[0][2] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[2][1] = 2;
        arr[2][2] = 2;
        arr[2][3] = 1;
        arr[3][3] = 1;
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
