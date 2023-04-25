import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class  Reader {
    Deliveries d;
    Matches m;
    List deliveries;
    List matches;
    public static void main(String[] args) {
        Reader r = new Reader();
        r.addData();
        Scanner sc = new Scanner(System.in);
        //System.out.println();
        for(;;)
        {
        System.out.println("\n" +
                "    1. Number of matches played per year of all the years in IPL.\n" +
                "    2. Number of matches won of all teams over all the years of IPL.\n" +
                "    3. For the year 2016 get the extra runs conceded per team.\n" +
                "    4. For the year 2015 get the top economical bowlers.\n" +
                "    5. Create your own scenario.\n" +
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
                System.exit(0);
                break;

            default:
                System.out.println("Enter correct option");
                break;
        }
        }
    }
        public  void addData(){

            String line = "";
            d = new Deliveries();
            m = new Matches();
            deliveries = new LinkedList();
            matches = new ArrayList();
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("IPL-Project/deliveries.csv"));
                while ((line = br.readLine()) != null )
                {
                    int count = 0;
                    String[] d1 = line.split(",");
//                    d.match_id = d1[count++];
//                    d.inning = d1[count++];
//                    d.batting_team = d1[count++];
//                    d.bowling_team = d1[count++];
//                    d.over = d1[count++];
//                    d.ball = d1[count++];
//                    d.batsman = d1[count++];
//                    d.non_striker = d1[count++];
//                    d.bowler = d1[count++];
//                    d.is_super_over = d1[count++];
//                    d.wide_runs = d1[count++];
//                    d.bye_runs = d1[count++];
//                    d.legbye_runs = d1[count++];
//                    d.noball_runs = d1[count++];
//                    d.penalty_runs = d1[count++];
//                    d.batsman_runs = d1[count++];
//                    d.extra_runs = d1[count++];
//                    d.total_runs = d1[count++];
                    Deliveries d2 = new Deliveries(d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++],d1[count++]);
                    deliveries.add(d2);
                  //  System.out.println(d2);
                }
                //System.out.println(deliveries.get(100000));
                BufferedReader br1 = new BufferedReader(new FileReader("IPL-Project/matches.csv"));
                while ((line = br1.readLine()) != null ) {
                    int count = 0;
                    String[] m1 = line.split(",");
//                    m.id = m1[count++];
//                    //System.out.println(m.id);
//                    m.season = m1[count++];
//                    m.city = m1[count++];
//                    m.date = m1[count++];
//                    m.team1 = m1[count++];
//                    m.team2 = m1[count++];
//                    m.toss_winner = m1[count++];
//                    m.toss_decision = m1[count++];
//                    m.result = m1[count++];
//                    m.dl_applied = m1[count++];
//                    m.winner = m1[count++];
//                    m.win_by_runs = m1[count++];
//                    m.win_by_wickets = m1[count++];
//                    m.player_of_match = m1[count++];
//                    m.venue = m1[count++];
                    Matches m2 = new Matches(m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++],m1[count++]);
                    matches.add(m2);
                   // System.out.println(m);
                }
                System.out.println(matches.get(0));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        public void scenario1()
        {
            TreeMap hm = new TreeMap();
            Matches m2 = (Matches) matches.get(1);
            int i = 2, count = 2;
            while(i<matches.size())
            {
                String sea = m2.season;
                m2 = (Matches) matches.get(i++);

                if(m2.season.equals(sea)) {
                    hm.put(m2.season, count++);
                }
                else
                    count = 2;
            }
            System.err.println("Number of matches played per year of all the years in IPL are : ");
            System.out.println(hm);

        }

    public void scenario2()
    {
        TreeMap hm = new TreeMap();
        Matches m2 = (Matches) matches.get(1);
        int i = 2, c=0,count = 2;
        while(i<matches.size())
        {
            String sea = m2.winner;
            m2 = (Matches) matches.get(i++);
            String w = m2.winner;
            if (hm.containsKey(w))
            c = (int) hm.get(w);
//            if(m2.winner.equals(sea)) {
                hm.put(w, ++c);
//            }
//            else
//                count = 2;
        }
        System.out.println(hm);
    }

    public void scenario3()
    {

    }

    public void scenario4()
    {

    }

    public void scenario5()
    {

    }
    }
