package kvizmester.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import kvizmester.common.BaseActionBean;

public class LogoutActionBean extends BaseActionBean {
	
	@DefaultHandler
	public Resolution logout() {
		System.out.println("logout");
		getContext().setUser(null);
		return new ForwardResolution(LoginActionBean.VIEW);
	}
}
