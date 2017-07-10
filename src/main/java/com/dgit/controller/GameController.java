package com.dgit.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.domein.Criteria;
import com.dgit.domein.GameVo;
import com.dgit.domein.PageMaker;
import com.dgit.domein.SearchCriteria;
import com.dgit.service.GameService;
import com.dgit.util.MediaUtils;
import com.dgit.util.UploadFileUtils;

@Controller
public class GameController {

	@Autowired
	GameService service;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	
	
	@RequestMapping(value="/gameListPage", method=RequestMethod.GET)
	public String gameListPage(Criteria criteria, Model model) throws Exception{
		List<GameVo> list = service.listCriteria(criteria);
		model.addAttribute("list",list);
		
		PageMaker pageMaker= new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.totalGameCount());
		
		model.addAttribute("pageMaker",pageMaker);
		return "gameListPage";
	}
	

	@RequestMapping(value="/gameDetailPage", method=RequestMethod.GET)
	public String gameDetailPage(int gno,Model model) throws Exception{
		GameVo vo= service.gameReadSelectByNo(gno);
		model.addAttribute("gameVo",vo);
		return "gameDetailPage";
		
	}
	
	@RequestMapping(value="/gameCreate", method=RequestMethod.GET)
	public String gameCreateGet(){
		return "gameCreateInput";
	}
	
	
	
	
	@RequestMapping(value="/gameCreate", method=RequestMethod.POST)
	public String gameCreatePost(GameVo vo,List<MultipartFile> imgFiles,List<MultipartFile> titlefile) throws Exception{
		if(imgFiles.get(0).getSize()!=0){
			vo.setsPath(registerImg(imgFiles,125).toArray(new String[registerImg(imgFiles,125).size()]));
		}
		if(titlefile.get(0).getSize()!=0){
			vo.setTitleImg(registerImg(titlefile,300).get(0));
		}
		service.gameCreate(vo);
		return "redirect:gameListPage";
	}
	
	
	@RequestMapping(value="/gameModify", method=RequestMethod.GET)
	public String gameModifyGet(int gno,Model model) throws Exception{
		GameVo vo= service.gameReadSelectByNo(gno);
		model.addAttribute("GameVo",vo);
		return "gameModifyInput";
	}
	
	@RequestMapping(value="/gameModify",method=RequestMethod.POST)
	public String gameModifyPost(GameVo vo /*,@ModelAttribute SearchCriteria searchCriteria*/) throws Exception{
		service.gameModify(vo);
		return "gameModifyInput";
	}
	
	@ResponseBody
	@RequestMapping(value="displayFile") //displayFile?filename=******.jpg
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity=null;
		InputStream in = null;
		try{
			
			String formetName= filename.substring(filename.lastIndexOf(".")+1);
			MediaType mtype= MediaUtils.getMediaType(formetName);
			HttpHeaders header= new HttpHeaders();
			header.setContentType(mtype);
			
			in= new FileInputStream(uploadPath+"/"+filename);
			entity= new ResponseEntity<byte[]>(IOUtils.toByteArray(in),header,HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entity;
	}
	
	
	@ResponseBody
	@RequestMapping(value="displayTitleFile") //displayFile?filename=******.jpg
	public ResponseEntity<byte[]> displayTitleFile(String filename){
		ResponseEntity<byte[]> entity=null;
		InputStream in = null;
		try{
			
			String formetName= filename.substring(filename.lastIndexOf(".")+1);
			MediaType mtype= MediaUtils.getMediaType(formetName);
			HttpHeaders header= new HttpHeaders();
			header.setContentType(mtype);
			
			String front=filename.substring(0,12);
			String end= filename.substring(14);
			
			in= new FileInputStream(uploadPath+"/"+front+end);
			entity= new ResponseEntity<byte[]>(IOUtils.toByteArray(in),header,HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return entity;
	}
	
	
	
	
	@RequestMapping(value="calList" ,method=RequestMethod.GET)
	public String calender() throws Exception{
		return "cal";
	}
	
	@ResponseBody
	@RequestMapping(value="calendarAjax",method=RequestMethod.POST)
	public ResponseEntity<List<GameVo>> calenderStartList() throws Exception{
		ResponseEntity<List<GameVo>> entity=null;
		List<GameVo> list= service.saleListPage();
		try{
			entity= new ResponseEntity<List<GameVo>>(list, HttpStatus.OK);
		}catch(Exception e){
			entity= new ResponseEntity<List<GameVo>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
		// 이미지 등록
		private List<String> registerImg(List<MultipartFile> imgFiles,int size) throws IOException{
			ArrayList<String> list = new ArrayList<>();
			for(MultipartFile file: imgFiles){	
				
			String thumb = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes(),size);
			list.add(thumb);
			}
			
			return list;
		}
		
		// 파일삭제
		private String[] deleteFile(String[] files){
			for(int i=0;i<files.length;i++){
				if(!files[i].equals("")){
					File file= new File(uploadPath+files[i]);
					file.delete();
					
					String front=files[i].substring(0,12);
					String end= files[i].substring(14);
					
					String originFileName=front+end;
					File fileorigin= new File(uploadPath+originFileName) ;
					fileorigin.delete();
				}
			}
			return files;
		}

}
