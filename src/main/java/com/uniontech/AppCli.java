package com.uniontech;

import com.uniontech.commands.BaseCmd;
import picocli.CommandLine;

/**
 * @author ut000198
 * @date 2024/06/12
 * @description 主程序入口
 */
public class AppCli {

    public static void main(String[] args) {

        int exitCode = new CommandLine(new BaseCmd()).execute(args);
        System.exit(exitCode);
    }

}