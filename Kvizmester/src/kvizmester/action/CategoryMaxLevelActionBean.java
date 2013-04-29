package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.CategoryLevel;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class CategoryMaxLevelActionBean extends BaseActionBean {
	public static final String VIEW = "/WEB-INF/web/statistics/categoryLevelMax.jsp";
	
	private List<CategoryLevel> maxCategoryLevel;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		maxCategoryLevel = test.getMaxLevelByCategories();
		return new ForwardResolution(VIEW);
	}

	public List<CategoryLevel> getMaxCategoryLevel() {
		return maxCategoryLevel;
	}

	public void setMaxCategoryLevel(List<CategoryLevel> avgCategoryLevel) {
		this.maxCategoryLevel = avgCategoryLevel;
	}
}
