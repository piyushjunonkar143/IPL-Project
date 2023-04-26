import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class  Reader {
    Deliveries d;
    Matches m;
    List<Deliveries> deliveries;
    List<Matches> matches;

    public static void main(String[] args) {
        Reader r = new Reader();
        r.addData();                                      //method for reading the data from both csv files
        Scanner sc = new Scanner(System.in);
        for (; ; )                                        // Infinite loop running so that we can access all the scenario at once
        {
            System.out.println("\n" +
                    "    1. Number of matches played per year of all the years in IPL.\n" +
                    "    2. Number of matches won of all teams over all the years of IPL.\n" +
                    "    3. For the year 2016 get the extra runs conceded per team.\n" +
                    "    4. For the year 2015 get the top economical bowlers.\n" +
                    "    5. Total runs scored by each players in IPL .\n" +
                    "    6. Exit. \n");


            switch (sc.nextInt()) {
                case 1:
                    r.scenario1();
                    break;

                case 2:
                    r.scenario2();
                    break;

                case 3:
                    r.scenario3();
                    break;

                case 4:
                    r.scenario4();
                    break;

                case 5:
                    r.scenario5();
                    break;

                case 6:
                    System.exit(0);                   // whole program will be stopped
                    break;

                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }

    public void addData() {

        String line = "";
        d = new Deliveries();                             // Object created for Deliveries class
        m = new Matches();                                // Object created for Matches class
        deliveries = new ArrayList();
        matches = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("IPL-Project/deliveries.csv"));       // This will read the deliveries.csv file
            while ((line = br.readLine()) != null) {
                int count = 0;
                String[] d1 = line.split(",");
                Deliveries d2 = new Deliveries(d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++]);
                deliveries.add(d2);                       // adding each rows to deliveries list so that it will be easily accessible
            }
            BufferedReader br1 = new BufferedReader(new FileReader("IPL-Project/matches.csv"));  // this will read the matches.csv file
            while ((line = br1.readLine()) != null) {
                int count = 0;
                String[] m1 = line.split(",");      // it will split each data from a row
                Matches m2 = new Matches(m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++]);
                matches.add(m2);                          // adding each rows to matches list so that it will be easily accessible
            }
        }catch (IOException e) {
            System.out.println("something wrong happened while reading the files/ taking the input");
            e.printStackTrace();
         }
    }
    public void scenario1() {
        TreeMap<String , Integer> hm = new TreeMap<String, Integer>();  //this will store the year and no. of matches data
        Matches m2 = (Matches) matches.get(1); // object type data is down casted to Matches type class
        int i = 2, count = 2;
        while (i < matches.size()) {
            String sea = m2.season;
            m2 = (Matches) matches.get(i++);
            if (m2.season.equals(sea)) {
                hm.put(m2.season, count++);
            } else {
                count = 2;
            }
        }
        System.err.println("Number of matches played per year of all the years in IPL are : ");
        System.out.println(hm);

    }

    public void scenario2() {
        //2. Number of matches won of all teams over all the years of IPL.
        TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
        Matches m2 = (Matches) matches.get(1);
        int i = 1;
        while (i < matches.size()) {
            int c = 0;
            m2 = (Matches) matches.get(i++);
            String w = m2.winner;
            if(w.equals(""))
            {
                continue;
            }
            if (hm.containsKey(w)) {
                c = (int) hm.get(w);
            }
            hm.put(w, ++c);
        }
        System.out.println("Number of matches won of all teams over all the years of IPL.");
        System.out.println(hm);
    }

    public void scenario3() {
        //3. For the year 2016 get the extra runs conceded per team.
        TreeMap hm = new TreeMap<>();
        Integer m_id = 0, count = 0, index = 0;
        String w = "";
        int i = 2;
        while (i < matches.size()) {
            Matches m2 = (Matches) matches.get(i++);
            int j = 1;

            if (m2.season.equals("2016")) {
                m_id = Integer.parseInt(m2.id);

                while (j < deliveries.size()) {
                    Deliveries d2 = (Deliveries) deliveries.get(j++);
                    w = d2.batting_team;

                    if (d2.match_id.equals(m2.id)) {

                        if (hm.containsKey(w) && d2.extra_runs != null) {
                            count = (int) hm.get(w) + Integer.parseInt(d2.extra_runs);
                        } else {
                            count = 0;
                        }

                        hm.put(w, count);
                    }
                }
            }
        }
        System.err.println("For the year 2016 get the extra runs conceded per team are :.");
        System.out.println(hm);
    }


    public void scenario4() {
        //4. For the year 2015 get the top economical bowlers.
        TreeMap hm = new TreeMap();
        TreeMap hm2 = new TreeMap();
        TreeMap hm3 = new TreeMap();
        Integer m_id = 0, count = 0, bowl=0;
        String w = "";
        int i = 1;

        while (i < matches.size()) {

            Matches m2 = (Matches) matches.get(i++);
            int j = 0;
            if (m2.season.equals("2015")) {

                m_id = Integer.parseInt(m2.id);
                while (j < deliveries.size()) {

                    Deliveries d2 = (Deliveries) deliveries.get(j++);
                    w = d2.bowler;
                    if (d2.match_id.equals(m2.id)) {

                        if (hm.containsKey(w)) {

                            count = (int) hm.get(w) + Integer.parseInt(d2.total_runs);
                            bowl = (int) hm2.get(w) + 1;
                        } else {
                            count = 0;
                            bowl =1;
                        }

                        hm.put(w, count);
                        hm2.put(w, bowl);
                        double b = count / (bowl / 6.0);
                        hm3.put(w,b);
                    }
                }
            }
        }
        double min = 100;
        Object minkey = null;
        for(Object a : hm3.keySet())
        {
            double value = (double) hm3.get(a);
            if(value<min)
            {
                min = value;
                minkey = a;
            }
        }
        System.err.println("Most Economical bowler is : ");
        System.out.println(minkey + " with economy rate " + min);
    }
    public void scenario5()
    {
    // Total runs scored by each players in IPL
        TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
        Integer score = 0;
        for(int i = 1; i<deliveries.size(); i++)
        {
            Deliveries d2 = (Deliveries) deliveries.get(i);
            String b = d2.batsman;
            if(hm.containsKey(b))
            {
                score = Integer.parseInt(d2.total_runs) + hm.get(b) ;
            }
            else
            {
                score = Integer.parseInt(d2.total_runs);
            }
            hm.put(b, score);
        }
        System.err.println("Total runs scored by each players in IPL");
        System.out.println(hm);
    }
    }
