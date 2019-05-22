package cn.jbolt.devicestorage;

import java.sql.Date;
import java.util.List;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import cn.jbolt.common.model.Devicestorage;

public class DeviceStorageController extends Controller {

	public void index() {
		renderJsp("devicestorage.jsp");
	}
	
	@ActionKey("devicestorage/storagePaginate")
	public void storagePaginate() {
		
		Integer pageNumber = getParaToInt("pageNumber");
		
		if(pageNumber == null) {
			pageNumber = 1;
		}
		
		List<Devicestorage> dstorages = null;
		
		dstorages = Devicestorage.dao.find("Select * from devicestorage");
		
		Page<Devicestorage> Pagedstorage = Devicestorage.dao.paginate(pageNumber, 5, "select * "," from devicestorage ");

		setAttr("deviceStorage",dstorages);
		
		setAttr("deviceStoragePage", Pagedstorage);
		
		renderJsp("../devicestorage.jsp");
	}
	
	@ActionKey("devicestorage/deleteDevice")
	public void deleteDevice() {
		String id = get("id").trim();
		String delDevice = "delete from `devicestorage` where `device_id` = '" + id +"'";
		Db.delete(delDevice);
		redirect("/devicestorage/storagePaginate");
		
	}
	
	public void updateDevice() {
		String device_id = getPara();
		String device_name = getPara();
		String device_brand = getPara();
		String device_model = getPara();
		Integer device_number = null;
		String device_location = getPara();
		Date device_date = null;
		String device_note = getPara(); 
		String device_attri = getPara();
		
		String updateDevice = "UPDATE devicestorage SET " + 
				"device_name = '"+ device_name +
				"',device_brand ='" + device_brand +
				"',device_model ='"+ device_model +
				"',device_number = " + device_number +
				",device_location = '" + device_location +
				"',device_date = '" + device_date +
				"',device_note ='" + device_note +
				"',device_attri ='"+ device_attri + 
 				"' WHERE device_id = '" + device_id +"';";
		
		Db.update(updateDevice);
	}
	
	public void addnDevice() {
		String maxId = null;
		Integer newId = null;
		String queryId = "Select max(device_id) from devicestorage";
		maxId = Db.queryStr(queryId);
		newId = Integer.valueOf(maxId)+1;
		setAttr("newId",newId);
		
		String device_name = getPara();
		String device_brand = getPara();
		String device_model = getPara();
		Integer device_number = null;
		String device_location = getPara();
		Date device_date = null;
		String device_note = getPara();
		String device_attri = getPara();
		
		String insertDevice = "INSERT INTO devicestorage VALUES('"+ newId.toString() +"'"+
				",'"+device_name+"'"+",'"+device_brand+"'"+
				",'"+device_model+"'"+",'"+device_number+"'"+
				",'"+device_location+"'"+",'"+device_date+"'"+
				",'"+device_note+"'"+",'"+device_attri+"'"+")";
		
		Db.update(insertDevice);
	}
	
	public void addDevice() {
		String device_id = getPara();
		String device_name = getPara();
		String device_brand = getPara();
		String device_model = getPara();
		Integer device_number = null;
		String device_location = getPara();
		Date device_date = null;
		String device_note = getPara();
		String device_attri = getPara();
		
		String insertDevice = "INSERT INTO devicestorage VALUES('"+ device_id +"'"+
				",'"+device_name+"'"+",'"+device_brand+"'"+
				",'"+device_model+"'"+",'"+device_number+"'"+
				",'"+device_location+"'"+",'"+device_date+"'"+
				",'"+device_note+"'"+",'"+device_attri+"'"+")";
		
		Db.update(insertDevice);
	}
	
}
