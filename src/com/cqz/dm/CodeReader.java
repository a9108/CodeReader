package com.cqz.dm;

/**
 * 开发者赚钱平台:www.uuwise.com
 * 更多函数细节：dll.uuwise.com
 * 
 */

public class CodeReader
{
	public static String getImgCode(String picPath,int code){
		try{
			UUAPI.SOFTID = 103955;
			UUAPI.SOFTKEY = "961e89ffaf004720981bfaa60e22cd60";	//KEY 获取方式：http://dll.uuwise.com/index.php?n=ApiDoc.GetSoftIDandKEY
			UUAPI.DLLVerifyKey = "7BE1A6AF-249D-4272-BBBE-A3DAB7927E39";//校验API文件是否被篡改，实际上此值不参与传输，关系软件安全，高手请实现复杂的方法来隐藏此值，防止反编译,获取方式也是在后台获取软件ID和KEY一个地方
			
			UUAPI.USERNAME = "cxz2004";		//用户帐号和密码(非开发者帐号)，在打码之前，需要先设置好，给用户留一个输入帐号和密码的地方
			UUAPI.PASSWORD = "cat12321";
		
			
			boolean status=UUAPI.checkAPI();	//校验API，必须调用一次，校验失败，打码不成功
			
			if(!status){
				System.out.print("API文件校验失败，无法使用打码服务");
				return "";
			}
			//识别开始
			String result[]=UUAPI.easyDecaptcha(picPath, code);//picPath是图片路径,1004是codeType,http://www.uuwise.com/price.html
			
			System.out.println("Image Code Result : "+result[1]);
			return result[1];
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
}
