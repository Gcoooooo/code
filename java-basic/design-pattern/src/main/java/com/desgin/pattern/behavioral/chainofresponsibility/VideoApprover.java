package com.desgin.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if (StringUtils.isNoneEmpty(course.getVideo())) {
            System.out.println(course.getName() + "含有视频，批准");
            //交给下一个责任链对象处理
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getName() + "不含有视频，不批准，流程结束");
            return;
        }
    }
}
