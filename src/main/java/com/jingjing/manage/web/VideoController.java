package com.jingjing.manage.web;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Result;
import com.jingjing.manage.dto.VideoDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Video;
import com.jingjing.manage.common.ResultGenerator;
import com.jingjing.manage.param.PageParam;
import com.jingjing.manage.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
/**
 * Created by yuanqingjing on 2018/4/9
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;
    /**
     * 查找视频列表
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<VideoDto> videoList(@RequestBody PageParam param){
        return videoService.list(param);
    }

    /**
     * 添加视频
     * @param video
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Video video){
        int resultTotal = 0;
        video.setCreateTime(new Date());
        resultTotal = videoService.addVideo(video);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


    /**
     * 修改
     * @param video
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Video video) {
        int resultTotal = 0;
        resultTotal = videoService.updateVideo(video);
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
     */
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            videoService.deleteVideo(Integer.parseInt(idsStr[i]));
        }
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
    public Result findById(@PathVariable("id") Integer id) throws Exception {
        Video video = videoService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(video);
        return result;
    }
}
