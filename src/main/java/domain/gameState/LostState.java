package domain.gameState;

import domain.Game;

public class LostState extends GameSate {

    public LostState(Game game) {
        super(game);
    }

    @Override
    public void betNumber(int number, int quantity) {
        throw new RuntimeException("This game is over and sadly you lost. You cannot betNumber again");
    }

    @Override
    public int play() {
        throw new RuntimeException("This game is over and sadl you lost. You cannot play again");
    }
}
