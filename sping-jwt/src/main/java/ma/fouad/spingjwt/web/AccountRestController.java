package ma.fouad.spingjwt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.fouad.spingjwt.entities.AppRole;
import ma.fouad.spingjwt.entities.AppUser;
import ma.fouad.spingjwt.service.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	private AppUser register(@RequestBody RegisterForm userForm) {
		
		if (!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("You must confirm your password");
		}
		AppUser user= accountService.findUserByUserName(userForm.getUsername());
		if (user!=null) {
			throw new RuntimeException("This user already exists");
		}
		AppUser appUser= new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		// roles  "ADMIN" , "USER" added in the start main class (run function) 
		 accountService.saveUser(appUser);
		 accountService.addRoleToUser(userForm.getUsername(),userForm.getRole());
		 
		 return appUser;
		
	}
	
}










