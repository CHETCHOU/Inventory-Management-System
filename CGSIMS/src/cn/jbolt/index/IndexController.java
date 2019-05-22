package cn.jbolt.index;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.jbolt.common.model.Tuser;
/**
 * IndexController 指向系统访问首页
 * @author jbolt.cn
 * @email 909854136@qq.com
 * @date 2018年11月4日 下午9:02:52
 */
public class IndexController extends Controller {
	
	Tuser users = null;
	Record user = null;
	String idValue = null;
	
	String msg = "";
	JSONObject json = new JSONObject();
	
	/**
	 * 首页Action
	 */
	@ActionKey("index/authUser")
	public void authUser() {

		String userId = getPara("userName");
		String password = getPara("inputPassword1");
		
		String querySql = "SELECT username from tuser where tu_id = ? AND password = ? ";
		
		try{
			users = Tuser.dao.findFirst(querySql,userId,password);
		}catch(Exception ex){
			ex.printStackTrace();
			msg = "数据库读取失败，请重试！";
		}
		
		if(users != null) {			
			setSessionAttr("loginUser",users.getStr("username"));
			renderJsp("mainpage.jsp");
		}else {
			msg = "账号或密码错误，请确认后重新输入！";
			json.put("msg",msg);
			renderJson(json);
			renderError(500,"/index");
		}
	}
	
	@ActionKey("index/editPwd")
	public void editPwd() {
		String userName = getSessionAttr("loginUser");
		String oldPwd = getPara("inputPassword2");
		String newPwd1 = getPara("inputPassword3");
		String newPwd2 = getPara("inputPassword4");
		String queryId = "SELECT * from tuser where username = '" + userName + "'";
		users =Tuser.dao.findFirst(queryId);
		idValue = users.getStr("tu_id").toString();
		String pwd = users.getStr("password").toString();
		if(newPwd1.equals(newPwd2)) {
			if(pwd.equals(oldPwd)) {
				String updatePwd = "Update tuser set password = '"+ newPwd1 + "' where tu_id = '" + idValue + "'";
				Db.update(updatePwd);
				msg ="密码修改成功！";
				renderText("密码修改成功！");
			}else {
				msg = "两次输入的密码不一致，请重新输入！";
				json.put("msg",msg);
				renderJson(json);
			}
		}else {
			msg = "旧密码错误，请重新输入！";
			json.put("msg",msg);
			renderJson(json);
		}	
	}
	public void index() {
		render("index.html");
	}
	
}