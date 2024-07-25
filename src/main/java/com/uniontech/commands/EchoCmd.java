package com.uniontech.commands;

import com.uniontech.common.Com;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author ut000198
 * @date 2024/06/12
 * @description 输出文本命令
 */
@Command(
        name = "echo",
        mixinStandardHelpOptions = true,
        description = "用于打印输出文本",
        version = Com.VERSION
)
public class EchoCmd implements Callable<Integer> {

    @Option(names = {"-t", "--text"}, description = "打印输入文本")
    private String text;

    @Override
    public Integer call() throws Exception {
        System.out.println(text);
        return 0;
    }
}
