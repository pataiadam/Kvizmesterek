package kvizmester.action;

import kvizmester.common.BaseActionBean;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

import org.apache.log4j.Logger;

/**
 * A very simple calculator action.
 * 
 * @author Tim Fennell
 */
public class HomeActionBean extends BaseActionBean implements ActionBean {


	/**
	 * Main view
	 */
	private static final String VIEW = "/WEB-INF/web/home.jsp";

	/**
	 * LOGGER.
	 */
	private final Logger logger = Logger.getLogger(HomeActionBean.class);

	
	@DefaultHandler
	public Resolution addition() {
		logger.info("log4j is mukodik");
		return new ForwardResolution(VIEW);
	}
}