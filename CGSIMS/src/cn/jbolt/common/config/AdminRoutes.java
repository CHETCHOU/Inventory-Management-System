package cn.jbolt.common.config;

import com.jfinal.config.Routes;

import cn.jbolt.devicestorage.DeviceStorageController;
import cn.jbolt.index.IndexController;
import cn.jbolt.mainpage.mainPageController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
	
		//针对一组路由配置baseViewPath
		this.setBaseViewPath("/");
		//针对一组路由配置单独的拦截器
		//this.addInterceptor(new AdminAuthInterceptor());
		//针对后台管理系统配置路由+controller
		//this.add("/admin", AdminIndexController.class,"/index");
		this.add("/",IndexController.class);
		this.add("/mainpage",mainPageController.class);
		this.add("/DeviceStorage",DeviceStorageController.class);
	
	}

}