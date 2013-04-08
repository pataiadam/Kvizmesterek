package kvizmester.action;

import kvizmester.common.BaseActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class MainGameActionBean extends BaseActionBean {
	
	private static final String VIEW = "/WEB-INF/web/mainGame.jsp";

	@DefaultHandler
	public Resolution mainGame() {
		return new ForwardResolution(VIEW);
	}
	


}
