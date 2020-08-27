package com.malatesh.login;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malatesh.beans.UserLoginDetails;
import com.malatesh.beans.UserRegistrationInfo;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class.getName());

	private final UserDataAccessLayer userDataAccessLayer;

	public LoginController(UserDataAccessLayer userDataAccessLayer) {
		this.userDataAccessLayer = userDataAccessLayer;
	}

	@GetMapping(value = "login")
	public String loginPage() {
		logger.info("Loaded login page successfully");
		return "redirect:/loginPage.jsp";
	}

	@GetMapping(value = "/registration")
	public String handleRegistrationAction() {
		logger.info("Loaded registration page successfully");
		return "redirect:/registrationPage.jsp";
	}

	@PostMapping(value = "/successRegistration")
	public String registrationPage(Model model,
			@ModelAttribute("registrationBean") UserRegistrationInfo registrationBean) {
		logger.info("saving data " + registrationBean);
		try {
			model.addAttribute("msg", registrationBean.getUserName());
			registrationBean.update();
			userDataAccessLayer.addNewUser(registrationBean);
		} catch (Exception e) {

			model.addAttribute("error", "Failed to save data");
		}

		return "redirect:/successRegistration.jsp";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(@ModelAttribute("loginBean") UserLoginDetails loginBean) {
		if (null != loginBean && null != loginBean.getUserName() && null != loginBean.getPassword()
				&& !loginBean.getUserName().isEmpty() && !loginBean.getPassword().isEmpty()) {
			String userName = loginBean.getUserName();
			String passsWord = loginBean.getPassword();

			UserLoginDetails loginDetails = userDataAccessLayer.getUserDetailsByUserName(userName);

			if (null != loginDetails) {
				if (loginDetails.getUserName().equals(userName) && loginDetails.getPassword().equals(passsWord)) {
					return "redirect:/successLogin.jsp";
				}
			}
			return "redirect:/loginErrorPage.jsp";
		}
		return "redirect:/loginPage.jsp";

	}

	@RequestMapping(value = "/login/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") String userName, Model model) {

		UserLoginDetails loginDetails = userDataAccessLayer.getUserDetailsByUserName(userName);

		if (loginDetails == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		userDataAccessLayer.deleteUserDetailsByUserName(userName);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@GetMapping(value = "/backLogin")
	public String backLoginPage() {
		logger.info("Loaded login page successfully");
		return "redirect:/loginPage.jsp";
	}

	@GetMapping(value = "/backRegister")
	public String backRegisterPage() {
		logger.info("Loaded login page successfully");
		return "redirect:/registrationPage.jsp";
	}

}
