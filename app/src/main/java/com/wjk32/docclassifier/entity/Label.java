package com.wjk32.docclassifier.entity;

import java.io.Serializable;

/**
 * Created by Jikang Wang on 11/16/18.
 */
public class Label implements Serializable {
    private String label;

    public Label(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
