package akihiro.kikuhara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	UserRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		// DBから全件取得
		Iterable<User> list = repository.findAll();
		model.addAttribute("results", list);

		return "index";
	}
	
	//登録処理
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(Model model,@RequestParam("insert") String name){
		System.out.println("1:=============================");
		
		User user = new User();
		user.setName(name);
		
		repository.save(user);
		System.out.println("2:=============================");
		
		
		return "redirect:/";
	}
	
}
