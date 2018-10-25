package domain.gameState;

import domain.Game;

public class WonState extends GameSate {

    public WonState(Game game) {
        super(game);
    }

    @Override
    public void betNumber(int number, int quantity) {
        throw new RuntimeException("This game is over and you won. You cannot betNumber again");
    }

    @Override
    public int play() {
        throw new RuntimeException("This game is over and you won. You cannot play again");
    }

}
