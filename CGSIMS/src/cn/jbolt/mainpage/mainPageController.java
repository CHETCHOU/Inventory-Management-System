package cn.jbolt.mainpage;

import com.jfinal.core.Controller;

public class mainPageController extends Controller {
	
	public void index() {
		renderJsp("mainpage.jsp");
	}

}
