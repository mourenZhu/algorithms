package cn.zhumouren.algorithms.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author mourenZhu
 * @version 1.0
 * @description 读入工具类
 * @date 2021/11/15 11:06
 **/
public class StdIn {

    public static String[] readAllStringsByFile(String path) throws IOException {
        Path p = Paths.get(path);
        List<String> list = Files.readAllLines(p);
        String[] strings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }
}
