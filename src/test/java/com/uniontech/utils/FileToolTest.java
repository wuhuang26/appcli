package com.uniontech.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileToolTest {

    FileTool fileTool = new FileTool();
    String localPath = "/tmp/test";


    @Test
    public void testFileExist() {
        boolean ret = fileTool.fileExist(localPath);
        assertTrue(ret);
    }


    @Test
    public void testDirDel(){
        boolean ret = fileTool.dirDel(localPath);
        assertTrue(ret);
    }

    @Test
    public void testCopyFile(){
        boolean ret = fileTool.fileCopy("/home/uos/Downloads/com.postman.postman_10.24_amd64.deb",
                "/tmp/test/");
        assertTrue(ret);
    }

    @Test
    public void testDecompressDeb() {
        boolean ret = fileTool.decompressDeb("/home/uos/Downloads/com.postman.postman_10.24_amd64.deb");
        assertTrue(ret);
    }

    @Test
    public void testMkDir(){
        fileTool.mkDir(localPath);
        boolean ret = fileTool.fileExist(localPath);
        assertTrue(ret);
    }

}