package cn.jbolt.devicestorage;

import java.util.List;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import cn.jbolt.common.model.Devicestorage;

public class DeviceStorageController extends Controller {

	public void index() {
		renderJsp("devicestorage.jsp");
	}
	
	@ActionKey("devicestorage/storagePaginate")
	public void storagePaginate() {
		
		//String device_name = getPara("device_name");
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

}
