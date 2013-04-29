package kvizmester.action;

import java.util.List;

import kvizmester.beans.statistics.CategoryLevel;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class CategoryAvgLevelActionBean extends BaseActionBean {
	
	public static final String VIEW = "/WEB-INF/web/statistics/categoryLevelAvg.jsp";
	
	private List<CategoryLevel> avgCategoryLevel;
	
	@DefaultHandler
	public Resolution view() {
		OracleConnection test = new OracleConnection();
		avgCategoryLevel = test.getCategoryLevelStatistics();
		return new ForwardResolution(VIEW);
	}

	public List<CategoryLevel> getAvgCategoryLevel() {
		return avgCategoryLevel;
	}

	public void setAvgCategoryLevel(List<CategoryLevel> avgCategoryLevel) {
		this.avgCategoryLevel = avgCategoryLevel;
	}
}
