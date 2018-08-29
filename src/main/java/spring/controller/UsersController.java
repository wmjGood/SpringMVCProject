package spring.controller;



import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.pojo.Users;
import spring.service.UserService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class UsersController {

   @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
      private  Logger logger=Logger.getLogger(UsersController.class);

    /*添加*/

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public  String addUser(@ModelAttribute("user")Users users ){
        return "addUsers";
    }

  @RequestMapping(value = "/add",method = RequestMethod.POST)
    public  String addUserSave(@Valid  Users user,BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return  "addUsers";
        }
        if ((userService.addUsers(user))>0){
            return "index";
        }
        return  "addUsers";
    }

 /*文件上传*/
/* @RequestMapping(value = "/add",method = RequestMethod.POST)
 public  String addUserSave(Users users, HttpSession session, HttpServletRequest request,
                            @RequestParam(value = "idpath",required = false) MultipartFile attach){
     String idpath=null;
     //判断是否有上传文件
     if (!attach.isEmpty()){
         //文件上传路径
         String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
           logger.info("uploadfile+----"+path);
         String oldFileName = attach.getOriginalFilename();  //原文件名
         logger.info("oldFileName------"+oldFileName);
         String prefix = FilenameUtils.getExtension(oldFileName);//获取原文件的后缀
         logger.info("prefix----"+prefix);
         int fileSize=500000;
         logger.debug("size-----"+attach.getSize());
         //上传文件不得超过500kb
         if(attach.getSize()>fileSize){
             request.setAttribute("uploadFileError","上传文件大小不能超过500kb");
             return "addUsers";
             //上传图片格式不正确
         }else if (prefix.equalsIgnoreCase("jpg")||prefix.equalsIgnoreCase("png")||
         prefix.equalsIgnoreCase("jpeg")||prefix.equalsIgnoreCase("pneg")){
             //文件名称
             String fileName = System.currentTimeMillis()+ RandomUtils.nextInt(0,1000000)+"_Personal.jpg";
             logger.debug("fileName----"+fileName);
             //创建文件
             File file=new File(path,fileName);
             //文件不存在就创建文件
             if (!file.exists()){

                 file.mkdirs();
             }
             //保存
             try {
                 //把MultipartFile中文件流的数据传输到目标文件中
                 attach.transferTo(file);

             } catch (IOException e) {
                 request.setAttribute("uploadFileError","上传失败");
                 e.printStackTrace();
             }
             //使用File.separator是为了在不同的此操作系统中（windows和Linux）自动适应路径分隔符，低入侵的代码实现
             idpath=path+File.separator+fileName;
             System.out.println(idpath+"--------------------------");
         }else{
             request.setAttribute("uploadFileError","上传图片格式不正确");
             return  "addUsers";
         }

     }
     users.setIdPicPath(idpath);
     if ((userService.addUsers(users))>0){
         return "index";
     }
     return  "addUsers";
 }*/

    //修改
    @RequestMapping(value = "/modifyUser",method = RequestMethod.GET)
    public  String getUserID(@RequestParam String id, Model model){
        Users user = userService.findUser(id);
        model.addAttribute(user);
        return  "modifyUser";
    }

    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
    public  String modifyUserSave(Users users,HttpSession session){
        if ((userService.updateUsers(users))>0){
            return "index";
        }
        return  "addUsers";
    }
}
