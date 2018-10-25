package domain.gameState;

import domain.Game;

public class OnlyPlayState extends GameSate {

    public OnlyPlayState(Game game) {
        super(game);
    }

    @Override
    public void betNumber(int number, int quantiy) {
        throw new RuntimeException("You've already betNumber");
    }

    @Override
    public int play() {
        return super.play();
    }
}
