package domain.gameState;

import domain.Game;

public class NotBetYetState extends GameSate {

    public NotBetYetState(Game game) {
        super(game);
    }

    @Override
    public void betNumber(int number, int quantiy) {
        this.game.setState(new BetOrPlayState(this.game));
        this.game.setBetNumber(number,quantiy);
    }

    @Override
    public int play() {
        throw new RuntimeException("You should have betNumber before playing");
    }
}
