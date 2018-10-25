package domain;

import java.util.Map;

public class Player {
    private String name;
    private int treasure = 0;
    private Game game=null;

    public Player(String name, int treasure) {
        this.name = name;
        this.treasure = treasure;
    }

    public String getName() {
        return name;
    }

    public int getTreasure() {
        return treasure;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void betNumber(int number, int quantity) {
        if (game == null)
            throw new RuntimeException("You need a game to betNumber");

        if (quantity <= treasure) {
            treasure -= quantity;
            game.betNumber(number, quantity);
        }
        else throw new RuntimeException("You cannot betNumber more than you have");
    }

    public void play() {
        if (game == null) {
            throw new RuntimeException("You need a game to play");
        }
        treasure += 2 * game.play();
    }

    public boolean hasWon() {
        return game.hasWon();
    }

    public int[] getBetNumber() {
        return game.getBetNumber();
    }

    public boolean catBet() {
        return game.canBet();
    }

    public int getTotalBet() {
        return game.getTotalBet();
    }

    public Map<Integer, Integer> getBettings() {
        return game.getBettings();
    }

    public int getWinnerNumber() {
        return game.getWinnerNumber();
    }

    public int getPrize() {
        return game.getPrize(game.getWinnerNumber());
    }
}
