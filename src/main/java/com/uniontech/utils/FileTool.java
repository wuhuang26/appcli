package com.uniontech.utils;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.uniontech.common.Com;

import java.nio.file.StandardCopyOption;

/**
 * @author ut000198
 * @date 2024/06/12
 * @description 文件执行的工具类
 */
public class FileTool {

    public boolean fileExist(String path) {
        return FileUtil.exist(path);
    }

    public boolean dirDel(String path) {
        try {
            return FileUtil.clean(path);
        }catch (Exception e) {
            System.out.println(Com.ERROR_DELETE_DIR+e.toString());
            return false;
        }
    }

    public boolean fileCopy(String srcPath, String targetPath) {
        try {
            FileUtil.copyFile(srcPath, targetPath, StandardCopyOption.COPY_ATTRIBUTES);
            return true;
        }catch (Exception e) {
            System.out.println(Com.ERROR_COPY_FILE+e.toString());
            return false;
        }
    }

    public boolean decompressDeb(String path) {
        try{
            ShellTool shellTool = new ShellTool();
            String cmd = "dpkg -x " + path + " " + Com.DEB_WORK_DIR;
            String result = shellTool.runCmdStr(cmd);
            return !StrUtil.contains(result, "Exception");
        }catch (Exception e) {
            System.out.println(Com.ERROR_DECOMPRESS_DEB+e.toString());
            return false;
        }
    }

    public void mkDir(String path){
        try{
            FileUtil.mkdir(path);
        }catch (Exception e){
            System.out.println(Com.ERROR_MAKE_DIR+e.toString());
        }
    }

}
