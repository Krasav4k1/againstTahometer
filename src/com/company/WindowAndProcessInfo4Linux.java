package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WindowAndProcessInfo4Linux {

    public static final String WIN_ID_CMD = "xprop -root | grep " + "\"_NET_ACTIVE_WINDOW(WINDOW)\"" + "|cut -d ' ' -f 5";
//    public static final String WIN_ID_CMD = "wmctrl -l|awk '{$3=\"\"; $2=\"\"; $1=\"\"; print $0}'";
    public static final String WIN_INFO_CMD_PREFIX = "xwininfo -id ";
    public static final String WIN_INFO_CMD_MID = " |awk \'BEGIN {FS=\"\\\"\"}/xwininfo: Window id/{print $2}\' | sed \'s/-[^-]*$//g\'";

    public String execShellCmd(String cmd) {
        try {

            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[]{"/bin/bash", "-c", cmd});
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            String output = "";
            while ((line = buf.readLine()) != null) {
                output = line;
            }
            return output;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

    public String windowInfoCmd(String winId) {
        if (null != winId && !"".equalsIgnoreCase(winId)) {
            return WIN_INFO_CMD_PREFIX + winId + WIN_INFO_CMD_MID;
        }
        return null;
    }

    public static boolean titeName(){
        WindowAndProcessInfo4Linux windowAndProcessInfo4Linux = new WindowAndProcessInfo4Linux();
        String winId = windowAndProcessInfo4Linux.execShellCmd(WIN_ID_CMD);
        String winInfoMcd = windowAndProcessInfo4Linux.windowInfoCmd(winId);
        String windowTitle = windowAndProcessInfo4Linux.execShellCmd(winInfoMcd);
        if(windowTitle.equals("Desktop") || windowTitle.equals("UnTahometer")){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
    WindowAndProcessInfo4Linux windowAndProcessInfo4Linux = new WindowAndProcessInfo4Linux();
    while (true){
        String winId = windowAndProcessInfo4Linux.execShellCmd(WIN_ID_CMD);
        String winInfoMcd = windowAndProcessInfo4Linux.windowInfoCmd(winId);
        String windowTitle = windowAndProcessInfo4Linux.execShellCmd(winInfoMcd);
        System.out.println(windowTitle);
        Thread.sleep(1000);
    }

//        while (true){
//            Runtime.getRuntime().exec("xset dpms force off");
//
//            if()
//            Runtime.getRuntime().exec("xset dpms force on");
//
//        }

//        robot.keyPress(KeyEvent.VK_ALT);
    }


}
