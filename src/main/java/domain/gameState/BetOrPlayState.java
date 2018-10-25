package domain.gameState;

import domain.Game;

public class BetOrPlayState extends GameSate {
    private final int MAX_BETS = 3;


    public BetOrPlayState(Game game) {
        super(game);
    }

    @Override
    public void betNumber(int number, int quantity) {
        game.setBetNumber(number, quantity);
        if (game.getNumberOfBets() >= MAX_BETS) {
            game.setState(new OnlyPlayState(game));
        }
    }

    @Override
    public int play() {
        return super.play();
    }
}
