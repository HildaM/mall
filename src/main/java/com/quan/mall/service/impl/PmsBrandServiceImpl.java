package com.quan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.quan.mall.mbg.mapper.PmsBrandMapper;
import com.quan.mall.mbg.model.PmsBrand;
import com.quan.mall.mbg.model.PmsBrandExample;
import com.quan.mall.service.PmsBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName: PmsBrandServiceImpl
 * @Description:
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 16:17
 */

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }


    // 自己写的测试
    @Override
    public List<PmsBrand> testList(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        // 生成条件类
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        // 传条件的主要类
        PmsBrandExample.Criteria criteria = pmsBrandExample.createCriteria();

        // 数据判定
        if (!StringUtils.isNotEmpty(name)) {
            criteria.andNameEqualTo(name);
        }

        // 执行指定的sql
        return brandMapper.selectByExample(pmsBrandExample);
    }
}

