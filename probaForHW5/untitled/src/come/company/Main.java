package come.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        Instruments n = new Instruments();
        n.addToList();
        System.out.println(n.deals);
         // n.seeOne();
         // n.dealsOnThisDay();
         // n.dealsOnThisWeak();
        n.changeDealls();
        System.out.println(n.deals);

    }
}