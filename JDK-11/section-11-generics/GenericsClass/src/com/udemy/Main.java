package com.udemy;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer bob = new SoccerPlayer("Bob");

        // note that Team's members field takes Player, and our players inherit from Player
        // generic class can now specify an object type using a diamond <>
        Team<BaseballPlayer> coloradoRockies = new Team<>("Colorado Rockies");
        // coloradoRockies.addPlayer(joe); this will now show an error
        coloradoRockies.addPlayer(pat);
        System.out.println(coloradoRockies.numPlayers());

        Team<FootballPlayer> nebraskaCornhuskers = new Team<>("Nebraska Cornhuskers");
        nebraskaCornhuskers.addPlayer(joe);
        System.out.println(nebraskaCornhuskers.numPlayers());

        // generic Team<T> accepts any objects, bounded type parameter Team<T extends Player> helps fix
        // Team<String> brokenTeam = new Team<>("Uh oh");  ->  this will no longer work
        // brokenTeam.addPlayer("no-player");  ->  valid, but breaks the (now replaced) ugly cast in addPlayer()

        Team<SoccerPlayer> nmUnited = new Team<>("New Mexico United");
        nmUnited.addPlayer(bob);

        Team<FootballPlayer> oklahomaSooners = new Team<>("Oklahoma Sooners");
        FootballPlayer alex = new FootballPlayer("Alex");
        oklahomaSooners.addPlayer(alex);

        Team<FootballPlayer> lsuTigers = new Team<>("LSU Tigers");
        Team<FootballPlayer> oregonDucks = new Team<>("Oregon Ducks");

        // nebraskaCornhuskers.matchResult(nmUnited, 0, 2); use the type <> in matchResult() to prevent
        nebraskaCornhuskers.matchResult(oklahomaSooners, 35, 28);
        nebraskaCornhuskers.matchResult(lsuTigers, 14, 32);
        nebraskaCornhuskers.matchResult(oregonDucks, 21, 29);
        oklahomaSooners.matchResult(lsuTigers, 18, 36);
        oklahomaSooners.matchResult(oregonDucks, 20, 27);
        lsuTigers.matchResult(oregonDucks, 32, 27);

        System.out.println("Rankings:");
        System.out.println(nebraskaCornhuskers.getName() + ": " + nebraskaCornhuskers.ranking());
        System.out.println(oklahomaSooners.getName() + ": " + oklahomaSooners.ranking());
        System.out.println(lsuTigers.getName() + ": " + lsuTigers.ranking());
        System.out.println(oregonDucks.getName() + ": " + oregonDucks.ranking());

        System.out.println(nebraskaCornhuskers.compareTo(lsuTigers));
        System.out.println(oregonDucks.compareTo(oklahomaSooners));
    }
}
