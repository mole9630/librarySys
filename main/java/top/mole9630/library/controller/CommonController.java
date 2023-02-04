package top.mole9630.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.mole9630.library.common.Result;
import top.mole9630.library.utils.CreateCAPTCHAImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 文件上传和下载
 */
@RestController
@RequestMapping("/common")
@Api(tags = "文件上传和下载相关接口")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 文件上传
     * @param file 文件
     * @return 文件名
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> update(MultipartFile file) { // 变量名file必须和input标签name一致
        // file是一个临时文件, 需要转存到指定位置, 否则本次请求完成后临时文件会删除
        // 处理文件名
        String originalFilename = file.getOriginalFilename(); // 获取原始文件名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 使用UUID重新生成文件名, 避免文件名重复被覆盖
        String fileName = UUID.randomUUID().toString() + suffix;

        // 生成文件夹
        File dir = new File(basePath);
        // 判断目录是否存在
        if (!dir.exists()) {
            // 不存在则创建
            dir.mkdirs();
        }
        try {
            // 将临时文件转存到指定位置
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.getMessage();
        }
        return Result.success(fileName);
    }

    /**
     * 文件下载
     * @param name 文件名
     * @param response 响应
     */
    @GetMapping("/download")
    @ApiOperation("文件下载")
    public void download(String name, HttpServletResponse response) {
        try {
            // 输入流-通过输入流读取文件内容
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            // 输出流-通过输出流将文件内容写出到浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg"); // 设置响应头, 告诉浏览器文件类型

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len); // 写入bytes数组的0到len位置的内容
                outputStream.flush(); // 刷新缓冲区
            }

            // 关闭输入输出流
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取图形验证码
     * @param request 请求
     * @param response 响应
     * @return 图形验证码
     */
    @GetMapping("/getVerifiCodeImage")
    @ApiOperation("获取图形验证码")
    public Result<String> getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response){
        BufferedImage verifiCodeImage = CreateCAPTCHAImage.getVerifiCodeImage();
        String verifiCode = new String(CreateCAPTCHAImage.getVerifiCode()).toLowerCase();
        // 将验证码存入session
//        HttpSession session = request.getSession();
//        session.setAttribute("verifiCode",verifiCode);

        // 将验证码存入redis
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String key = "imgCAPTCHA_" + uuid; // 设置验证码的key
        redisTemplate.opsForValue().set(key, verifiCode, 30, TimeUnit.MINUTES); // 设置验证码的有效时间为30分钟

        try {
            ImageIO.write(verifiCodeImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(uuid);
    }
}
