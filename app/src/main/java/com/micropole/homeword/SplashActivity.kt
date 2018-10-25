package com.micropole.homeword

import android.Manifest
import com.blankj.utilcode.util.PermissionUtils
import com.micropole.homeword.util.LocationManagerUtil
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import java.util.*

/**
 * @ClassName       SplashActivity
 * @Description     启动页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/18 17:48
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class SplashActivity : BaseMvpViewActivity(){
    override fun getActivityLayoutId(): Int = R.layout.activity_splash

    override fun initData() {
        PermissionUtils.permission(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CHANGE_WIFI_STATE).callback(object : PermissionUtils.SimpleCallback {
            override fun onGranted() {
                LocationManagerUtil.getInstance().startLocation()
                startMain()
            }

            override fun onDenied() {
                LocationManagerUtil.getInstance().startLocation()
                startMain()
            }

        }).rationale { it.again(false) }.request()

    }

    fun startMain(){
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(GuideActivity::class.java)
            }
        },1500)
    }

    override fun initEvent() {
    }
}