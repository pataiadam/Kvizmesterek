package kvizmester.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import kvizmester.common.BaseActionBean;

public class GameActionBean extends BaseActionBean {
	
	private static final String VIEW = "/WEB-INF/web/game.jsp";
	private String text;
	
	@DefaultHandler
	public Resolution game() {
		return new ForwardResolution(VIEW);
	}
	
    public Resolution ajax() {
        return new ForwardResolution("/WEB-INF/web/gameRooms.jsp");
    }

    public Resolution submit() {
        return new RedirectResolution(GameActionBean.class);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
