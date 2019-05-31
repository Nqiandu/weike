package com.dlg.proj.demo.service;

import com.dlg.proj.demo.entity.Getorder;
import com.dlg.proj.demo.entity.Result;

import java.util.List;

public interface GetorderService {
    Result selectbyuserid(Integer userId);
    Result wgdr(String userid);

}
