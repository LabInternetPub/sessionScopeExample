package cat.tecnocampus.chancegames.persistence;

import domain.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//@Repository
@Component
public class PlayerDAO {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Player> playerRowMapper = (rs, i) -> {
        return new Player(rs.getString("username"), rs.getInt("treasure"));
    };

    public PlayerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Player getPlayer(String username) {
        return jdbcTemplate.queryForObject("select * from userplayer where username = ?", new Object[]{username}, playerRowMapper);
    }

    public void updatePlayer(Player player) {
        jdbcTemplate.update("update userplayer set treasure = ? where username = ?", player.getTreasure(), player.getName());
        jdbcTemplate.update("insert into game (total_bet, prize, won, player) values (?, ?, ?, ?)", player.getTotalBet(), player.getPrize(), player.hasWon(), player.getName());
    }
}
