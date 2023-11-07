package com.example.studyprojectcontroller.study;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 网络接口
 */
@Slf4j
public class StudyNetWorkInteface {

    /**
     * 练习一
     */
    public static void studyNetWork() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                System.out.println("网络设备名称=" + network.getName());
                System.out.println("getDisplayName获得网络设备显示名称=" + network.getDisplayName());
                System.out.println("getIndex获得网络接口的索引=" + network.getIndex());
                System.out.println("isUp是否已经开启并运行=" + network.isUp());
                System.out.println("isBoopback是否为回调接口=" + network.isLoopback());
                Enumeration<NetworkInterface> subInterfaces = network.getSubInterfaces();
                while (subInterfaces.hasMoreElements()) {
                    NetworkInterface subInterface = subInterfaces.nextElement();
                    System.out.println("\tgetName获取网络设备名称=" + subInterface.getName());
                    System.out.println("\tgetDisplayName获得网络设备显示名称=" + subInterface.getDisplayName());
                    System.out.println("\tisVirtual是否为虚拟接口=" + subInterface.isVirtual());
                    System.out.println("\tgetParent获得父接口的hashCode=" + subInterface.getParent().hashCode());
                }
            }
        } catch (Exception e) {
            log.error("出错了...");
        }
    }

    /**
     * networkInteface中的MTU学习
     */
    public static void netWorkMtu() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface nextwork = interfaces.nextElement();
                System.out.println("getName获取网络设备名称=" + nextwork.getName());
                System.out.println("getDisplayName获得网络设备显示名称=" + nextwork.getDisplayName());
                System.out.println("getMTU获得最大传输单元=" + nextwork.getMTU());
            }
        } catch (Exception e) {
            log.error("出错了...");
        }
    }

    /**
     * 学习Mac
     */
    public static void netWorkIntefaceMac() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("getName获取网络设备名称=" + networkInterface.getName());
                System.out.println("getDisplayName获得网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.print("Mac地址=");
                byte[] networkByte = networkInterface.getHardwareAddress();
                // 为null或长度为0时，有2种情况，第一种是权限不够安全管理器没有通过校验导致null，第二种是地址根本就不存在
                if (networkByte != null && networkByte.length != 0) {
                    for (int i = 0; i < networkByte.length; i++) {
                        System.out.print(networkByte[i] + " ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            log.error("出错了...");
        }
    }

    public static void netWorkIntefaceIp() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("getName获得网络设备名称=" + networkInterface.getName());
                System.out.println("getDisplayName获得网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("getInetAddresses获得网络接口的InetAddress信息：");
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("\tgetCanonicalHostName获取此IP地址的完全限定域名=" + inetAddress.getCanonicalHostName());
                    System.out.println("\tgetHostName获取此IP地址的主机名=" + inetAddress.getHostName());
                    System.out.println("\tgetHostAddress返回IP地址字符串=" + inetAddress.getHostAddress());
                    System.out.println("\t获得本机的回调地址=" + inetAddress.getLocalHost());
                    System.out.println("\tgetAddress返回此InetAddress对象的原始IP地址=");
                    byte[] arr = inetAddress.getAddress();
                    if (arr != null && arr.length != 0) {
                        for (int i = 0; i < arr.length; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                }
            }

        } catch (Exception e) {
            log.error("出错了...");
        }
    }

    public static void netWorkGetBack() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    // 获取主机名所有的ip地址
                    InetAddress[] localhosts = inetAddress.getAllByName("www.baidu.com");
                    for (int i = 0; i < localhosts.length; i++) {
                        InetAddress ad = localhosts[i];
                        System.out.print("获取主机名所有的ip地址 "+ad.getHostAddress()+" ");
                    }
                    System.out.println();

                    // 本机地址
                    InetAddress localHost = inetAddress.getLocalHost();
                    byte[] lo = localHost.getAddress();
                    if (lo != null) {
                        for (int i = 0; i < lo.length; i++) {
                            System.out.print(" " + lo[i] + " ");
                        }
                        System.out.println();
                        System.out.println(localHost.getClass().getName());
                        System.out.println();
                    }
                    // 回调地址
                    InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
                    byte[] loop = loopbackAddress.getAddress();
                    if (loop != null) {
                        for (int i = 0; i < loop.length; i++) {
                            System.out.print(" " + loop[i] + " ");
                        }
                        System.out.println();
                        System.out.println(localHost.getClass().getName());
                        System.out.println();
                    }
                    // 根据主机名获取ip
                    System.out.println(inetAddress.getByName("www.baidu.com").getHostAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        StudyNetWorkInteface.studyNetWork();
//        StudyNetWorkInteface.netWorkMtu();
//        StudyNetWorkInteface.netWorkIntefaceMac();
        StudyNetWorkInteface.netWorkIntefaceIp();
//        StudyNetWorkInteface.netWorkGetBack();
    }
}
