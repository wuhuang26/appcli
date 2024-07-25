package com.uniontech.utils;

import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import com.uniontech.common.Com;

import java.util.List;

/**
 * @author ut000198
 * @date 2024/06/12
 * @description 用于执行linux的shell命令工具类
 */
public class ShellTool {

    public String runCmdStr(String args) {
        try {
            return RuntimeUtil.execForStr(args);
        } catch (Exception e) {
            return e.toString();
        }
    }

    public List<String> findFilePath(String path, String condition) {
        try {
            String cmd = StrUtil.format("find {} -name {}", path, condition);
            return RuntimeUtil.execForLines(cmd);
        } catch (Exception e) {
            System.out.println(Com.NOT_FOUND_FIND_FILE + e.toString());
            return null;
        }
    }

    public List<String> lddFileInfo(String path) {
        try {
            String cmd = "ldd " + path;
            return RuntimeUtil.execForLines(cmd);
        } catch (Exception e) {
            System.out.println(Com.ERROR_LDD_FILE + e.toString());
            return null;
        }
    }

}
