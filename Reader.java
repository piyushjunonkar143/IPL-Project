import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class  Reader {
    static Deliveries d;
    static Matches m;
    static List deliveries;
    static List matches;
    static {
        addData();
    }
    public static void main(String[] args) {
       Reader r = new Reader();

        }
        public static void addData(){
            String line = "";
            d = new Deliveries();
            m = new Matches();
            deliveries = new LinkedList();
            matches = new LinkedList();
            try
            {
                BufferedReader br = new BufferedReader(new FileReader("IPL-Project/deliveries.csv"));
                while ((line = br.readLine()) != null )
                {
                    int count = 0;
                    String[] d1 = line.split(",");
                    d.match_id = d1[count++];
                    d.inning = d1[count++];
                    d.batting_team = d1[count++];
                    d.bowling_team = d1[count++];
                    d.over = d1[count++];
                    d.ball = d1[count++];
                    d.batsman = d1[count++];
                    d.non_striker = d1[count++];
                    d.bowler = d1[count++];
                    d.is_super_over = d1[count++];
                    d.wide_runs = d1[count++];
                    d.bye_runs = d1[count++];
                    d.legbye_runs = d1[count++];
                    d.noball_runs = d1[count++];
                    d.penalty_runs = d1[count++];
                    d.batsman_runs = d1[count++];
                    d.extra_runs = d1[count++];
                    d.total_runs = d1[count++];
                    deliveries.add(d);
                }
                BufferedReader br1 = new BufferedReader(new FileReader("IPL-Project/matches.csv"));
                while ((line = br1.readLine()) != null ) {
                    int count = 0;
                    String[] m1 = line.split(",");
                    m.id = m1[count++];
                    m.season = m1[count++];
                    m.city = m1[count++];
                    m.date = m1[count++];
                    m.team1 = m1[count++];
                    m.team2 = m1[count++];
                    m.toss_winner = m1[count++];
                    m.toss_decision = m1[count++];
                    m.result = m1[count++];
                    m.dl_applied = m1[count++];
                    m.winner = m1[count++];
                    m.win_by_runs = m1[count++];
                    m.win_by_wickets = m1[count++];
                    m.player_of_match = m1[count++];
                    m.venue = m1[count++];
                    matches.add(m);

                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
