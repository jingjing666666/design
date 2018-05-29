package com.jingjing.manage.web;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Result;
import com.jingjing.manage.dto.PictureDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.PageBean;
import com.jingjing.manage.entity.Picture;
import com.jingjing.manage.service.PictureService;
import com.jingjing.manage.util.ResponseUtil;
import com.jingjing.manage.common.ResultGenerator;
import com.jingjing.manage.util.DateUtil;
import org.apache.log4j.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by yuanqingjing on 2018/4/9
 */
@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Resource
    private PictureService pictureService;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(PictureController.class);// 日志文件

    /**
     * 查找图片列表
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<PictureDto> articleList(@RequestParam(value="page",required=false,defaultValue="1") Integer page , @RequestParam(value="pageSize",required=false,defaultValue="10") Integer pageSize, @RequestParam(value="type",required=false,defaultValue="1") Integer type){
        return pictureService.pictureList(page, pageSize,type);
    }

    /**
     * 添加一张图片
     *
     * @param picture
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Picture picture) {
        Integer resultTotal = pictureService.addPicture(picture);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     *
     * @param picture
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Picture picture ) {
        int resultTotal = 0;

        resultTotal = pictureService.updatePicture(picture);

        log.info("request: picture/update , " + picture.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("id") String id)  {
        if (id.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = id.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            pictureService.deletePicture(Integer.parseInt(idsStr[i]));
        }
        log.info("request: picture/delete , ids: " + id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据id查找
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id") Integer id)  {
        Picture picture = pictureService.findById(id);
        log.info("request: picture/findById");
        if (picture != null) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(picture);
            return result;
        } else {
            return ResultGenerator.genFailResult("无资源");
        }
    }


/**
 * -------------------------------------------------------------------------------------------------------------------
 */








//    /**
//     * 查找相应的数据集合
//     *
//     * @param page
//     * @param rows
//     * @param picture
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/datagrid")
//    public String list(
//            @RequestParam(value = "page", required = false) String page,
//            @RequestParam(value = "rows", required = false) String rows,
//            Picture picture, HttpServletResponse response) throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (page != null && rows != null) {
//            PageBean pageBean = new PageBean(Integer.parseInt(page),
//                    Integer.parseInt(rows));
//            map.put("start", pageBean.getStart());
//            map.put("size", pageBean.getPageSize());
//        }
//        if (picture != null) {
//            map.put("id", picture.getId() + "");
//            map.put("type", picture.getType() + "");
////            map.put("grade", picture.getGrade() + "");
//        }
//        List<Picture> pictureList = pictureService.findPicture(map);
//        Long total = pictureService.getTotalPicture(map);
//        JSONObject result = new JSONObject();
//        JSONArray jsonArray = JSONArray.fromObject(pictureList);
//        result.put("rows", jsonArray);
//        result.put("total", total);
//        log.info("request: pictures/datagrid , map: " + map.toString());
//        ResponseUtil.write(response, result);
//        return null;
//    }
//
//    /**
//     * 查找相应的数据集合
//     *
//     * @param page
//     * @param rows
//     * @param picture
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Result list(
//            @RequestParam(value = "page", required = false) String page,
//            @RequestParam(value = "rows", required = false) String rows,
//            Picture picture) throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (page != null && rows != null) {
//            PageBean pageBean = new PageBean(Integer.parseInt(page),
//                    Integer.parseInt(rows));
//            map.put("start", pageBean.getStart());
//            map.put("size", pageBean.getPageSize());
//        }
//        if (picture != null) {
//            map.put("id", picture.getId() + "");
//            map.put("type", picture.getType() + "");
////            map.put("grade", picture.getGrade() + "");
//        }
//        List<Picture> pictureList = pictureService.findPicture(map);
//        Result result = ResultGenerator.genSuccessResult();
//        Long total = pictureService.getTotalPicture(map);
//        Map data = new HashMap();
//        data.put("rows", pictureList);
//        data.put("total", total);
//        log.info("request: picture/list , map: " + map.toString());
//        result.setData(data);
//        return result;
//    }
//
//
//    /**
//     * 添加
//     *
//     * @param picture
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    @ResponseBody
//    public Result save1(@RequestBody Picture picture)
//            throws Exception {
//        int resultTotal = 0;
//
////        picture.setTime(DateUtil.getCurrentDateStr());
//
//        resultTotal = pictureService.addPicture(picture);
//
//        log.info("request: picture/save , " + picture.toString());
//
//        if (resultTotal > 0) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("添加失败");
//        }
//    }
//
//    /**
//     * 修改
//     *
//     * @param picture
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "", method = RequestMethod.PUT)
//    @ResponseBody
//    public Result update1(@RequestBody Picture picture)
//            throws Exception {
//        int resultTotal = 0;
//
////        picture.setTime(DateUtil.getCurrentDateStr());
//
//        resultTotal = pictureService.updatePicture(picture);
//
//        log.info("request: picture/update , " + picture.toString());
//
//        if (resultTotal > 0) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("修改失败");
//        }
//    }
//
//
//    /**
//     * 删除
//     *
//     * @param ids
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public Result delete1(@PathVariable(value = "ids") String ids
//    ) throws Exception {
//        if (ids.length() > 20) {
//            return ResultGenerator.genFailResult("ERROR");
//        }
//        String[] idsStr = ids.split(",");
//        for (int i = 0; i < idsStr.length; i++) {
//            pictureService.deletePicture(Integer.parseInt(idsStr[i]));
//        }
//        log.info("request: picture/delete , ids: " + ids);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    /**
//     * 根据id查找
//     *
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Result findById1(@PathVariable("id") Integer id) throws Exception {
//        Picture picture = pictureService.findById(id);
//        log.info("request: picture/findById");
//        if (picture != null) {
//            Result result = ResultGenerator.genSuccessResult();
//            result.setData(picture);
//            return result;
//        } else {
//            return ResultGenerator.genFailResult("无资源");
//        }
//    }
}