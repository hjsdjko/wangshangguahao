
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yisheng")
public class YishengController {
    private static final Logger logger = LoggerFactory.getLogger(YishengController.class);

    @Autowired
    private YishengService yishengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("yishengDeleteStart",1);params.put("yishengDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yishengService.queryPage(params);

        //字典表数据转换
        List<YishengView> list =(List<YishengView>)page.getList();
        for(YishengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishengEntity yisheng = yishengService.selectById(id);
        if(yisheng !=null){
            //entity转view
            YishengView view = new YishengView();
            BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("yisheng_uuid_number", yisheng.getYishengUuidNumber())
            .eq("yisheng_name", yisheng.getYishengName())
            .eq("yisheng_types", yisheng.getYishengTypes())
            .eq("zhiwei_types", yisheng.getZhiweiTypes())
            .eq("yisheng_shanchang", yisheng.getYishengShanchang())
            .eq("shangxia_types", yisheng.getShangxiaTypes())
            .eq("yisheng_clicknum", yisheng.getYishengClicknum())
            .eq("yisheng_delete", yisheng.getYishengDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity==null){
            yisheng.setShangxiaTypes(1);
            yisheng.setYishengClicknum(1);
            yisheng.setYishengDelete(1);
            yisheng.setCreateTime(new Date());
            yishengService.insert(yisheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .notIn("id",yisheng.getId())
            .andNew()
            .eq("yisheng_uuid_number", yisheng.getYishengUuidNumber())
            .eq("yisheng_name", yisheng.getYishengName())
            .eq("yisheng_types", yisheng.getYishengTypes())
            .eq("zhiwei_types", yisheng.getZhiweiTypes())
            .eq("yisheng_shanchang", yisheng.getYishengShanchang())
            .eq("shangxia_types", yisheng.getShangxiaTypes())
            .eq("yisheng_clicknum", yisheng.getYishengClicknum())
            .eq("yisheng_delete", yisheng.getYishengDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if("".equals(yisheng.getYishengPhoto()) || "null".equals(yisheng.getYishengPhoto())){
                yisheng.setYishengPhoto(null);
        }
        if(yishengEntity==null){
            yishengService.updateById(yisheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<YishengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YishengEntity yishengEntity = new YishengEntity();
            yishengEntity.setId(id);
            yishengEntity.setYishengDelete(2);
            list.add(yishengEntity);
        }
        if(list != null && list.size() >0){
            yishengService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YishengEntity> yishengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YishengEntity yishengEntity = new YishengEntity();
//                            yishengEntity.setYishengUuidNumber(data.get(0));                    //医生编号 要改的
//                            yishengEntity.setYishengName(data.get(0));                    //医生名称 要改的
//                            yishengEntity.setYishengPhoto("");//照片
//                            yishengEntity.setYishengTypes(Integer.valueOf(data.get(0)));   //科室 要改的
//                            yishengEntity.setZhiweiTypes(Integer.valueOf(data.get(0)));   //职位 要改的
//                            yishengEntity.setYishengShanchang(data.get(0));                    //擅长 要改的
//                            yishengEntity.setYishengContent("");//照片
//                            yishengEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            yishengEntity.setYishengClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            yishengEntity.setYishengDelete(1);//逻辑删除字段
//                            yishengEntity.setCreateTime(date);//时间
                            yishengList.add(yishengEntity);


                            //把要查询是否重复的字段放入map中
                                //医生编号
                                if(seachFields.containsKey("yishengUuidNumber")){
                                    List<String> yishengUuidNumber = seachFields.get("yishengUuidNumber");
                                    yishengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yishengUuidNumber = new ArrayList<>();
                                    yishengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yishengUuidNumber",yishengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //医生编号
                        List<YishengEntity> yishengEntities_yishengUuidNumber = yishengService.selectList(new EntityWrapper<YishengEntity>().in("yisheng_uuid_number", seachFields.get("yishengUuidNumber")).eq("yisheng_delete", 1));
                        if(yishengEntities_yishengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YishengEntity s:yishengEntities_yishengUuidNumber){
                                repeatFields.add(s.getYishengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医生编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yishengService.insertBatch(yishengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yishengService.queryPage(params);

        //字典表数据转换
        List<YishengView> list =(List<YishengView>)page.getList();
        for(YishengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishengEntity yisheng = yishengService.selectById(id);
            if(yisheng !=null){

                //点击数量加1
                yisheng.setYishengClicknum(yisheng.getYishengClicknum()+1);
                yishengService.updateById(yisheng);

                //entity转view
                YishengView view = new YishengView();
                BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("yisheng_uuid_number", yisheng.getYishengUuidNumber())
            .eq("yisheng_name", yisheng.getYishengName())
            .eq("yisheng_types", yisheng.getYishengTypes())
            .eq("zhiwei_types", yisheng.getZhiweiTypes())
            .eq("yisheng_shanchang", yisheng.getYishengShanchang())
            .eq("shangxia_types", yisheng.getShangxiaTypes())
            .eq("yisheng_clicknum", yisheng.getYishengClicknum())
            .eq("yisheng_delete", yisheng.getYishengDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity==null){
            yisheng.setYishengDelete(1);
            yisheng.setCreateTime(new Date());
        yishengService.insert(yisheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
