package com.mc2022.template;

import java.io.Serializable;

public class Question implements Serializable {

    private String que;
    private boolean ans;

    public Question(String que, boolean ans) {
        this.que = que;
        this.ans = ans;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public boolean getAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
