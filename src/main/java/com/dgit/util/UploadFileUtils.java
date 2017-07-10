package com.dgit.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	//파일의 폴더와 이름을 리턴한다
	public static String uploadFile(String uploadPath,String originalName,byte[] fileData,int size) throws IOException{
		UUID uid= UUID.randomUUID();
		String datePath=calcPath(uploadPath);
		
		String saveName=datePath+"/"+ uid.toString()+"_"+originalName;
		
		File target= new File(uploadPath, saveName);
		
		FileCopyUtils.copy(fileData, target);
		
		String thumbName= mkThumnail(uploadPath, datePath, uid.toString()+"_"+originalName,size);
		
		return thumbName; //2017/06/03/s_aaaaa_a.jpg
	}
	

	public static String calcPath(String uploadPath){
		Calendar cal= Calendar.getInstance();
		String yearPath="/"+cal.get(Calendar.YEAR);
		String monthPath= String.format("%s/%02d", yearPath, cal.get(Calendar.MONTH)+1);
		String dayPath= String.format("%s/%02d/%02d", yearPath, cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));
		
		
		mkDir(uploadPath,yearPath,monthPath,dayPath);
		
		return dayPath;
	}
	
	private static void mkDir(String uploadPath,String...paths){
		for(String path:paths){
			File dirPath= new File(uploadPath+path);
			if(!dirPath.exists()){
				dirPath.mkdirs();
			}
		}
	}
	
	

	private static String mkThumnail(String uploadPath,String datePath,String fileName, int size) throws IOException{
		String originName=uploadPath+"/"+datePath+"/"+fileName;
		BufferedImage sourceImg= ImageIO.read(new File(originName));
		
		//섬네일 이미지 높이를 뒤의 100px로 동일하게 만듬
		BufferedImage destImg= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,size);
		
		String thumbFileName= uploadPath+"/"+datePath+"/s_"+fileName;
		
		File newFile= new File(thumbFileName);
		
		String formatName=fileName.substring(fileName.lastIndexOf(".")+1);//확장자
		
		// Thumbnail 경로 / 파일 이름에 리사이징된 이미지를 넣는다
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return datePath+"/s_"+fileName;
	}
}
