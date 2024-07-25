package com.uniontech.commands;

import com.uniontech.common.Com;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author ut000198
 * @date 2024/06/12
 * @description 用于对app的deb包对比基线变动检查
 */
@Command(
        name = "appcheck",
        mixinStandardHelpOptions = true,
        description = "用于对app文件进行基线对比检查",
        version = Com.VERSION
)
public class AppCheckCmd implements Callable<Integer> {

    @Option(names = {"-f", "--file"}, required = true, description = "app检查的deb包文件路径")
    private String filePath;

    @Override
    public Integer call() throws Exception {
        System.out.println(filePath);
        return 0;
    }
}
