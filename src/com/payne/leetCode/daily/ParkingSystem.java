package com.payne.leetCode.daily;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2021/03/19 - 09:46
 * Author     Payne.
 * About      类描述：
 */

class ParkingSystem {
    private final static int TYPE_BIG = 1;
    private final static int TYPE_MEDIUM = 2;
    private final static int TYPE_SMALL = 3;

    private int mBig;
    private int mMedium;
    private int mSmall;

    public ParkingSystem(int big, int medium, int small) {
        mBig = big;
        mMedium = medium;
        mSmall = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case TYPE_BIG:
                if (mBig >= 1) {
                    mBig--;
                    return true;
                } else {
                    return false;
                }
            case TYPE_MEDIUM:
                if (mMedium >= 1) {
                    mMedium--;
                    return true;
                } else {
                    return false;
                }
            case TYPE_SMALL:
                if (mSmall >= 1) {
                    mSmall--;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

}
