package com.binjcover.datatype;

public class UserN {

	private int _ID;
	private String uName;
	private String phno;
	private String prefr;
	private int cc_id;

	/**
	 * Constructor
	 * @param _ID
	 * @param uName
	 * @param phno
	 * @param prefr
	 * @param cc_id
	 */
	public UserN(int _ID, String uName, String phno, String prefr, int cc_id) {
		super();
		this._ID = _ID;
		this.uName = uName;
		this.phno = phno;
		this.prefr = prefr;
		this.cc_id = cc_id;
	}

	/**
	 * Constructor 
	 * @param _ID
	 * @param uName
	 * @param phno
	 */
	public UserN(int _ID, String uName, String phno) {
		super();
		this._ID = _ID;
		this.uName = uName;
		this.phno = phno;
	}

	/**
	 * default constructor
	 */
	public UserN() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserN)) {
			return false;
		}
		UserN other = (UserN) obj;
		if (_ID != other._ID) {
			return false;
		}
		return true;
	}

	public int get_ID() {
		return _ID;
	}

	public void set_ID(int _ID) {
		this._ID = _ID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPrefr() {
		return prefr;
	}

	public void setPrefr(String prefr) {
		this.prefr = prefr;
	}

	public int getCc_id() {
		return cc_id;
	}

	public void setCc_id(int cc_id) {
		this.cc_id = cc_id;
	}


}
