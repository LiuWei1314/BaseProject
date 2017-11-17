package com.kemai.basemodule.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by mark.liu on 2017-5-24.
 */
@Entity
public class Test {
    @Id
    @Property(nameInDb = "cFood_C")
    private String cFood_C;//菜品编码
    @Property(nameInDb = "cFood_N")
    private String cFood_N;//菜品名称

    @Generated(hash = 1583374517)
    public Test(String cFood_C, String cFood_N) {
        this.cFood_C = cFood_C;
        this.cFood_N = cFood_N;
    }

    @Generated(hash = 372557997)
    public Test() {
    }

    public String getCFood_C() {
        return this.cFood_C;
    }

    public void setCFood_C(String cFood_C) {
        this.cFood_C = cFood_C;
    }

    public String getCFood_N() {
        return this.cFood_N;
    }

    public void setCFood_N(String cFood_N) {
        this.cFood_N = cFood_N;
    }
}
