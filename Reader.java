import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class  Reader {
    public static void main(String[] args) {
       Reader r = new Reader();
        String line = "";
        Deliveries d = new Deliveries();
        Matches m = new Matches();
        List deliveries = new LinkedList();
        List matches = new LinkedList();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/home/piyushjunonkar/Java/IPL Project/IPL-Project/Deliveries.java"));
            while ((line = br.readLine()) != null && !(line.equals("")))
            {
                int count = 0;
                System.out.println(line);
                String[] d1 = line.split(",");

                System.out.println(Arrays.toString(d1) + "  -   " +count);
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

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(deliveries);
        }

    }
