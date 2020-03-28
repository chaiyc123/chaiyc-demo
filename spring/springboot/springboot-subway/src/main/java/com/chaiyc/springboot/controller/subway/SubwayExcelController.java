package com.chaiyc.springboot.controller.subway;

import com.alibaba.fastjson.JSONObject;
import com.chaiyc.springboot.entities.subway.Subway;
import com.chaiyc.springboot.service.subway.SubwayService;
import com.chaiyc.springboot.utils.DateUtil;
import com.chaiyc.springboot.utils.ExcelUtil;
import com.chaiyc.springboot.utils.FileUtil;
import com.chaiyc.springboot.utils.ResponseUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/subway")
public class SubwayExcelController {

    @Autowired
    SubwayService subwayService;


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
            filePath = new ClassPathResource("static/excel_templates/subway.xls").getFile().getPath();

            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(xlsName, "UTF-8"));

            fio=new FileInputStream(filePath);//将模板读入流
            sos = response.getOutputStream();
            wb = new HSSFWorkbook(fio);

            wb.write(sos);// 写入
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sos.flush();
            sos.close();
            fio.close();
        }
    }

    /**
     * 跳转到导入页面
     * @return
     */
    @RequestMapping("/toImportDialog")
    public String toImportDialog(){

        return "subway/subway_import";
    }


    /**
     * 接受文件   解析  上传资料。
     * @param file
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadExcel")
    public String upload_excel(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpServletRequest request)throws Exception {
        JSONObject result = new JSONObject();
        String filePath = "";
        System.out.println(file.getOriginalFilename());

        if(!file.isEmpty()){
            filePath = new ClassPathResource("static/excel_templates/subway.xls").getFile().getPath();

            //把文件名子换成（时间搓.png）
            // String imageName="houtai_logo."+file.getOriginalFilename().split("\\.")[1];
            String fileName= DateUtil.formatDate(new Date(), "yyyyMMdd-HHmmssSSS")+"_"+file.getOriginalFilename();

            FileUtil.makeDirs(filePath);
            //保存服务器
            file.transferTo(new File(filePath+fileName));

            //解析
            List<Subway> list =  excel_to_clientInfo(new File(filePath+fileName));

            //开始 上传 数据库
            for(Subway Subway:list) {
                subwayService.importSubway(Subway);
            }

            //删除用过的文件
            FileUtil.deleteFile(filePath+fileName);
        }
        result.put("success", true);
        result.put("msg", "导入成功");
        return "redirect:/subway/list";
    }

    /**
     * 解析 excel 中的数据，返回数据集合
     * @param userUploadFile
     * @return
     * @throws ParseException
     */
    private List<Subway> excel_to_clientInfo(File userUploadFile) throws ParseException {
        List<Subway> list = new ArrayList<Subway>();
        Subway Subway = null;
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(userUploadFile));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            //获取第一个sheet页
            HSSFSheet sheet = wb.getSheetAt(0);
            if(sheet!=null){
                for(int rowNum =1;rowNum<=sheet.getLastRowNum();rowNum++){
                    HSSFRow row = sheet.getRow(rowNum);
                    if(row==null){
                        continue;
                    }
                    Subway  = new Subway();

                    //去掉编码中的  .0 如果全是数字 后面有.0

                    Subway.setCheckName(ExcelUtil.formatCell(row.getCell(0)));
                    Subway.setCheckPhone(ExcelUtil.formatCell(row.getCell(0)));
                    Subway.setCheckStation(ExcelUtil.formatCell(row.getCell(0)));
                    Subway.setRemark(ExcelUtil.formatCell(row.getCell(0)));
                    Subway.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));

                    list.add(Subway);
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 导出数据
     * @return
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String filePath = new ClassPathResource("static/excel_templates/subway.xls").getFile().getPath();

        List<Subway> list = subwayService.getQuerySubway();

        Workbook wb = fillExcelDataWithTemplate(list,filePath);

        String date = DateUtil.formatDate(new Date(), "yyyy-MM-dd");

        ResponseUtil.export(response,wb,date+"兰州地铁检查数据.xls");
        return null;
    }


    /**
     *  组装导出数据
     * @return
     */
    public static Workbook fillExcelDataWithTemplate(List<Subway> list , String templateFileUrl) {

        Workbook wb = null ;
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFileUrl));
            wb = new HSSFWorkbook(fs);
            // 取得 模板的 第一个sheet 页
            Sheet sheet = wb.getSheetAt(0);
            // 拿到sheet页有 多少列
            int cellNums = sheet.getRow(0).getLastCellNum();
            // 从第2行 开搞    下标1  就是第2行
            int rowIndex = 1;
            Row row ;
            for(Subway subway : list){
                row = sheet.createRow(rowIndex);
                rowIndex ++;

                row.createCell(0).setCellValue(subway.getCheckName());
                row.createCell(1).setCellValue(subway.getCheckPhone());
                row.createCell(2).setCellValue(subway.getCheckStation());
                row.createCell(3).setCellValue(subway.getRemark());
                row.createCell(4).setCellValue(subway.getCreateTime());




            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
}
