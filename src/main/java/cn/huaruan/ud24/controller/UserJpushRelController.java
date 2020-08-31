package cn.huaruan.ud24.controller;


import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.UserJpushRel;
import cn.huaruan.ud24.service.UserJpushRelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * ClassName: UserJpushRelController <br/>
 * Description: 极光用户关系 <br/>
 * date: 2020年3月11日 上午10:18:04 <br/>  
 *  
 * @author haiming.huang  
 *
 */
@Api(value = "极光用户关系",tags = {"极光用户关系"})
@RestController
@RequestMapping("/jpush/userJpushRel")
public class UserJpushRelController {
	
	@Autowired
	private UserJpushRelService userJpushRelService;

	@ApiOperation(value = "新增极光用户关系",notes = "userId,registrationId必填")
	@RequestMapping(value ="/insert",method=RequestMethod.POST)
	public ResultMessage insertUserJpushRel(@RequestBody UserJpushRel userJpushRel) {
		return userJpushRelService.insertUserJpushRel(userJpushRel);
	}


}
