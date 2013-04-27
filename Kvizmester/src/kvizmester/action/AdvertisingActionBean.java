package kvizmester.action;

import java.util.Date;
import java.util.List;

import kvizmester.beans.Advertising;
import kvizmester.common.BaseActionBean;
import kvizmester.test.Test;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;

public class AdvertisingActionBean extends BaseActionBean {
	/**
	 * Main view
	 */
	public static final String VIEW = "/WEB-INF/web/admin/advertising.jsp";
	
	public static final String VIEW2 = "/WEB-INF/web/admin/newAdvertising.jsp";
	
	public static final String VIEW3 = "/WEB-INF/web/admin/redirectToAdvertising.jsp";
	
	private List<Advertising> advertisingList;
	
	private int modifyAdvertisingId;
	
	private String url;
	
	private Date beginning;
	
	private Date end;
	
	private int deleteAdvertisingId;
	
	@DefaultHandler
	public Resolution view() {
		if(url != null) {
			return uploadAdvertising();
		}
		Test test = new Test();
		
		advertisingList = test.getAllAdvertising();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution newAdvertising() {
		return new ForwardResolution(VIEW2);
	}
	
	public Resolution uploadAdvertising() {
		
		Test test = new Test();
		
		if(! test.uploadAdvertising(url, beginning, end)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
			return new ForwardResolution(VIEW2);
		}
		
		advertisingList = test.getAllAdvertising();
		
		return new ForwardResolution(VIEW);
	}
	
	public Resolution deleteAdvertising() {
		Test test = new Test();
		
		if(! test.deleteAdvertisingById(deleteAdvertisingId)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
		}
		
		advertisingList = test.getAllAdvertising();

		return new ForwardResolution(VIEW);
	}
	
	public Resolution updateAdvertising() {
		Test test = new Test();
		
		if(! test.updateAdvertising(modifyAdvertisingId, url, beginning, end)) {
			getContext().getValidationErrors().addGlobalError(
	                new SimpleError("Hiba a művelet során!") );
		}
		
		advertisingList = test.getAllAdvertising();
		
		return new ForwardResolution(VIEW3);
	}

	public List<Advertising> getAdvertisingList() {
		return advertisingList;
	}

	public void setAdvertisingList(List<Advertising> advertisingList) {
		this.advertisingList = advertisingList;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setDeleteAdvertisingId(int deleteAdvertisingId) {
		this.deleteAdvertisingId = deleteAdvertisingId;
	}

	public void setModifyAdvertisingId(int modifyAdvertisingId) {
		this.modifyAdvertisingId = modifyAdvertisingId;
	}
}
