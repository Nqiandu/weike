package com.dlg.proj.demo.controller;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.util.VerificationCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/dx")

public class VerificationCodeController {
    /**
     * 获取图片验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/get")
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VerificationCode verificationCode = new VerificationCode();
        //获取验证码图片
        BufferedImage image = verificationCode.getImage();
        //获取验证码内容
        String text = verificationCode.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("signcode", randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image, "jpeg", sos);
        sos.flush();
        sos.close();
    }

    /**
     * 验证图片验证码
     * @param request
     * @param signcode
     * @return
     */

    @RequestMapping("/check")
    public Result check(HttpServletRequest request, String signcode) {
        HttpSession session = request.getSession();
        String signcodeSession = (String) session.getAttribute("signcode");
        if (signcode == null) {
            return new Result(null,"-100","获取失败！",0);
        }

        if (signcodeSession == null) {
            return new Result(null,"-100","获取失败！",0);
        }
        //验证的时候不区分大小写
        if (signcode.equalsIgnoreCase(signcodeSession)) {

            return new Result(null,"200","验证成功！",0);
        }
        return new Result(null,"-100","验证失败！",0);
    }
}



