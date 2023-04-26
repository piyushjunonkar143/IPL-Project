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
        r.addData(); //method for reading the data from both csv files
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
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
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }

    public void addData() {

        String line = "";
        d = new Deliveries();
        m = new Matches();
        deliveries = new ArrayList();
        matches = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("IPL-Project/deliveries.csv"));
            while ((line = br.readLine()) != null) {
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
               Deliveries d2 = new Deliveries(d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++], d1[count++]);
                deliveries.add(d2);
                //  System.out.println(d2);
            }
            //System.out.println(deliveries.get(100000));
            BufferedReader br1 = new BufferedReader(new FileReader("IPL-Project/matches.csv"));
            while ((line = br1.readLine()) != null) {
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
                Matches m2 = new Matches(m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++], m1[count++]);
                matches.add(m2);
                // System.out.println(m);
            }
            System.out.println(matches.get(0));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scenario1() {
        TreeMap hm = new TreeMap();
        Matches m2 = (Matches) matches.get(1);
        int i = 2, count = 2;
        while (i < matches.size()) {
            String sea = m2.season;
            m2 = (Matches) matches.get(i++);

            if (m2.season.equals(sea)) {
                hm.put(m2.season, count++);
            } else
                count = 2;
        }
        System.err.println("Number of matches played per year of all the years in IPL are : ");
        System.out.println(hm);

    }

    public void scenario2() {
        //2. Number of matches won of all teams over all the years of IPL.
        TreeMap hm = new TreeMap();
        Matches m2 = (Matches) matches.get(1);
        int i = 1, count = 2;
        while (i < matches.size()) {
            int c = 0;
            String sea = m2.winner;
            m2 = (Matches) matches.get(i++);
            String w = m2.winner;
            if (hm.containsKey(w)) {
                c = (int) hm.get(w);
                //System.out.println(c);
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
                // System.out.println(m_id);
                while (j < deliveries.size()) {
                    Deliveries d2 = (Deliveries) deliveries.get(j++);
                    w = d2.batting_team;
                    if (d2.match_id.equals(m2.id)) {
                        //System.out.println("first");
                        if (hm.containsKey(w) && d2.extra_runs != null) {
                            count = (int) hm.get(w) + Integer.parseInt(d2.extra_runs);
                            //System.out.println(d2.match_id+ " - " +d2.batting_team + "  -  "+ count);
                        } else {
                            count = 0;
                        }
                        hm.put(w, count);
                    }
                }
            }
//                System.out.println(m_id + " - "+ Integer.parseInt(d2.extra_runs));
        }
        System.err.println("For the year 2016 get the extra runs conceded per team are :.");
        System.out.println(hm);
    }


    public void scenario4() {
        //4. For the year 2015 get the top economical bowlers.
        TreeMap hm = new TreeMap();
        TreeMap hm2 = new TreeMap();
        TreeMap hm3 = new TreeMap();
        Integer m_id = 0, count = 1, bowl=0;
        String w = "";
        int i = 1;
        while (i < matches.size()) {
            Matches m2 = (Matches) matches.get(i++);
            int j = 0;
            if (m2.season.equals("2015")) {
                m_id = Integer.parseInt(m2.id);
                // System.out.println(m_id);
                while (j < deliveries.size()) {
                    Deliveries d2 = (Deliveries) deliveries.get(j++);
                    w = d2.bowler;
                    if (d2.match_id.equals(m2.id)) {
                        //System.out.println("first");
                        if (hm.containsKey(w)) {
                            count = (int) hm.get(w) + Integer.parseInt(d2.total_runs);
                           // System.out.println(d2.match_id+ " - " +d2.bowler + "  -  "+ count);
                            bowl = (int) hm2.get(w) + 1;
                            System.out.println(d2.match_id+ " - " +d2.bowler + "  -  "+ bowl);
                        } else {
                            count = 1;
                            bowl =1;
                        }
                        hm.put(w, count);
                        hm2.put(w, bowl);
                        double b = bowl/6;
                        if(b>=1)
                        hm3.put(count/b,w);
                    }
                }
            }
        }
        System.err.println("Most Economical bowler is : ");
        System.out.println(hm3.firstEntry().getValue() + " with economy rate " + hm3.firstEntry().getKey());
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
        System.out.println(hm);

    }
    }
