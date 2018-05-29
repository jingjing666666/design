package com.jingjing.manage.web;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Result;
import com.jingjing.manage.common.ResultGenerator;
import com.jingjing.manage.dto.ArticleDto;
import com.jingjing.manage.dto.QiniuDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.param.PageParam;
import com.jingjing.manage.service.ArticleService;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by yuanqingjing on 2018/4/9
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {
    private static String accessKey = "hvZZC30YogLHCpiKcrzsq95kPQWRyfyE4ksof5k2";
    private static String secretKey = "LBjjw7v-LzS0pXePN3MOLeBYy5OOKYYzL6Bm5kjm";
    private static String bucket = "xuexunbao";
    private static String path = "http://oxpgahw70.bkt.clouddn.com/";
    @Resource
    private ArticleService articleService;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(ArticleController.class);// 日志文件
//    /**
//     * 查找文章列表
//     *
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping(value = "/lists", method = RequestMethod.GET)
//    @ResponseBody
//    public PageInfo<ArticleDto> articleList1(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize, @RequestParam(value = "type", required = false, defaultValue = "10") Integer type) {
//        return articleService.articleList(page, pageSize, type);
//    }

    /**
     * 查找文章列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    /**
     * 查找文章列表
     * @param page
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<ArticleDto> articleList(@RequestBody PageParam page) {
        return articleService.articleList(page);
    }


    @RequestMapping(value = "/system/qiniu", method = RequestMethod.GET)
    @ResponseBody
    public QiniuDto qiniuConfig() {
        QiniuDto qiniuDto = new QiniuDto();
        qiniuDto.setBucket(bucket);
        qiniuDto.setPath(path);
        Config.ACCESS_KEY = accessKey;
        Config.SECRET_KEY = secretKey;
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = bucket;
        PutPolicy putPolicy = new PutPolicy(bucketName);
        try {
            String uptoken = putPolicy.token(mac);
            qiniuDto.setUptoken(uptoken);
        } catch (Exception e) {
            System.out.println("异常");
        }
        return qiniuDto;
    }

    /**
     * 添加
     *
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Article article) {
        Integer resultTotal = articleService.addArticle(article);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     *
     * @param article
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Article article) {
        int resultTotal = 0;
        resultTotal = articleService.updateArticle(article);
        log.info("request: article/update , " + article.toString());
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            articleService.deleteArticle(Integer.parseInt(idsStr[i]));
        }
        log.info("request: article/delete , ids: " + ids);
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
    public Result findById(@PathVariable("id") Integer id) {
        Article article = articleService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(article);
        return result;
    }

}