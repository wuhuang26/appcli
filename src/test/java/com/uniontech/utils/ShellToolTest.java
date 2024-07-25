package com.uniontech.utils;

import java.util.List;

import cn.hutool.core.util.StrUtil;
import com.uniontech.common.Com;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellToolTest {
    ShellTool shellTool = new ShellTool();

    @Test
    public void testRunCmdStr(){
        String str = shellTool.runCmdStr("sl");
        System.out.println(str);
        assertNotNull(str);
    }

    @Test
    public void testFindFilePath(){
        List<String> result = shellTool.findFilePath(Com.DEB_WORK_DIR, "*.so");
        for(String line: result){
            System.out.println(line);
        }
        System.out.println(result.size());
        assertNotNull(result);
    }

    @Test
    public void testLddFileInfo(){
        String path = "/tmp/app_deb_offline_check/opt/apps/com.postman.postman/files/Postman/app/libEGL.so";
        List<String> result = shellTool.lddFileInfo(path);
        for(String line: result){
            System.out.println(line);
            String[] names = StrUtil.splitToArray(line, " ");
            System.out.println(names[0]);
        }
        System.out.println(result.size());
        assertNotNull(result);
    }

}