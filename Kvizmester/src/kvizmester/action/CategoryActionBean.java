package kvizmester.action;

import java.util.List;

import kvizmester.beans.Category;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;

public class CategoryActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/admin/category.jsp";
	
	public static final String VIEW2 = "/WEB-INF/web/admin/newCategory.jsp";
	

	public static final String VIEW3 = "/WEB-INF/web/admin/redirectToCategory.jsp";
	
	private List<Category> categoryList;
	
	private String newCategoryName;
	
	private int modifyCategoryId;
	
	private int deleteCategoryId;
	
	@DefaultHandler
	public Resolution view() {
		if(newCategoryName != null) {
			return uploadCategory();
		}
				
		OracleConnection test = new OracleConnection();
		
		categoryList = test.getAllCategory();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution newCategory() {
		
		return new ForwardResolution(VIEW2);
	}
	
	public Resolution uploadCategory() {
		OracleConnection test = new OracleConnection();
		
		Category c = test.getCategoryByName(newCategoryName);
		
		if(c != null) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Már létezik ilyen nevű kategória!") );
			return new ForwardResolution(VIEW2);
		}
		
		if(test.uploadCategory(newCategoryName) == false) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW2);
		}
		
		categoryList = test.getAllCategory();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution deleteCategory() {
		OracleConnection test = new OracleConnection();
		
		if(test.deleteCategoryById(deleteCategoryId) == false) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW2);
		}
		getContext().getMessages().add(new LocalizableMessage("delete.successful"));
		
		categoryList = test.getAllCategory();
		
		return view();
	}
	
	public Resolution updateCategory() {
		OracleConnection test = new OracleConnection();
		
		if(! test.updateCategory(modifyCategoryId, newCategoryName)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
		}
		
		categoryList = test.getAllCategory();
		
		return new ForwardResolution(VIEW3);
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public void setNewCategoryName(String newCategoryName) {
		this.newCategoryName = newCategoryName;
	}

	public int getDeleteCategoryId() {
		return deleteCategoryId;
	}

	public void setDeleteCategoryId(int deleteCategoryId) {
		this.deleteCategoryId = deleteCategoryId;
	}

	public void setModifyCategoryId(int modifyCategoryId) {
		this.modifyCategoryId = modifyCategoryId;
	}
}
