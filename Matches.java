

class  Matches {
    String id;
    String season;
    String city;
    String 	date;
    String 	team1;
    String 	team2;
    String 	toss_winner;
    String 	toss_decision;
    String 	result;
    String 	dl_applied;
    String 	winner;
    String 	win_by_runs;
    String 	win_by_wickets;
    String 	player_of_match;
    String 	venue;

    @Override
    public String toString() {
        return "Matches{" +
                "id='" + id + '\'' +
                ", season='" + season + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", toss_winner='" + toss_winner + '\'' +
                ", toss_decision='" + toss_decision + '\'' +
                ", result='" + result + '\'' +
                ", dl_applied='" + dl_applied + '\'' +
                ", winner='" + winner + '\'' +
                ", win_by_runs='" + win_by_runs + '\'' +
                ", win_by_wickets='" + win_by_wickets + '\'' +
                ", player_of_match='" + player_of_match + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }

    public Matches() {

    }

    public Matches(String id, String season, String city, String date, String team1, String team2, String toss_winner, String toss_decision, String result, String dl_applied, String winner, String win_by_runs, String win_by_wickets, String player_of_match, String venue) {
        this.id = id;
        this.season = season;
        this.city = city;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.toss_winner = toss_winner;
        this.toss_decision = toss_decision;
        this.result = result;
        this.dl_applied = dl_applied;
        this.winner = winner;
        this.win_by_runs = win_by_runs;
        this.win_by_wickets = win_by_wickets;
        this.player_of_match = player_of_match;
        this.venue = venue;
    }
}
