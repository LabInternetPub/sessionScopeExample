package cat.tecnocampus.chancegames.webController;

import cat.tecnocampus.chancegames.gameControllers.GameController;
import cat.tecnocampus.chancegames.webController.helperObjects.BetForm;
import cat.tecnocampus.chancegames.webController.helperObjects.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayWebController {
    private GameController gameController;

    public PlayWebController(GameController gameController) {
        this.gameController = gameController;
    }

    @GetMapping("newGame")
    public String newGame(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "createGame";
    }

    @PostMapping("newGame")
    public String newGamePost(UserForm userForm) {

        gameController.createPlayer(userForm.getUsername());

        return "redirect:/betNumber";
    }

    @GetMapping("betNumber")
    public String betting(Model model) {
        BetForm betForm = new BetForm();
        betForm.setNumber(2);
        betForm.setQuantity(5);

        model.addAttribute("betForm", betForm);
        model.addAttribute("username", gameController.getUsername());
        return "betNumber";
    }

    @PostMapping("betNumber")
    public String bettingPost(BetForm betForm, Model model) {
        gameController.betNumber(betForm.getNumber(), betForm.getQuantity());

        model.addAttribute("username", gameController.getUsername());
        if (gameController.canBet()) {
            return "redirect:/betOrPlay";
        } else {
            return "redirect:/play";
        }
    }

    @GetMapping("betOrPlay")
    public String betOrPlay(Model model) {
        int[] betNumber = gameController.getBetNumber();
        BetForm betForm = new BetForm();
        betForm.setNumber(2);
        betForm.setQuantity(5);

        model.addAttribute("username", gameController.getUsername());
        model.addAttribute("bettings", gameController.getBettings());
        model.addAttribute("betForm", betForm);
        return "betOrPlay";
    }

    @GetMapping("play")
    public String playing(Model model) {
        int[] betNumber = gameController.getBetNumber();
        model.addAttribute("username", gameController.getUsername());
        model.addAttribute("bettings", gameController.getBettings().entrySet());
        return "playForm";
    }

    @PostMapping("play")
    public String playingPost() {
        gameController.play();
        return "redirect:/final";
    }

    @GetMapping("final")
    public String gameOver(Model model) {
        int[] betNumber = gameController.getBetNumber();
        model.addAttribute("username", gameController.getUsername());
        model.addAttribute("bettings", gameController.getBettings());
        model.addAttribute("treasure", gameController.getTreasure());
        model.addAttribute("winnerNumber", gameController.getWinnerNumber());
        if (gameController.hasWon()) {
            model.addAttribute("hasWon", true);
        } else {
            model.addAttribute("hasWon", false);
        }

        return "result";
    }
}