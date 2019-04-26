package com.qdu.controller;

import com.qdu.pojo.Message;
import com.qdu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;


//留言板：去留言
@ResponseBody
@RequestMapping(value="user/toMessage", method = RequestMethod.POST)
public Message toMessage(String uid, String messageContent, HttpServletRequest request){
       uid= request.getParameter("uid");
      messageContent= request.getParameter("messageContent");
      messageService.toMessage(uid,messageContent);
        return messageService.getMessageById();
    }

}
