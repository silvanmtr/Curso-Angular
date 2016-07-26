/**
 * 
 */
package br.com.apiweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Silvan de Jesus
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String irParaHome(){
		return "index";
	}
}
