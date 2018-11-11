package top.qingrang.sql_session_cache.beans;

public class Country{
	private Integer cid;
	private String cname;

	public Country() {
		super();
	}

	public Country(String cname){
		this.cname = cname;
	}

	public Country(Integer cid,String cname){
		this.cid = cid;
		this.cname = cname;
	}

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
}
