/**
 * 
 * 
 */

function checkpwd(){
	var check = false;
	var pwd1 = document.getElementById("inputPassword1");
	var pwd2 = document.getElementById("inputPassword2");
	var pwd3 = document.getElementById("inputPassword3");
	
	if(pwd1== null || pwd2 == null || pwd3 == null ){
		alert("请重新输入！");
		return check;
	}else{
		if(pwd2 != pwd3){
			alert("两次输入的密码不一致，请重新输入");
			return check;
		}else{
			check = true;
			return check;
		}
	}

}