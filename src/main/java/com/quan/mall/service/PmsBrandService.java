package com.quan.mall.service;

import com.quan.mall.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PmsBrandService
 * @Description: 品牌管理service
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/30 15:50
 */

@Service
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
