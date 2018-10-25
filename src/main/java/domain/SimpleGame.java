package domain;

import domain.gameState.*;

import java.util.HashMap;
import java.util.Map;

public class SimpleGame implements Game {
    private Map<Integer, Integer> bet;
    private GameSate state;
    private final String name = "Simple game";
    private int winnerNumber = -1;

    public SimpleGame() {
        state = new NotBetYetState(this);
        bet = new HashMap<>();
    }

    @Override
    public void betNumber(int number, int quantity) {
        state.betNumber(number, quantity);
    }

    @Override
    public int play() {
        return state.play();
    }

    @Override
    public void setBetNumber(int number, int quantity) {
        this.bet.put(number,quantity);
    }

    @Override
    public int[] getBetNumber() {
        int betNumber[] = new int[2];
        for (Map.Entry<Integer, Integer> e : bet.entrySet()) {
            betNumber[0]=e.getKey();
            betNumber[1]=e.getValue();
        }
        return betNumber;
    }

    @Override
    public Map<Integer, Integer> getBettings() {
        return bet;
    }

    @Override
    public int getNumberOfBets() {
        return bet.size();
    }

    @Override
    public void setState(GameSate state) {
        this.state = state;
    }

    @Override
    public boolean canBet() {
        return state.getClass() == NotBetYetState.class || state.getClass() == BetOrPlayState.class;
    }

    @Override
    public boolean hasWon() {
        return state.getClass() == WonState.class;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBetWinnerNumber(int number) {
        return bet.containsKey(number);
    }

    @Override
    public int getPrize(int number) {
        if (bet.containsKey(number)) {
            return bet.get(number);
        }
        return 0;
    }

    @Override
    public int getTotalBet() {
        return bet.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public int getWinnerNumber() {
        if (state.getClass() == LostState.class || state.getClass() == WonState.class) {
            return winnerNumber;
        }
        throw new RuntimeException("Game not finished yet. It has not a winner number");
    }

    @Override
    public void setWinnerNumber(int winnerNumber) {
        this.winnerNumber = winnerNumber;
    }
}
