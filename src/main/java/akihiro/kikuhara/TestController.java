package akihiro.kikuhara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@Autowired
	UserRepository repository;

	@RequestMapping(value = "/")
	public String index(Model model) {

		Iterable<User> list = repository.findAll();
		model.addAttribute("results", list);

		for (User user : list) {
			System.out.println("ID:" + user.getId() + "  NAME:" + user.getName());
		}

		return "index";
	}
}
