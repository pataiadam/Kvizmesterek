package kvizmester.action;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import kvizmester.beans.Bejegyzes;
import kvizmester.beans.User;
import kvizmester.common.BaseActionBean;
import kvizmester.oracledatabase.OracleConnection;
import kvizmester.utils.Role;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class DummyForumActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/web/dummyforum.jsp";
	
	private static final String VIEW2 = "/WEB-INF/web/redirectToForum.jsp";


	private ArrayList<Bejegyzes> bejegyzeslista;
	

	
	private User userObj;
	private OracleConnection test=new OracleConnection();
	private String user="";
	private String SQL="";
	
	private ResultSet rs;
	private int id;
	
	private int deleteCommentId;
	static private int replyId=0;
	static private int changeId=0;
	private String comm;
	private String updateComm;
	private int admin=0;
	private Connection connect;
	
	@DefaultHandler
	public Resolution listaz() {
		userObj = getContext().getUser();
		user=userObj.getUsername();
		id=userObj.getId();
		if(userObj.getRole() == Role.ADMIN) {
			admin = 1;
		}

		try {
			bejegyzeslista=new ArrayList<>();
			connect=test.connect();
			
			
				PreparedStatement preparedStatement = null;
				SQL = "SELECT jatekos.felhasznalo_nev, jatekos.pontszam, forum.szoveg, forum.forum_id, forum.reply_id, datum, admin FROM forum, jatekos WHERE forum.jatekos_id=jatekos.jatekos_id and forum.reply_id is null order by forum_id DESC ";
				preparedStatement = connect.prepareStatement(SQL);		
				rs = preparedStatement.executeQuery();						
				 
				while (rs.next()) {
					Date date = new Date(rs.getDate("datum").getTime());
					Calendar cal = new GregorianCalendar();
					cal.setTime(date);
					String datum = cal.get(Calendar.YEAR) + "." + (cal.get(Calendar.MONTH)+1) + "." + cal.get(Calendar.DAY_OF_MONTH) + ":" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);
													
					bejegyzeslista.add(new Bejegyzes(
							rs.getString("felhasznalo_nev"),
							rs.getInt("pontszam"),
							pic(rs.getString("felhasznalo_nev"),rs.getInt("admin")),
							delete(rs.getString("felhasznalo_nev"),rs.getInt("forum_id")),
							rs.getString("szoveg"),
							rs.getInt("forum_id"),
							rs.getInt("reply_id"),
							rs.getDate("datum"),
							rs.getDate("datum") + "<b> "+rs.getString("felhasznalo_nev")+"</b> írta:</b>"));

				
					/*********************************/
				
					
					
					
					PreparedStatement preparedStatement2 = null;
					String SQL2 = "SELECT jatekos.felhasznalo_nev, jatekos.pontszam, forum.szoveg, forum.forum_id, forum.reply_id, datum, admin FROM forum, jatekos WHERE forum.jatekos_id=jatekos.jatekos_id and forum.reply_id="+rs.getInt("forum_id") +"order by forum_id DESC";
					preparedStatement2 = connect.prepareStatement(SQL2);		
					ResultSet rs2 = preparedStatement2.executeQuery();						
						 
					while (rs2.next()) {
						
								bejegyzeslista.add(new Bejegyzes(
								rs2.getString("felhasznalo_nev"),
								rs2.getInt("pontszam"),
								pic(rs2.getString("felhasznalo_nev"),rs2.getInt("admin")),
								delete(rs2.getString("felhasznalo_nev"),rs2.getInt("forum_id")),
								rs2.getString("szoveg"),
								rs2.getInt("forum_id"),
								rs2.getInt("reply_id"),
								rs2.getDate("datum"),
								rs2.getDate("datum")+" <b>"+rs2.getString("felhasznalo_nev")+"</b> írta <b>"+rs.getString("felhasznalo_nev")+"</b> hozzászólására: "));
					
					}
					
				/****************************************/
				
				}rs.close();
				
		
		
		}
		catch (Exception e) {
			System.out.println("HIBA "+SQL+" -> "+e.getMessage());
		}
		return new ForwardResolution(VIEW);
	}
	
	public Resolution deleteComment() {
				
		try {
			
			connect=test.connect();
			SQL="DELETE FROM forum WHERE forum_id='"+deleteCommentId+"'";
			Statement stmt=null;
			stmt = connect.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();	
			
		}
		catch(Exception e)
		{
			System.out.println("HIBA "+SQL+" -> "+e.getMessage()+e.getLocalizedMessage());
		}
		
		
		
		this.replyId=0;
		this.changeId=0;
		
		
		return new ForwardResolution(VIEW2);
	}
	public Resolution updateComment() {
		byte[] ptext = null;
		try {
			ptext = updateComm.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updateComm = new String(ptext); 
	
		try{
		
		if(updateComm.length()>0) {
			
			connect=test.connect();
			
			SQL=" UPDATE forum SET szoveg = '"+this.updateComm+"' WHERE forum_id = '"+this.changeId+"'";
			Statement stmt=null;
			stmt = connect.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
			}
	
		}
		catch(Exception e)
		{
			System.out.println("HIBA "+SQL+" -> "+e.getMessage()+e.getLocalizedMessage());
		}
		
		
		
		
		this.changeId=0;
		return new ForwardResolution(VIEW2);
		
	}
	public Resolution addComment() {
		byte[] ptext = null;
		try {
			ptext = comm.getBytes("ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comm = new String(ptext); 
		
		
		try {
			
			if(comm.length()>0) {
			
			connect=test.connect();
			if(replyId>0)
			SQL="Insert into forum (jatekos_id,szoveg,reply_id) values ('"+	getContext().getUser().getId()+"','"+comm+"','"+replyId+"')";
			else
			SQL="Insert into forum (jatekos_id,szoveg) values ('"+	getContext().getUser().getId()+"','"+comm+"')";
	
			Statement stmt=null;
			stmt = connect.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		this.replyId=0;
		return new ForwardResolution(VIEW2);
	}
	
	public Resolution CommentComment() {
		return new ForwardResolution(VIEW2);
	}
	public Resolution changeComment() {
		System.out.println("huhuhuhahahahha "+this.changeId);
		return new ForwardResolution(VIEW2);
	}
	
	
	
	
	
	
	public String delete (String commentelo, int deleteCommentId) {		
		String db="<td background=\"img/forum/center.png\" width=56 height=92> <a href='/Kvizmester/DummyForum.action?deleteComment=&deleteCommentId=" + deleteCommentId + "'><img  src= \"img/forum/del.png\" onmouseover=\"this.src='img/forum/del_over.png'\" onmouseout=\"this.src='img/forum/del.png'\"></a></td>"+
				  "<td background=\"img/forum/center.png\" width=56 height=92> <a href='/Kvizmester/DummyForum.action?changeComment=&changeId=" + deleteCommentId + "'><img  src= \"img/forum/mod.png\" onmouseover=\"this.src='img/forum/mod_over.png'\" onmouseout=\"this.src='img/forum/mod.png'\"></a></td>";
		if(this.admin==1 || user.equals(commentelo)) return db;
		return "";
	}
	
	public String pic (String commentelo, int admine) {
		if(commentelo.equals(user)) return "img/forum/green_left.png";
		if (admine==1) return "img/forum/red_left.png";
		return "img/forum/blue_left.png";
	}

	
	
	
	public ArrayList<Bejegyzes> getBejegyzeslista() {
		return bejegyzeslista;
	}

	public void setBejegyzeslista(ArrayList<Bejegyzes> bejegyzeslista) {
		this.bejegyzeslista = bejegyzeslista;
	}
	
	public int getUserId() {
		return userObj.getId();
	}
	
	public String getUserName() {
		return userObj.getUsername();
	}
	
	public Role getUserRole() {
		return userObj.getRole();
	}

	public int getDeleteCommentId() {
		return deleteCommentId;
	}

	public void setDeleteCommentId(int deleteCommentId) {
		this.deleteCommentId = deleteCommentId;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comment) {
		this.comm = comment;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int reply_id) {
		this.replyId = reply_id;
	}

	public int getChangeId() {
		return changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	public String getUpdateComm() {
		return updateComm;
	}

	public void setUpdateComm(String updateComm) {
		this.updateComm = updateComm;
	}
	
	
}


