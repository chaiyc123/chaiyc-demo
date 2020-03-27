package com.chaiyc.springboot.controller.subway;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("/subway")
public class SubwayImport {


    /**
     * 模板下载
     * @return
     */
    @RequestMapping("/templateDownload")
    public void excelDown(HttpServletRequest request,
                          HttpServletResponse response) throws Exception{
        String filePath = "";
        String xlsName="兰州地铁检查模板.xls";

        OutputStream sos=null;
        FileInputStream fio=null;
        HSSFWorkbook wb = null;
        try{
            filePath = request.getServletContext().getRealPath("/") + "excel_templates/subway.xls";
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(xlsName, "UTF-8"));

            fio=new FileInputStream(filePath);//将模板读入流
            sos = response.getOutputStream();
            wb = new HSSFWorkbook(fio);

            wb.write(sos);// 写入
        }catch (Exception e){
            e.printStackTrace();
            //returnMsg("error", "模板下载失败！失败原因：" + e.getMessage(), request);
        }
    }
}
