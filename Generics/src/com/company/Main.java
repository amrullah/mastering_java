package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
	    BaseballPlayer pat = new BaseballPlayer("Pat");
	    SoccerPlayer beckham = new SoccerPlayer("Beckham");
	    SoccerPlayer rooney = new SoccerPlayer("Rooney");

	    Team<FootballPlayer> manchesterUnited = new Team<>("Manchester United");
	    manchesterUnited.addPlayer(joe);

		Team<BaseballPlayer> puneWarriors = new Team<>("Pune Warriors");
		puneWarriors.addPlayer(pat);

		Team<SoccerPlayer> punjabKings = new Team<>("Punjab Kings");
		punjabKings.addPlayer(beckham);

		Team<SoccerPlayer> gujaratLions = new Team<>("Gujarat Lions");
		gujaratLions.addPlayer(rooney);

		gujaratLions.matchResult(punjabKings, 3, 1);
//		gujaratLions.matchResult(manchesterUnited, 3, 5);  // won't be allowed due to presence of type parameter

        System.out.println(manchesterUnited.numPlayers());

        ArrayList<Team<SoccerPlayer>> teams = new ArrayList<>();
//        teams.add(manchesterUnited);
//        teams.add(puneWarriors);
        teams.add(punjabKings);
        teams.add(gujaratLions);
        printRankings(teams);
    }

    private static void printRankings(List<Team<SoccerPlayer>> teams) {
		System.out.println("\nTeam rankings:");
		Collections.sort(teams);
    	for (Team<SoccerPlayer> team : teams) {
			System.out.printf("%1$s : %2$s\n", team, team.ranking());
		}
	}
}
