/**
 * 负责与服务器之间的的信息传递
 * by MMMMMMoSky
 */
package com.example.luojiaapp;

import android.provider.ContactsContract;
import android.util.Log;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection {
    private static String serverIP = "10.129.11.41";
    private static int serverPort = 12345;

    /**
     * 登陆验证 传入用户id和密码, 若登陆成功, 返回用户名, 若登陆失败, 返回 null
     *
     * @param userid
     * @param password
     * @return 用户名
     */
    public static String verifyPassword(final String userid, final String password) {
        final List<String> ret = new ArrayList<>();  // 黑科技传递消息? 不想用 Handler
        Runnable vp = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(serverIP, serverPort);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("verify password");
                    out.writeUTF(userid);
                    out.writeUTF(password);
                    String username = in.readUTF();
                    if (!"?".equals(username)) {  // 要求用户名不为单个问号
                        ret.clear();
                        ret.add(username);
                    }
                } catch (Exception e) {
                    ret.clear();
                }
            }
        };

        Thread thread = new Thread(vp);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            ret.clear();
        }

        if (ret.size() != 1 || "?".equals(ret.get(0))) {
            return null;
        }

        return ret.get(0);
    }

    /**
     * 注册用户 提供用户昵称和密码, 返回用户id, 注册失败则返回 null
     * @param username
     * @param password
     * @return 用户id
     */
    public static String registerCommonUser(final String username, final String password) {
        final List<String> ret = new ArrayList<>();
        Runnable rc = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(serverIP, serverPort);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("register common user");
                    out.writeUTF(username);
                    out.writeUTF(password);
                    String userid = in.readUTF();
                    if (!"?".equals(userid)) {
                        ret.clear();
                        ret.add(userid);
                    }
                } catch (Exception e) {
                    ret.clear();
                }
            }
        };

        Thread thread = new Thread(rc);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            ret.clear();
        }

        if (ret.size() != 1 || "?".equals(ret.get(0))) {
            return null;
        }

        return ret.get(0);
    }

    /**
     * 获取当前用户的商人信息, 若该用户还未注册成为商人, 返回 null
     * 发送的是已经登陆的用户id, 这个方法不应该在未登陆的时候调用
     * @return 商人信息 "%s;%s;%s;%s;%s" % (姓名, 联系方式, 学部, 院系, 年级)
     */
    public static String getSellerInfo() {
        if (!LoginStatus.loggedin) {
            return null;
        }

        final List<String> ret = new ArrayList<>();
        Runnable gs = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(serverIP, serverPort);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("get seller info");
                    out.writeUTF(LoginStatus.userid);
                    String info = in.readUTF();
                    if (!"?".equals(info)) {
                        ret.clear();
                        ret.add(info);
                    }
                } catch (Exception e) {
                    ret.clear();
                }
            }
        };

        Thread thread = new Thread(gs);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            ret.clear();
        }

        if (ret.size() != 1 || "?".equals(ret.get(0))) {
            return null;
        }

        return ret.get(0);
    }

    /**
     * 注册成为商人
     * 发送的是已经登陆的用户id, 这个方法不应该在未登陆的时候调用
     * @param sellerinfo 注册信息, 格式: "%s;%s;%s;%s;%s" % (姓名, 联系方式, 学部, 院系, 年级)
     * @return 注册是否成功
     */
    public static boolean registerSeller(final String sellerinfo) {
        final List<Boolean> ret = new ArrayList<>();
        Runnable rs = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket(serverIP, serverPort);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("register seller");
                    out.writeUTF(LoginStatus.userid);
                    out.writeUTF(sellerinfo);
                    String res = in.readUTF();
                    ret.clear();
                    ret.add("true".equalsIgnoreCase(res));
                } catch (Exception e) {
                    ret.clear();
                }
            }
        };

        Thread thread = new Thread(rs);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            ret.clear();
        }

        if (ret.size() != 1) {
            return false;
        }

        return ret.get(0);
    }
}
