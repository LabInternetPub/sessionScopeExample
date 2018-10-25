package domain;

import domain.gameState.GameSate;

import java.util.Map;

public interface Game {

    void betNumber(int number, int quantity);
    int play();
    String getName();

    void setBetNumber(int number, int quantity);
    int[] getBetNumber();
    Map<Integer, Integer> getBettings();
    int getNumberOfBets();

    boolean isBetWinnerNumber(int number);

    int getPrize(int number);

    void setState(GameSate state);

    boolean canBet();

    boolean hasWon();

    int getWinnerNumber();
    void setWinnerNumber(int winnerNumber);

    int getTotalBet();
}
