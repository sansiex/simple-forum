package job.test.forum.utils;

import org.apache.commons.cli.*;

/**
 * Created by yifan.cao on 2016/7/19.
 */
public class OptionUtil {
    private static final String formatstr = " [-t][-p][-e][-c][-l][-d][-s]";
    private static Options opt;


    private static Options getOption() {
        synchronized (OptionUtil.class) {
            if (opt == null)
            {
                opt = new Options();
                opt.addOption("t",false,"操作讨论\n加-c创建讨论，参数：用户ID，主题，内容\n-e编辑讨论，参数：讨论ID，主题，内容\n");
                opt.addOption("p",false,"操作回复\n加-c创建讨论，参数：用户ID，讨论ID，回复内容\n-e编辑讨论，参数：回复ID，回复内容\n");
                opt.addOption("e",true,"进行编辑操作，配合-t或-p使用");
                opt.addOption("c",true,"进行创建操作，配合-t或-p使用");
                opt.addOption("l",false,"展示讨论列表");
                opt.addOption("d",true,"展示讨论详情,加参数：讨论ID");
                opt.addOption("s",false,"调用脚本随机创建用户，讨论及回复");
            }
        }
        return opt;
    }

    public static CommandLine getCommandLine(String[] args)
    {
        Options options = getOption();
        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new PosixParser();
        CommandLine cl = null;
        try {
            // 处理Options和参数
            cl = parser.parse( options, args );
        } catch (ParseException e) {
            e.printStackTrace();
            formatter.printHelp( formatstr, options );
        }
        return cl;
    }

    public static void printHelp(){
        Options options = getOption();
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( formatstr, options );
    }
}