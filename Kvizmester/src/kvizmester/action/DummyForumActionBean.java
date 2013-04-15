package kvizmester.action;

import java.util.ArrayList;
import kvizmester.beans.Bejegyzes;

import kvizmester.common.BaseActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class DummyForumActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/web/dummyforum.jsp";

	private ArrayList<Bejegyzes> bejegyzeslista;

	@DefaultHandler
	public Resolution addition() {
		
		bejegyzeslista=new ArrayList<>();
		bejegyzeslista.add(new Bejegyzes("xyxyxy1"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy2"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy3"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		bejegyzeslista.add(new Bejegyzes("xyxyxy4"));
		
		return new ForwardResolution(VIEW);
	}

	public ArrayList<Bejegyzes> getBejegyzeslista() {
		return bejegyzeslista;
	}

	public void setBejegyzeslista(ArrayList<Bejegyzes> bejegyzeslista) {
		this.bejegyzeslista = bejegyzeslista;
	}
	

}
