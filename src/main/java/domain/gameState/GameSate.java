package domain.gameState;

import domain.Game;

import java.util.HashMap;
import java.util.Random;

public abstract class GameSate {
    Game game;
    Random randomNumberGenerator = new Random();


    public GameSate(Game game) {
        this.game = game;
    }

    public abstract void betNumber(int number, int quantity);

    public int play() {
        int winner = randomNumberGenerator.nextInt(10);
        game.setWinnerNumber(winner);

        if (game.isBetWinnerNumber(winner)) {
            game.setState(new WonState(game));
            return game.getPrize(winner);
        }

        game.setState(new LostState(game));
        return 0; //if lost player has already paid


    }
}
