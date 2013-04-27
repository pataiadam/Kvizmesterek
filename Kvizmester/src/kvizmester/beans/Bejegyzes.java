package kvizmester.beans;

import java.sql.Date;

public class Bejegyzes {

	private String felhasznalonev;
	private int pontszam;
	//private int admin;
	private String bejegyzes;
	private String kep;
	private String delete;
	private int id;
	private int reply_id;
	private Date datum;
	private String rendezes;
	private String kiirta;

	
	public Bejegyzes(String felhasznalonev, int pontszam, String kep, String delete, String bejegyzes, int id, int rid, Date datum, String kiirta) {
		this.bejegyzes=bejegyzes;
		this.kep=kep;
		this.felhasznalonev=felhasznalonev;
		this.id=id;
		this.reply_id=rid;
		this.delete=delete;
		this.pontszam=pontszam;
		this.datum=datum;
		this.kiirta=kiirta;

		if(rid==0) {
			this.rendezes="20"; 
					}
		else{
			this.rendezes="0";
			}
	}
	public String getBejegyzes() {
		return bejegyzes;
	}

	public void setBejegyzes(String bejegyzes) {
		this.bejegyzes = bejegyzes;
	}
	public String getFelhasznalonev() {
		return felhasznalonev;
	}
	public void setFelhasznalonev(String felhasznalonev) {
		this.felhasznalonev = felhasznalonev;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKep() {
		return kep;
	}
	public void setKep(String kep) {
		this.kep = kep;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getPontszam() {
		return pontszam;
	}
	public void setPontszam(int pontszam) {
		this.pontszam = pontszam;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getRendezes() {
		return rendezes;
	}
	public void setRendezes(String rendezes) {
		this.rendezes = rendezes;
	}
	public String getKiirta() {
		return kiirta;
	}
	public void setKiirta(String kiirta) {
		this.kiirta = kiirta;
	}

	
}
