package com.rara.lms.util;

public class PageUtilTest {
    public static void main(String[] args) {

        PageUtil pageUtil = new PageUtil(151, 0, 3, "");
        String htmlPager = pageUtil.pager();

        System.out.println(htmlPager);
    }
}
