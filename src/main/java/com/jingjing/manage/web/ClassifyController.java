package com.jingjing.manage.web;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Result;
import com.jingjing.manage.common.ResultGenerator;
import com.jingjing.manage.entity.Classify;
import com.jingjing.manage.service.ClassifyService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanqingjing on 2018/5/6
 */
@Controller
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(ArticleController.class);// 日志文件

    /**
     * 查找文章列表
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Classify> list(@RequestParam(value="page",required=false,defaultValue="1") Integer page , @RequestParam(value="pageSize",required=false,defaultValue="10") Integer pageSize){
        return classifyService.list(page, pageSize);
    }

    /**
     * 添加
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Classify classify) {
        Integer resultTotal = classifyService.addClassify(classify);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Classify classify) {
        int resultTotal = 0;

        resultTotal = classifyService.updateClassify(classify);

        log.info("request: article/update , " + classify.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
    /**
     * 删除
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("id")  Integer id)  {


            classifyService.deleteClassify(id);

        log.info("request: classify/delete , id: " + id);
        return ResultGenerator.genSuccessResult();
    }
    /**
     * 获取三级分类
     */
    @RequestMapping(value = "/getLevel/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Classify> getLevel(@PathVariable("id") Integer id)  {
        if (id<0||id>3){
            return null;
        }
        return classifyService.getLevel(id);
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
        Classify classify = classifyService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(classify);
        return result;
    }

    /**
     * 根据父类id查找
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findchildren/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Classify> findchildren(@PathVariable("id") Integer id)  {
        return classifyService.findchildren(id);

    }

}
