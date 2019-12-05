package com.bastou.tuclp.controller;

public interface IProgressInfo {

    void setMax(int max);
    void update(int per);
    void end();
}
