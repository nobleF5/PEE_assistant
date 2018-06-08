package com.jxufe.handler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jxufe.entity.EEDetails;
import com.jxufe.service.EEDetailsService;
import com.jxufe.util.ImageUtil;

@Controller
@RequestMapping(value="/eedetailsHandler")
public class EEDetailsHandler {

	@Autowired
	private EEDetailsService eEDetailsService;
	
	@RequestMapping(value="/queryeedetails", method = RequestMethod.GET)
	public String queryEEDetails(Map<String, Object> map) {
		List<EEDetails> eEDetails = eEDetailsService.findAll();
		map.put("eEDetails", eEDetails);
		return "foreui/PEE_assistant";
	}
	
	
	@RequestMapping(value="valicode")
	public void valicode(HttpServletResponse response, HttpSession session){
		Object[] obj = ImageUtil.createImage();
		
		String code = (String) obj[0];
		BufferedImage image = (BufferedImage)obj[1];
		response.setContentType("image/png");
		try {
			ImageIO.write(image, "png", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  	
}
