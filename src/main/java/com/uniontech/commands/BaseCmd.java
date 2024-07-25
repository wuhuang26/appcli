package com.uniontech.commands;

import picocli.CommandLine.Command;




/**
 * @author ut000198
 * @date 2024/06/12
 * @description 命令基础类用于包含所有命令
 */
@Command(
        subcommands = {
                EchoCmd.class,
                AppCheckCmd.class
        }
)
public class BaseCmd {
}
