/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bachphong
 */
public class JType {
    
    private int mId;
    private String mType;
    private String mText;
    
    public JType() {
        
    }
    
    public JType(String type, String text) {
        mText = text;
        mType = type;
    }
    
    public JType(int id, String type, String text) {
        mId = id;
        mText = text;
        mType = type;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
    
}
