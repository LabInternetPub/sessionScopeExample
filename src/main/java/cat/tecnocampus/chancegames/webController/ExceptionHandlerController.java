package cat.tecnocampus.chancegames.webController;

import cat.tecnocampus.chancegames.gameControllers.GameController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    GameController gameController;

    public ExceptionHandlerController(GameController gameController) {
        this.gameController = gameController;
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleUsernameDoesNotExist(Model model, Exception ex) {

        model.addAttribute("username", gameController.getUsername());
        model.addAttribute("message", ex.getMessage());
        return "error/gameError";
    }
}
