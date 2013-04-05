package kvizmester.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import kvizmester.common.BaseActionBean;

public class LogoutActionBean extends BaseActionBean {
	
	private static final String VIEW = "/index.jsp";
	
	@DefaultHandler
	public Resolution logout() {
		getContext().setUser(null);
		return new ForwardResolution(VIEW);
	}
}
