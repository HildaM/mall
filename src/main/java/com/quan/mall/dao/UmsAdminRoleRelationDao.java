package com.quan.mall.dao;

import com.quan.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UmsAdminRoleRelationDao
 * @Description: 后台用户与角色管理自定义Dao
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/15 16:41
 */

@Mapper
public interface UmsAdminRoleRelationDao {
    // 获取用户所有权限（包括+-权限）
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
