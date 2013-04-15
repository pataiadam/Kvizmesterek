package kvizmester.common;

import kvizmester.action.LoginActionBean;
import kvizmester.utils.Role;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public abstract class BaseActionBean implements ActionBean {
	private BaseActionBeanContext actionBeanContext;

	public BaseActionBean() {
		//		String homeDir = getContext().getServletContext().getRealPath("/");
		//		File propertiesFile = new File(homeDir,
		//				"WEB-INF/classes/log4j.properties");
		//		PropertyConfigurator.configure(propertiesFile.toString());
	}

	@Override
	public BaseActionBeanContext getContext() {
		return actionBeanContext;
	}

	@Override
	public void setContext(ActionBeanContext actionBeanContext) {
		this.actionBeanContext = (BaseActionBeanContext) actionBeanContext;
	}
	
	public Role getRole() {
		return getContext().getRole();
	}
}
