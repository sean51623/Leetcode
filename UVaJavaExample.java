// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"
/*
Java Specifications:
The Java programs submitted must be in a single source code (not .class) file. Nevertheless, you can add as many classes as you need in this file. All the classes in this file must not be within any package.

All programs must begin in a static main method in a Main class.

Do not use public classes: even Main must be non public to avoid compile error.

Use buffered I/O to avoid time limit exceeded due to excesive flushing.
*/
import java.io.*;
import java.util.*;

class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, min, max, num, n, cycle, cyclemax;

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          if (a < b) { min=a; max=b; } else { min=b; max=a; }
          for (cyclemax=-1, num=min; num<=max; num++) {
            for (n=num, cycle=1; n != 1; cycle++) if ((n % 2) != 0) n=3*n+1; else n >>= 1;
            if (cycle > cyclemax) cyclemax=cycle;
            }
          System.out.println (a + " " + b + " " + cyclemax);
        }
    }
}