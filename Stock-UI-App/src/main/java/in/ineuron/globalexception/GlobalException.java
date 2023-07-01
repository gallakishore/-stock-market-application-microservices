package in.ineuron.globalexception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Exception.class)
	public String handleUnkownException(Exception e, Model model) {
		model.addAttribute("errorMessage", "Some internal issue has occured please try after some time");
		return "error";
	}
}
