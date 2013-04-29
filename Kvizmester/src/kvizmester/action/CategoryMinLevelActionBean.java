package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.CategoryLevel;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class CategoryMinLevelActionBean extends BaseActionBean {
public static final String VIEW = "/WEB-INF/web/statistics/categoryLevelMin.jsp";
	
	private List<CategoryLevel> minCategoryLevel;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		minCategoryLevel = test.getMinLevelByCategories();
		return new ForwardResolution(VIEW);
	}

	public List<CategoryLevel> getMinCategoryLevel() {
		return minCategoryLevel;
	}

	public void setMinCategoryLevel(List<CategoryLevel> avgCategoryLevel) {
		this.minCategoryLevel = avgCategoryLevel;
	}
}
