package com.fh.goods.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UploadDown {
	
	/**
	 * 下载
	 * @param filePath
	 * @param fileName
	 * @param response 
	 * @param request 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void downLoad(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!StringUtils.isEmpty(filePath)){
			String realPath = request.getServletContext().getRealPath("");
			File f= new File(realPath+filePath);
			//判断图片是否存在
			if(f.exists()){
				//设置MIME类型
				//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据
				//application/octet-stream以流的形式下载 下载任意格式
				response.setContentType("application/octet-stream");			
				//或者为response.setContentType("application/x-msdownload");
				
				//设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
				response.addHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1"));
				
				InputStream inputStream=new FileInputStream(f);
				ServletOutputStream outputStream=response.getOutputStream();
				byte[] bs=new byte[1024];
				while((inputStream.read(bs)>0)){
					outputStream.write(bs);
				}
				outputStream.close();
				inputStream.close();	
			}
			
		}
	}
	
	/**
	 * 上传
	 * @param folderName 
	 * @param request 
	 * @param images 
	 * @return 
	 */
	public static Map<String, String> upload(MultipartFile images, HttpServletRequest request, String folderName) {
		Map<String, String> map = new HashMap<String, String>();
		//1. 设置上传路径
		String path=request.getServletContext().getRealPath(folderName);
		//创建图片文件夹
		File f = new File(path);
		//exists() 存在的意思
		if(!f.exists()){
			//mkdir() 创建文件夹
			f.mkdir();
		}
		//getOriginalFilename取真实文件名称
		String realFileName = images.getOriginalFilename();
		//取最后一个点的下标
		int lastIndexOf = realFileName.lastIndexOf(".");
		//根据下标截取到后缀名名称
		String hz= realFileName.substring(lastIndexOf);
		//生成一个随机的32位的字符串  当做图片名称
		String uuid= UUID.randomUUID().toString();
		//把32位的串和后缀名称进行拼接 拼成成一个新的虚拟名称
		// 为了防止上传同一张图片产生覆盖
		String falseFileName = uuid+hz;
		//把路径和文件名称放入到file中
		File file = new File(path+"/"+falseFileName);
		try {
			//transferTo 上传
			images.transferTo(file);
			map.put("filePath", "http://localhost:8080/"+folderName+"/"+falseFileName);
			map.put("fileName", realFileName);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	

}
