package train.pooyan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimpleController {

	@GetMapping("/formView")
	public String formView() {
		return "formView";
	}
	
	@PostMapping("/result")
	public String resultPage() {
		return "resultPage";
	}
}
