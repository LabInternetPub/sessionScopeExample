package cat.tecnocampus.chancegames.gameControllers;

import cat.tecnocampus.chancegames.persistence.PlayerDAO;
import domain.Player;
import domain.SimpleGame;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameController {
    private Player player;
    private PlayerDAO playerDAO;

    public GameController(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void createPlayer(String username) {
        this.player = playerDAO.getPlayer(username);
        this.player.setGame(new SimpleGame());
    }

    public void betNumber(int number, int quantity) {
        player.betNumber(number, quantity);
    }

    public String getUsername() {
        return player.getName();
    }

    public void play() {
        player.play();
        playerDAO.updatePlayer(player);
    }

    public int[] getBetNumber() {
        return player.getBetNumber();
    }

    public Map<Integer, Integer> getBettings() {
        return player.getBettings();
    }

    public boolean hasWon() {
        return player.hasWon();
    }

    public int getWinnerNumber() {
        return player.getWinnerNumber();
    }

    public int getTreasure() {
        return player.getTreasure();
    }

    public boolean canBet() {
        return player.catBet();
    }
}
