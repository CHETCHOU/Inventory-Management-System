package cn.jbolt.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseTuser<M extends BaseTuser<M>> extends Model<M> implements IBean {

	public M setTuId(java.lang.Long tuId) {
		set("tu_id", tuId);
		return (M)this;
	}
	
	public java.lang.Long getTuId() {
		return getLong("tu_id");
	}

	public M setPassword(java.lang.String password) {
		set("password", password);
		return (M)this;
	}
	
	public java.lang.String getPassword() {
		return getStr("password");
	}

	public M setUsername(java.lang.String username) {
		set("username", username);
		return (M)this;
	}
	
	public java.lang.String getUsername() {
		return getStr("username");
	}

	public M setRoleId(java.lang.Long roleId) {
		set("role_id", roleId);
		return (M)this;
	}
	
	public java.lang.Long getRoleId() {
		return getLong("role_id");
	}

}
