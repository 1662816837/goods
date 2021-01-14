package com.fh.goods.entity.vo;



//自定义的规范     ajax的请求  返回的都是json数据





//  {"status":,"info":,"data":}
public class ReponseData{
	private Integer code;
	
	private String message;
	
	private Object data;
	
	public ReponseData() {

	}
	
	
	public static ReponseData success(Object data) {
		ReponseData rs=new ReponseData();
		rs.setCode(200);
		rs.setMessage("处理成功");
		rs.setData(data);
		return  rs;
	}
	
	public static ReponseData error(String code) {
		ReponseData rs=new ReponseData();
		rs.setMessage(code);
		rs.setCode(500);
		rs.setData(null);
		return  rs;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
