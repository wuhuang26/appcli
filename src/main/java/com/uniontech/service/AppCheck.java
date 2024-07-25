package com.uniontech.service;

import cn.hutool.log.StaticLog;
import com.uniontech.common.Com;
import com.uniontech.utils.FileTool;


/**
 * @author ut000198
 * @date 2024/06/12
 * @description app检查执行流程类
 */
public class AppCheck {

    // 定义打印日式类
    private void logInfo(String msg){
        StaticLog.info(msg, Com.INFO);
    }

    // 运行检查app的主程序方法
    public boolean run(String filePath){
        logInfo("检查环境检测中");
        FileTool fileTool = new FileTool();
        boolean notExist = !fileTool.fileExist(Com.DEB_WORK_DIR);
        if (notExist) {
            logInfo("临时处理目录不存在创建中");
            fileTool.mkDir(Com.DEB_WORK_DIR);
        }
        logInfo("环境初始化完成");
        boolean copyFail = !fileTool.fileCopy(filePath, Com.DEB_WORK_DIR);
        logInfo("app软件包解压中");
        if (copyFail) {
            logInfo("文件加压到工作目录失败，请检查目录权限或执行权限后再重新直行脚本");
            return false;
        }



        return true;
    }
}
