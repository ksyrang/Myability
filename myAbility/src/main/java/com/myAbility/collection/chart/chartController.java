package com.myAbility.collection.chart;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.myAbility.collection.chart.DAO.googlechartDTO;

@Controller
public class chartController {
	
	
	@PostMapping("testProc")
	public String testProc(Model model) {
		
		Gson gson = new Gson();
		googlechartDTO reperenceDTO = new googlechartDTO();
		reperenceDTO.addColumn("", "string"); //가로축 명칭 정의
		reperenceDTO.addColumn("금년매출", "number"); // 컬럼
		reperenceDTO.createRows(2);//갯수만큼 묶음 row 생성
		reperenceDTO.addCell(0,"Cell1_mid","Cell1_right");
		reperenceDTO.addCell(0,100);
		reperenceDTO.addCell(1,"Cell2_mid","Cell2_right");
		reperenceDTO.addCell(1,200);
		
//		String jSon = gson.toJson(reperenceDTO.getResult());
		
		HashMap<String, Object> testmap = new HashMap<String, Object>();
		HashMap<String, Object> innertestmap = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> testlist = new ArrayList<HashMap<String, Object>>();
		
		//구글 차트DTO의 cols 형식 : Map(List(Map))형태로 구성되어야 함
		innertestmap.put("innertest key", "innertestvalue");
		testlist.add(innertestmap);

		testmap.put("cols", testlist);
		
		
		//구글 차트DTO의 cols 형식 : Map(List(Map(List(Map)))형태로 구성되어야 함
		
		
		String jSon = gson.toJson(testmap);
		System.out.println(jSon);
		return "redirect:/index?formpath=findInfo";
	}

}
