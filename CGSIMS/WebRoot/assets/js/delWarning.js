/**
 * 
 */

function delWarning(id){
	var warningmsg = confirm("删除此记录后不可恢复，请确认是否删除？");
	if (warningmsg == true){
		window.location.href = "../devicestorage/deleteDevice?id="+encodeURI(id);
	}else if(warningmsg == false){
		
	}
}
