package kvizmester.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import kvizmester.common.BaseActionBean;

public class GameActionBean extends BaseActionBean {
	
	private static final String VIEW = "/WEB-INF/web/game.jsp";
	
	@DefaultHandler
	public Resolution game() {
		return new ForwardResolution(VIEW);
	}
}
